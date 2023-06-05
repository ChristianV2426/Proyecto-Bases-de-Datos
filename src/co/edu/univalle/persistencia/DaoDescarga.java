/*
  Archivo: DaoDigital.java
  Bases de Datos - 750006C - Grupo 01
  Proyecto - Biblioteca Universidad del Valle

  Autores: 
  John Freddy Belalcazar Rojas - john.freddy.belalcazar@correounivalle.edu.co - 2182464-3743 
  Santiago Gonzalez Galvez - santiago.galvez@correounivalle.edu.co - 2183392-3743 
  Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 2140112-3743 
  Christian David Vargas Gutierrez - vargas.christian@correounivalle.edu.co - 2179172-3743

  Profesor:
  Ph.D. Oswaldo Solarte

  Licencia: GNU-GPL
*/

package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.*;
import java.sql.*;
import java.time.*;
import java.time.format.*;

public class DaoDescarga implements DaoGeneral<Descarga> {
  Connection conexionBD;

  public DaoDescarga(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Descarga descarga) {
    String sentenciaInsert = 
      "INSERT INTO descarga VALUES ('" +
      descarga.getCodigoDescarga() + "', '" +
      descarga.getIdUsuario() + "', '" +
      descarga.getIsbn() + "', '" +
      descarga.getUrl() + "', '" +
      descarga.getFechaDescargaConHora() + "', '" +
      descarga.getNumIp() + "');";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Descarga descarga) {
    String sentenciaUpdate =
      "UPDATE descarga SET id_usuario='" + descarga.getIdUsuario() +
      "', ISBN='" + descarga.getIsbn() +
      "', URL='" + descarga.getUrl() +
      "', fecha_descarga_con_hora='" + descarga.getFechaDescargaConHora() +
      "', num_ip='" + descarga.getNumIp() +
      "' WHERE codigo_descarga='" + descarga.getCodigoDescarga() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM descarga WHERE codigo_descarga='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_descarga, ISBN, titulo, URL, id_usuario, nombre_usuario, fecha_descarga_con_hora, num_ip " +
      "FROM descarga NATURAL JOIN digital NATURAL JOIN libro NATURAL JOIN usuario;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Descarga obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM descarga WHERE codigo_descarga='" + llavePrimaria + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Descarga(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3),
          resultadoConsulta.getString(4),
          LocalDateTime.parse(resultadoConsulta.getString(5), formato),
          resultadoConsulta.getString(6) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }

}

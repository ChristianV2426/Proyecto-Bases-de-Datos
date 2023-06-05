/*
  Archivo: DaoSolicitud.java
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
import java.time.LocalDate;

public class DaoSolicitud implements DaoGeneral<Solicitud> {
  Connection conexionBD;

  public DaoSolicitud(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Solicitud solicitud) {
    String sentenciaInsert =
      "INSERT INTO solicitud VALUES ('" + 
      solicitud.getCodigoSolicitud() + "' , '" +
      solicitud.getIdUsuario() + "' , '" +
      solicitud.getFechaSolicitud() + "', '" +
      solicitud.getDescripcion() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Solicitud solicitud) {
    String sentenciaUpdate =
      "UPDATE solicitud SET id_usuario='" + solicitud.getIdUsuario() +
      "', fecha_solicitud='" + solicitud.getFechaSolicitud() + 
      "', descripcion ='" + solicitud.getDescripcion() + 
      "' WHERE codigo_solicitud='" + solicitud.getCodigoSolicitud() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM solicitud WHERE codigo_solicitud='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_solicitud, fecha_solicitud, id_usuario, nombre_usuario, ISBN, titulo, descripcion " +
      "FROM solicitud NATURAL JOIN usuario NATURAL JOIN pide NATURAL JOIN libro;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Solicitud obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
      "SELECT * FROM solicitud WHERE codigo_solicitud='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Solicitud(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          LocalDate.parse(resultadoConsulta.getString(3)),
          resultadoConsulta.getString(4) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  } 

}

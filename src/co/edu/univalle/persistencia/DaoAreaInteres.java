/*
  Archivo: DaoAreaInteres.java
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

public class DaoAreaInteres implements DaoGeneral<AreaInteres> {
  Connection conexionBD;

  public DaoAreaInteres(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(AreaInteres areaInteres) {
    String sentenciaInsert =
      "INSERT INTO area_interes_profesor VALUES ('" + 
      areaInteres.getIdUsuario() + "' , '" +
      areaInteres.getCodigoArea() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(AreaInteres areaInteres) {
    String sentenciaUpdate =
      "UPDATE area_interes_profesor SET id_usuario='" + areaInteres.getIdUsuario() +
      "', codigo_area='" + areaInteres.getCodigoArea() + 
      "' WHERE id_usuario='" + areaInteres.getIdUsuario() +
      "' AND codigo_area='" + areaInteres.getCodigoArea() + ";";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete =
      "DELETE FROM area_interes_profesor WHERE id_usuario='" + llavePrimaria.substring(0, llavePrimaria.indexOf(",")) + 
      "' AND codigo_area='" + llavePrimaria.substring(llavePrimaria.indexOf(",") + 2) + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT * FROM area_interes_profesor;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public AreaInteres obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
      "SELECT * FROM area_interes_profesor " +
      "WHERE id_usuario='" + llavePrimaria.substring(0, llavePrimaria.indexOf(",")) +
      "' AND codigo_area='" + llavePrimaria.substring(llavePrimaria.indexOf(",") + 2) + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new AreaInteres(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }

}

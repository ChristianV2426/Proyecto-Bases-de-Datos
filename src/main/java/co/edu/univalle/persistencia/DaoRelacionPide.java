/*
  Archivo: DaoRelacionPide.java
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

public class DaoRelacionPide implements DaoGeneral<RelacionPide> {
  Connection conexionBD;

  public DaoRelacionPide(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(RelacionPide relacionPide) {
    String sentenciaInsert =
      "INSERT INTO pide VALUES ('" + 
      relacionPide.getCodigoSolicitud() + "' , '" +
      relacionPide.getIsbn() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(RelacionPide relacionPide) {
    String sentenciaUpdate =
      "UPDATE pide SET codigo_solicitud='" + relacionPide.getCodigoSolicitud() +
      "', ISBN='" + relacionPide.getIsbn() + 
      "' WHERE codigo_solicitud='" + relacionPide.getCodigoSolicitud() +
      "' AND ISBN='" + relacionPide.getIsbn() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete =
      "DELETE FROM pide WHERE codigo_solicitud='" + llavePrimaria.substring(0, llavePrimaria.indexOf(",")) + 
      "' AND ISBN='" + llavePrimaria.substring(llavePrimaria.indexOf(",") + 2) + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT * FROM pide;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public RelacionPide obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
      "SELECT * FROM pide " +
      "WHERE codigo_solicitud='" + llavePrimaria.substring(0, llavePrimaria.indexOf(",")) +
      "' AND ISBN='" + llavePrimaria.substring(llavePrimaria.indexOf(",") + 2) + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new RelacionPide(
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

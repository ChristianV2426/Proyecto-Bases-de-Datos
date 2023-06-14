/*
  Archivo: DaoArea.java
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

public class DaoArea implements DaoGeneral<Area>{
  Connection conexionBD;

  public DaoArea(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Area area) {
    String sentenciaInsert =
      "INSERT INTO area_conocimiento VALUES ('" + 
      area.getCodigoArea() + "', '" +
      area.getNombreArea() + "', '" + 
      area.getDescripcionArea() + "', '"
      + area.getAreaPadre() + "');";
    
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Area area) {
    String sentenciaUpdate =
      "UPDATE area_conocimiento SET nombre_area='" + area.getNombreArea() +
      "', descripcion_area='" + area.getDescripcionArea() +
      "', area_padre='" + area.getAreaPadre() + 
      "' WHERE codigo_area='" + area.getCodigoArea() + "';";
    
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM area_conocimiento WHERE codigo_area='" + llavePrimaria + "';";
    
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  } 

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT * FROM area_conocimiento;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  } 

  @Override
  public Area obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM area_conocimiento " +
      "WHERE codigo_area='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Area(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3),
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

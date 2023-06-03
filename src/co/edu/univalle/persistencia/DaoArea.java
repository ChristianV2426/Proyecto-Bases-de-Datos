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
  int numeroColumnas = Area.getNumeroColumnas();

  public DaoArea(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Area area) {
    String sentenciaInsert = "INSERT INTO area_conocimiento VALUES ('" + 
      area.getCodigoArea() + "', '" + area.getNombreArea() + "', '" + 
      area.getDescripcionArea() + "', '" + area.getAreaPadre() + "');";
    
    try{
      Statement sentenciaSQL = conexionBD.createStatement();
      sentenciaSQL.executeUpdate(sentenciaInsert);
      return true;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia INSERT INTO para el elemento: " + area.getNombreArea() + ".\nError: " + error.getMessage());
      return false;
    }
  }

  @Override
  public Area obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT codigo_area, nombre_area, descripcion_area, area_padre FROM area_conocimiento " +
      "WHERE codigo_area='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(ManejadorArchivos.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Area(resultadoConsulta.getString(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3), resultadoConsulta.getString(4));
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }

  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_area, nombre_area, descripcion_area, area_padre FROM area_conocimiento;";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);
      int numeroFilas = ManejadorArchivos.numeroFilasEnResultadoConsulta(resultadoConsulta);

      if(numeroFilas == 0)
        return null;
      
      String[][] arreglo = new String[numeroFilas][numeroColumnas];

      for(int fila = 0; fila < numeroFilas; fila++){
        resultadoConsulta.next();

        for(int columna = 0; columna < numeroColumnas; columna++)
          arreglo[fila][columna] = resultadoConsulta.getString(columna+1);
      }

      return arreglo;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para obtener todos los elementos.\nError: " + error.getMessage());
      return null;
    }
  }

  @Override
  public boolean editarElemento(Area area) {
    String sentenciaUpdate = "UPDATE area_conocimiento SET nombre_area='" + area.getNombreArea() +
      "', descripcion_area='" + area.getDescripcionArea() + "', area_padre='" + area.getAreaPadre() + 
      "' WHERE codigo_area='" + area.getCodigoArea() + "';";
  
    try{
      Statement sentenciaSQL = conexionBD.createStatement();
      sentenciaSQL.executeUpdate(sentenciaUpdate);
      return true;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia UPDATE para el elemento: " + area.getNombreArea() + ".\nError: " + error.getMessage());
      return false;
    }
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM area_conocimiento WHERE codigo_area='" + llavePrimaria + "';";
  
    try{
      Statement sentenciaSQL = conexionBD.createStatement();
      sentenciaSQL.executeUpdate(sentenciaDelete);
      return true;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia DELETE para el elemento con llave primaria : " + llavePrimaria + ".\nError: " + error.getMessage());
      return false;
    }
  }  
  
}

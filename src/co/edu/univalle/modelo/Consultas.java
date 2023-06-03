/*
  Archivo: Consultas.java
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
package co.edu.univalle.modelo;

import java.sql.*;

public class Consultas {
  public static boolean ejecutarSentenciaInsertUpdateDelete(String sentencia, Connection conexionBD){
    try{
      Statement sentenciaSQL = conexionBD.createStatement();
      
      if(sentenciaSQL.executeUpdate(sentencia) == 1)
        return true;
      else
        return false;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia: " + sentencia + ".\nError: " + error.getMessage());
      return false;
    }
  }

  public static int numeroFilasEnResultadoConsulta(ResultSet resultadoConsulta){
    int numeroFilas = 0;
    try {
      resultadoConsulta.last();
      numeroFilas = resultadoConsulta.getRow();
      resultadoConsulta.beforeFirst();
      return numeroFilas;

    } catch (Exception error){
      System.out.println("Error contando el número de filas en el resultado de la consulta.\nError: " + error.getMessage());
      return 0;
    }
  }

  public static String[][] traerTodosLosElementos(String sentenciaSelect, Connection conexionBD){    
    try{
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      int numeroFilas = numeroFilasEnResultadoConsulta(resultadoConsulta);
      if(numeroFilas == 0)
        return null;

      int numeroColumnas = resultadoConsulta.getMetaData().getColumnCount();
      String[][] arreglo = new String[numeroFilas][numeroColumnas];

      for(int fila = 0; fila < numeroFilas; fila++){
        resultadoConsulta.next();

        for(int columna = 0; columna < numeroColumnas; columna++)
          arreglo[fila][columna] = resultadoConsulta.getString(columna+1);
      }

      return arreglo;

    } catch (Exception error){
      System.out.println("No se pudo ejecutar la sentencia SELECT para obtener todos los elementos: "+ sentenciaSelect + "\nError: " + error.getMessage());
      return null;
    }
  }

}

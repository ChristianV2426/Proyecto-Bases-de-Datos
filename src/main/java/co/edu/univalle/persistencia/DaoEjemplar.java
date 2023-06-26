/*
  Archivo: DaoEjemplar.java
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
import java.util.ArrayList;

public class DaoEjemplar implements DaoGeneral<Ejemplar> {
  Connection conexionBD;

  public DaoEjemplar(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Ejemplar ejemplar) {
    String sentenciaInsert =
      "INSERT INTO ejemplar VALUES ('" +
      ejemplar.getCodigoEjemplar() + "', '" + 
      ejemplar.getIsbn() + "', '" +
      ejemplar.getNumEjemplar() + "', '" +
      ejemplar.getEstante() + "', '" +
      ejemplar.getNumCajon() + "', '" +
      ejemplar.getNumPasillo() + "', '" +
      ejemplar.getNombreSala() + "', '" +
      ejemplar.getDisponible() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Ejemplar ejemplar) {
    String sentenciaUpdate =
      "UPDATE ejemplar SET ISBN='" + ejemplar.getIsbn() +
      "', num_ejemplar='" + ejemplar.getNumEjemplar() +
      "', estante='" + ejemplar.getEstante() +
      "', num_cajon='" + ejemplar.getNumCajon() +
      "', num_pasillo='" + ejemplar.getNumPasillo() +
      "', nombre_sala='" + ejemplar.getNombreSala() +
      "', disponible='" + ejemplar.getDisponible() +
      "' WHERE codigo_ejemplar='" + ejemplar.getCodigoEjemplar() + "';";

      System.out.println(sentenciaUpdate);

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete =
      "DELETE FROM ejemplar WHERE codigo_ejemplar='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT ISBN, titulo, num_ejemplar, nombre_editorial, nombre_area, num_pagina " + 
      "FROM ejemplar NATURAL JOIN libro NATURAL JOIN editorial NATURAL JOIN area_conocimiento;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Ejemplar obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
      "SELECT ISBN, titulo, num_pagina, anio_publicacion, idioma, codigo_area, codigo_editorial, codigo_ejemplar, num_ejemplar, estante, num_cajon, num_pasillo, nombre_sala, disponible " +
      "FROM ejemplar NATURAL JOIN libro WHERE codigo_ejemplar='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoPertenencia = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoPertenencia) == 1){
        resultadoPertenencia.next();
        return new Ejemplar(
          resultadoPertenencia.getString(1),
          resultadoPertenencia.getString(2),
          Integer.valueOf(resultadoPertenencia.getString(3)),
          Integer.valueOf(resultadoPertenencia.getString(4)),
          resultadoPertenencia.getString(5),
          resultadoPertenencia.getString(6),
          resultadoPertenencia.getString(7),
          resultadoPertenencia.getString(8), 
          Integer.valueOf(resultadoPertenencia.getString(9)),
          resultadoPertenencia.getString(10),
          resultadoPertenencia.getString(11),
          resultadoPertenencia.getString(12),
          resultadoPertenencia.getString(13),
          resultadoPertenencia.getBoolean(14) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }

  public int ejemplaresEnTotal(String isbnLibro) {
    String setenciaSelect = "SELECT COUNT(codigo_ejemplar) FROM ejemplar WHERE ISBN='" + isbnLibro + "';";

    try{
      Statement sentenciaSQL = conexionBD.createStatement();
      ResultSet resultado = sentenciaSQL.executeQuery(setenciaSelect);

      resultado.next();
      return resultado.getInt(1);

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para comprobar el número de ejemplares del libro con ISBN: " + isbnLibro + " en la Base de Datos.\nError: " + error.getMessage());
      return -1;
    }
  }

  public ArrayList<String> ejemplaresDisponibles(String isbnLibro) {
    ArrayList<String> ejemplaresDisponibles = new ArrayList<String>();

    String sentenciaPertenencia = "SELECT EXISTS (SELECT 1 FROM libro WHERE ISBN='" + isbnLibro + "');";
    String sentenciaConsultaEjemplares = "SELECT codigo_ejemplar FROM ejemplar WHERE ISBN='" + isbnLibro + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoPertenencia = sentenciaSQL.executeQuery(sentenciaPertenencia);

      resultadoPertenencia.next();
      if(resultadoPertenencia.getBoolean(1)){
        ResultSet resultadoConsultaEjemplares = sentenciaSQL.executeQuery(sentenciaConsultaEjemplares);
        int numeroEjemplares = Consultas.numeroFilasEnResultadoConsulta(resultadoConsultaEjemplares);

        if(numeroEjemplares > 0){
          while(resultadoConsultaEjemplares.next()){
            Ejemplar ejemplar = obtenerElemento(resultadoConsultaEjemplares.getString(1));

            if(ejemplar.getDisponible())
              ejemplaresDisponibles.add(ejemplar.getCodigoEjemplar());
          }

        return ejemplaresDisponibles; 
        }
      }

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para comprobar la pertenencia del libro con ISBN: " + isbnLibro + " en la Base de Datos.\nError: " + error.getMessage());
      return null;
    }

    return null;
  }

}

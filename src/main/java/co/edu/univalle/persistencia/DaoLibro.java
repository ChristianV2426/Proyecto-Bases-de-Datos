/*
  Archivo: DaoLibro.java
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

public class DaoLibro implements DaoGeneral<Libro>{
  Connection conexionBD;

  public DaoLibro(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Libro libro) {
    String sentenciaInsert =
      "INSERT INTO libro VALUES ('" +
      libro.getIsbn() + "', '" +
      libro.getTitulo() + "', '" +
      libro.getNumPagina() + "', '" +
      libro.getAnioPublicacion() + "', '" + 
      libro.getIdioma() + "', '" +
      libro.getCodigoArea() + "', '" +
      libro.getCodigoEditorial() + "');";
    
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Libro libro) {
    String sentenciaUpdate =
      "UPDATE libro SET titulo='" + libro.getTitulo() +
      "', num_pagina='" + libro.getNumPagina() +
      "', anio_publicacion='" + libro.getAnioPublicacion() +
      "', idioma='" + libro.getIdioma() +
      "', codigo_area='" + libro.getCodigoArea() +
      "', codigo_editorial='" +  libro.getCodigoEditorial() +
      "' WHERE ISBN='" + libro.getIsbn() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM libro WHERE ISBN='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT " +
      "libro.ISBN, titulo, COUNT(codigo_ejemplar), string_agg(DISTINCT primer_nombre || ' ' || primer_apellido, ', ') AS autores, " +
      "nombre_editorial, idioma, CASE WHEN EXISTS (SELECT 1 FROM digital WHERE digital.ISBN = libro.ISBN) THEN TRUE ELSE FALSE END AS digital " +
      "FROM libro LEFT JOIN ejemplar ON libro.ISBN=ejemplar.ISBN LEFT JOIN editorial ON libro.codigo_editorial = editorial.codigo_editorial " +
      "LEFT JOIN escribe ON libro.ISBN = escribe.ISBN NATURAL JOIN autor GROUP BY libro.ISBN, titulo, nombre_editorial ORDER BY libro.ISBN;";

    String[][] todosLibros = Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
    actualizarDigital(todosLibros);

    return todosLibros;
  }

  public String[][] obtenerLibrosDisponibles(String isbn) {
      String sentenciaSelect = "SELECT " +
        "libro.ISBN, titulo, codigo_ejemplar, string_agg(DISTINCT primer_nombre || ' ' || primer_apellido, ', ') AS autor, " +
        "nombre_editorial, idioma, CASE WHEN EXISTS (SELECT 1 FROM digital WHERE digital.ISBN = libro.ISBN) THEN TRUE ELSE FALSE END AS digital " +
        "FROM ejemplar NATURAL JOIN libro NATURAL JOIN autor NATURAL JOIN escribe NATURAL JOIN editorial " +
        "WHERE ISBN='" + isbn + "' GROUP BY (libro.ISBN, codigo_ejemplar, nombre_editorial) ORDER BY codigo_ejemplar;";

    String[][] librosDisponibles = Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
    actualizarDigital(librosDisponibles);

    return librosDisponibles;
  }

  public void actualizarDigital(String[][] librosDisponibles) {
    for(int i = 0; i < librosDisponibles.length; i++){
      if (librosDisponibles[i][6].toLowerCase().equals("true") || librosDisponibles[i][6].toLowerCase().equals("t"))
        librosDisponibles[i][6] = "Sí";

      else 
        librosDisponibles[i][6] = "No";
      }
  }

  @Override
  public Libro obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM libro WHERE ISBN='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Libro(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          Integer.valueOf(resultadoConsulta.getString(3)),
          Integer.valueOf(resultadoConsulta.getString(4)),
          resultadoConsulta.getString(5),
          resultadoConsulta.getString(6), 
          resultadoConsulta.getString(7) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }

}

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
      ejemplar.getNombreSala() + "');";
  
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
      "' WHERE codigo_ejemplar='" + ejemplar.getCodigoEjemplar() + "';";

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
      "SELECT ISBN, titulo, num_pagina, anio_publicacion, idioma, codigo_area, codigo_editorial, codigo_ejemplar, num_ejemplar, estante, num_cajon, num_pasillo, nombre_sala " +
      "FROM ejemplar NATURAL JOIN libro WHERE codigo_ejemplar='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Ejemplar(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          Integer.valueOf(resultadoConsulta.getString(3)),
          Integer.valueOf(resultadoConsulta.getString(4)),
          resultadoConsulta.getString(5),
          resultadoConsulta.getString(6),
          resultadoConsulta.getString(7),
          resultadoConsulta.getString(8), 
          Integer.valueOf(resultadoConsulta.getString(9)),
          resultadoConsulta.getString(10),
          resultadoConsulta.getString(11),
          resultadoConsulta.getString(12),
          resultadoConsulta.getString(13) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }

}
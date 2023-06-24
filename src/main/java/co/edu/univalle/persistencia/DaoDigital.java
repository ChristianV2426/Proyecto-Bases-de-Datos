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

public class DaoDigital implements DaoGeneral<Digital>{
  Connection conexionBD;

  public DaoDigital(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Digital digital) {
    String sentenciaInsert =
      "INSERT INTO digital VALUES ('" +
      digital.getCodigoDigital() + "', '" + 
      digital.getIsbn() + "', '" +
      digital.getUrl() + "', '" +
      digital.getTamanoBytes() + "', '" +
      digital.getFormato() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Digital digital) {
    String sentenciaUpdate =
      "UPDATE digital SET ISBN='" + digital.getIsbn() +
      "', URL='" + digital.getUrl() +
      "', tamano_bytes='" + digital.getTamanoBytes() +
      "', formato='" + digital.getFormato() +
      "' WHERE codigo_digital='" + digital.getCodigoDigital() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = 
      "DELETE FROM digital WHERE codigo_digital='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT ISBN, titulo, URL, formato, nombre_editorial, nombre_area " + 
      "FROM digital NATURAL JOIN libro NATURAL JOIN editorial NATURAL JOIN area_conocimiento;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Digital obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
    "SELECT ISBN, titulo, num_pagina, anio_publicacion, idioma, codigo_area, codigo_editorial, codigo_digital, URL, tamano_bytes, formato " + 
    "FROM digital NATURAL JOIN libro WHERE ISBN='" + llavePrimaria + "';";

    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Digital(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          Integer.valueOf(resultadoConsulta.getString(3)),
          Integer.valueOf(resultadoConsulta.getString(4)),
          resultadoConsulta.getString(5),
          resultadoConsulta.getString(6),
          resultadoConsulta.getString(7),
          resultadoConsulta.getString(8),
          resultadoConsulta.getString(9),
          Integer.valueOf(resultadoConsulta.getString(10)),
          resultadoConsulta.getString(11) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}

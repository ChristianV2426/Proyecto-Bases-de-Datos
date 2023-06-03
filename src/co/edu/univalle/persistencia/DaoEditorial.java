/*
  Archivo: DaoEditorial.java
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

public class DaoEditorial implements DaoGeneral<Editorial> {
  Connection conexionBD;

  public DaoEditorial(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Editorial editorial) {
    String sentenciaInsert = "INSERT INTO editorial VALUES ('" + 
      editorial.getCodigoEditorial() + "', '" + editorial.getNombreEditorial() + "', '" + 
      editorial.getPaisOrigen() + "', '" + editorial.getPaginaWeb() + "');";
    
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Editorial editorial) {
    String sentenciaUpdate = "UPDATE editorial SET nombre_editorial='" + editorial.getNombreEditorial() +
      "', pais_origen='" + editorial.getPaisOrigen() + "', pagina_web='" + editorial.getPaginaWeb() + 
      "' WHERE codigo_editorial='" + editorial.getCodigoEditorial() + "';";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM editorial WHERE codigo_editorial='" + llavePrimaria + "';";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_editorial, nombre_editorial, pais_origen, pagina_web FROM editorial;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Editorial obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT codigo_editorial, nombre_editorial, pais_origen, pagina_web FROM editorial " +
      "WHERE codigo_editorial='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Editorial(resultadoConsulta.getString(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3), resultadoConsulta.getString(4));
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}

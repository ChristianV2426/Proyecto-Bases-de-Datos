/*
  Archivo: DaoAutor.java
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

public class DaoAutor implements DaoGeneral<Autor> {
  Connection conexionBD;

  public DaoAutor(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Autor autor) {
    String sentenciaInsert = "INSERT INTO autor VALUES ('" + 
    autor.getCodigoAutor() + "', '" + autor.getPrimerNombre() + "', '" + autor.getSegundoNombre() +
    "', '" + autor.getPrimerApellido() + "', '" + autor.getSegundoApellido() + "');";
  
  return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Autor autor) {
    String sentenciaUpdate = "UPDATE autor SET primer_nombre='" + autor.getPrimerNombre() + "', segundo_nombre='" + autor.getSegundoNombre() +
      "', primer_apellido='" + autor.getPrimerApellido() + "', segundo_apellido='" + autor.getSegundoApellido() +
      "' WHERE codigo_autor='" + autor.getCodigoAutor() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM autor WHERE codigo_autor='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT codigo_autor, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido FROM autor;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Autor obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT codigo_autor, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido FROM autor " +
      "WHERE codigo_autor='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Autor(resultadoConsulta.getString(1), resultadoConsulta.getString(2), resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getString(5));
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}

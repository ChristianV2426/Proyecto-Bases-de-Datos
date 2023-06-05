/*
  Archivo: DaoProfesor.java
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

public class DaoProfesor implements DaoGeneral<Profesor>{
  Connection conexionBD;

  public DaoProfesor(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Profesor profesor) {
    String sentenciaInsert =
      "INSERT INTO profesor VALUES ('" + 
      profesor.getIdUsuario() + "' , '" +
      profesor.getDependencia() + "', '" +
      profesor.getTitulo() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Profesor profesor) {
    String sentenciaUpdate =
      "UPDATE profesor SET dependencia='" + profesor.getDependencia() +
      "', titulo='" + profesor.getTitulo() + 
      "' WHERE id_usuario='" + profesor.getIdUsuario() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM profesor WHERE id_usuario='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT id_usuario, nombre_usuario, dependencia, titulo, email FROM profesor NATURAL JOIN usuario;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Profesor obtenerElemento(String llavePrimaria) {
    String sentenciaSelect =
      "SELECT id_usuario, nombre_usuario, telefono, direccion, email, dependencia, titulo " +
      "FROM profesor NATURAL JOIN usuario WHERE id_usuario='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Profesor(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3),
          resultadoConsulta.getString(4),
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

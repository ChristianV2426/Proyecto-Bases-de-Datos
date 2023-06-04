/*
  Archivo: DaoUsuario.java
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

public class DaoUsuario implements DaoGeneral<Usuario> {
  Connection conexionBD;

  public DaoUsuario(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(Usuario usuario) {
    String sentenciaInsert =
      "INSERT INTO usuario VALUES ('" + 
      usuario.getIdUsuario() + "' , '" +
      usuario.getNombreUsuario() + "', '" +
      usuario.getTelefono() + "', '" +
      usuario.getDireccion() + "', '" +
      usuario.getEmail() + "');";
  
    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(Usuario usuario) {
    String sentenciaUpdate =
      "UPDATE usuario SET nombre_usuario='" + usuario.getNombreUsuario() +
      "', telefono='" + usuario.getTelefono() +
      "', direccion='" + usuario.getDireccion() +
      "', email='" + usuario.getEmail() +
      "' WHERE id_usuario='" +
      usuario.getIdUsuario() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
    String sentenciaDelete = "DELETE FROM usuario WHERE id_usuario='" + llavePrimaria + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
    String sentenciaSelect = "SELECT * FROM usuario;";

    return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

  @Override
  public Usuario obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM usuario WHERE id_usuario='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new Usuario(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2),
          resultadoConsulta.getString(3),
          resultadoConsulta.getString(4),
          resultadoConsulta.getString(5) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}

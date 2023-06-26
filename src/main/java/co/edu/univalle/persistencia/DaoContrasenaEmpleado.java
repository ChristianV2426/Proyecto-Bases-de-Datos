/*
  Archivo: DaoContrasenaEmpleado.java
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
import org.jasypt.util.password.*;

public class DaoContrasenaEmpleado implements DaoGeneral<ContrasenaEmpleado> {
  Connection conexionBD;
  StrongPasswordEncryptor encriptador = new StrongPasswordEncryptor();

  public DaoContrasenaEmpleado(Connection conexionBD) {
    this.conexionBD = conexionBD;
  }

  @Override
  public boolean insertarElemento(ContrasenaEmpleado contrasena) {
    String sentenciaInsert =
      "INSERT INTO contrasena_empleado (id_empleado, contrasena) VALUES ('" +
      contrasena.getIdEmpleado() + "', '" +
      contrasena.getContrasena() + "');";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaInsert, conexionBD);
  }

  @Override
  public boolean editarElemento(ContrasenaEmpleado contrasena) {
    String sentenciaUpdate = 
      "UPDATE contrasena_empleado SET contrasena='" + contrasena.getContrasena() +
      "' WHERE id_empleado='" + contrasena.getIdEmpleado() + "';";

    return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaUpdate, conexionBD);
  }

  @Override
  public boolean eliminarElemento(String llavePrimaria) {
  String sentenciaDelete = "DELETE FROM contrasena_empleado WHERE id_empleado='" + llavePrimaria + "';";

  return Consultas.ejecutarSentenciaInsertUpdateDelete(sentenciaDelete, conexionBD);
  }

  @Override
  public String[][] obtenerTodosLosElementos() {
  String sentenciaSelect = "SELECT * FROM contrasena_empleado;";

  return Consultas.traerTodosLosElementos(sentenciaSelect, conexionBD);
  }

    public void encriptarContrasenas(){
    String[][] contrasenas = obtenerTodosLosElementos();
      for (String[] contrasena: contrasenas) {
        ContrasenaEmpleado contrasenaEmpleado = new ContrasenaEmpleado(contrasena[0], contrasena[1]);

        if(contrasenaEmpleado.getContrasena().length() < 50){
          contrasenaEmpleado.setContrasena(encriptador.encryptPassword(contrasenaEmpleado.getContrasena()));
          editarElemento(contrasenaEmpleado);
        }      
      }
    }

  public String encriptarContrasena(String contrasena){
    return encriptador.encryptPassword(contrasena);
  }

  public boolean validarContrasena(String empleado, String contrasena){
    ContrasenaEmpleado contrasenaEmpleado = obtenerElemento(empleado);

    if (contrasenaEmpleado != null)
      return encriptador.checkPassword(contrasena, contrasenaEmpleado.getContrasena());
    
    else
      return false;
  }

  @Override
  public ContrasenaEmpleado obtenerElemento(String llavePrimaria) {
    String sentenciaSelect = "SELECT * FROM contrasena_empleado WHERE id_empleado='" + llavePrimaria + "';";
    
    try {
      Statement sentenciaSQL = conexionBD.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ResultSet resultadoConsulta = sentenciaSQL.executeQuery(sentenciaSelect);

      if(Consultas.numeroFilasEnResultadoConsulta(resultadoConsulta) == 1){
        resultadoConsulta.next();
        return new ContrasenaEmpleado(
          resultadoConsulta.getString(1),
          resultadoConsulta.getString(2) );
      }

      else
        return null;

    } catch (Exception error) {
      System.out.println("No se pudo ejecutar la sentencia SELECT para el elemento con llave primaria: " + llavePrimaria + ".\nError: " + error.getMessage());
      return null;
    }
  }
  
}


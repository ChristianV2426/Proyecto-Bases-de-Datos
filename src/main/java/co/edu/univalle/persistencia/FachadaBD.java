/*
  Archivo: FachadaBD.java
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

import java.sql.*;

public class FachadaBD {
  private String url;
  private String usuario;
  private String password;
  private Connection conexionBD = null;

  public FachadaBD(String url, String usuario, String password) {
    this.url = url;
    this.usuario = usuario;
    this.password = password;
  }

  public Connection conectar(){
    try{
      Class.forName("org.postgresql.Driver");

    } catch (ClassNotFoundException error) {
      System.out.println("No se pudo cargar el Driver. Error: " + error.getMessage());
    }

    try{
      conexionBD = DriverManager.getConnection(url, usuario, password);
      System.out.println("Conexión exitosa con la base de datos.");
      return conexionBD;

    } catch(SQLException error) {
      System.out.println("Error al abrir la base de datos. Error: " + error.getMessage());
      return null;
    }

  }

  public Connection getConexionBD() {
    if(conexionBD == null)
      conectar();

    return conexionBD;
  }

  public void closeConexionBD(Connection conexion){
    if(conexionBD != null){
      try{
        conexion.close();
        System.out.println("Conexión con la base de datos cerrada con éxito");

      } catch (SQLException error) {
        System.out.println("Error al cerrar la base de datos. Error: " + error.getMessage());
      }
    }

  }

  /*
  public static void main(String[] args) {
    FachadaBD fachadaBD = new FachadaBD();
    Connection conexionBD = fachadaBD.getConexionBD();
    fachadaBD.closeConexionBD(conexionBD);
  }
  */

}

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

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;


public class FachadaBD {
  private String url;
  private String usuario;
  private String password;
  private Connection conexionBD = null;

  public FachadaBD(String rutaArchivoCredenciales) {
    Scanner scanner = null;
    File archivoCredenciales = null;

    try {
      archivoCredenciales = new File(rutaArchivoCredenciales);
      scanner = new Scanner(archivoCredenciales);

      for(int i = 0; i < 2; i++)
        scanner.nextLine();
      
      String lineaUrl = scanner.nextLine();
      String lineaUsuario = scanner.nextLine();
      String lineaPassword = scanner.nextLine();

      this.url = lineaUrl.substring(lineaUrl.lastIndexOf(" ") + 1);
      this.usuario = lineaUsuario.substring(lineaUsuario.lastIndexOf(" ") + 1);
      this.password = lineaPassword.substring(lineaPassword.lastIndexOf(" ") + 1);

    } catch(FileNotFoundException exception){
        JOptionPane.showMessageDialog(null,
            "No se encontró el archivo de credenciales.\n\n" + archivoCredenciales.getAbsolutePath() +
            "\n\nPor favor asegúrse de que en esta ruta se encuentre un archivo de credenciales valido.",
            "Conexión con la base de datos fallida", JOptionPane.ERROR_MESSAGE);
        System.exit(0);

    } catch(IOException exception){
        JOptionPane.showMessageDialog(null,
            "No se pude leer el contenido del archivo: " + exception.getMessage() + "\nAsegúrese de que en esta ruta se encuentre un archivo de credenciales valido o contacte al administrador.",
            "Conexión con la base de datos fallida", JOptionPane.ERROR_MESSAGE);
        System.exit(0);

    } finally {
      try {
        scanner.close();

      } catch (Exception exception2){
        JOptionPane.showMessageDialog(null,
            "No se encontró el archivo de credenciales.\n\n" + archivoCredenciales.getAbsolutePath() +
            "\n\nPor favor asegúrse de que en esta ruta se encuentre un archivo de credenciales valido o contacte al administrador.",
            "Conexión con la base de datos fallida", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
      }
    }
  }
  
  public Connection conectar(){
    try{
      Class.forName("org.postgresql.Driver");

    } catch (ClassNotFoundException error) {
        JOptionPane.showMessageDialog(null, "No se pudo cargar el Driver de PostgreSQL.\nPor favor Contacte al administrador.",
            "Conexión con la base de datos fallida", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        System.out.println("No se pudo cargar el Driver. Error: " + error.getMessage());
    }

    try{
        conexionBD = DriverManager.getConnection(url, usuario, password);
        System.out.println("Conexión exitosa con la base de datos.");
        return conexionBD;

    } catch(SQLException error) {
        JOptionPane.showMessageDialog(null,
            "Credenciales incorrectas" +
            "\n\nURL:  " + url +
            "\nUsuario:  " + usuario + 
            "\nContraseña:  " + password + 
            "\n\nPor favor asegúrese de ingresar las credenciales correctas en el archivo de credenciales.\n",
            "Conexión con la base de datos fallida", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
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
}

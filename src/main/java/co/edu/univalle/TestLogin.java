package co.edu.univalle;
import co.edu.univalle.vistas.*;

import java.sql.*;
import co.edu.univalle.controlador.*;
import co.edu.univalle.persistencia.*;


public class TestLogin {
  public static void main(String[] args) {
      String url = "jdbc:postgresql://localhost:5432/biblioteca";
      String usuario = "postgres";
      String password = "password";
      FachadaBD fachadaBD = new FachadaBD(url, usuario, password);
      Connection conexionBD = fachadaBD.getConexionBD();

      Biblioteca biblioteca = new Biblioteca(conexionBD);

      biblioteca.getContrasenasUsuarios().encriptarContrasenas();
      biblioteca.getContrasenasEmpleados().encriptarContrasenas();
      
      // Crea la vista
      vistaLogin vistaLogin = new vistaLogin("Inicio Sesión");
      
      // Crea el controlador pasando las instancias DAO creadas 
      ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, biblioteca);
      
      // Inicializa la vista
      vistaLogin.setVisible(true);

      

      //fachadaBD.closeConexionBD(conexionBD);
    }
}

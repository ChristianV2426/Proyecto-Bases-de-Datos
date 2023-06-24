package co.edu.univalle;
import co.edu.univalle.vistas.vistaLogin;

import java.sql.Connection;

import co.edu.univalle.controlador.ControladorLogin;
import co.edu.univalle.persistencia.DaoContrasenaUsuario;
import co.edu.univalle.persistencia.DaoUsuario;
import co.edu.univalle.persistencia.DaoEmpleado;
import co.edu.univalle.persistencia.DaoContrasenaEmpleado;
import co.edu.univalle.persistencia.FachadaBD;

public class TestLogin {
  public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/biblioteca_database";
        String usuario = "ulven";
        String password = "Ulven_1729";

        FachadaBD fachadaBD = new FachadaBD(url, usuario, password);
        Connection conexionBD = fachadaBD.getConexionBD();

        // Crea las instancias DAO para el usuario y la contraseña
        DaoUsuario daoUsuario = new DaoUsuario(conexionBD);
        DaoContrasenaUsuario daoContrasenaUsuario = new DaoContrasenaUsuario(conexionBD);

        // Crea las instancias DAO para el empleado y su contraseña
        DaoEmpleado daoEmpleado = new DaoEmpleado(conexionBD);
        DaoContrasenaEmpleado daoContrasenaEmpleado = new DaoContrasenaEmpleado(conexionBD);
        
        // Crea la vista
        vistaLogin vistaLogin = new vistaLogin("Inicio Sesión");
        
        // Crea el controlador pasando las instancias DAO creadas
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, daoUsuario, daoContrasenaUsuario, daoEmpleado, daoContrasenaEmpleado);
        
        // Inicializa la vista
        vistaLogin.setVisible(true);
    }
}

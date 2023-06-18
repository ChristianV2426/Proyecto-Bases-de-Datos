/*
  Archivo: Main.java
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
package co.edu.univalle;

import co.edu.univalle.vistas.vistaLogin;
import co.edu.univalle.vistas.vistaUConsultarLibro;

import java.sql.Connection;

import co.edu.univalle.controlador.ControladorLogin;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.persistencia.DaoContrasenaUsuario;
import co.edu.univalle.persistencia.DaoUsuario;
import co.edu.univalle.persistencia.DaoEmpleado;
import co.edu.univalle.persistencia.DaoContrasenaEmpleado;
import co.edu.univalle.persistencia.FachadaBD;

public class Main {
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



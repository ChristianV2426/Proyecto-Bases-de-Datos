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

import co.edu.univalle.controlador.ControladorUsuario;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.persistencia.FachadaBD;
import co.edu.univalle.vistas.*;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String url = "jdbc:postgresql://localhost:5432/biblioteca_database";
        String usuario = "BleatingDog";
        String password = "&Santi14_SQL&";
        FachadaBD fachadaBD = new FachadaBD(url, usuario, password);
        Connection conexionBD = fachadaBD.getConexionBD();

        Biblioteca biblioteca = new Biblioteca(conexionBD);
        VistaUsuario prueba = new VistaUsuario("Modo Usuario", biblioteca, biblioteca.getUsuarios().obtenerElemento("US001"));
        //VistaEmpleado prueba2 = new VistaEmpleado("Modo Empleado");
    }
}
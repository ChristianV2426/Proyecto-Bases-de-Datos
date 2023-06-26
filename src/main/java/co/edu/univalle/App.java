/*
    Archivo: App.java
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

import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;
import java.sql.*;


public class App {
    public static void main(String[] args) {
        String rutaArchivoCredenciales = "./credenciales.txt";
        FachadaBD fachadaBD = new FachadaBD(rutaArchivoCredenciales);
        Connection conexionBD = fachadaBD.getConexionBD();
        Biblioteca biblioteca = new Biblioteca(conexionBD);

        //VistaLogin vistaLogin = new VistaLogin("Login", biblioteca);
        VistaEmpleado vistaEmpleado = new VistaEmpleado("Menú Empleado", biblioteca,biblioteca.getEmpleados().obtenerElemento("EM000"));

    }
}

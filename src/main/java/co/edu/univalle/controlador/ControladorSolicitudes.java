/*
  Archivo: ControladorSolicitudes.java
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

package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaEmpleado;

public class ControladorSolicitudes {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;

    public ControladorSolicitudes(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
    }
    
    
}

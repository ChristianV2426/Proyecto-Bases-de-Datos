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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorSolicitudes {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;

    public ControladorSolicitudes(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        vista.addListenersSolicitudes(new ManejadoraDeMouse());
        actualizarTabla();
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnRechazarSolicitud()){
                if (e.getButton() == 1 && vista.getBtnRechazarSolicitud().isEnabled()){
                    opcionRechazar();
                }
            }
            
            if (e.getSource() == vista.getBtnDescripcionSolicitud()){
                if (e.getButton() == 1 && vista.getBtnDescripcionSolicitud().isEnabled()){
                    opcionMostrar();
                }
            }
            
            if (e.getSource() == vista.getBtnAprobarSolicitud()){
                if (e.getButton() == 1 && vista.getBtnAprobarSolicitud().isEnabled()){
                    opcionAprobar();
                }
            }
        }
    }

    private void actualizarTabla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void opcionRechazar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionMostrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionAprobar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

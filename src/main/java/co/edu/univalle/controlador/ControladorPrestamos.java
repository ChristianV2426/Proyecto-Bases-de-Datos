/*
  Archivo: ControladorPrestamos.java
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

import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.modelo.*;
import co.edu.univalle.vistas.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.time.*;
import java.awt.*;

public class ControladorPrestamos {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();

    public ControladorPrestamos(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;

        vista.addListenersPrestamos(new ManejadoraDeMouse());

        vista.getTxtUsuarioPrestamoA().setText("");
        vista.getTxtNumPrestamoA().setText(biblioteca.getSerialPrestamo());
        vista.getTxtIsbnPrestamoA().setText("");
        vista.getTxtUsuarioPrestamoM().setText("");
        vista.getTxtIsbnPrestamoM().setText("");
        vista.getTxtUsuarioPrestamoC().setText("");
        vista.getTxtFechaPrestamoC().setText(LocalDate.now().toString());
        vista.getTxtPrestamoE().setText("");

        vista.getTxtNumPrestamoA().setEditable(false);
        vista.getTxtUsuarioPrestamoM().setEditable(false);
        vista.getTxtFechaPrestamoC().setEditable(false);
        vista.getTxtUsuarioPrestamoE().setEditable(false);

        vista.disenoTabla(vista.getTablaPrestamoA(), vista.getScrollPrestamoA());
        vista.getTablaPrestamoA().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));

        vista.disenoTabla(vista.getTablaPrestamoM(), vista.getScrollPrestamoM());
        vista.getTablaPrestamoM().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));

        vista.disenoTabla(vista.getTablaPrestamoC(), vista.getScrollPrestamoC());
        vista.getTablaPrestamoC().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraConsultarPrestamo()));

        vista.disenoTabla(vista.getTablaPrestamoE(), vista.getScrollPrestamoE());
        vista.getTablaPrestamoE().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));

    }

    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource() == vista.getBtnMultasTodasU()){
                if(e.getButton() == 1){
                }
            }

            // else if(e.getSource() == )
        }
    }
    
    
}

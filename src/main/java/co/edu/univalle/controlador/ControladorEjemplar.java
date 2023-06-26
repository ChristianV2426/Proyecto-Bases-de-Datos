/*
  Archivo: ControladorEjemplar.java
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

import co.edu.univalle.modelo.Ejemplar;
import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.modelo.Libro;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaEmpleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControladorEjemplar {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;

    public ControladorEjemplar(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        vista.addListenersEjemplares(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnCheckEjemplarA()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarA().isEnabled()){
                    opcionCheckA();
                }
            }
            
            if (e.getSource() == vista.getBtnAgregarEjemplarA()){
                if (e.getButton() == 1 && vista.getBtnAgregarEjemplarA().isEnabled()){
                    opcionAgregar();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckEjemplarM()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarM().isEnabled()){
                    opcionCheckM();
                }
            }
            
            if (e.getSource() == vista.getBtnModificarEjemplarM()){
                if (e.getButton() == 1 && vista.getBtnModificarEjemplarM().isEnabled()){
                    opcionModificar();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckEjemplarC()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarC().isEnabled()){
                    opcionCheckC();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckEjemplarE()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarE().isEnabled()){
                    opcionCheckE();
                }
            }
            
            if (e.getSource() == vista.getBtnEliminarEjemplarE()){
                if (e.getButton() == 1 && vista.getBtnEliminarEjemplarE().isEnabled()){
                    opcionEliminar();
                }
            }
        }
    }

    private void opcionCheckA() {
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarA().getText());
        if (libro == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
        } else {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado corresponde a: " + libro.getTitulo() + ".</p></html>", 
                        "Información", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
        }
    }

    private void opcionAgregar() {
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarA().getText());
        if (libro == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        biblioteca.getEjemplares().
        Ejemplar ejemplar = new Ejemplar(vista.getTxtIsbnEjemplarA(),vista.getTxtNumeroEjemplarA(),);
        biblioteca.getEjemplares().insertarElemento(ejemplar);
    }

    private void opcionCheckM() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionModificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionCheckC() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionCheckE() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionEliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

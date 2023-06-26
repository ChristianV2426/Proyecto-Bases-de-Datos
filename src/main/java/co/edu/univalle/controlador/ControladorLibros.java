/*
  Archivo: ControladorLibros.java
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
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControladorLibros {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;

    public ControladorLibros(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        vista.addListenersLibros(new ManejadoraDeMouse());
        System.out.println("Añadiendo listeners");
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnAgregarLibroA()){
                  if (e.getButton() == 1){
                      opcionAgregarLibro();
                  }
            }
               
            if (e.getSource() == vista.getBtnCheckLibroM() || e.getSource() == vista.getBtnCheckLibroC() || e.getSource() == vista.getBtnCheckLibroE()){
                if (e.getButton() == 1){
                    opcionCheckLibro();
                }
            }
            
            if (e.getSource() == vista.getBtnModificarLibroM()){
                if (e.getButton() == 1){
                    opcionModificarLibro();
                }
            }

            if (e.getSource() == vista.getBtnEliminarLibroE()){
                if (e.getButton() == 1){
                    opcionMultas();
                }
            }
            
            if (e.getSource() == vista.getBtnSiLibroA() || e.getSource() == vista.getBtnSiLibroM() || e.getSource() == vista.getBtnSiLibroC() || e.getSource() == vista.getBtnSiLibroE()){
                if (e.getButton() == 1){
                    opcionSiDigital();
                }
            }
            
            if (e.getSource() == vista.getBtnNoLibroA() || e.getSource() == vista.getBtnNoLibroM() || e.getSource() == vista.getBtnNoLibroC() || e.getSource() == vista.getBtnNoLibroE()){
                if (e.getButton() == 1){
                    opcionNoDigital();
                }
            }
            
            
        }

    }
    
    private void opcionAgregarLibro() {
        
        //Obteniendo los datos del libro
        String nombre = vista.getTxtNombreLibroA().getText();
        String isbn = vista.getTxtIsbnLibroA().getText();
        int numPagina = Integer.parseInt(vista.getTxtPaginasLibroA().getText());
        int anioPublicacion = Integer.parseInt(vista.getTxtAnoLibroA().getText());
        String idioma = (String)vista.getComboIdiomaLibroA().getSelectedItem();
        String codigoArea = (String)vista.getComboAreaLibroA().getSelectedItem();
        String codigoEditorial = (String)vista.getComboEditorialLibroA().getSelectedItem();;
        
        if (nombre.isEmpty()){
            System.out.println("hola");
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Todos los campos son obligatorios.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        } else {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Libro agregado con éxito.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
        }
        //Obteniendo los datos del libro si es digital
        if(vista.getBtnNoLibroA().isEnabled()){ //Si btnNo está habilitado, es porque el libro es digital
            String url = vista.getTxtUrlLibroA().getText();
            String tamBytes = vista.getTxtTamanoLibroA().getText();
            String formato = (String)vista.getComboFormatoLibroA().getSelectedItem();
        }
        
    }

    private void opcionConsultarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionCheckLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionModificarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionMultas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionSiDigital() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcionNoDigital() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

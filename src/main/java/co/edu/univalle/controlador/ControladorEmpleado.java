/*
  Archivo: ControladorEmpleado.java
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
import co.edu.univalle.vistas.VistaLogin;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ControladorEmpleado {
    private Biblioteca biblioteca;
    private VistaEmpleado vista;
    private Empleado empleado;

    public ControladorEmpleado(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado) {
        this.biblioteca = biblioteca;
        this.vista = vista;
        this.empleado = empleado;
        vista.addListeners(new ManejadoraDeMouse());
        
        //Listener para close
        vista.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                biblioteca.cerrarConexion();
                System.exit(0);
            }});
        
        //Creando controladores para el menú del empleado
        ControladorLibros controladorLibros = new ControladorLibros(vista, biblioteca, empleado);
        ControladorPrestamos controladorPrestamos = new ControladorPrestamos(vista, biblioteca, empleado);
        ControladorMultas controladorMultas = new ControladorMultas(vista, biblioteca, empleado);
        ControladorSolicitudes controladorSolicitudes = new ControladorSolicitudes(vista, biblioteca, empleado);
        ControladorDescargas controladorDescargas = new ControladorDescargas(vista, biblioteca, empleado);
        ControladorEjemplar controladorEjemplar = new ControladorEjemplar(vista, biblioteca, empleado);
        ControladorManejoPersonal controladorManejoPersonal = new ControladorManejoPersonal(vista, biblioteca, empleado);
//        if (empleado.getEsAdmin() == true){
//            ControladorManejoPersonal controladorManejoPersonal = new ControladorManejoPersonal(vista, biblioteca, empleado);
//        }
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnManejoPersonal()){
                  if (e.getButton() == 1 && vista.getBtnManejoPersonal().isEnabled()){
                      opcionManejoPersonal();
                  }
            }
                      
            if (e.getSource() == vista.getBtnLibros()){
                if (e.getButton() == 1){
                    opcionLibros();
                }
            }

            if (e.getSource() == vista.getBtnPrestamos()){
                if (e.getButton() == 1){
                    opcionPrestamos();
                }
            }

            if (e.getSource() == vista.getBtnMultas()){
                if (e.getButton() == 1){
                    opcionMultas();
                }
            }
            
            if (e.getSource() == vista.getBtnSolicitudes()){
                if (e.getButton() == 1){
                    opcionSolicitudes();
                }
            }
            
            if (e.getSource() == vista.getBtnDescargas()){
                  if (e.getButton() == 1){
                      opcionDescargas();
                  }
            }
            
            if (e.getSource() == vista.getBtnEjemplar()){
                  if (e.getButton() == 1){
                      opcionEjemplar();
                  }
            }
            
            if (e.getSource() == vista.getBtnCerrar()){
                  if (e.getButton() == 1){
                      opcionCerrar();
                  }
            }
        }
    }
    
    private void opcionManejoPersonal() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardManejo");
        
        //Modificando elementos gráficos
        vista.getBtnManejoPersonal().setEnabled(false);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
    }

    private void opcionLibros() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardLibro");
        
        //Modificando elementos gráficos
        vista.getBtnLibros().setEnabled(false);
        vista.getBtnManejoPersonal().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
    }

    private void opcionPrestamos() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardPrestamo");
        
        //Modificando elementos gráficos
        vista.getBtnPrestamos().setEnabled(false);
        vista.getBtnManejoPersonal().setEnabled(true);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
    }

    private void opcionMultas() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardMulta");
        
        //Modificando elementos gráficos
        vista.getBtnMultas().setEnabled(false);
        vista.getBtnManejoPersonal().setEnabled(true);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
    }

    private void opcionSolicitudes() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardSolicitud");
        
        //Modificando elementos gráficos
        vista.getBtnSolicitudes().setEnabled(false);
        vista.getBtnManejoPersonal().setEnabled(true);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
    }

    private void opcionDescargas() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardDescarga");
        
        //Modificando elementos gráficos
        vista.getBtnDescargas().setEnabled(false);
        vista.getBtnManejoPersonal().setEnabled(true);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
    }

    private void opcionEjemplar() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardEjemplar");
        
        //Modificando elementos gráficos
        vista.getBtnManejoPersonal().setEnabled(true);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(false);
    }

    private void opcionCerrar() {
        VistaLogin vistaLogin = new VistaLogin("Inicio Sesión", biblioteca);
        vista.dispose();
    }
    
    public static TableModel asignarModelo(String[][] datos, String[] encabezado) {
        TableModel model = new DefaultTableModel(datos, encabezado)
        {
            public boolean isCellEditable(int row, int column)
            {
                return false; //Esta línea se asegura de que no se editen las celdas de la tabla
            }
        };

        return model;
    }
    
    //Hacer que un TextField sólo permita ingresar números sin espacios
    public final void verificarNumero(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) | Character.isSpaceChar(c)){
                    e.consume();
                }
            }
        });
    }
    
    //Hacer que un TextField sólo permita ingresar letras y espacios
    public final void verificarTexto(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (Character.isAlphabetic(c) | Character.isSpaceChar(c)){
                    e.setKeyChar(c);
                } else {
                    e.consume();
                }
            }
        });
    }
}

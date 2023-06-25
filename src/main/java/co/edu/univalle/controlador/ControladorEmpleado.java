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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
}

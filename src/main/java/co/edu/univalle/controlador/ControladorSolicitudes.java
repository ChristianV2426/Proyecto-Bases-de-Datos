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
import co.edu.univalle.modelo.Solicitud;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaEmpleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        String[] cabeceraSolicitudes = vista.getCabeceraSolicitudes();
        String [][] todasLasSolicitudes = biblioteca.getSolicitudes().obtenerTodosLosElementos();
        vista.getTableSolicitud().setModel(asignarModelo(todasLasSolicitudes,cabeceraSolicitudes));
    }
    
    private void opcionRechazar() {
        int filaSeleccionada = vista.getTableSolicitud().getSelectedRow();
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se seleccionó ningúna solicitud.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        Solicitud solicitud = biblioteca.getSolicitudes().obtenerElemento(vista.obtenerInfoSolicitud(filaSeleccionada)[0]);
        
        if (!solicitud.getEstadoSolicitud().equals("En espera")){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Se debe seleccionar una solicitud en estado de 'En espera'.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        Solicitud cambio = new Solicitud(solicitud.getCodigoSolicitud(),solicitud.getIdUsuario(),solicitud.getFechaSolicitud(),solicitud.getDescripcion(),"Rechazada");
        
        biblioteca.getSolicitudes().editarElemento(cambio);
        JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Solicitud rechazada con éxito.</p></html>", 
                        "Información", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
        actualizarTabla();
    }

    private void opcionMostrar() {
        int filaSeleccionada = vista.getTableSolicitud().getSelectedRow();
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se seleccionó ningúna solicitud.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        Solicitud solicitud = biblioteca.getSolicitudes().obtenerElemento(vista.obtenerInfoSolicitud(filaSeleccionada)[0]);
        vista.getTxtAreaSolicitud().setText(solicitud.getDescripcion());
    }

    private void opcionAprobar() {
        int filaSeleccionada = vista.getTableSolicitud().getSelectedRow();
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se seleccionó ningúna solicitud.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        Solicitud solicitud = biblioteca.getSolicitudes().obtenerElemento(vista.obtenerInfoSolicitud(filaSeleccionada)[0]);
        
        if (!solicitud.getEstadoSolicitud().equals("En espera")){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Se debe seleccionar una solicitud en estado de 'En espera'.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        Solicitud cambio = new Solicitud(solicitud.getCodigoSolicitud(),solicitud.getIdUsuario(),solicitud.getFechaSolicitud(),solicitud.getDescripcion(),"Aceptada");
        
        biblioteca.getSolicitudes().editarElemento(cambio);
        JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Solicitud aceptada con éxito.</p></html>", 
                        "Información", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
        actualizarTabla();
        opcionEjemplar(vista.obtenerInfoSolicitud(filaSeleccionada)[5]);
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
    
    private void opcionEjemplar(String ISBN) {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardEjemplar");
        
        //Modificando elementos gráficos
        vista.getBtnEjemplar().setEnabled(false);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        if(empleado.getEsAdministrador() == true)
            vista.getBtnManejoPersonal().setEnabled(true);
        vista.getTxtIsbnEjemplarA().setText(ISBN);
    }
}

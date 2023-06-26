/*
  Archivo: ControladorMultas.java
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

public class ControladorMultas {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();

    public ControladorMultas(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        alinear.setHorizontalAlignment(SwingConstants.CENTER);

        vista.addListenersMultas(new ManejadoraDeMouse());

        vista.getTxtIdMultas().setText("");
        vista.getTxtFechaMultas().setText(LocalDate.now().toString());

        vista.getBtnMultasUsuarioU().setEnabled(false);
        vista.getTxtFechaMultas().setEditable(false);

        vista.disenoTabla(vista.getTableMultasU(), vista.getScrollMultasU());
        vista.getTableMultasU().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraMultas()));
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource() == vista.getBtnMultasTodasU()){
                if(e.getButton() == 1){
                    opcionMultasTodas();
                }
            }

            if(e.getSource() == vista.getBtnMultasUsuarioT()){
                if(e.getButton() == 1){
                    opcionMultasUsuario();
                }
            }

            if(e.getSource() == vista.getBtnCheckMultas()){
                if(e.getButton() == 1){
                    opcionCheckMultas();
                }
            }

            if(e.getSource() == vista.getBtnPagarMultas()){
                if(e.getButton() == 1){
                    opcionPagarMulta();
                }
            }
        }
    }

    private void opcionMultasTodas(){
        CardLayout cardLayout = (CardLayout) vista.getSubPanelMulta().getLayout();
        cardLayout.show(vista.getSubPanelMulta(), "cardMultaTodo");

        vista.getBtnMultasTodasT().setEnabled(false);
        vista.getBtnMultasUsuarioT().setEnabled(true);

        vista.disenoTabla(vista.getTableMultasT(), vista.getScrollMultasT());
        String[] cabeceraTodaMultas = vista.getCabeceraTodaLasMultas();
        String[][] todasMultas = biblioteca.getMultas().obtenerTodosLosElementos();

        vista.getTableMultasT().setModel(ControladorEmpleado.asignarModelo(todasMultas, cabeceraTodaMultas));
        vista.getTableMultasT().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTableMultasT().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTableMultasT().getColumnModel().getColumn(4).setCellRenderer(alinear);
        vista.getTableMultasT().getColumnModel().getColumn(5).setCellRenderer(alinear);
        vista.getTableMultasT().getColumnModel().getColumn(6).setCellRenderer(alinear);
    }

    private void opcionMultasUsuario(){
        CardLayout cardLayout = (CardLayout) vista.getSubPanelMulta().getLayout();
        cardLayout.show(vista.getSubPanelMulta(), "cardMultaUsuario");

        vista.getBtnMultasUsuarioU().setEnabled(false);
        vista.getBtnMultasTodasU().setEnabled(true);
        vista.getTxtIdMultas().setText("");

        vista.getTableMultasU().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraMultas()));  
    }

    private void opcionCheckMultas(){
        String idUsuario = vista.getTxtIdMultas().getText();

        if(idUsuario.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor ingrese el ID del usuario que desea consultar.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        Usuario usuario = biblioteca.getUsuarios().obtenerElemento(idUsuario);
        
        if(usuario == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El usuario no se encuentra registrado. Por favor verifique el ID ingresado.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        String[] cabeceraMultas = vista.getCabeceraMultas();
        String[][] multasUsuario = biblioteca.getMultas().obtenerMultasUsuario(idUsuario);

        if(multasUsuario == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El usuario no tiene multas registradas.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        vista.getTableMultasU().setModel(ControladorEmpleado.asignarModelo(multasUsuario, cabeceraMultas));
        vista.getTableMultasU().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTableMultasU().getColumnModel().getColumn(1).setCellRenderer(alinear);
        vista.getTableMultasU().getColumnModel().getColumn(3).setCellRenderer(alinear);
        vista.getTableMultasU().getColumnModel().getColumn(4).setCellRenderer(alinear);
        vista.getTableMultasU().getColumnModel().getColumn(5).setCellRenderer(alinear);
    }

    private void opcionPagarMulta(){
        int filaSeleccionada = vista.getTableMultasU().getSelectedRow();

        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Primero debe seleccionar una multa.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        String codigo_multa = vista.getTableMultasU().getValueAt(filaSeleccionada, 0).toString();
        Multa multa = biblioteca.getMultas().obtenerElemento(codigo_multa);

        if(multa.getEstadoMulta()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Esta multa ya se encuentra pagada.</p></html>", 
                        "Esta multa ya está pagada", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.warningIcon"));
            return;

        } else {
            multa.setEstadoMulta(Boolean.TRUE);

            if(biblioteca.getMultas().editarElemento(multa)){
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">La multa ha sido pagada.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.informationIcon"));

                opcionCheckMultas();
                return;
            }

            JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No se ha podido realizar la transacción.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
        }
    }

}

/*
  Archivo: ControladorUsuario.java
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

import co.edu.univalle.modelo.Libro;
import co.edu.univalle.modelo.Usuario;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaLogin;
import co.edu.univalle.vistas.VistaUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ControladorUsuario {
    private VistaUsuario vista;
    private Biblioteca biblioteca;
    private Usuario usuario;
    
    //CellRenderer para centrar columnas
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
    
    public ControladorUsuario(VistaUsuario vista, Biblioteca biblioteca, Usuario usuario) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.vista.addListeners(new ManejadoraDeMouse());
        this.vista.getTablaConsultar().setModel(asignarModelo(null,vista.getCabeceraConsultar()));
        alinear.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnConsultar()){
                  if (e.getButton() == 1){
                      opcionConsultar();
                  }
            }
          
            if (e.getSource() == vista.getBtnSolicitud()){
                if (e.getButton() == 1){
                    opcionSolicitud();
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
            
            if (e.getSource() == vista.getBtnCerrar()){
                if (e.getButton() == 1){
                    opcionCerrar();
                }
            }
            
            if (e.getSource() == vista.getBtnConsultarLibro()){
                  if (e.getButton() == 1){
                      opcionConsultarLibro();
                  }
            }
            
            if (e.getSource() == vista.getBtnConsultarLibros()){
                  if (e.getButton() == 1){
                      opcionConsultarLibros();
                  }
            }
        }
    }
    
    private void opcionConsultar() {
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardConsultar");
        vista.getBtnConsultar().setEnabled(false);
        vista.getBtnSolicitud().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.disenoTabla(vista.getTablaConsultar(), vista.getScrollConsultar());
        vista.getTablaConsultar().setModel(asignarModelo(null,vista.getCabeceraConsultar()));
    }
    
    private void opcionSolicitud() {
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardSolicitud");
        vista.getBtnSolicitud().setEnabled(false);
        vista.getBtnConsultar().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
    }

    private void opcionPrestamos() {
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardPrestamo");
        vista.getBtnPrestamos().setEnabled(false);
        vista.getBtnConsultar().setEnabled(true);
        vista.getBtnSolicitud().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.disenoTabla(vista.getTablaPrestamo(), vista.getScrollPrestamo());
        
        //Ingresando datos del usuario
        vista.getTxtNomPrestamo().setText(usuario.getNombreUsuario());
        vista.getTxtFechaPrestamo().setText(LocalDate.now().toString());
        String[] cabeceraPrestamo = vista.getCabeceraPrestamos();
        String[][] prestamosUsuario = biblioteca.getPrestamos().obtenerPrestamosUsuario(usuario.getIdUsuario());
        vista.getTablaPrestamo().setModel(asignarModelo(prestamosUsuario,cabeceraPrestamo));
    }

    private void opcionMultas() {
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardMulta");
        vista.getBtnMultas().setEnabled(false);
        vista.getBtnConsultar().setEnabled(true);
        vista.getBtnSolicitud().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.disenoTabla(vista.getTablaMulta(), vista.getScrollMulta());
        
        //Ingresando datos del usuario
        vista.getTxtNomMulta().setText(usuario.getNombreUsuario());
        vista.getTxtFechaMulta().setText(LocalDate.now().toString());
        String[] cabeceraMulta = vista.getCabeceraMultas();
        String[][] multasUsuario = biblioteca.getMultas().obtenerMultasUsuario(usuario.getIdUsuario());
        vista.getTablaMulta().setModel(asignarModelo(multasUsuario,cabeceraMulta));
    }
    
    private void opcionConsultarLibro() {
        
        //Obteniendo datos
        String libroIsbn = vista.getTxtIsbn().getText();
        if(libroIsbn.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Ingrese un ISBN.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String[][] libroAConsultar = biblioteca.getLibros().obtenerLibrosDisponibles(libroIsbn);
        if(libroAConsultar == null){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No existe un libro registrado con ese ISBN.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String[] cabeceraConsultar = vista.getCabeceraConsultar();
        vista.getTablaConsultar().setModel(asignarModelo(libroAConsultar,cabeceraConsultar));
        
        //Centra la columna especificada
        vista.getTablaConsultar().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaConsultar().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaConsultar().getColumnModel().getColumn(6).setCellRenderer(alinear);
        }

    private void opcionConsultarLibros() {
        vista.getTxtIsbn().setText("");
        String[] cabeceraConsultar = vista.getCabeceraConsultar();
        String [][] todosLosLibros = biblioteca.getLibros().obtenerTodosLosElementos();
        vista.getTablaConsultar().setModel(asignarModelo(todosLosLibros,cabeceraConsultar));
        
        //Centra la columna especificada
        vista.getTablaConsultar().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaConsultar().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaConsultar().getColumnModel().getColumn(6).setCellRenderer(alinear);

    }
    private void opcionCerrar() {
        VistaLogin vistaLogin = new VistaLogin("Inicio Sesión");
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
}

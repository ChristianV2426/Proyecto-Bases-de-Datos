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

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaLogin;
import co.edu.univalle.vistas.VistaUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.table.*;

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
        
        // Listener para close.
        vista.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                biblioteca.cerrarConexion();
                System.exit(0);
            }});
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
            
            if (e.getSource() == vista.getBtnDescargar()){
                  if (e.getButton() == 1){
                      opcionDescargar();
                  }
            }
            
            if (e.getSource() == vista.getBtnSolicitar()){
                  if (e.getButton() == 1){
                      opcionSolicitar();
                  }
            }
        }
    }
    
    private void opcionConsultar() {
        
        //Mostrando el panel de consultar
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardConsultar");
        
        //Modificando elementos gráficos
        vista.getBtnConsultar().setEnabled(false);
        vista.getBtnSolicitud().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        
        //Aplicando diseño a la tabla consultar
        vista.disenoTabla(vista.getTablaConsultar(), vista.getScrollConsultar());
        vista.getTablaConsultar().setModel(asignarModelo(null,vista.getCabeceraConsultar()));
    }
    
    private void opcionSolicitud() {
        
        //Mostrando el panel de consultar
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardSolicitud");
        
        //Modificando elementos gráficos
        vista.getBtnSolicitud().setEnabled(false);
        vista.getBtnConsultar().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        
        //Ingresando datos
        vista.getTxtUsuarioSolicitud().setText(usuario.getNombreUsuario());
        vista.getTxtFechaSolicitud().setText(LocalDate.now().toString());
        vista.getTxtIdSolicitud().setText(biblioteca.getSerialSolicitud());
        
    }

    private void opcionPrestamos() {
        
        //Mostrando el panel de consultar
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardPrestamo");
        
        //Modificando elementos gráficos
        vista.getBtnPrestamos().setEnabled(false);
        vista.getBtnConsultar().setEnabled(true);
        vista.getBtnSolicitud().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        
        //Aplicando diseño a la tabla préstamo
        vista.disenoTabla(vista.getTablaPrestamo(), vista.getScrollPrestamo());
        
        //Ingresando datos del usuario
        vista.getTxtNomPrestamo().setText(usuario.getNombreUsuario());
        vista.getTxtFechaPrestamo().setText(LocalDate.now().toString());
        String[] cabeceraPrestamo = vista.getCabeceraPrestamos();
        String[][] prestamosUsuario = biblioteca.getPrestamos().obtenerPrestamosUsuario(usuario.getIdUsuario());
        vista.getTablaPrestamo().setModel(asignarModelo(prestamosUsuario,cabeceraPrestamo));
    }

    private void opcionMultas() {
        //Aplicando diseño a la tabla consultar        
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardMulta");
        
        //Modificando elementos gráficos
        vista.getBtnMultas().setEnabled(false);
        vista.getBtnConsultar().setEnabled(true);
        vista.getBtnSolicitud().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        
        //Aplicando diseño a la tabla préstamo
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
    
    private void opcionDescargar() {
        
        int filaSeleccionada = vista.getTablaConsultar().getSelectedRow();
        if (filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se seleccionó ningún libro.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        //Oteniendo la información del libro seleccionado
        String[] infoLibro = vista.obtenerInfoLibro(filaSeleccionada);
        if (infoLibro[6] == "No"){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Este libro no está disponible digitalmente.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        } else {
            String libroADescargar = infoLibro[0];
            Digital libroDigital = biblioteca.getDigitales().obtenerElemento(libroADescargar);
            
            //Creando la descarga
            String codigoDescarga = biblioteca.getSerialDescarga();
            Descarga descargaUsuario = new Descarga(codigoDescarga, usuario, libroDigital, LocalDateTime.now().withNano(0),"192.168.0.5");
            
            //Añadiendo la descarga a la BD
            if (biblioteca.getDescargas().insertarElemento(descargaUsuario)){
                biblioteca.sumarSerialDescarga();
                JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Libro descargado con éxito.</p></html>", 
                        "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            } else {
                JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se pudo realizar la descarga.</p></html>", 
                        "Operación sin éxito", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            }
        }
    }
    
    private void opcionSolicitar() {
        
        String descripcion = vista.getTxtAreaSolicitud().getText();
        String isbn = vista.getTxtIsbnSolicitud().getText();
        
        if(isbn.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Debe ingresar el ISBN del libro.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        if(biblioteca.getLibros().obtenerElemento(isbn) == null){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Lo sentimos, este libro no se encuentra registrado en nuestra biblioteca.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        if(descripcion.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Debe explicar el motivo de su solicitud.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        //Obteniendo los datos de la vista
        LocalDate fechaSolicitud = LocalDate.parse(vista.getTxtFechaSolicitud().getText());
        String codigoSolicitud = biblioteca.getSerialSolicitud();
        
        //Creando la solicitud
        Solicitud solicitudCliente = new Solicitud(codigoSolicitud, usuario, fechaSolicitud, descripcion, "En espera");
        //Creando la relacion pide
        RelacionPide clientePide = new RelacionPide(solicitudCliente.getCodigoSolicitud(),isbn);
        
        //Añadiendo la solicitud y la relación pide a la BD
        if(biblioteca.getSolicitudes().insertarElemento(solicitudCliente) && biblioteca.getRelacionesPide().insertarElemento(clientePide)){
            biblioteca.sumarSerialSolicitud();
            
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Su solicitud ha sido registrada, la analizaremos lo más pronto posible.</p></html>", 
                        "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            vista.getTxtIdSolicitud().setText(biblioteca.getSerialSolicitud());
            //Limpiando campos
            limpiarSolicitud();
        } else {
            biblioteca.getSolicitudes().eliminarElemento(codigoSolicitud);
            biblioteca.getRelacionesPide().eliminarElemento(codigoSolicitud);
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se pudo realizar la solicitud.</p></html>", 
                        "Operación sin éxito", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
        }
    }
    
    private void opcionCerrar() {
        VistaLogin vistaLogin = new VistaLogin("Inicio Sesión", biblioteca);
        vista.dispose();
    }
    
    public void limpiarSolicitud(){
        vista.getTxtIsbnSolicitud().setText("");
        vista.getTxtAreaSolicitud().setText("");
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

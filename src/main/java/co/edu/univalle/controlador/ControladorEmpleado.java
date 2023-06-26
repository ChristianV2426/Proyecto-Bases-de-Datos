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

import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.modelo.*;
import co.edu.univalle.vistas.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

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
        ControladorLibros controladorLibros = new ControladorLibros(vista, biblioteca, empleado,this);
        ControladorPrestamos controladorPrestamos = new ControladorPrestamos(vista, biblioteca, empleado,this);
        ControladorMultas controladorMultas = new ControladorMultas(vista, biblioteca, empleado,this);
        ControladorSolicitudes controladorSolicitudes = new ControladorSolicitudes(vista, biblioteca, empleado,this);
        ControladorEjemplar controladorEjemplar = new ControladorEjemplar(vista, biblioteca, empleado,this);
        if (empleado.getEsAdministrador() == true){
            ControladorManejoPersonal controladorManejoPersonal = new ControladorManejoPersonal(vista, biblioteca, empleado,this);
        }
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

            if (e.getSource() == vista.getBtnDescargarInfo()){
                    if (e.getButton() == 1){
                        opcionDescargarInfo();
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
        
        //Estableciendo el ISBN del libro
        vista.getTxtIsbnLibroA().setText(biblioteca.getSerialLibro());
        vista.disenoTabla(vista.getTablaTodosLosLibros(), vista.getScrollTodosLosLibros());
        String[] cabeceraLibros = vista.getCabeceraConsultarLibros();
        String[][] todosLosLibros = biblioteca.getLibros().obtenerTodosLosElementos();
        vista.getTablaTodosLosLibros().setModel(asignarModelo(todosLosLibros,cabeceraLibros));
        vista.getPanelLibro().removeTabAt(3);
        
        //Modificando elementos gráficos del panel libro añadir
        vista.getBtnSiLibroA().setEnabled(true);
        vista.getBtnNoLibroA().setEnabled(false);
        vista.getTxtUrlLibroA().setVisible(false);
        vista.getTxtTamanoLibroA().setVisible(false);
        vista.getComboFormatoLibroA().setVisible(false);
        vista.getLblFormatoLibroA().setVisible(false);
        vista.getLblUrlLibroA().setVisible(false);
        vista.getLblTamanoLibroA().setVisible(false);
        
        //Modificando elementos gráficos del panel libro eliminar
        vista.getBtnSiLibroE().setEnabled(false);
        vista.getBtnEliminarLibroE().setEnabled(false);
        vista.getBtnNoLibroE().setEnabled(false);
        vista.getTxtUrlLibroE().setVisible(false);
        vista.getTxtTamanoLibroE().setVisible(false);
        vista.getComboFormatoLibroE().setVisible(false);
        vista.getLblFormatoLibroE().setVisible(false);
        vista.getLblUrlLibroE().setVisible(false);
        vista.getLblTamanoLibroE().setVisible(false);
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardLibro");
        
        //Modificando elementos gráficos del menú
        vista.getBtnLibros().setEnabled(false);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
        if(empleado.getEsAdministrador() == true)
            vista.getBtnManejoPersonal().setEnabled(true);
    }

    private void opcionPrestamos() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardPrestamo");
        vista.getPanelPrestamo().removeTabAt(1);
        //Modificando elementos gráficos
        vista.getBtnPrestamos().setEnabled(false);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
        if(empleado.getEsAdministrador() == true)
            vista.getBtnManejoPersonal().setEnabled(true);
    }

    private void opcionMultas() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardMulta");
        
        //Modificando elementos gráficos
        vista.getBtnMultas().setEnabled(false);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
        if(empleado.getEsAdministrador() == true)
            vista.getBtnManejoPersonal().setEnabled(true);
    }

    private void opcionSolicitudes() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardSolicitud");
        
        //Modificando elementos gráficos
        vista.getBtnSolicitudes().setEnabled(false);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnDescargas().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
        if(empleado.getEsAdministrador() == true)
            vista.getBtnManejoPersonal().setEnabled(true);
    }

    private void opcionDescargas() {
        
        //Mostrando el panel de manejo de personal
        vista.getCardLayout().show(vista.getPanelPrincipal(), "cardDescarga");
        
        //Modificando elementos gráficos
        vista.getBtnDescargas().setEnabled(false);
        vista.getBtnLibros().setEnabled(true);
        vista.getBtnPrestamos().setEnabled(true);
        vista.getBtnMultas().setEnabled(true);
        vista.getBtnSolicitudes().setEnabled(true);
        vista.getBtnEjemplar().setEnabled(true);
        if(empleado.getEsAdministrador() == true)
            vista.getBtnManejoPersonal().setEnabled(true);
        
        //Obteniendo descargas de la BD
        vista.disenoTabla(vista.getTableDescargas(), vista.getScrollDescargas());
        String[] cabeceraDescargas = vista.getCabeceraDescargas();
        String [][] todosLasDescargas = biblioteca.getDescargas().obtenerTodosLosElementos();
        vista.getTableDescargas().setModel(asignarModelo(todosLasDescargas,cabeceraDescargas));
    }

    private void opcionEjemplar() {
        
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
    }

    private void opcionDescargarInfo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = fileChooser.showOpenDialog(null);

        if(seleccion != JFileChooser.CANCEL_OPTION){
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if(ManejadorArchivos.guardarEnArchivoTextoPlano(biblioteca, ruta)){
                JOptionPane.showMessageDialog(null,"¡El resumen de la base de datos se guardó correctamente en un archivo de texto plano!", "Operación realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"¡Hubo un problema al guardar el estado de la aplicación en un archivo de texto plano!" +
                "\nAsegurese de haber seleccionado una carpeta de destino correcta. \nSi considera que este es un error, por favor póngase en contacto con el administrador del sistema.", "Operación fallida", JOptionPane.ERROR_MESSAGE);
            }
        }
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

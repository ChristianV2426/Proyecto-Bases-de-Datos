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

import co.edu.univalle.modelo.Digital;
import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.modelo.Libro;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaEmpleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControladorLibros {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;
    private boolean switchCheckM = false;
    private boolean switchCheckE = false;

    public ControladorLibros(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        controladorEmpleado.verificarNumero(vista.getTxtPaginasLibroA());
        controladorEmpleado.verificarNumero(vista.getTxtAnoLibroA());
        controladorEmpleado.verificarNumero(vista.getTxtPaginasLibroM());
        controladorEmpleado.verificarNumero(vista.getTxtAnoLibroM());
        controladorEmpleado.verificarNumero(vista.getTxtPaginasLibroC());
        controladorEmpleado.verificarNumero(vista.getTxtAnoLibroC());
        controladorEmpleado.verificarNumero(vista.getTxtPaginasLibroE());
        controladorEmpleado.verificarNumero(vista.getTxtAnoLibroE());
        vista.addListenersLibros(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnAgregarLibroA()){
                  if (e.getButton() == 1){
                      opcionAgregarLibro();
                  }
            }
               
            if (e.getSource() == vista.getBtnCheckLibroC()){
                if (e.getButton() == 1){
                    opcionCheckConsultarLibro();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckLibroM()){
                if (e.getButton() == 1){
                    opcionCheckModificarLibro();
                }
            }
            if (e.getSource() == vista.getBtnCheckLibroE()){
                if (e.getButton() == 1){
                    opcionCheckEliminarLibro();
                }
            }
            if (e.getSource() == vista.getBtnModificarLibroM()){
                if (e.getButton() == 1){
                    opcionModificarLibro();
                }
            }

            if (e.getSource() == vista.getBtnEliminarLibroE()){
                if (e.getButton() == 1){
                    opcionEliminarLibro();
                }
            }
            
            if (e.getSource() == vista.getBtnSiLibroA() || e.getSource() == vista.getBtnSiLibroM()){
                if (e.getButton() == 1){
                    opcionSiDigital((JButton)e.getSource());
                }
            }
            
            if (e.getSource() == vista.getBtnNoLibroA() || e.getSource() == vista.getBtnNoLibroM()){
                if (e.getButton() == 1){
                    opcionNoDigital((JButton)e.getSource());
                }
            }
        }
    }
    
    private void opcionAgregarLibro() {
        
        //Obteniendo los datos del libro
        String titulo = vista.getTxtNombreLibroA().getText();
        String isbn = vista.getTxtIsbnLibroA().getText();
        String numPaginas = vista.getTxtPaginasLibroA().getText();
        String anioPublicacion = vista.getTxtAnoLibroA().getText();
        String idioma = (String)vista.getComboIdiomaLibroA().getSelectedItem();
        String codigoArea = (String)vista.getComboAreaLibroA().getSelectedItem();
        String codigoEditorial = (String)vista.getComboEditorialLibroA().getSelectedItem();
        
        //Verificar que los campos no estén vacíos
        if (titulo.isBlank() || isbn.isBlank() || numPaginas.isBlank() || anioPublicacion.isBlank() || idioma.isBlank() || codigoArea.isBlank() || codigoEditorial.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Todos los campos son obligatorios.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        //Verificando si el libro es digital
        if(vista.getBtnNoLibroA().isEnabled()){ //Si btnNo está habilitado, es porque el libro es digital
            
            //Obteniendo los datos del libro digital
            String url = vista.getTxtUrlLibroA().getText();
            String tamBytes = vista.getTxtTamanoLibroA().getText();
            String formato = (String)vista.getComboFormatoLibroA().getSelectedItem();

            if(url.isBlank() || tamBytes.isBlank() || formato.isBlank()){
                JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">Todos los campos son obligatorios.</p></html>", 
                    "Error", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.errorIcon"));
            return;
            }
            //Conversiones para el libro digital
            int anioPublicacionInt = Integer.parseInt(anioPublicacion);
            int cantPaginas = Integer.parseInt(numPaginas);
            int tamBytesInt = Integer.parseInt(tamBytes);
            String codigoDigital = isbn + "-" + "URL01";
            
            //Creando el libro y su versión digital
            Libro libro = new Libro(isbn, titulo, cantPaginas, anioPublicacionInt, idioma, codigoArea.substring(0, 5), codigoEditorial.substring(0, 5));
            Digital libroDigital = new Digital(libro,codigoDigital, url, tamBytesInt, formato);
            
            //Agregando el libro y su versión digital a la BD
            if(biblioteca.getLibros().insertarElemento(libro) && biblioteca.getDigitales().insertarElemento(libroDigital)){
                biblioteca.sumarSerialLibro();
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">Libro agregado con éxito.</p></html>", 
                            "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.informationIcon"));
                limpiarAnadir();
                return;
            } else {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No se pudo agregar el libro.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
        }
        
        //Conversiones para el libro no digital
        Integer anioPublicacionInt = Integer.parseInt(anioPublicacion);
        Integer cantPaginas = Integer.parseInt(numPaginas);

        //Creado un libro no digital
        Libro libro = new Libro(isbn, titulo, cantPaginas, anioPublicacionInt, idioma, codigoArea.substring(0, 5), codigoEditorial.substring(0, 5));
        
        //Añadiendo el libro a la BD
        if(biblioteca.getLibros().insertarElemento(libro)){
            biblioteca.sumarSerialLibro();
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Libro agregado con éxito.</p></html>", 
                        "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            limpiarAnadir();
        } else {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se pudo agregar el libro.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
    }

    private void opcionCheckConsultarLibro() {
        String isbn = vista.getTxtIsbnLibroC().getText();
        if(isbn.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Ingrese un ISBN válido.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Libro libroAConsultar = biblioteca.getLibros().obtenerElemento(isbn);
        if(libroAConsultar == null){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Este libro no existe en la biblioteca.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String codigoEditorial = libroAConsultar.getCodigoEditorial();
        String nombreEditorial = biblioteca.getEditoriales().obtenerElemento(codigoEditorial).getNombreEditorial();
        String codigoArea = libroAConsultar.getCodigoArea();
        String nombreArea = biblioteca.getAreas().obtenerElemento(codigoArea).getNombreArea();

        vista.getTxtTituloLibroC().setText(libroAConsultar.getTitulo());
        vista.getTxtAnoLibroC().setText(libroAConsultar.getAnioPublicacion().toString());
        vista.getTxtPaginasLibroC().setText(libroAConsultar.getNumPagina().toString());
        vista.getComboIdiomaLibroC().setSelectedItem(libroAConsultar.getIdioma());
        vista.getComboEditorialLibroC().setSelectedItem(codigoEditorial + "-" + nombreEditorial);
        vista.getComboAreaLibroC().setSelectedItem(codigoArea + " - " + nombreArea);
        if(biblioteca.getDigitales().obtenerElemento(isbn) != null){
            Digital digital = biblioteca.getDigitales().obtenerElemento(isbn);
            vista.getTxtUrlLibroC().setText(digital.getUrl());
            vista.getTxtTamanoLibroC().setText(digital.getTamanoBytes().toString());
            vista.getComboFormatoLibroC().setSelectedItem(digital.getFormato());
        } else {
            vista.getTxtUrlLibroC().setVisible(false);
            vista.getTxtTamanoLibroC().setVisible(false);
            vista.getComboFormatoLibroC().setVisible(false);
            vista.getLblFormatoLibroC().setVisible(false);
            vista.getLblUrlLibroC().setVisible(false);
            vista.getLblTamanoLibroC().setVisible(false);
        }
    }
    
    private void opcionCheckModificarLibro() {
        String isbn = vista.getTxtIsbnLibroM().getText();
        if(isbn.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Ingrese un ISBN válido.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Libro libroAConsultar = biblioteca.getLibros().obtenerElemento(isbn);
        if(libroAConsultar == null){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Este libro no existe en la biblioteca.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        if(switchCheckM == false){
            vista.getBtnCheckLibroM().setText("Cancelar");
            switchCheckM = true;
            
            //Modificando la vista
            vista.getBtnModificarLibroM().setEnabled(true);
            vista.getTxtIsbnLibroM().setEnabled(false);
            vista.getTxtTituloLibroM().setEnabled(true);
            vista.getTxtAnoLibroM().setEnabled(true);
            vista.getTxtPaginasLibroM().setEnabled(true);
            vista.getComboIdiomaLibroM().setEnabled(true);
            vista.getComboEditorialLibroM().setEnabled(true);
            vista.getComboAreaLibroM().setEnabled(true);
            
            //Ingresando los datos del libro
            String codigoEditorial = libroAConsultar.getCodigoEditorial();
            String nombreEditorial = biblioteca.getEditoriales().obtenerElemento(codigoEditorial).getNombreEditorial();
            String codigoArea = libroAConsultar.getCodigoArea();
            String nombreArea = biblioteca.getAreas().obtenerElemento(codigoArea).getNombreArea();

            vista.getTxtTituloLibroM().setText(libroAConsultar.getTitulo());
            vista.getTxtAnoLibroM().setText(libroAConsultar.getAnioPublicacion().toString());
            vista.getTxtPaginasLibroM().setText(libroAConsultar.getNumPagina().toString());
            vista.getComboIdiomaLibroM().setSelectedItem(libroAConsultar.getIdioma());
            vista.getComboEditorialLibroM().setSelectedItem(codigoEditorial + "-" + nombreEditorial);
            vista.getComboAreaLibroM().setSelectedItem(codigoArea + " - " + nombreArea);
            
            if(biblioteca.getDigitales().obtenerElemento(isbn) != null){
                Digital digital = biblioteca.getDigitales().obtenerElemento(isbn);
                vista.getTxtUrlLibroM().setText(digital.getUrl());
                vista.getTxtTamanoLibroM().setText(digital.getTamanoBytes().toString());
                vista.getComboFormatoLibroM().setSelectedItem(digital.getFormato());
                vista.getTxtUrlLibroM().setVisible(true);
                vista.getTxtTamanoLibroM().setVisible(true);
                vista.getComboFormatoLibroM().setVisible(true);
                vista.getTxtUrlLibroM().setEnabled(true);
                vista.getTxtTamanoLibroM().setEnabled(true);
                vista.getComboFormatoLibroM().setEnabled(true);
                vista.getBtnSiLibroM().setEnabled(false);
                vista.getBtnNoLibroM().setEnabled(true);
                
            } else {
                vista.getBtnSiLibroM().setEnabled(true);
                vista.getBtnNoLibroM().setEnabled(false);
                vista.getTxtUrlLibroM().setVisible(false);
                vista.getTxtTamanoLibroM().setVisible(false);
                vista.getComboFormatoLibroM().setVisible(false);
                vista.getLblFormatoLibroM().setVisible(false);
                vista.getLblUrlLibroM().setVisible(false);
                vista.getLblTamanoLibroM().setVisible(false);
            }
            
        } else if (switchCheckM == true){
            vista.getBtnCheckLibroM().setText("Check");
            switchCheckM = false;
            
            //Modificando la vista
            vista.getTxtIsbnLibroM().setEnabled(true);
            vista.getTxtTituloLibroM().setEnabled(false);
            vista.getTxtAnoLibroM().setEnabled(false);
            vista.getTxtPaginasLibroM().setEnabled(false);
            vista.getComboIdiomaLibroM().setEnabled(false);
            vista.getComboEditorialLibroM().setEnabled(false);
            vista.getComboAreaLibroM().setEnabled(false);
            vista.getBtnSiLibroM().setEnabled(false);
            vista.getBtnNoLibroM().setEnabled(false);
            vista.getBtnModificarLibroM().setEnabled(false);
            
            limpiarModificar();
        }
    }
    
    private void opcionCheckEliminarLibro() {
        String isbn = vista.getTxtIsbnLibroE().getText();
        if(isbn.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Ingrese un ISBN válido.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Libro libroAEliminar = biblioteca.getLibros().obtenerElemento(isbn);
        if(libroAEliminar == null){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Este libro no existe en la biblioteca.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        if(switchCheckE == false){
            vista.getBtnCheckLibroE().setText("Cancelar");
            vista.getBtnEliminarLibroE().setEnabled(true);
            vista.getTxtIsbnLibroE().setEnabled(false);
            switchCheckE = true;
            
            //Ingresando los datos del libro a eliminar
            String codigoEditorial = libroAEliminar.getCodigoEditorial();
            String nombreEditorial = biblioteca.getEditoriales().obtenerElemento(codigoEditorial).getNombreEditorial();
            String codigoArea = libroAEliminar.getCodigoArea();
            String nombreArea = biblioteca.getAreas().obtenerElemento(codigoArea).getNombreArea();

            vista.getTxtTituloLibroE().setText(libroAEliminar.getTitulo());
            vista.getTxtAnoLibroE().setText(libroAEliminar.getAnioPublicacion().toString());
            vista.getTxtPaginasLibroE().setText(libroAEliminar.getNumPagina().toString());
            vista.getComboIdiomaLibroE().setSelectedItem(libroAEliminar.getIdioma());
            vista.getComboEditorialLibroE().setSelectedItem(codigoEditorial + "-" + nombreEditorial);
            vista.getComboAreaLibroE().setSelectedItem(codigoArea + " - " + nombreArea);

            if(biblioteca.getDigitales().obtenerElemento(isbn) != null){
                Digital digital = biblioteca.getDigitales().obtenerElemento(isbn);
                vista.getTxtUrlLibroE().setText(digital.getUrl());
                vista.getTxtTamanoLibroE().setText(digital.getTamanoBytes().toString());
                vista.getComboFormatoLibroE().setSelectedItem(digital.getFormato());
            } else {
                vista.getTxtUrlLibroE().setVisible(false);
                vista.getTxtTamanoLibroE().setVisible(false);
                vista.getComboFormatoLibroE().setVisible(false);
                vista.getLblFormatoLibroE().setVisible(false);
                vista.getLblUrlLibroE().setVisible(false);
                vista.getLblTamanoLibroE().setVisible(false);
            }
        } else if (switchCheckE == true){
            vista.getBtnCheckLibroE().setText("Check");
            vista.getTxtIsbnLibroE().setEnabled(true);
            vista.getBtnEliminarLibroE().setEnabled(false);
            switchCheckE = false;
            limpiarEliminar();
        }
    }


    private void opcionModificarLibro() {
        
        //Obteniendo los datos del libro
        String titulo = vista.getTxtTituloLibroM().getText();
        String isbn = vista.getTxtIsbnLibroM().getText();
        String numPaginas = vista.getTxtPaginasLibroM().getText();
        String anioPublicacion = vista.getTxtAnoLibroM().getText();
        String idioma = (String)vista.getComboIdiomaLibroM().getSelectedItem();
        String codigoArea = (String)vista.getComboAreaLibroM().getSelectedItem();
        String codigoEditorial = (String)vista.getComboEditorialLibroM().getSelectedItem();
        
        //Verificar que los campos no estén vacíos
        if (titulo.isBlank() || isbn.isBlank() || numPaginas.isBlank() || anioPublicacion.isBlank() || idioma.isBlank() || codigoArea.isBlank() || codigoEditorial.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Todos los campos son obligatorios.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        
        //Verificando si el libro es digital
        if(vista.getBtnNoLibroM().isEnabled()){ //Si btnNo está habilitado, es porque el libro es digital
            
            //Obteniendo los datos del libro digital
            String url = vista.getTxtUrlLibroM().getText();
            String tamBytes = vista.getTxtTamanoLibroM().getText();
            String formato = (String)vista.getComboFormatoLibroM().getSelectedItem();

            if(url.isBlank() || tamBytes.isBlank() || formato.isBlank()){
                JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">Todos los campos son obligatorios.</p></html>", 
                    "Error", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.errorIcon"));
            return;
            }
            //Conversiones para el libro digital
            int anioPublicacionInt = Integer.parseInt(anioPublicacion);
            int cantPaginas = Integer.parseInt(numPaginas);
            int tamBytesInt = Integer.parseInt(tamBytes);
            String codigoDigital = isbn + "-" + "URL01";
            
            //Creando el libro y su versión digital
            Libro libro = new Libro(isbn, titulo, cantPaginas, anioPublicacionInt, idioma, codigoArea.substring(0, 5), codigoEditorial.substring(0, 5));
            Digital libroDigital = new Digital(libro,codigoDigital, url, tamBytesInt, formato);
            
            //Modificando el libro y su versión digital en la BD
            if(biblioteca.getLibros().editarElemento(libro) && biblioteca.getDigitales().editarElemento(libroDigital)){
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">Libro modificado con éxito.</p></html>", 
                            "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.informationIcon"));
                limpiarModificar();
                return;
            } else {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No se pudo modificar el libro.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
        }
        
        //Conversiones para el libro no digital
        Integer anioPublicacionInt = Integer.parseInt(anioPublicacion);
        Integer cantPaginas = Integer.parseInt(numPaginas);

        //Creado un libro no digital
        Libro libro = new Libro(isbn, titulo, cantPaginas, anioPublicacionInt, idioma, codigoArea.substring(0, 5), codigoEditorial.substring(0, 5));
        
        //Modificando el libro en la BD
        if(biblioteca.getLibros().editarElemento(libro)){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Libro modificado con éxito.</p></html>", 
                        "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            limpiarModificar();
        } else {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No se pudo modificar el libro.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
    }

    private void opcionEliminarLibro() {
        String isbn = vista.getTxtIsbnLibroE().getText();
        Libro libroAEliminar = biblioteca.getLibros().obtenerElemento(isbn);
        JOptionPane.showMessageDialog(vista, isbn);
        JOptionPane.showMessageDialog(vista, biblioteca.getSerialLibro());
        
        if(libroAEliminar == null){
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Este libro no existe en la biblioteca.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String codigoDigitalABorrar = "";
        if(biblioteca.getDigitales().obtenerElemento(isbn) != null){
            codigoDigitalABorrar = biblioteca.getDigitales().obtenerElemento(isbn).getCodigoDigital();
            
        }
        String codigo;
        String[][] numero = biblioteca.getEjemplares().obtenerTodosLosElementos();
        ArrayList<String> ejemplaresAEliminar = new ArrayList();
        
        //Bucle para extraer los códigos de los ejemplares a eliminar
        for(int i = 0; i < numero.length; i++){
            if(numero[0][i].equals(isbn)){
                if (Integer.parseInt(numero[2][i]) < 10) {
                    JOptionPane.showMessageDialog(vista, vista);
                    ejemplaresAEliminar.add(isbn + "-N0" + numero[2][i]);
                } else {
                    ejemplaresAEliminar.add(isbn + "-N" + numero[2][i]);
                }
            }
        }
        
        ArrayList<Boolean> ejemplaresEliminados = new ArrayList();
        //Bucle para eliminar todos los ejemplares
        for(int i = 0; i < ejemplaresAEliminar.size(); i++){
            if(biblioteca.getEjemplares().eliminarElemento(ejemplaresAEliminar.get(i))){
                ejemplaresEliminados.add(true);
            }
        }
        
        if(biblioteca.getLibros().eliminarElemento(isbn) && biblioteca.getDigitales().eliminarElemento(codigoDigitalABorrar) && ejemplaresEliminados.size() == ejemplaresAEliminar.size()){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El libro fue eliminado con éxito.</p></html>", 
                "Operación realizada con éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.informationIcon"));
            vista.getTxtIsbnLibroA().setText(biblioteca.getSerialLibro());
            limpiarEliminar();
        } else {
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">No se pudo eliminar el libro.</p></html>", 
                "Error", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            }
    }

    private void opcionSiDigital(JButton boton) {
        if(boton == vista.getBtnSiLibroA()){
            boton.setEnabled(false);
            vista.getBtnNoLibroA().setEnabled(true);
            vista.getTxtUrlLibroA().setVisible(true);
            vista.getTxtTamanoLibroA().setVisible(true);
            vista.getComboFormatoLibroA().setVisible(true);
            vista.getLblFormatoLibroA().setVisible(true);
            vista.getLblUrlLibroA().setVisible(true);
            vista.getLblTamanoLibroA().setVisible(true);
            return;
        }
        
        if(boton == vista.getBtnSiLibroM() && boton.isEnabled()){
            boton.setEnabled(false);
            vista.getBtnNoLibroM().setEnabled(true);
            vista.getTxtUrlLibroM().setVisible(true);
            vista.getTxtTamanoLibroM().setVisible(true);
            vista.getComboFormatoLibroM().setVisible(true);
            vista.getLblFormatoLibroM().setVisible(true);
            vista.getLblUrlLibroM().setVisible(true);
            vista.getLblTamanoLibroM().setVisible(true);
            return;
        }
    }

    private void opcionNoDigital(JButton boton) {
        if(boton == vista.getBtnNoLibroA()){
            boton.setEnabled(true);
            vista.getBtnNoLibroA().setEnabled(false);
            vista.getTxtUrlLibroA().setVisible(false);
            vista.getTxtTamanoLibroA().setVisible(false);
            vista.getComboFormatoLibroA().setVisible(false);
            vista.getLblFormatoLibroA().setVisible(false);
            vista.getLblUrlLibroA().setVisible(false);
            vista.getLblTamanoLibroA().setVisible(false);
        }
        if(boton == vista.getBtnNoLibroM() && boton.isEnabled()){
            boton.setEnabled(false);
            vista.getBtnSiLibroM().setEnabled(true);
            vista.getBtnNoLibroM().setEnabled(false);
            vista.getTxtUrlLibroM().setVisible(false);
            vista.getTxtTamanoLibroM().setVisible(false);
            vista.getComboFormatoLibroM().setVisible(false);
            vista.getLblFormatoLibroM().setVisible(false);
            vista.getLblUrlLibroM().setVisible(false);
            vista.getLblTamanoLibroM().setVisible(false);
            return;
        }
    }
    
    private void limpiarAnadir(){
        //Limpiando los campos de la ventana y seteando próximo isbn
        vista.getTxtNombreLibroA().setText("");
        vista.getTxtIsbnLibroA().setText(biblioteca.getSerialLibro());
        vista.getTxtPaginasLibroA().setText("");
        vista.getTxtAnoLibroA().setText("");
        vista.getComboIdiomaLibroA().setSelectedItem(vista.getComboIdiomaLibroA().getModel().getElementAt(0));
        vista.getComboAreaLibroA().setSelectedItem(vista.getComboAreaLibroA().getModel().getElementAt(0));
        vista.getComboEditorialLibroA().setSelectedItem(vista.getComboEditorialLibroA().getModel().getElementAt(0));
    }
    
    private void limpiarModificar(){
        //Limpiando los campos de la ventana modificar
        vista.getTxtTituloLibroM().setText("");
        vista.getTxtIsbnLibroM().setText("");
        vista.getTxtPaginasLibroM().setText("");
        vista.getTxtAnoLibroM().setText("");
        vista.getComboIdiomaLibroM().setSelectedItem(vista.getComboIdiomaLibroM().getModel().getElementAt(0));
        vista.getComboAreaLibroM().setSelectedItem(vista.getComboAreaLibroM().getModel().getElementAt(0));
        vista.getComboEditorialLibroM().setSelectedItem(vista.getComboEditorialLibroM().getModel().getElementAt(0));
        
        //Modificando la ventana
        vista.getBtnCheckLibroM().setText("Check");
        vista.getTxtIsbnLibroM().setEnabled(true);
        vista.getTxtUrlLibroM().setVisible(false);
        vista.getTxtTamanoLibroM().setVisible(false);
        vista.getComboFormatoLibroM().setVisible(false);
        vista.getLblFormatoLibroM().setVisible(false);
        vista.getLblUrlLibroM().setVisible(false);
        vista.getLblTamanoLibroM().setVisible(false);
        vista.getComboEditorialLibroM().setEnabled(false);
        vista.getComboAreaLibroM().setEnabled(false);
        vista.getComboIdiomaLibroM().setEnabled(false);
        vista.getTxtPaginasLibroM().setEnabled(false);
        vista.getTxtTituloLibroM().setEnabled(false);
        vista.getTxtAnoLibroM().setEnabled(false);
        vista.getBtnNoLibroM().setEnabled(false);
        vista.getBtnSiLibroM().setEnabled(false);
        vista.getBtnModificarLibroM().setEnabled(false);
    }
    
    public void limpiarEliminar(){
        //Limpiando los campos de la ventana eliminar
        vista.getBtnEliminarLibroE().setEnabled(false);
        vista.getTxtTituloLibroE().setText("");
        vista.getTxtIsbnLibroE().setText("");
        vista.getTxtPaginasLibroE().setText("");
        vista.getTxtAnoLibroE().setText("");
        vista.getComboIdiomaLibroE().setSelectedItem(vista.getComboIdiomaLibroE().getModel().getElementAt(0));
        vista.getComboAreaLibroE().setSelectedItem(vista.getComboAreaLibroE().getModel().getElementAt(0));
        vista.getComboEditorialLibroE().setSelectedItem(vista.getComboEditorialLibroE().getModel().getElementAt(0));
        
    }
}

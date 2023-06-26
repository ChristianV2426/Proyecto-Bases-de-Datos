/*
  Archivo: ControladorPrestamos.java
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
import java.math.BigDecimal;
import javax.swing.*;
import javax.swing.table.*;
import java.time.*;
import java.awt.*;
import java.util.*;
import java.time.temporal.*;

public class ControladorPrestamos {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;
    private boolean switchBtnCheckPrestamoA = false;
    ArrayList<String[]> listaPrestamos = new ArrayList<String[]>();
    private DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();

    public ControladorPrestamos(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;

        vista.addListenersPrestamos(new ManejadoraDeMouse());
        alinear.setHorizontalAlignment(SwingConstants.CENTER);

        vista.getTxtUsuarioPrestamoA().setText("");
        vista.getTxtNumPrestamoA().setText(biblioteca.getSerialPrestamo());
        vista.getTxtIsbnPrestamoA().setText("");
        vista.getTxtUsuarioPrestamoM().setText("");
        vista.getTxtIsbnPrestamoM().setText("");
        vista.getTxtUsuarioPrestamoC().setText("");
        vista.getTxtFechaPrestamoC().setText(LocalDate.now().toString());
        vista.getTxtPrestamoE().setText("");

        vista.getTxtNumPrestamoA().setEditable(false);
        vista.getTxtUsuarioPrestamoM().setEditable(false);
        vista.getTxtFechaPrestamoC().setEditable(false);
        vista.getTxtUsuarioPrestamoE().setEditable(false);

        vista.disenoTabla(vista.getTablaPrestamoA(), vista.getScrollPrestamoA());
        vista.getTablaPrestamoA().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));

        vista.disenoTabla(vista.getTablaPrestamoM(), vista.getScrollPrestamoM());
        vista.getTablaPrestamoM().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));

        vista.disenoTabla(vista.getTablaPrestamoC(), vista.getScrollPrestamoC());
        vista.getTablaPrestamoC().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraConsultarPrestamo()));

        vista.disenoTabla(vista.getTablaPrestamoE(), vista.getScrollPrestamoE());
        vista.getTablaPrestamoE().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraConsultarPrestamo()));
    }

    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource() == vista.getBtnCheckPrestamoA()){
                if(e.getButton() == 1){
                    if(switchBtnCheckPrestamoA)
                        opcionBorrarUsuarioAnhadir();
        
                    else
                        opcionVerificarUsuarioAnhadir();
                }
            }

            if(e.getSource() == vista.getBtnVerificarPrestamoA())
                if(e.getButton() == 1){
                    opcionVerificarLibro();                    
                }
            
            if(e.getSource() == vista.getBtnAgregarPrestamoA()){
                if(e.getButton() == 1){
                    opcionAgregarEjemplar();
                }
            }

            if(e.getSource() == vista.getBtnRemoverPrestamoA()){
                if(e.getButton() == 1){
                    opcionRemoverEjemplar();
                }
            }

            if(e.getSource() == vista.getBtnRealizarPrestamoA()){
                if(e.getButton() == 1){
                    opcionRealizarPrestamo();
                }
            }

            if(e.getSource() == vista.getBtnCheckPrestamoC()){
                if(e.getButton() == 1){
                    opcionVerificarUsuarioConsultar();
                }
            }

            if(e.getSource() == vista.getBtnDevolverPrestamoC()){
                if(e.getButton() == 1){
                    opcionDevolverEjemplar();
                }
            }

            if(e.getSource() == vista.getBtnCheckPrestamoE()){
                if(e.getButton() == 1){
                    opcionVerificarUsuarioEliminar();
                }
            }

            if(e.getSource() == vista.getBtnEliminarPrestamoE()){
                if(e.getButton() == 1){
                    opcionEliminarPrestamo();
                }
            }
        }
    }

    private void opcionVerificarUsuarioAnhadir() {
        String idUsuario = vista.getTxtUsuarioPrestamoA().getText();

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
                "<html><p style = \" font:12px; \">El usuario no se encuentra registrado. Por favor verifique el ID ingresado..</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return; 
        }

        switchBtnCheckPrestamoA = true;
        vista.getBtnCheckPrestamoA().setText("Borrar");
        vista.getTxtUsuarioPrestamoA().setEditable(false);
        vista.getTxtIsbnPrestamoA().setEditable(true);
        vista.getTxtIsbnPrestamoA().setEnabled(true);
        vista.getBtnVerificarPrestamoA().setEnabled(true);
    }

    private void opcionBorrarUsuarioAnhadir() {
        switchBtnCheckPrestamoA = false;
        vista.getBtnCheckPrestamoA().setText("Check");
        vista.getTxtUsuarioPrestamoA().setEditable(true);
        vista.getTxtIsbnPrestamoA().setText("");
        vista.getTxtIsbnPrestamoA().setEditable(false);
        vista.getBtnVerificarPrestamoA().setEnabled(false);
        vista.getComboEjemplarPrestamoA().removeAllItems();
        vista.getComboEjemplarPrestamoA().setEditable(false);
        vista.getComboEjemplarPrestamoA().setEnabled(false);
        vista.getBtnAgregarPrestamoA().setEnabled(false);
        vista.getTablaPrestamoA().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));

    }

    private void opcionVerificarLibro() {
        String isbnLibro = vista.getTxtIsbnPrestamoA().getText();

        if(isbnLibro.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor ingrese el ISBN del libro que desea consultar.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        Libro libro = biblioteca.getLibros().obtenerElemento(isbnLibro);

        if(libro == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El libro no se encuentra registrado. Por favor verifique el ISBN ingresado.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            
            vista.getComboEjemplarPrestamoA().removeAllItems();
            vista.getComboEjemplarPrestamoA().setEditable(false);
            vista.getComboEjemplarPrestamoA().setEnabled(false);
            vista.getBtnAgregarPrestamoA().setEnabled(false);
            return; 
        }

        ArrayList<String> ejemplaresDisponibles = biblioteca.getEjemplares().ejemplaresDisponibles(isbnLibro);

        if(ejemplaresDisponibles == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Lo sentimos, el libro ingresado no tiene ejemplares disponibles para préstamo.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            
            vista.getComboEjemplarPrestamoA().removeAllItems();
            vista.getComboEjemplarPrestamoA().setEditable(false);
            vista.getComboEjemplarPrestamoA().setEnabled(false);
            vista.getBtnAgregarPrestamoA().setEnabled(false);
            return; 
        }

        vista.getComboEjemplarPrestamoA().setModel(new DefaultComboBoxModel<>(ejemplaresDisponibles.toArray(new String[0])));
        vista.getComboEjemplarPrestamoA().setEditable(true);
        vista.getComboEjemplarPrestamoA().setEnabled(true);
        vista.getBtnAgregarPrestamoA().setEnabled(true);

    }

    private void opcionAgregarEjemplar() {
        String codigoEjemplar = vista.getComboEjemplarPrestamoA().getSelectedItem().toString();
        Ejemplar ejemplar = biblioteca.getEjemplares().obtenerElemento(codigoEjemplar);

        if(ejemplar == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El ejemplar no se encuentra registrado. Por favor verifique el código de ejemplar seleccionado.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return; 
        }

        String[] nuevoEjemplar = {ejemplar.getCodigoEjemplar(), ejemplar.getTitulo(), LocalDate.now().toString(), LocalDate.now().plusDays(10).toString()};
        
        if((listaPrestamos.stream().map(e -> e[0].equals(nuevoEjemplar[0])).anyMatch(e -> e))){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El ejemplar ya se encuentra en la lista de préstamos.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return; 
        }

        listaPrestamos.add(nuevoEjemplar);

        vista.getTablaPrestamoA().setModel(ControladorEmpleado.asignarModelo(listaPrestamos.toArray(new String[listaPrestamos.size()][]), vista.getCabeceraPrestamo()));
        vista.getTablaPrestamoA().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaPrestamoA().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaPrestamoA().getColumnModel().getColumn(3).setCellRenderer(alinear);
    }

    private void opcionRemoverEjemplar() {
        int filaSeleccionada = vista.getTablaPrestamoA().getSelectedRow();

        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor seleccione el ejemplar que desea eliminar.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        listaPrestamos.remove(filaSeleccionada);
        vista.getTablaPrestamoA().setModel(ControladorEmpleado.asignarModelo(listaPrestamos.toArray(new String[listaPrestamos.size()][]), vista.getCabeceraPrestamo()));
        vista.getTablaPrestamoA().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaPrestamoA().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaPrestamoA().getColumnModel().getColumn(3).setCellRenderer(alinear);

    }

    private void opcionRealizarPrestamo() {
        int ejemplaresEnPrestamo = listaPrestamos.size();

        if(ejemplaresEnPrestamo == 0){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor agregue al menos un ejemplar a la lista de préstamos.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        String codigoPrestamo = vista.getTxtNumPrestamoA().getText();
        String idUsuario = vista.getTxtUsuarioPrestamoA().getText();
        String idEmpleado = empleado.getIdEmpleado();
        LocalDate fechaPrestamo = LocalDate.now();

        Prestamo prestamo = new Prestamo(codigoPrestamo, idUsuario, idEmpleado, fechaPrestamo);
        ArrayList<RelacionPresta> listaRelaciones = new ArrayList<>();
        ArrayList<Ejemplar> listaEjemplares = new ArrayList<>();

        for(String[] ejemplar : listaPrestamos){
            RelacionPresta relacion = new RelacionPresta(biblioteca.getSerialPresta(), codigoPrestamo, ejemplar[0], LocalDate.now().plusDays(10));
            Ejemplar ejemplarPrestado = biblioteca.getEjemplares().obtenerElemento(ejemplar[0]);
            ejemplarPrestado.setDisponible(Boolean.FALSE);
            System.out.println(ejemplarPrestado.getCodigoEjemplar() + " "+  ejemplarPrestado.getDisponible());
            biblioteca.getEjemplares().editarElemento(ejemplarPrestado);
            biblioteca.sumarSerialPresta();
            listaRelaciones.add(relacion);
        }



        if(biblioteca.getPrestamos().insertarElemento(prestamo) &&
            (listaRelaciones.stream().map(presta -> biblioteca.getRelacionesPresta().insertarElemento(presta))).allMatch(e -> e) &&
                (listaEjemplares.stream().map(ejemplar -> biblioteca.getEjemplares().editarElemento(ejemplar))).allMatch(e -> e)){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El préstamo se ha realizado con éxito.</p></html>", 
                "Operación exitosa", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.informationIcon"));

            biblioteca.sumarSerialPrestamo();
            vista.getTxtNumPrestamoA().setText(biblioteca.getSerialPrestamo());
            opcionBorrarUsuarioAnhadir();
            listaPrestamos.clear();
            vista.getTablaPrestamoA().setModel(ControladorEmpleado.asignarModelo(null, vista.getCabeceraPrestamo()));
            return;
        }


    }

    private void opcionVerificarUsuarioConsultar() {
        String idUsuario = vista.getTxtUsuarioPrestamoC().getText();

        if(idUsuario.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor ingrese el ID del usuario.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        Usuario usuario = biblioteca.getUsuarios().obtenerElemento(idUsuario);

        if(usuario == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El usuario no se encuentra registrado en el sistema.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        String[][] listaPrestamos = biblioteca.getPrestamos().obtenerPrestamosUsuario(idUsuario);

        if(listaPrestamos == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El usuario no tiene préstamos registrados en el sistema.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }



        String[] cabecera = vista.getCabeceraConsultarPrestamo();
        vista.getTablaPrestamoC().setModel(ControladorEmpleado.asignarModelo(listaPrestamos, cabecera));
        vista.getTablaPrestamoC().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaPrestamoC().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaPrestamoC().getColumnModel().getColumn(3).setCellRenderer(alinear);
        vista.getTablaPrestamoC().getColumnModel().getColumn(4).setCellRenderer(alinear);
        vista.getTablaPrestamoC().getColumnModel().getColumn(5).setCellRenderer(alinear);
        vista.getTablaPrestamoC().getColumnModel().getColumn(6).setCellRenderer(alinear);
        }
    
    private void opcionDevolverEjemplar() {
        int filaSeleccionada = vista.getTablaPrestamoC().getSelectedRow();

        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor seleccione el ejemplar que desea devolver.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        String codigoPresta = (String) vista.getTablaPrestamoC().getValueAt(filaSeleccionada, 0);
        RelacionPresta presta = biblioteca.getRelacionesPresta().obtenerElemento(codigoPresta);
        String estado = (String) vista.getTablaPrestamoC().getValueAt(filaSeleccionada, 6);

        if(presta == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El préstamo del ejemplar no se encuentra registrado en el sistema.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        if(estado.equals("Entregado") || estado.equals("Entregado con retraso")){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El ejemplar ya ha sido devuelto.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        presta.setFechaDevolucionReal(LocalDate.now());

        if(biblioteca.getRelacionesPresta().editarElemento(presta)){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El ejemplar se ha devuelto con éxito.</p></html>", 
                "Operación exitosa", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.informationIcon"));
            opcionVerificarUsuarioConsultar();

            if(presta.getFechaDevolucionReal().isAfter(presta.getFechaDevolucionEsperada())){
                JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">Sin embargo, el ejemplar ha sido devuelto con mora. Por lo tanto se generará una multa</p></html>", 
                    "Operación exitosa", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.informationIcon"));

                String codigoMulta = biblioteca.getSerialMulta();
                long diasDiferencia = ChronoUnit.DAYS.between(presta.getFechaDevolucionEsperada(), presta.getFechaDevolucionReal());
                BigDecimal valorMulta = BigDecimal.valueOf(1200).multiply(BigDecimal.valueOf(diasDiferencia));   
                Multa multa = new Multa(codigoMulta, presta.getCodigoPresta(), LocalDate.now(), valorMulta, "Multa por mora", Boolean.FALSE);

                if(biblioteca.getMultas().insertarElemento(multa)){
                    JOptionPane.showMessageDialog(vista, 
                        "La multa se ha generado con éxito. A continuación los datos de la multa: \n" + multa.toString() + "\n", 
                        "Operación exitosa", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
                    biblioteca.sumarSerialMulta();
                    return;
                }
            }


            return;
        }
    }

    private void opcionVerificarUsuarioEliminar() {
        String codigoPrestamo = vista.getTxtPrestamoE().getText();

        if(codigoPrestamo.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor ingrese el código del préstamo.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        Prestamo prestamo = biblioteca.getPrestamos().obtenerElemento(codigoPrestamo);

        if(prestamo == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El préstamo no se encuentra registrado en el sistema. Por favor ingrese un código de préstamo valido.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        vista.getTxtUsuarioPrestamoE().setText(prestamo.getIdUsuario());
        String[][] listaPrestamos = biblioteca.getPrestamos().obtenerPrestamosUsuario(prestamo.getIdUsuario());
        String[] cabecera = vista.getCabeceraConsultarPrestamo();
        vista.getTablaPrestamoE().setModel(ControladorEmpleado.asignarModelo(listaPrestamos, cabecera));
        vista.getTablaPrestamoE().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(3).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(4).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(5).setCellRenderer(alinear);

    }
    
    private void opcionEliminarPrestamo() {
        String codigoPrestamo = vista.getTxtPrestamoE().getText();

        if(codigoPrestamo.isBlank()){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">Por favor ingrese el código del préstamo.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        Prestamo prestamo = biblioteca.getPrestamos().obtenerElemento(codigoPrestamo);

        if(prestamo == null){
            JOptionPane.showMessageDialog(vista, 
                "<html><p style = \" font:12px; \">El préstamo no se encuentra registrado en el sistema. Por favor ingrese un código de préstamo valido.</p></html>", 
                "Operación sin éxito", JOptionPane.OK_OPTION, 
                UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        vista.getTxtUsuarioPrestamoE().setText(prestamo.getIdUsuario());
        String[][] listaPrestamos = biblioteca.getPrestamos().obtenerPrestamosUsuario(prestamo.getIdUsuario());
        String[] cabecera = vista.getCabeceraConsultarPrestamo();
        vista.getTablaPrestamoE().setModel(ControladorEmpleado.asignarModelo(listaPrestamos, cabecera));
        vista.getTablaPrestamoE().getColumnModel().getColumn(0).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(2).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(3).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(4).setCellRenderer(alinear);
        vista.getTablaPrestamoE().getColumnModel().getColumn(5).setCellRenderer(alinear);

        int opcionSeleccionada = JOptionPane.showConfirmDialog(vista, 
            "<html><p style = \" font:12px; \">¿Está seguro que desea eliminar el préstamo?</p></html>", 
            "Confirmación", JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, UIManager.getIcon("OptionPane.questionIcon"));

        if(opcionSeleccionada == JOptionPane.YES_OPTION){
            String[][] relacionesPresta = biblioteca.getPrestamos().relacionesPrestaEnPrestamo(codigoPrestamo);
            ArrayList<String> codigosPresta = new ArrayList<>();
            for(int i = 0; i < relacionesPresta.length; i++){
                codigosPresta.add(relacionesPresta[i][0]);
            }

            if((codigosPresta.stream().map(codigo -> biblioteca.getRelacionesPresta().eliminarElemento(codigo))).allMatch(e -> e) && biblioteca.getPrestamos().eliminarElemento(codigoPrestamo)){
                JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">El préstamo se ha eliminado con éxito.</p></html>", 
                    "Operación exitosa", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.informationIcon"));

                    vista.getTxtPrestamoE().setText("");
                    vista.getTxtUsuarioPrestamoE().setText("");
                    vista.getTablaPrestamoE().setModel(ControladorEmpleado.asignarModelo(null, cabecera));
                return;
            } else {
                JOptionPane.showMessageDialog(vista, 
                    "Ha sucedio un error al intentar elimianr el prestamo. ¡Hay una multa asociada al préstamo!\nEste registro no se puede eliminar por integridad referencial en la Base de Datos.", 
                    "Operación sin éxito", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
        }
    }
}

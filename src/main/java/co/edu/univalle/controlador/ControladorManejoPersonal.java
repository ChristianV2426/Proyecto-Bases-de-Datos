/*
  Archivo: ControladorManejoPersonal.java
  Bases de Datos - 750006C - Grupo 01
  Proyecto - Biblioteca Universidad del Valle

  Autores: 
  John Freddy Belalcazar Rojas - john.freddy.belalcazar@correounivalle.edu.co - 2182464-3743 
  Santiago Gonzalez Galvez - santiago.galvez@correounivalle.edu.co - 2183392-3743 
  Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 2140112-3743 
  Christian David Vargas Gutiérrez - vargas.christian@correounivalle.edu.co - 2179172-3743

  Profesor:
  Ph.D. Oswaldo Solarte

  Licencia: GNU-GPL
*/

package co.edu.univalle.controlador;

import co.edu.univalle.modelo.ContrasenaEmpleado;
import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaEmpleado;

import java.awt.CardLayout;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class ControladorManejoPersonal {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;
    private Boolean swicheCheckM = false;    
    private Boolean swicheCheckE = false;
    private Boolean swicheCheckC = false;

    public ControladorManejoPersonal(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.biblioteca = biblioteca;
        this.vista = vista;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        
        vista.addListenersManejo(new ManejadoraDeMouse());
        vista.getBtnModificarManejoM().setEnabled(false);
        vista.getBtnEmpleadoManejoC().setEnabled(false);
        limpiarCampos("A");

        // Listener para close.
        vista.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                biblioteca.cerrarConexion();
                System.exit(0);
            }
        });

    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){

            if(e.getSource() == vista.getCheckPasswordManejoA()){
                if(vista.getCheckPasswordManejoA().isEnabled())
                    mostrarContrasena();
            }

            if(e.getSource() == vista.getCheckPasswordManejoM()){
                if(vista.getCheckPasswordManejoM().isEnabled())
                    mostrarContrasena();
            }

            if(e.getSource() == vista.getBtnAnadirManejoA()){
                if(vista.getBtnAnadirManejoA().isEnabled())
                    registrarEmpleado();
            }

            if(e.getSource() == vista.getBtnCheckManejoE()){
                if(vista.getBtnCheckManejoE().isEnabled())
                    buscarEmpleado("E");
            }

            if(e.getSource() == vista.getBtnCheckManejoM()){
                if(vista.getBtnCheckManejoM().isEnabled())
                    buscarEmpleado("M");
            }

            if(e.getSource() == vista.getBtnModificarManejoM()){
                if(vista.getBtnModificarManejoM().isEnabled())
                    modificarEmpleado();
            }

            if(e.getSource() == vista.getBtnEliminarManejoE()){
                if(vista.getBtnEliminarManejoE().isEnabled())
                    eliminarEmpleado();
            }

            if(e.getSource() == vista.getBtnCheckManejoC()){
                if(vista.getBtnCheckManejoC().isEnabled())
                    buscarEmpleado("C");
            }

            if(e.getSource() == vista.getBtnEmpleadoManejoC()){
                if(vista.getBtnEmpleadoManejoC().isEnabled())
                    consultarEmpleadoIndividual();
            }

            if(e.getSource() == vista.getBtnEmpleadosManejoC()){
                if(vista.getBtnEmpleadosManejoC().isEnabled())
                    consultarEmpleados();
            }
        }
    }

    private void consultarEmpleados() {
        vista.getBtnEmpleadosManejoC().setEnabled(false);
        vista.getBtnEmpleadoManejoC().setEnabled(true);

        CardLayout cardLayout = (CardLayout) vista.getSubPanelManejoConsultar().getLayout();
        cardLayout.show(vista.getSubPanelManejoConsultar(), "cardManejoEmpleados");

        actualizarEmpleados();
    }

    private void actualizarEmpleados() {
        vista.disenoTabla(vista.getTablaManejoC(), vista.getScrollManejoC());
        String[] cabeceraEmpleados = vista.getCabeceraConsultarEmpleados();
        String[][] empleados = biblioteca.getEmpleados().obtenerTodosLosElementos();

        vista.getTablaManejoC().setModel(ControladorEmpleado.asignarModelo(empleados, cabeceraEmpleados));
    }

    private void consultarEmpleadoIndividual() {
        vista.getBtnEmpleadosManejoC().setEnabled(true);
        vista.getBtnEmpleadoManejoC().setEnabled(false);

        CardLayout cardLayout = (CardLayout) vista.getSubPanelManejoConsultar().getLayout();
        cardLayout.show(vista.getSubPanelManejoConsultar(), "cardManejoEmpleado");
    }

    private void eliminarEmpleado(){
        String identificacion = vista.getTxtIdManejoE().getText();
        if(identificacion.equals("")){
            JOptionPane.showMessageDialog(vista, "Ingrese la identificación del empleado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Empleado empleadoAEliminar = biblioteca.getEmpleados().obtenerElemento(identificacion);
        ContrasenaEmpleado contrasenaEmpleado = biblioteca.getContrasenasEmpleados().obtenerElemento(identificacion);

        if(empleadoAEliminar == null){
            JOptionPane.showMessageDialog(vista, "El empleado con la identificación proporcionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(vista, "¿Está seguro que desea eliminar el empleado?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if(opcion == JOptionPane.YES_OPTION){
            biblioteca.getContrasenasEmpleados().eliminarElemento(identificacion);
            biblioteca.getEmpleados().eliminarElemento(identificacion);
            JOptionPane.showMessageDialog(vista, "El empleado ha sido eliminado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
            biblioteca.restarSerialEmpleado();
            actualizarEmpleados();
        }
        limpiarCampos("E");
    }

    private void buscarEmpleado(String tipo) {
        String identificacion = "";
        if (tipo == "C") {
            identificacion = vista.getTxtIdManejoC().getText();
            if(identificacion.equals("")){
                JOptionPane.showMessageDialog(vista, "Ingrese la identificación del empleado", "Error", JOptionPane.ERROR_MESSAGE);
                limpiarCampos("C");
                return;
            }

            Empleado empleadoABuscar = biblioteca.getEmpleados().obtenerElemento(identificacion);

            if(empleadoABuscar == null){
                JOptionPane.showMessageDialog(vista, "El empleado con la identificación proporcionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(swicheCheckC==false) {
                vista.getBtnCheckManejoC().setText("Cancelar");
                vista.getTxtNombreManejoC().setText(empleadoABuscar.getNombreEmpleado());
                vista.getComboCargoManejoC().setSelectedItem(empleadoABuscar.getCargo());
                swicheCheckC = true;
            } else if (swicheCheckC==true) {
                vista.getBtnCheckManejoC().setText("Check");
                swicheCheckC = false;
                limpiarCampos("C");
            }

        } else if (tipo == "E") {
            identificacion = vista.getTxtIdManejoE().getText();
            if(identificacion.equals("")){
                JOptionPane.showMessageDialog(vista, "Ingrese la identificación del empleado", "Error", JOptionPane.ERROR_MESSAGE);
                limpiarCampos("E");
                return;
            }

            Empleado empleadoABuscar = biblioteca.getEmpleados().obtenerElemento(identificacion);

            if(empleadoABuscar == null){
                JOptionPane.showMessageDialog(vista, "El empleado con la identificación proporcionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(swicheCheckE==false) {
                vista.getBtnCheckManejoE().setText("Cancelar");
                vista.getTxtNombreManejoE().setText(empleadoABuscar.getNombreEmpleado());
                vista.getComboCargoManejoE().setSelectedItem(empleadoABuscar.getCargo());
                swicheCheckE = true;
            } else if (swicheCheckE==true) {
                vista.getBtnCheckManejoE().setText("Check");
                swicheCheckE = false;
                limpiarCampos("E");
            }
            
        } else if (tipo == "M") {
            identificacion = vista.getTxtIdManejoM().getText();
            if(identificacion.equals("")){
                JOptionPane.showMessageDialog(vista, "Ingrese la identificación del empleado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            Empleado empleadoABuscar = biblioteca.getEmpleados().obtenerElemento(identificacion);
    
            if (empleadoABuscar == null) {
                JOptionPane.showMessageDialog(vista, "El empleado con la identificación proporcionada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if(swicheCheckM==false) {
                vista.getBtnCheckManejoM().setText("Cancelar");
                swicheCheckM = true;
                vista.getTxtNombreManejoM().setText(empleadoABuscar.getNombreEmpleado());
                vista.getComboCargoManejoM().setSelectedItem(empleadoABuscar.getCargo());
                vista.getTxtIdManejoM().setEnabled(false);
                vista.getTxtNombreManejoM().setEnabled(true);
                vista.getComboCargoManejoM().setEnabled(true);
                vista.getTxtPasswordManejoM().setEnabled(true);
                vista.getCheckPasswordManejoM().setEnabled(true);
                vista.getBtnModificarManejoM().setEnabled(true);
    
            } else if (swicheCheckM==true) {
                vista.getBtnCheckManejoM().setText("Check");
                swicheCheckM = false;
                vista.getTxtIdManejoM().setText("");
                vista.getTxtIdManejoM().setEnabled(true);
                vista.getTxtNombreManejoM().setEnabled(false);
                vista.getComboCargoManejoM().setEnabled(false);
                vista.getTxtPasswordManejoM().setEnabled(false);
                vista.getCheckPasswordManejoM().setEnabled(false);
                vista.getBtnModificarManejoM().setEnabled(false);
                limpiarCampos("M");
            }
        }
    }
    
    private void modificarEmpleado() {
        String identificacion = vista.getTxtIdManejoM().getText();
        String nombre = vista.getTxtNombreManejoM().getText();
        String cargo = vista.getComboCargoManejoM().getSelectedItem().toString();
        String contrasena = new String(vista.getTxtPasswordManejoA().getPassword());
        String contrasenaEncriptada = biblioteca.getContrasenasEmpleados().encriptarContrasena(contrasena);
        
        ContrasenaEmpleado contrasenaAModificar = new ContrasenaEmpleado(identificacion, contrasenaEncriptada);
        Empleado empleadoAModificar = new Empleado(identificacion, nombre, cargo, false);

        biblioteca.getContrasenasEmpleados().editarElemento(contrasenaAModificar);
        biblioteca.getEmpleados().editarElemento(empleadoAModificar);
        
        JOptionPane.showMessageDialog(vista, "Modificación exitosa.", "Exito", JOptionPane.INFORMATION_MESSAGE);
        actualizarEmpleados();
        limpiarCampos("M");
    }

    private void registrarEmpleado() {
        String identificacion = vista.getTxtIdManejoA().getText();
        String nombre = vista.getTxtNombreManejoA().getText();
        String cargo = (String)vista.getComboCargoManejoA().getSelectedItem();
        String contrasena = new String(vista.getTxtPasswordManejoA().getPassword());

        if(identificacion.equals("") || nombre.equals("") || cargo.equals("") || contrasena.equals("")){
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Empleado nuevoEmpleado = new Empleado(identificacion, nombre, cargo, false);
        
        if (!biblioteca.getEmpleados().insertarElemento(nuevoEmpleado)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar el empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String contrasenaEncriptada = biblioteca.getContrasenasEmpleados().encriptarContrasena(contrasena);
        ContrasenaEmpleado nuevaContrasena = new ContrasenaEmpleado(identificacion, contrasenaEncriptada);

        if (!biblioteca.getContrasenasEmpleados().insertarElemento(nuevaContrasena)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar la contraseña del empleado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(vista, "Registro exitoso.", "Exito", JOptionPane.INFORMATION_MESSAGE);
        actualizarEmpleados();
        biblioteca.sumarSerialEmpleado();
        limpiarCampos("A");
    }
    
    private void limpiarCampos(String tipo) {
        if (tipo.equals("A")) {
            // Limpiar campos de Añadir.
            vista.getTxtIdManejoA().setText(biblioteca.getSerialEmpleado());
            vista.getTxtNombreManejoA().setText("");
            vista.getTxtPasswordManejoA().setText("");
            vista.getComboCargoManejoA().setSelectedIndex(0);
        }
        else if (tipo.equals("M")) {
            // Limpiar campos de Modificar.
            vista.getTxtIdManejoM().setText("");
            vista.getTxtNombreManejoM().setText("");
            vista.getTxtPasswordManejoM().setText("");
            vista.getComboCargoManejoM().setSelectedIndex(0);
            vista.getBtnCheckManejoM().setText("Check");
            swicheCheckM = false;
            vista.getTxtIdManejoM().setText("");
            vista.getTxtIdManejoM().setEnabled(true);
            vista.getTxtNombreManejoM().setEnabled(false);
            vista.getComboCargoManejoM().setEnabled(false);
            vista.getTxtPasswordManejoM().setEnabled(false);
            vista.getCheckPasswordManejoM().setEnabled(false);
            vista.getBtnModificarManejoM().setEnabled(false);
        }

        else if (tipo.equals("E")) {
            // Limpiar campos de Eliminar.
            vista.getTxtIdManejoE().setText("");
            vista.getTxtNombreManejoE().setText("");
            vista.getComboCargoManejoE().setSelectedIndex(0);
            vista.getTxtIdManejoA().setText(biblioteca.getSerialEmpleado());
        }
        else if (tipo.equals("C")) {
            vista.getTxtIdManejoC().setText("");
            vista.getTxtNombreManejoC().setText("");
            vista.getComboCargoManejoC().setSelectedIndex(0);
        }
    }

    private void mostrarContrasena(){
        if (vista.getCheckPasswordManejoA().isSelected()) {
            vista.getTxtPasswordManejoA().setEchoChar((char)0);}
        else 
            vista.getTxtPasswordManejoA().setEchoChar('*');

        if (vista.getCheckPasswordManejoM().isSelected()) {
            vista.getTxtPasswordManejoM().setEchoChar((char)0);}
        else 
            vista.getTxtPasswordManejoM().setEchoChar('*');
    }
}
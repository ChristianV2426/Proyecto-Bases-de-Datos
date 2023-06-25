/*
    Archivo: ControladorLogin.java
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
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;
import java.awt.event.*;
import javax.swing.*;

public class ControladorLogin {
    private VistaLogin vista;
    private Biblioteca biblioteca;

    public ControladorLogin(VistaLogin vista, Biblioteca biblioteca) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        vista.addListeners(new ManejadoraDeMouse());

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
            if(e.getSource() == vista.getCheckPassword()){
                mostrarContrasena();
            }

            if(e.getSource() == vista.getBtnIngresar()){
                iniciarSesion();
            }

            if(e.getSource() == vista.getLblRegistro()){
                registrarNuevoUsuario();
            }

            if(e.getSource() == vista.getBtnSalir()){
                biblioteca.cerrarConexion();
                System.exit(0);
            }
        }
    }

    private void mostrarContrasena(){
        if (vista.getCheckPassword().isSelected()) 
            vista.getTxtPassword().setEchoChar((char)0);

        else 
            vista.getTxtPassword().setEchoChar('*');
    }

    private void iniciarSesion() {
        String idUsuario = vista.getTxtIdentificacion().getText();
        String contrasena = new String(vista.getTxtPassword().getPassword());

        if(idUsuario.isBlank()){
            JOptionPane.showMessageDialog(vista, "Por favor ingrese la identificación del usuario", "Error", JOptionPane.ERROR_MESSAGE);
            return;
            
        } else if (contrasena.isBlank() || contrasena.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Por favor ingrese la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ContrasenaUsuario usuario = biblioteca.getContrasenasUsuarios().obtenerElemento(idUsuario);
        ContrasenaEmpleado empleado = biblioteca.getContrasenasEmpleados().obtenerElemento(idUsuario);

        if (usuario == null && empleado == null) {
            JOptionPane.showMessageDialog(vista, "El usuario no existe. Por favor verifique la identificación del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (usuario != null && biblioteca.getContrasenasUsuarios().validarContrasena(idUsuario, contrasena)) {
                System.out.println(usuario.getContrasena());
                vista.dispose();
                new VistaUsuario("Menú Usuario", biblioteca, biblioteca.getUsuarios().obtenerElemento(idUsuario));

        } else if (empleado != null && biblioteca.getContrasenasEmpleados().validarContrasena(idUsuario, contrasena)) {
                System.out.println(empleado.getContrasena());
                vista.dispose();
                // new vistaConsultarLibroEmpleado("empleado");
                new VistaEmpleado("Menú Empleado"); // Se debe de cambiar esta línea

        } else {
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta.\nPor favor intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarNuevoUsuario(){
        Object[] options = {"Estudiante", "Profesor"};
        int opcionRegistro = JOptionPane.showOptionDialog(vista,
                "¿Qué tipo de usuario desea registrar?",
                "Seleccione una opción",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        switch (opcionRegistro) {
            case 0: // Estudiante
                VistaRegistroEstudiante vistaRegistroEstudiante = new VistaRegistroEstudiante("Registro de Estudiante", biblioteca, vista);

                vista.setVisible(false); 
                vistaRegistroEstudiante.setVisible(true);
                break;

            case 1: // Profesor
                VistaRegistroProfesor vistaRegistroProfesor = new VistaRegistroProfesor("Registro de Profesor", biblioteca, vista);
                vista.setVisible(false); 
                vistaRegistroProfesor.setVisible(true);
                break;
        }
    }

}

package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class ControladorLogin {
    private vistaLogin vista;
    private Biblioteca biblioteca;

    public ControladorLogin(vistaLogin vista, Biblioteca biblioteca) {
        this.vista = vista;
        this.biblioteca = biblioteca;

        this.vista.getBtnIngresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarSesion();
            }
        });

        this.vista.getBtnSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.vista.getCheckPassword().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.getCheckPassword().isSelected()) {
                    vista.getTxtPassword().setEchoChar((char)0);
                } else {
                    vista.getTxtPassword().setEchoChar('*');
                }
            }
        });

        this.vista.getLblRegistro().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
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
                    vistaRegistroEstudiante vistaRegistroEstudiante = new vistaRegistroEstudiante("Registro de Estudiante");
                    new ControladorRegistroEstudiante(vistaRegistroEstudiante, biblioteca, vista);
                    vista.setVisible(false); 
                    vistaRegistroEstudiante.setVisible(true);
                    break;


                case 1: // Profesor
                    vistaRegistroProfesor vistaRegistroProfesor = new vistaRegistroProfesor("Registro de Profesor");
                    new ControladorRegistroProfesor(vistaRegistroProfesor, biblioteca, vista);
                    vista.setVisible(false); 
                    vistaRegistroProfesor.setVisible(true);
                    break;

            }
        }
    });

    }

    private void iniciarSesion() {
        String idUsuario = vista.getTxtIdentificacion().getText();
        String contrasena = new String(vista.getTxtPassword().getPassword());

        if (contrasena.isBlank() || contrasena.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Por favor ingrese la contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ContrasenaUsuario usuario = biblioteca.getContrasenasUsuarios().obtenerElemento(idUsuario);
        ContrasenaEmpleado empleado = biblioteca.getContrasenasEmpleados().obtenerElemento(idUsuario);

        if (usuario == null && empleado == null) {
            JOptionPane.showMessageDialog(vista, "Usuario no existe. Por favor verifique el ID de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (usuario != null && biblioteca.getContrasenasUsuarios().validarContrasena(idUsuario, contrasena)) {
                System.out.println(usuario.getContrasena());
                vista.dispose();
                new vistaUsuario("usuario");

        } else if (empleado != null && biblioteca.getContrasenasEmpleados().validarContrasena(idUsuario, contrasena)) {
                System.out.println(empleado.getContrasena());
                vista.dispose();
                // new vistaConsultarLibroEmpleado("empleado");
                new VistaEmpleado("empleado"); // Se debe de cambiar esta línea

        } else {
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

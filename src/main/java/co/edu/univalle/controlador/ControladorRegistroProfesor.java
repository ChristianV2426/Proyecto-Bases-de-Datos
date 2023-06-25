package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorRegistroProfesor {
    private VistaRegistroProfesor vista;
    private Biblioteca biblioteca;
    private VistaLogin vistaLogin;

    public ControladorRegistroProfesor(VistaRegistroProfesor vista, Biblioteca biblioteca, VistaLogin vistaLogin) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.vistaLogin = vistaLogin;

        this.vista.getBtnRegresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverALogin();
            }
        });

        this.vista.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProfesor();
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
    }

    private void registrarProfesor() {
        String nombre = vista.getTxtNombre().getText();
        String identificacion = vista.getTxtIdentificacion().getText();
        String contrasena = new String(vista.getTxtPassword().getPassword());
        String email = vista.getTxtEmail().getText();
        String telefono = vista.getTxtTelefono().getText();
        String direccion = vista.getTxtDireccion().getText();
        String dependencia = vista.getComboDependencia().getSelectedItem().toString();
        String profesion = vista.getComboProfesion().getSelectedItem().toString();

        if (nombre.isEmpty() || identificacion.isEmpty() || contrasena.isEmpty() || email.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || dependencia.isEmpty() || profesion.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario nuevoUsuario = new Usuario(identificacion, nombre, telefono, direccion, email);
        Profesor nuevoProfesor = new Profesor(nuevoUsuario, dependencia, profesion);

        if (!biblioteca.getUsuarios().insertarElemento(nuevoUsuario) || !biblioteca.getProfesores().insertarElemento(nuevoProfesor)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String contrasenaEncriptada = biblioteca.getContrasenasUsuarios().encriptarContrasena(contrasena);
        ContrasenaUsuario nuevaContrasena = new ContrasenaUsuario(identificacion, contrasenaEncriptada);

        if (!biblioteca.getContrasenasUsuarios().insertarElemento(nuevaContrasena)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar la contraseña del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            biblioteca.getUsuarios().eliminarElemento(identificacion);
            biblioteca.getProfesores().eliminarElemento(identificacion);
            return;
        }

        JOptionPane.showMessageDialog(vista, "Registro exitoso.", "Exito", JOptionPane.INFORMATION_MESSAGE);
        volverALogin();
    }

    private void volverALogin() {
        vista.dispose();
        vistaLogin.setVisible(true);
    }
}

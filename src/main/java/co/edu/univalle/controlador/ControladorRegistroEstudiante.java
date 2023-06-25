package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorRegistroEstudiante {
    private vistaRegistroEstudiante vista;
    private Biblioteca biblioteca;
    private vistaLogin vistaLogin;

    public ControladorRegistroEstudiante(vistaRegistroEstudiante vista, Biblioteca biblioteca, vistaLogin vistaLogin) {
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
                registrarEstudiante();
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

    private void registrarEstudiante() {
        String nombre = vista.getTxtNombre().getText();
        String identificacion = vista.getTxtIdentificacion().getText();
        String contrasena = new String(vista.getTxtPassword().getPassword());
        String email = vista.getTxtEmail().getText();
        String telefono = vista.getTxtTelefono().getText();
        String direccion = vista.getTxtDireccion().getText();
        String carrera = (String)vista.getComboCarrera().getSelectedItem();
        String universidad = (String)vista.getComboUniversidad().getSelectedItem();

        if (nombre.isEmpty() || identificacion.isEmpty() || contrasena.isEmpty() || email.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || carrera.isEmpty() || universidad.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estudiante nuevoEstudiante = new Estudiante(identificacion, nombre, telefono, direccion, email, carrera, universidad);

        if (!biblioteca.getUsuarios().insertarElemento(nuevoEstudiante) || !biblioteca.getEstudiantes().insertarElemento(nuevoEstudiante)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            biblioteca.getUsuarios().eliminarElemento(identificacion);
            biblioteca.getEstudiantes().eliminarElemento(identificacion);
            return;
        }

        String contrasenaEncriptada = biblioteca.getContrasenasUsuarios().encriptarContrasena(contrasena);
        ContrasenaUsuario nuevaContrasena = new ContrasenaUsuario(identificacion, contrasenaEncriptada);

        if (!biblioteca.getContrasenasUsuarios().insertarElemento(nuevaContrasena)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar la contraseña del estudiante.", "Error", JOptionPane.ERROR_MESSAGE);
            biblioteca.getUsuarios().eliminarElemento(identificacion);
            biblioteca.getEstudiantes().eliminarElemento(identificacion);
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

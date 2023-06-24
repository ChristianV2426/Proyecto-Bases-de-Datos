package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin {
    private VistaLogin vista;
    private DaoUsuario daoUsuario;
    private DaoContrasenaUsuario daoContrasena;
    private DaoEmpleado daoEmpleado;
    private DaoContrasenaEmpleado daoContrasenaEmpleado;

    public ControladorLogin(VistaLogin vista, DaoUsuario daoUsuario, DaoContrasenaUsuario daoContrasena, DaoEmpleado daoEmpleado, DaoContrasenaEmpleado daoContrasenaEmpleado) {
        this.vista = vista;
        this.daoUsuario = daoUsuario;
        this.daoContrasena = daoContrasena;
        this.daoEmpleado = daoEmpleado;
        this.daoContrasenaEmpleado = daoContrasenaEmpleado;

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
    }

    private void iniciarSesion() {
        String idUsuario = vista.getTxtIdentificacion().getText();
        String contrasena = new String(vista.getTxtPassword().getPassword());

        Usuario usuario = daoUsuario.obtenerElemento(idUsuario);
        ContrasenaUsuario contrasenaUsuario = daoContrasena.obtenerElemento(idUsuario);
        
        Empleado empleado = daoEmpleado.obtenerElemento(idUsuario);
        ContrasenaEmpleado contrasenaEmpleado = daoContrasenaEmpleado.obtenerElemento(idUsuario);

        if (usuario != null && contrasenaUsuario != null) {
            if (contrasenaUsuario.getContrasena().equals(contrasena)) {
                vista.dispose();
                new VistaUsuario("usuario");
            } else {
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (empleado != null && contrasenaEmpleado != null) {
            if (contrasenaEmpleado.getContrasena().equals(contrasena)) {
                vista.dispose();
                // new vistaConsultarLibroEmpleado("empleado");
                new VistaEmpleado("empleado"); // Se debe de cambiar esta línea

            } else {
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

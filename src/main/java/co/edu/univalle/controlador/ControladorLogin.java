package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Usuario;
import co.edu.univalle.modelo.ContrasenaUsuario;
import co.edu.univalle.persistencia.DaoUsuario;
import co.edu.univalle.persistencia.DaoContrasenaUsuario;
import co.edu.univalle.vistas.vistaLogin;
import co.edu.univalle.vistas.vistaUConsultarLibro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorLogin {
    private vistaLogin vista;
    private DaoUsuario daoUsuario;
    private DaoContrasenaUsuario daoContrasena;

    public ControladorLogin(vistaLogin vista, DaoUsuario daoUsuario, DaoContrasenaUsuario daoContrasena) {
        this.vista = vista;
        this.daoUsuario = daoUsuario;
        this.daoContrasena = daoContrasena;

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

        if (usuario != null && contrasenaUsuario != null) {
            if (contrasenaUsuario.getContrasena().equals(contrasena)) {
                vista.dispose();
                new vistaUConsultarLibro("usuario");
            } else {
                JOptionPane.showMessageDialog(vista, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


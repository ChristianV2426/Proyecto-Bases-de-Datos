package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;
import java.awt.event.*;
import javax.swing.*;


public class ControladorRegistroEstudiante {
    private VistaRegistroEstudiante vista;
    private Biblioteca biblioteca;
    private VistaLogin vistaLogin;

    public ControladorRegistroEstudiante(VistaRegistroEstudiante vista, Biblioteca biblioteca, VistaLogin vistaLogin) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.vistaLogin = vistaLogin;
        vista.addListeners(new ManejadoraDeMouse());
        verificarTexto(vista.getTxtNombre());
        verificarNumero(vista.getTxtTelefono());

        // Listener para close.
        vista.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                biblioteca.cerrarConexion();
                System.exit(0);
        }});

        vista.getTxtIdentificacion().setText(biblioteca.getSerialUsuario());
    }

    class ManejadoraDeMouse extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getSource() == vista.getBtnRegresar()){
                volverALogin();
            }

            if(e.getSource() == vista.getBtnRegistrar()){
                registrarEstudiante();
            }

            if(e.getSource() == vista.getCheckPassword()){
                mostrarContrasena();
            }
        }
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
        vista.dispose();
        new VistaLogin("Login", biblioteca);
    }

    private void volverALogin() {
        vista.dispose();
        vistaLogin.setVisible(true);
    }

    private void mostrarContrasena(){
        if (vista.getCheckPassword().isSelected()) 
            vista.getTxtPassword().setEchoChar((char)0);

        else 
            vista.getTxtPassword().setEchoChar('*');
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

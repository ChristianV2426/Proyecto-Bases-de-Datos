package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vistas.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ControladorRegistroProfesor {
    private VistaRegistroProfesor vista;
    private Biblioteca biblioteca;
    private VistaLogin vistaLogin;

    public ControladorRegistroProfesor(VistaRegistroProfesor vista, Biblioteca biblioteca, VistaLogin vistaLogin) {
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
                registrarProfesor();
            }

            if(e.getSource() == vista.getCheckPassword()){
                mostrarContrasena();
            }
        }
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
        List<String> listaAreasInteres = vista.getListaArea().getSelectedValuesList();

        if (nombre.isEmpty() || identificacion.isEmpty() || contrasena.isEmpty() || email.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || dependencia.isEmpty() || profesion.isEmpty() || listaAreasInteres.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario nuevoUsuario = new Usuario(identificacion, nombre, telefono, direccion, email);
        Profesor nuevoProfesor = new Profesor(nuevoUsuario, dependencia, profesion);

        ArrayList<AreaInteres> areasInteres = new ArrayList();
        for(String areaInteres : listaAreasInteres){
            areasInteres.add(new AreaInteres(nuevoUsuario.getIdUsuario(), areaInteres.substring(0, 6)));
        }
        
        if (!biblioteca.getUsuarios().insertarElemento(nuevoUsuario) || !biblioteca.getProfesores().insertarElemento(nuevoProfesor)
            || !(areasInteres.stream().map(areaInteres -> biblioteca.getAreasInteres().insertarElemento(areaInteres))).allMatch(resultado -> resultado)) {
                
                biblioteca.getUsuarios().eliminarElemento(identificacion);
                biblioteca.getProfesores().eliminarElemento(identificacion);
                areasInteres.stream().map(areaInteres -> biblioteca.getAreasInteres().eliminarElemento(areaInteres.toString()));

                JOptionPane.showMessageDialog(vista, "Error al registrar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        String contrasenaEncriptada = biblioteca.getContrasenasUsuarios().encriptarContrasena(contrasena);
        ContrasenaUsuario nuevaContrasena = new ContrasenaUsuario(identificacion, contrasenaEncriptada);

        if (!biblioteca.getContrasenasUsuarios().insertarElemento(nuevaContrasena)) {
            JOptionPane.showMessageDialog(vista, "Error al registrar la contraseña del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            biblioteca.getUsuarios().eliminarElemento(identificacion);
            biblioteca.getProfesores().eliminarElemento(identificacion);
            areasInteres.stream().map(areaInteres -> biblioteca.getAreasInteres().eliminarElemento(areaInteres.toString()));
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
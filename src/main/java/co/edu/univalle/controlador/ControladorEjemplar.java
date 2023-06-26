/*
  Archivo: ControladorEjemplar.java
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

import co.edu.univalle.modelo.Ejemplar;
import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.modelo.Libro;
import co.edu.univalle.persistencia.Biblioteca;
import co.edu.univalle.vistas.VistaEmpleado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControladorEjemplar {
    private VistaEmpleado vista;
    private Biblioteca biblioteca;
    private Empleado empleado;
    private ControladorEmpleado controladorEmpleado;
    private Boolean swicheCheckA = false;
    private Boolean swicheCheckM = false;
    private Boolean swicheCheckE = false;

    public ControladorEjemplar(VistaEmpleado vista, Biblioteca biblioteca, Empleado empleado, ControladorEmpleado controladorEmpleado) {
        this.vista = vista;
        this.biblioteca = biblioteca;
        this.empleado = empleado;
        this.controladorEmpleado = controladorEmpleado;
        vista.addListenersEjemplares(new ManejadoraDeMouse());
        
        controladorEmpleado.verificarNumero(vista.getTxtNumeroEjemplarA());
        controladorEmpleado.verificarNumero(vista.getTxtNumeroEjemplarM());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vista.getBtnCheckEjemplarA()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarA().isEnabled()){
                    opcionCheckA();
                }
            }
            
            if (e.getSource() == vista.getBtnAgregarEjemplarA()){
                if (e.getButton() == 1 && vista.getBtnAgregarEjemplarA().isEnabled()){
                    opcionAgregar();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckEjemplarM()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarM().isEnabled()){
                    opcionCheckM();
                }
            }
            
            if (e.getSource() == vista.getBtnModificarEjemplarM()){
                if (e.getButton() == 1 && vista.getBtnModificarEjemplarM().isEnabled()){
                    opcionModificar();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckEjemplarC()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarC().isEnabled()){
                    opcionCheckC();
                }
            }
            
            if (e.getSource() == vista.getBtnCheckEjemplarE()){
                if (e.getButton() == 1 && vista.getBtnCheckEjemplarE().isEnabled()){
                    opcionCheckE();
                }
            }
            
            if (e.getSource() == vista.getBtnEliminarEjemplarE()){
                if (e.getButton() == 1 && vista.getBtnEliminarEjemplarE().isEnabled()){
                    opcionEliminar();
                }
            }
        }
    }

    private void opcionCheckA() {
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarA().getText());
        if (swicheCheckA==false) {
            if (libro == null) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            vista.getBtnCheckEjemplarA().setText("Cancelar");
            vista.getTxtIsbnEjemplarA().setEnabled(false);
            swicheCheckA = true;
            
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado corresponde a: " + libro.getTitulo() + ".</p></html>", 
                        "Información", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            vista.getTxtNumeroEjemplarA().setText(String.valueOf(biblioteca.getEjemplares().ejemplaresEnTotal(libro.getIsbn())+1));
        } else {
            vista.getBtnCheckEjemplarA().setText("Check");
            vista.getTxtIsbnEjemplarA().setEnabled(true);
            swicheCheckA = false;
            vista.getTxtNumeroEjemplarA().setText("");
        }
    }

    private void opcionAgregar() {
        if (swicheCheckA == false) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Por favor compruebe la información primero.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarA().getText());
        if (libro == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String codigo;
        String numero = vista.getTxtNumeroEjemplarA().getText();
        if (Integer.parseInt(numero)<10) {
            codigo = libro.getIsbn() + "-N0" + numero;
        } else {
            codigo = libro.getIsbn() + "-N" + numero;
        }
        if (biblioteca.getEjemplares().obtenerElemento(codigo) != null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Ya existe un ejemplar con ese código.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Ejemplar ejemplar = new Ejemplar(libro,
            codigo,
            Integer.valueOf(numero),
            vista.getTxtEstanteEjemplarA().getText(),
            vista.getTxtCajonEjemplarA().getText(),
            vista.getTxtPasilloEjemplarA().getText(),
            vista.getTxtSalaEjemplarA().getText(),
            true);
        biblioteca.getEjemplares().insertarElemento(ejemplar);
        JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">Ejemplar añadido con éxito.</p></html>", 
                    "Información", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.informationIcon"));
        vista.getBtnCheckEjemplarA().setText("Check");
        vista.getTxtIsbnEjemplarA().setEnabled(true);
        swicheCheckA = false;
        vista.getTxtNumeroEjemplarA().setText("");
        vista.getTxtEstanteEjemplarA().setText("");
        vista.getTxtCajonEjemplarA().setText("");
        vista.getTxtPasilloEjemplarA().setText("");
        vista.getTxtSalaEjemplarA().setText("");
    }

    private void opcionCheckM() {
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarM().getText());
        if (swicheCheckM==false) {
            if (libro == null) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            String codigo;
            String numero = vista.getTxtNumeroEjemplarM().getText();
            if ("".equals(numero)) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            if (Integer.parseInt(numero)<10) {
                codigo = libro.getIsbn() + "-N0" + numero;
            } else {
                codigo = libro.getIsbn() + "-N" + numero;
            }
            
            Ejemplar ejemplar = biblioteca.getEjemplares().obtenerElemento(codigo);
            if (ejemplar == null) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            vista.getBtnCheckEjemplarM().setText("Cancelar");
            vista.getTxtIsbnEjemplarM().setEnabled(false);
            vista.getTxtNumeroEjemplarM().setEnabled(false);
            swicheCheckM = true;
            
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado corresponde a: " + libro.getTitulo() + ".</p></html>", 
                        "Información", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            vista.getTxtEstanteEjemplarM().setText(ejemplar.getEstante());
            vista.getTxtCajonEjemplarM().setText(ejemplar.getNumCajon());
            vista.getTxtPasilloEjemplarM().setText(ejemplar.getNumPasillo());
            vista.getTxtSalaEjemplarM().setText(ejemplar.getNombreSala());
        } else {
            vista.getBtnCheckEjemplarM().setText("Check");
            vista.getTxtIsbnEjemplarM().setEnabled(true);
            vista.getTxtNumeroEjemplarM().setEnabled(true);
            swicheCheckM = false;
        }
    }

    private void opcionModificar() {
        if (swicheCheckM == false) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Por favor compruebe la información primero.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarM().getText());
        if (libro == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String codigo;
        String numero = vista.getTxtNumeroEjemplarM().getText();
        if (Integer.parseInt(numero)<10) {
            codigo = libro.getIsbn() + "-N0" + numero;
        } else {
            codigo = libro.getIsbn() + "-N" + numero;
        }
        if (biblioteca.getEjemplares().obtenerElemento(codigo) == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Ejemplar ejemplar = new Ejemplar(libro,
            codigo,
            Integer.valueOf(numero),
            vista.getTxtEstanteEjemplarM().getText(),
            vista.getTxtCajonEjemplarM().getText(),
            vista.getTxtPasilloEjemplarM().getText(),
            vista.getTxtSalaEjemplarM().getText(),
            true);
        biblioteca.getEjemplares().editarElemento(ejemplar);
        JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">Ejemplar modificado con éxito.</p></html>", 
                    "Información", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.informationIcon"));
        vista.getBtnCheckEjemplarM().setText("Check");
        vista.getTxtIsbnEjemplarM().setEnabled(true);
        vista.getTxtNumeroEjemplarM().setEnabled(true);
        swicheCheckM = false;
        vista.getTxtNumeroEjemplarM().setText("");
        vista.getTxtEstanteEjemplarM().setText("");
        vista.getTxtCajonEjemplarM().setText("");
        vista.getTxtPasilloEjemplarM().setText("");
        vista.getTxtSalaEjemplarM().setText("");
    }

    private void opcionCheckC() {
        
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarC().getText());
        if (libro == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        String codigo;
        String numero = vista.getTxtNumeroEjemplarC().getText();
        if ("".equals(numero)) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        if (Integer.parseInt(numero)<10) {
            codigo = libro.getIsbn() + "-N0" + numero;
        } else {
            codigo = libro.getIsbn() + "-N" + numero;
        }

        Ejemplar ejemplar = biblioteca.getEjemplares().obtenerElemento(codigo);
        if (ejemplar == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }

        JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">El ISBN ingresado corresponde a: " + libro.getTitulo() + ".</p></html>", 
                    "Información", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.informationIcon"));
        vista.getTxtEstanteEjemplarC().setText(ejemplar.getEstante());
        vista.getTxtCajonEjemplarC().setText(ejemplar.getNumCajon());
        vista.getTxtPasilloEjemplarC().setText(ejemplar.getNumPasillo());
        vista.getTxtSalaEjemplarC().setText(ejemplar.getNombreSala());
    }

    private void opcionCheckE() {
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarE().getText());
        if (swicheCheckE==false) {
            if (libro == null) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            String codigo;
            String numero = vista.getTxtNumeroEjemplarE().getText();
            if ("".equals(numero)) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            if (Integer.parseInt(numero)<10) {
                codigo = libro.getIsbn() + "-N0" + numero;
            } else {
                codigo = libro.getIsbn() + "-N" + numero;
            }
            
            Ejemplar ejemplar = biblioteca.getEjemplares().obtenerElemento(codigo);
            if (ejemplar == null) {
                JOptionPane.showMessageDialog(vista, 
                            "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                            "Error", JOptionPane.OK_OPTION, 
                            UIManager.getIcon("OptionPane.errorIcon"));
                return;
            }
            
            vista.getBtnCheckEjemplarE().setText("Cancelar");
            vista.getTxtIsbnEjemplarE().setEnabled(false);
            vista.getTxtNumeroEjemplarE().setEnabled(false);
            swicheCheckE = true;
            
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado corresponde a: " + libro.getTitulo() + ".</p></html>", 
                        "Información", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.informationIcon"));
            vista.getTxtEstanteEjemplarE().setText(ejemplar.getEstante());
            vista.getTxtCajonEjemplarE().setText(ejemplar.getNumCajon());
            vista.getTxtPasilloEjemplarE().setText(ejemplar.getNumPasillo());
            vista.getTxtSalaEjemplarE().setText(ejemplar.getNombreSala());
        } else {
            vista.getBtnCheckEjemplarE().setText("Check");
            vista.getTxtIsbnEjemplarE().setEnabled(true);
            vista.getTxtNumeroEjemplarE().setEnabled(true);
            swicheCheckE = false;
        }
    }

    private void opcionEliminar() {
        if (swicheCheckE == false) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">Por favor compruebe la información primero.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Libro libro = biblioteca.getLibros().obtenerElemento(vista.getTxtIsbnEjemplarE().getText());
        if (libro == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">El ISBN ingresado no se encuentra en la base de datos.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        String codigo;
        String numero = vista.getTxtNumeroEjemplarE().getText();
        if (Integer.parseInt(numero)<10) {
            codigo = libro.getIsbn() + "-N0" + numero;
        } else {
            codigo = libro.getIsbn() + "-N" + numero;
        }
        if (biblioteca.getEjemplares().obtenerElemento(codigo) == null) {
            JOptionPane.showMessageDialog(vista, 
                        "<html><p style = \" font:12px; \">No existe un ejemplar con ese código.</p></html>", 
                        "Error", JOptionPane.OK_OPTION, 
                        UIManager.getIcon("OptionPane.errorIcon"));
            return;
        }
        Ejemplar ejemplar = new Ejemplar(libro,
            codigo,
            Integer.valueOf(numero),
            vista.getTxtEstanteEjemplarE().getText(),
            vista.getTxtCajonEjemplarE().getText(),
            vista.getTxtPasilloEjemplarE().getText(),
            vista.getTxtSalaEjemplarE().getText(),
            true);
        biblioteca.getEjemplares().eliminarElemento(codigo);
        JOptionPane.showMessageDialog(vista, 
                    "<html><p style = \" font:12px; \">Ejemplar eliminado con éxito.</p></html>", 
                    "Información", JOptionPane.OK_OPTION, 
                    UIManager.getIcon("OptionPane.informationIcon"));
        vista.getBtnCheckEjemplarE().setText("Check");
        vista.getTxtIsbnEjemplarE().setEnabled(true);
        vista.getTxtNumeroEjemplarE().setEnabled(true);
        swicheCheckE = false;
        vista.getTxtNumeroEjemplarE().setText("");
        vista.getTxtEstanteEjemplarE().setText("");
        vista.getTxtCajonEjemplarE().setText("");
        vista.getTxtPasilloEjemplarE().setText("");
        vista.getTxtSalaEjemplarE().setText("");
    }
}

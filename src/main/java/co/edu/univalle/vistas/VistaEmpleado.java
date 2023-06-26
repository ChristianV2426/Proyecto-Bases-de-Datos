/*
  Archivo: vistaEmpleado.java
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

package co.edu.univalle.vistas;

import co.edu.univalle.controlador.ControladorEmpleado;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import co.edu.univalle.modelo.Ejemplar;
import co.edu.univalle.modelo.Empleado;
import co.edu.univalle.persistencia.Biblioteca;
import java.awt.event.MouseListener;

public class VistaEmpleado extends javax.swing.JFrame {
    private Empleado empleado;
    private final CardLayout cardLayout;
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    private DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    private String[] cabeceraConsultarEmpleados = {"ID","Nombre","Cargo"};
    private String[] cabeceraPrestamo = {"ISBN","Título","Ejemplar", "Retorno"};
    private String[] cabeceraConsultarPrestamo = {"Préstamo","Libros","Ejemplar","FPréstamo","Retorno","Estado"};
    private String[] cabeceraDescargas = {"Descarga", "Usuario","IP","Fecha","Título"};
    private String[] cabeceraSolicitudes = {"Solicitud", "Estado","Usuario","Fecha","Título","ISBN"};
    private String[] cabeceraMultas = {"Multas", "Ejemplar","Titulo","FechaMulta","Valor","Estado"};
    private String[] cabeceraTodaLasMultas = {"Multas", "Nombre","Ejemplar","Título","FechaMulta","Valor","Estado"};
    private String[] cabeceraConsultarLibros = {"ISBN","Título","Ejemplar","Autores","Editorial","Idioma","Digital"};
    
    public VistaEmpleado(String titulo, Biblioteca biblioteca, Empleado empleado) {
        this.empleado = empleado;
        initComponents();
        setVisible(true);
        setTitle(titulo);
        setResizable(false);
        setLocationRelativeTo(null);
        cardLayout = (CardLayout) panelPrincipal.getLayout();
        ControladorEmpleado controladorEmpleado = new ControladorEmpleado(this, biblioteca, empleado);
        if (empleado.getEsAdministrador() == false){
            cardLayout.show(panelPrincipal, "cardLibro");
            btnManejoPersonal.setEnabled(false);
            btnLibros.setEnabled(false);
            lblAdmin.setVisible(false);
        } else {
            cardLayout.show(panelPrincipal, "cardManejo");
            btnManejoPersonal.setEnabled(false);
        }
    }
        
    public void disenoTabla(JTable tablaGenerica, JScrollPane scrollGenerico){
        
        tablaGenerica.setFont(new Font("Segoe UI", 0, 12));
        
        //Fuente de cabecera
        th = tablaGenerica.getTableHeader();
        Font fuente = new Font("Georgia", Font.BOLD, 16);
        th.setFont(fuente);
        
        //Color cabecera
        tablaGenerica.setOpaque(false);
        Color colorCabecera = new Color(178, 130, 76); //Color café
        th.setBackground(colorCabecera);
        
        //Color fondo
        Color colorFondo = new Color(255, 255, 255);
        scrollGenerico.getViewport().setBackground(colorFondo);
    }
    
    public void addListeners(MouseListener listener){
        btnManejoPersonal.addMouseListener(listener);
        btnLibros.addMouseListener(listener);
        btnPrestamos.addMouseListener(listener);
        btnMultas.addMouseListener(listener);
        btnSolicitudes.addMouseListener(listener);
        btnDescargas.addMouseListener(listener);
        btnEjemplar.addMouseListener(listener);
        btnDescargarInfo.addMouseListener(listener);
        btnCerrar.addMouseListener(listener);
    }
    
    public void addListenersLibros(MouseListener listener){
        btnAgregarLibroA.addMouseListener(listener);
        btnCheckLibroC.addMouseListener(listener);
        btnCheckLibroE.addMouseListener(listener);
        btnCheckLibroM.addMouseListener(listener);
        btnModificarLibroM.addMouseListener(listener);
        btnEliminarLibroE.addMouseListener(listener);
        btnNoLibroA.addMouseListener(listener);
        btnNoLibroC.addMouseListener(listener);
        btnNoLibroE.addMouseListener(listener);
        btnNoLibroM.addMouseListener(listener);
        btnNoLibroA.addMouseListener(listener);
        btnSiLibroA.addMouseListener(listener);
        btnSiLibroC.addMouseListener(listener);
        btnSiLibroE.addMouseListener(listener);
        btnSiLibroM.addMouseListener(listener);
        btnSiLibroA.addMouseListener(listener);
    }
    
    public void addListenersManejo(MouseListener listeners){
        btnAnadirManejoA.addMouseListener(listeners);
        btnCheckManejoC.addMouseListener(listeners);
        btnCheckManejoE.addMouseListener(listeners);
        btnCheckManejoM.addMouseListener(listeners);
        btnEliminarManejoE.addMouseListener(listeners);
        btnEmpleadoManejoC.addMouseListener(listeners);
        btnEmpleadosManejoC.addMouseListener(listeners);
    }
    
    public void addListenersPrestamos(MouseListener listeners){
        btnAgregarPrestamoA.addMouseListener(listeners);
        btnAgregarPrestamoM.addMouseListener(listeners);
        btnCheckPrestamoA.addMouseListener(listeners);
        btnCheckPrestamoC.addMouseListener(listeners);
        btnCheckPrestamoE.addMouseListener(listeners);
        btnCheckPrestamoM.addMouseListener(listeners);
        btnDevolverPrestamoC.addMouseListener(listeners);
        btnEliminarPrestamoE.addMouseListener(listeners);
        btnModificarPrestamoM.addMouseListener(listeners);
        btnRealizarPrestamoA.addMouseListener(listeners);
        btnRemoverPrestamoA.addMouseListener(listeners);
        btnRemoverPrestamoM.addMouseListener(listeners);
        btnVerificarPrestamoA.addMouseListener(listeners);
        btnVerificarPrestamoM.addMouseListener(listeners);
    }
    
    public void addListenersMultas(MouseListener listeners){
        btnCheckMultas.addMouseListener(listeners);
        btnMultasTodasT.addMouseListener(listeners);
        btnMultasTodasU.addMouseListener(listeners);
        btnMultasUsuarioT.addMouseListener(listeners);
        btnMultasUsuarioU.addMouseListener(listeners);
        btnPagarMultas.addMouseListener(listeners);
    }
    
    public void addListenersSolicitudes(MouseListener listeners){
        btnAprobarSolicitud.addMouseListener(listeners);
        btnRechazarSolicitud.addMouseListener(listeners);
        btnDescripcionSolicitud.addMouseListener(listeners);
    }
    
    public void addListenersEjemplares(MouseListener listeners){
        btnAgregarEjemplarA.addMouseListener(listeners);
        btnCheckEjemplarA.addMouseListener(listeners);
        btnCheckEjemplarC.addMouseListener(listeners);
        btnCheckEjemplarE.addMouseListener(listeners);
        btnCheckEjemplarM.addMouseListener(listeners);
        btnEliminarEjemplarE.addMouseListener(listeners);
    }
            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        btnManejoPersonal = new javax.swing.JButton();
        btnLibros = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnMultas = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnSolicitudes = new javax.swing.JButton();
        btnDescargas = new javax.swing.JButton();
        btnEjemplar = new javax.swing.JButton();
        lblAdmin = new javax.swing.JLabel();
        btnDescargarInfo = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelManejo = new javax.swing.JTabbedPane();
        panelManejoAnadir = new javax.swing.JPanel();
        txtIdManejoA = new javax.swing.JTextField();
        lblIdManejoA = new javax.swing.JLabel();
        lblNombreManejoA = new javax.swing.JLabel();
        txtNombreManejoA = new javax.swing.JTextField();
        btnAnadirManejoA = new javax.swing.JButton();
        lblCargoManejoA = new javax.swing.JLabel();
        comboCargoManejoA = new javax.swing.JComboBox<>();
        lblPasswordManejoA = new javax.swing.JLabel();
        txtPasswordManejoA = new javax.swing.JPasswordField();
        checkPasswordManejoA = new javax.swing.JCheckBox();
        panelManejoModificar = new javax.swing.JPanel();
        txtIdManejoM = new javax.swing.JTextField();
        lblIdManejoM = new javax.swing.JLabel();
        lblNombreManejoM = new javax.swing.JLabel();
        txtNombreManejoM = new javax.swing.JTextField();
        btnModificarManejoM = new javax.swing.JButton();
        lblCargoManejoM = new javax.swing.JLabel();
        comboCargoManejoM = new javax.swing.JComboBox<>();
        lblPasswordManejoM = new javax.swing.JLabel();
        txtPasswordManejoM = new javax.swing.JPasswordField();
        checkPasswordManejoM = new javax.swing.JCheckBox();
        btnCheckManejoM = new javax.swing.JButton();
        panelManejoConsultar = new javax.swing.JPanel();
        btnEmpleadoManejoC = new javax.swing.JButton();
        btnEmpleadosManejoC = new javax.swing.JButton();
        subPanelManejoConsultar = new javax.swing.JPanel();
        panelEmpleadoManejoC = new javax.swing.JPanel();
        lblIdManejoC = new javax.swing.JLabel();
        btnCheckManejoC = new javax.swing.JButton();
        txtIdManejoC = new javax.swing.JTextField();
        lblNombreManejoC = new javax.swing.JLabel();
        txtNombreManejoC = new javax.swing.JTextField();
        lblCargoManejoC = new javax.swing.JLabel();
        comboCargoManejoC = new javax.swing.JComboBox<>();
        panelEmpleadosManejoC = new javax.swing.JPanel();
        scrollManejoC = new javax.swing.JScrollPane();
        tablaManejoC = new javax.swing.JTable();
        panelManejoEliminar = new javax.swing.JPanel();
        txtIdManejoE = new javax.swing.JTextField();
        lblIdManejoE = new javax.swing.JLabel();
        lblNombreManejoE = new javax.swing.JLabel();
        txtNombreManejoE = new javax.swing.JTextField();
        btnEliminarManejoE = new javax.swing.JButton();
        lblCargoManejoE = new javax.swing.JLabel();
        comboCargoManejoE = new javax.swing.JComboBox<>();
        btnCheckManejoE = new javax.swing.JButton();
        panelLibro = new javax.swing.JTabbedPane();
        panelLibroAnadir = new javax.swing.JPanel();
        lblNombreLibroA = new javax.swing.JLabel();
        txtNombreLibroA = new javax.swing.JTextField();
        lblIsbnLibroA = new javax.swing.JLabel();
        txtIsbnLibroA = new javax.swing.JTextField();
        lblPaginasLibroA = new javax.swing.JLabel();
        txtPaginasLibroA = new javax.swing.JTextField();
        lblAnoLibroA = new javax.swing.JLabel();
        txtAnoLibroA = new javax.swing.JTextField();
        lblIdiomaLibroA = new javax.swing.JLabel();
        lblEditorialLibroA = new javax.swing.JLabel();
        comboEditorialLibroA = new javax.swing.JComboBox<>();
        lblAreaLibroA = new javax.swing.JLabel();
        comboAreaLibroA = new javax.swing.JComboBox<>();
        lblDigitalLibroA = new javax.swing.JLabel();
        btnSiLibroA = new javax.swing.JButton();
        btnNoLibroA = new javax.swing.JButton();
        lblUrlLibroA = new javax.swing.JLabel();
        txtUrlLibroA = new javax.swing.JTextField();
        lblTamanoLibroA = new javax.swing.JLabel();
        txtTamanoLibroA = new javax.swing.JTextField();
        lblFormatoLibroA = new javax.swing.JLabel();
        comboFormatoLibroA = new javax.swing.JComboBox<>();
        btnAgregarLibroA = new javax.swing.JButton();
        comboIdiomaLibroA = new javax.swing.JComboBox<>();
        panelLibroModificar = new javax.swing.JPanel();
        lblIsbnLibroM = new javax.swing.JLabel();
        txtIsbnLibroM = new javax.swing.JTextField();
        btnCheckLibroM = new javax.swing.JButton();
        lblTituloLibroM = new javax.swing.JLabel();
        txtTituloLibroM = new javax.swing.JTextField();
        lblPaginasLibroM = new javax.swing.JLabel();
        txtPaginasLibroM = new javax.swing.JTextField();
        lblAnoLibroM = new javax.swing.JLabel();
        txtAnoLibroM = new javax.swing.JTextField();
        lblIdiomaLibroM = new javax.swing.JLabel();
        lblEditorialLibroM = new javax.swing.JLabel();
        comboEditorialLibroM = new javax.swing.JComboBox<>();
        lblAreaLibroM = new javax.swing.JLabel();
        comboAreaLibroM = new javax.swing.JComboBox<>();
        lblDigitalLibroM = new javax.swing.JLabel();
        btnSiLibroM = new javax.swing.JButton();
        btnNoLibroM = new javax.swing.JButton();
        lblUrlLibroM = new javax.swing.JLabel();
        txtUrlLibroM = new javax.swing.JTextField();
        lblTamanoLibroM = new javax.swing.JLabel();
        txtTamanoLibroM = new javax.swing.JTextField();
        lblFormatoLibroM = new javax.swing.JLabel();
        comboFormatoLibroM = new javax.swing.JComboBox<>();
        btnModificarLibroM = new javax.swing.JButton();
        comboIdiomaLibroM = new javax.swing.JComboBox<>();
        panelLibroConsultar = new javax.swing.JPanel();
        lblIsbnLibroC = new javax.swing.JLabel();
        txtIsbnLibroC = new javax.swing.JTextField();
        btnCheckLibroC = new javax.swing.JButton();
        lblTituloLibroC = new javax.swing.JLabel();
        txtTituloLibroC = new javax.swing.JTextField();
        lblPaginasLibroC = new javax.swing.JLabel();
        txtPaginasLibroC = new javax.swing.JTextField();
        lblAnoLibroC = new javax.swing.JLabel();
        txtAnoLibroC = new javax.swing.JTextField();
        lblIdiomaLibroC = new javax.swing.JLabel();
        lblEditorialLibroC = new javax.swing.JLabel();
        comboEditorialLibroC = new javax.swing.JComboBox<>();
        lblAreaLibroC = new javax.swing.JLabel();
        comboAreaLibroC = new javax.swing.JComboBox<>();
        lblDigitalLibroC = new javax.swing.JLabel();
        btnSiLibroC = new javax.swing.JButton();
        btnNoLibroC = new javax.swing.JButton();
        lblUrlLibroC = new javax.swing.JLabel();
        txtUrlLibroC = new javax.swing.JTextField();
        lblTamanoLibroC = new javax.swing.JLabel();
        txtTamanoLibroC = new javax.swing.JTextField();
        lblFormatoLibroC = new javax.swing.JLabel();
        comboFormatoLibroC = new javax.swing.JComboBox<>();
        comboIdiomaLibroC = new javax.swing.JComboBox<>();
        panelLibroEliminar = new javax.swing.JPanel();
        lblIsbnLibroE = new javax.swing.JLabel();
        txtIsbnLibroE = new javax.swing.JTextField();
        btnCheckLibroE = new javax.swing.JButton();
        lblTituloLibroE = new javax.swing.JLabel();
        txtTituloLibroE = new javax.swing.JTextField();
        lblPaginasLibroE = new javax.swing.JLabel();
        txtPaginasLibroE = new javax.swing.JTextField();
        lblAnoLibroE = new javax.swing.JLabel();
        txtAnoLibroE = new javax.swing.JTextField();
        lblIdiomaLibroE = new javax.swing.JLabel();
        lblEditorialLibroE = new javax.swing.JLabel();
        comboEditorialLibroE = new javax.swing.JComboBox<>();
        lblAreaLibroE = new javax.swing.JLabel();
        comboAreaLibroE = new javax.swing.JComboBox<>();
        lblDigitalLibroE = new javax.swing.JLabel();
        btnSiLibroE = new javax.swing.JButton();
        btnNoLibroE = new javax.swing.JButton();
        lblUrlLibroE = new javax.swing.JLabel();
        txtUrlLibroE = new javax.swing.JTextField();
        lblTamanoLibroE = new javax.swing.JLabel();
        txtTamanoLibroE = new javax.swing.JTextField();
        lblFormatoLibroE = new javax.swing.JLabel();
        comboFormatoLibroE = new javax.swing.JComboBox<>();
        btnEliminarLibroE = new javax.swing.JButton();
        comboIdiomaLibroE = new javax.swing.JComboBox<>();
        panelTodosLosLibros = new javax.swing.JPanel();
        panelTablaTodosLosLibros = new javax.swing.JPanel();
        scrollTodosLosLibros = new javax.swing.JScrollPane();
        tablaTodosLosLibros = new javax.swing.JTable();
        panelPrestamo = new javax.swing.JTabbedPane();
        panelPrestamoAnadir = new javax.swing.JPanel();
        lblNumPrestamoA = new javax.swing.JLabel();
        txtUsuarioPrestamoA = new javax.swing.JTextField();
        btnCheckPrestamoA = new javax.swing.JButton();
        lblUsuarioPrestamoA = new javax.swing.JLabel();
        txtNumPrestamoA = new javax.swing.JTextField();
        lblIsbnPrestamoA = new javax.swing.JLabel();
        txtIsbnPrestamoA = new javax.swing.JTextField();
        btnVerificarPrestamoA = new javax.swing.JButton();
        lblEjemplarPrestamoA = new javax.swing.JLabel();
        comboEjemplarPrestamoA = new javax.swing.JComboBox<>();
        btnAgregarPrestamoA = new javax.swing.JButton();
        scrollPrestamoA = new javax.swing.JScrollPane();
        tablaPrestamoA = new javax.swing.JTable();
        btnRemoverPrestamoA = new javax.swing.JButton();
        btnRealizarPrestamoA = new javax.swing.JButton();
        panelPrestamoModificar = new javax.swing.JPanel();
        lblUsuarioPrestamoM = new javax.swing.JLabel();
        txtPrestamoM = new javax.swing.JTextField();
        btnCheckPrestamoM = new javax.swing.JButton();
        lblPrestamoM = new javax.swing.JLabel();
        txtUsuarioPrestamoM = new javax.swing.JTextField();
        lblIsbnPrestamoM = new javax.swing.JLabel();
        txtIsbnPrestamoM = new javax.swing.JTextField();
        btnVerificarPrestamoM = new javax.swing.JButton();
        lblEjemplarPrestamoM = new javax.swing.JLabel();
        comboEjemplarPrestamoM = new javax.swing.JComboBox<>();
        btnAgregarPrestamoM = new javax.swing.JButton();
        scrollPrestamoM = new javax.swing.JScrollPane();
        tablaPrestamoM = new javax.swing.JTable();
        btnRemoverPrestamoM = new javax.swing.JButton();
        btnModificarPrestamoM = new javax.swing.JButton();
        panelPrestamoConsultar = new javax.swing.JPanel();
        txtUsuarioPrestamoC = new javax.swing.JTextField();
        btnCheckPrestamoC = new javax.swing.JButton();
        lblUsuarioPrestamoC = new javax.swing.JLabel();
        lblFechaPrestamoC = new javax.swing.JLabel();
        txtFechaPrestamoC = new javax.swing.JTextField();
        scrollPrestamoC = new javax.swing.JScrollPane();
        tablaPrestamoC = new javax.swing.JTable();
        btnDevolverPrestamoC = new javax.swing.JButton();
        panelPrestamoEliminar = new javax.swing.JPanel();
        txtPrestamoE = new javax.swing.JTextField();
        btnCheckPrestamoE = new javax.swing.JButton();
        lblPrestamoE = new javax.swing.JLabel();
        lblUsuarioPrestamoE = new javax.swing.JLabel();
        txtUsuarioPrestamoE = new javax.swing.JTextField();
        scrollPrestamoE = new javax.swing.JScrollPane();
        tablaPrestamoE = new javax.swing.JTable();
        btnEliminarPrestamoE = new javax.swing.JButton();
        panelMulta = new javax.swing.JTabbedPane();
        subPanelMulta = new javax.swing.JPanel();
        panelMultaUsuario = new javax.swing.JPanel();
        btnMultasUsuarioU = new javax.swing.JButton();
        btnMultasTodasU = new javax.swing.JButton();
        lblIdMultas = new javax.swing.JLabel();
        txtIdMultas = new javax.swing.JTextField();
        btnCheckMultas = new javax.swing.JButton();
        lblFechaMultas = new javax.swing.JLabel();
        txtFechaMultas = new javax.swing.JTextField();
        lblMultas = new javax.swing.JLabel();
        scrollMultasU = new javax.swing.JScrollPane();
        tableMultasU = new javax.swing.JTable();
        btnPagarMultas = new javax.swing.JButton();
        panelMultaTodo = new javax.swing.JPanel();
        btnMultasUsuarioT = new javax.swing.JButton();
        btnMultasTodasT = new javax.swing.JButton();
        scrollMultasT = new javax.swing.JScrollPane();
        tableMultasT = new javax.swing.JTable();
        panelSolicitud = new javax.swing.JTabbedPane();
        panelSolicitudConsultar = new javax.swing.JPanel();
        scrollTableSolicitud = new javax.swing.JScrollPane();
        tableSolicitud = new javax.swing.JTable();
        btnRechazarSolicitud = new javax.swing.JButton();
        btnAprobarSolicitud = new javax.swing.JButton();
        btnDescripcionSolicitud = new javax.swing.JButton();
        scrollAreaSolicitud = new javax.swing.JScrollPane();
        txtAreaSolicitud = new javax.swing.JTextArea();
        panelDescarga = new javax.swing.JTabbedPane();
        panelDescargaConsultar = new javax.swing.JPanel();
        lblDescargas = new javax.swing.JLabel();
        scrollDescargas = new javax.swing.JScrollPane();
        tableDescargas = new javax.swing.JTable();
        panelEjemplar = new javax.swing.JTabbedPane();
        panelEjemplarAnadir = new javax.swing.JPanel();
        lblIsbnEjemplarA = new javax.swing.JLabel();
        txtIsbnEjemplarA = new javax.swing.JTextField();
        btnCheckEjemplarA = new javax.swing.JButton();
        lblNumeroEjemplarA = new javax.swing.JLabel();
        txtNumeroEjemplarA = new javax.swing.JTextField();
        lblEstanteEjemplarA = new javax.swing.JLabel();
        txtEstanteEjemplarA = new javax.swing.JTextField();
        lblCajonEjemplarA = new javax.swing.JLabel();
        txtCajonEjemplarA = new javax.swing.JTextField();
        lblPasilloEjemplarA = new javax.swing.JLabel();
        txtPasilloEjemplarA = new javax.swing.JTextField();
        lblSalaEjemplarA = new javax.swing.JLabel();
        txtSalaEjemplarA = new javax.swing.JTextField();
        btnAgregarEjemplarA = new javax.swing.JButton();
        panelEjemplarModificar = new javax.swing.JPanel();
        lblIsbnEjemplarM = new javax.swing.JLabel();
        txtIsbnEjemplarM = new javax.swing.JTextField();
        btnCheckEjemplarM = new javax.swing.JButton();
        lblNumeroEjemplarM = new javax.swing.JLabel();
        txtNumeroEjemplarM = new javax.swing.JTextField();
        lblEstanteEjemplarM = new javax.swing.JLabel();
        txtEstanteEjemplarM = new javax.swing.JTextField();
        lblCajonEjemplarM = new javax.swing.JLabel();
        txtCajonEjemplarM = new javax.swing.JTextField();
        lblPasilloEjemplarM = new javax.swing.JLabel();
        txtPasilloEjemplarM = new javax.swing.JTextField();
        lblSalaEjemplarM = new javax.swing.JLabel();
        txtSalaEjemplarM = new javax.swing.JTextField();
        btnModificarEjemplarM = new javax.swing.JButton();
        panelEjemplarConsultar = new javax.swing.JPanel();
        lblIsbnEjemplarC = new javax.swing.JLabel();
        txtIsbnEjemplarC = new javax.swing.JTextField();
        btnCheckEjemplarC = new javax.swing.JButton();
        lblNumeroEjemplarC = new javax.swing.JLabel();
        txtNumeroEjemplarC = new javax.swing.JTextField();
        lblEstanteEjemplarC = new javax.swing.JLabel();
        txtEstanteEjemplarC = new javax.swing.JTextField();
        lblCajonEjemplarC = new javax.swing.JLabel();
        txtCajonEjemplarC = new javax.swing.JTextField();
        lblPasilloEjemplarC = new javax.swing.JLabel();
        txtPasilloEjemplarC = new javax.swing.JTextField();
        lblSalaEjemplarC = new javax.swing.JLabel();
        txtSalaEjemplarC = new javax.swing.JTextField();
        panelEjemplarEliminar = new javax.swing.JPanel();
        lblIsbnEjemplarE = new javax.swing.JLabel();
        txtIsbnEjemplarE = new javax.swing.JTextField();
        btnCheckEjemplarE = new javax.swing.JButton();
        lblNumeroEjemplarE = new javax.swing.JLabel();
        txtNumeroEjemplarE = new javax.swing.JTextField();
        lblEstanteEjemplarE = new javax.swing.JLabel();
        txtEstanteEjemplarE = new javax.swing.JTextField();
        lblCajonEjemplarE = new javax.swing.JLabel();
        txtCajonEjemplarE = new javax.swing.JTextField();
        lblPasilloEjemplarE = new javax.swing.JLabel();
        txtPasilloEjemplarE = new javax.swing.JTextField();
        lblSalaEjemplarE = new javax.swing.JLabel();
        txtSalaEjemplarE = new javax.swing.JTextField();
        btnEliminarEjemplarE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTitulo.setBackground(new java.awt.Color(205, 74, 74));

        lblTitulo.setFont(new java.awt.Font("Microsoft Himalaya", 1, 72)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Biblioteca Universidad del Valle");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addContainerGap())
        );

        panelFondo.add(panelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelMenu.setPreferredSize(new java.awt.Dimension(160, 480));

        btnManejoPersonal.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnManejoPersonal.setText("Manejo de personal");
        btnManejoPersonal.setFocusPainted(false);
        btnManejoPersonal.setRequestFocusEnabled(false);

        btnLibros.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnLibros.setText("Libros");
        btnLibros.setFocusPainted(false);
        btnLibros.setPreferredSize(new java.awt.Dimension(75, 27));
        btnLibros.setRequestFocusEnabled(false);

        btnPrestamos.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnPrestamos.setText("Préstamos");
        btnPrestamos.setFocusPainted(false);
        btnPrestamos.setPreferredSize(new java.awt.Dimension(75, 27));
        btnPrestamos.setRequestFocusEnabled(false);

        btnMultas.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnMultas.setText("Multas");
        btnMultas.setFocusPainted(false);
        btnMultas.setPreferredSize(new java.awt.Dimension(75, 27));
        btnMultas.setRequestFocusEnabled(false);

        btnCerrar.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnCerrar.setText("Cerrar sesión");
        btnCerrar.setFocusPainted(false);
        btnCerrar.setPreferredSize(new java.awt.Dimension(75, 27));
        btnCerrar.setRequestFocusEnabled(false);

        btnSolicitudes.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnSolicitudes.setText("Solicitudes");
        btnSolicitudes.setFocusPainted(false);
        btnSolicitudes.setPreferredSize(new java.awt.Dimension(75, 27));
        btnSolicitudes.setRequestFocusEnabled(false);

        btnDescargas.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnDescargas.setText("Descargas");
        btnDescargas.setFocusPainted(false);
        btnDescargas.setPreferredSize(new java.awt.Dimension(75, 27));
        btnDescargas.setRequestFocusEnabled(false);

        btnEjemplar.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnEjemplar.setText("Ejemplar");
        btnEjemplar.setFocusPainted(false);
        btnEjemplar.setPreferredSize(new java.awt.Dimension(75, 27));
        btnEjemplar.setRequestFocusEnabled(false);

        lblAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdmin.setText("Admin");

        btnDescargarInfo.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnDescargarInfo.setText("Descargar info");
        btnDescargarInfo.setFocusPainted(false);
        btnDescargarInfo.setPreferredSize(new java.awt.Dimension(75, 27));
        btnDescargarInfo.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSolicitudes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManejoPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEjemplar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargarInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManejoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDescargas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDescargarInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnManejoPersonal.setBackground(Color.WHITE);
        btnLibros.setBackground(Color.WHITE);
        btnPrestamos.setBackground(Color.WHITE);
        btnMultas.setBackground(Color.WHITE);
        btnCerrar.setBackground(Color.WHITE);
        btnSolicitudes.setBackground(Color.WHITE);
        btnDescargas.setBackground(Color.WHITE);
        btnEjemplar.setBackground(Color.WHITE);
        btnDescargarInfo.setBackground(Color.WHITE);

        panelFondo.add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 220, 480));

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setLayout(new java.awt.CardLayout());

        panelManejo.setFocusable(false);
        panelManejo.setRequestFocusEnabled(false);

        txtIdManejoA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblIdManejoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdManejoA.setText("Identificación:");

        lblNombreManejoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNombreManejoA.setText("Nombre:");

        txtNombreManejoA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnAnadirManejoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnAnadirManejoA.setText("Añadir");
        btnAnadirManejoA.setFocusPainted(false);
        btnAnadirManejoA.setRequestFocusEnabled(false);

        lblCargoManejoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCargoManejoA.setText("Cargo:");

        comboCargoManejoA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCargoManejoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblPasswordManejoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPasswordManejoA.setText("Contraseña:");

        txtPasswordManejoA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        checkPasswordManejoA.setText("Ver contraseña");

        javax.swing.GroupLayout panelManejoAnadirLayout = new javax.swing.GroupLayout(panelManejoAnadir);
        panelManejoAnadir.setLayout(panelManejoAnadirLayout);
        panelManejoAnadirLayout.setHorizontalGroup(
            panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelManejoAnadirLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnadirManejoA)
                    .addGroup(panelManejoAnadirLayout.createSequentialGroup()
                        .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdManejoA)
                            .addComponent(lblCargoManejoA)
                            .addComponent(lblPasswordManejoA)
                            .addComponent(lblNombreManejoA))
                        .addGap(279, 279, 279)
                        .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreManejoA)
                            .addComponent(comboCargoManejoA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPasswordManejoA, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkPasswordManejoA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdManejoA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        panelManejoAnadirLayout.setVerticalGroup(
            panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManejoAnadirLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdManejoA)
                    .addComponent(lblIdManejoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreManejoA)
                    .addComponent(lblNombreManejoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargoManejoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargoManejoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordManejoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordManejoA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkPasswordManejoA)
                .addGap(117, 117, 117)
                .addComponent(btnAnadirManejoA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        btnAnadirManejoA.setBackground(Color.WHITE);

        panelManejo.addTab("Añadir", panelManejoAnadir);

        txtIdManejoM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblIdManejoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdManejoM.setText("Identificación:");

        lblNombreManejoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNombreManejoM.setText("Nombre:");

        txtNombreManejoM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreManejoM.setEnabled(false);

        btnModificarManejoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnModificarManejoM.setText("Modificar");
        btnModificarManejoM.setFocusPainted(false);
        btnModificarManejoM.setRequestFocusEnabled(false);

        lblCargoManejoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCargoManejoM.setText("Cargo:");

        comboCargoManejoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCargoManejoM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCargoManejoM.setEnabled(false);

        lblPasswordManejoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPasswordManejoM.setText("Contraseña:");

        txtPasswordManejoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPasswordManejoM.setEnabled(false);

        checkPasswordManejoM.setText("Ver contraseña");
        checkPasswordManejoM.setEnabled(false);

        btnCheckManejoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckManejoM.setText("Check");
        btnCheckManejoM.setFocusPainted(false);
        btnCheckManejoM.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelManejoModificarLayout = new javax.swing.GroupLayout(panelManejoModificar);
        panelManejoModificar.setLayout(panelManejoModificarLayout);
        panelManejoModificarLayout.setHorizontalGroup(
            panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelManejoModificarLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnModificarManejoM)
                    .addGroup(panelManejoModificarLayout.createSequentialGroup()
                        .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCargoManejoM)
                            .addComponent(lblPasswordManejoM)
                            .addComponent(lblNombreManejoM)
                            .addGroup(panelManejoModificarLayout.createSequentialGroup()
                                .addComponent(lblIdManejoM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                                .addComponent(btnCheckManejoM)))
                        .addGap(12, 12, 12)
                        .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreManejoM)
                            .addComponent(comboCargoManejoM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPasswordManejoM, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkPasswordManejoM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdManejoM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        panelManejoModificarLayout.setVerticalGroup(
            panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManejoModificarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdManejoM)
                    .addComponent(lblIdManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreManejoM)
                    .addComponent(lblNombreManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargoManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargoManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasswordManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordManejoM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkPasswordManejoM)
                .addGap(117, 117, 117)
                .addComponent(btnModificarManejoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        btnModificarManejoM.setBackground(Color.WHITE);
        btnCheckManejoM.setBackground(Color.WHITE);

        panelManejo.addTab("Modificar", panelManejoModificar);

        btnEmpleadoManejoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnEmpleadoManejoC.setText("Consultar empleado");
        btnEmpleadoManejoC.setFocusPainted(false);
        btnEmpleadoManejoC.setRequestFocusEnabled(false);

        btnEmpleadosManejoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnEmpleadosManejoC.setText("Todos los empleados");
        btnEmpleadosManejoC.setFocusPainted(false);
        btnEmpleadosManejoC.setRequestFocusEnabled(false);

        subPanelManejoConsultar.setLayout(new java.awt.CardLayout());

        lblIdManejoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdManejoC.setText("Identificación:");

        btnCheckManejoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckManejoC.setText("Check");
        btnCheckManejoC.setFocusPainted(false);
        btnCheckManejoC.setRequestFocusEnabled(false);

        txtIdManejoC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblNombreManejoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNombreManejoC.setText("Nombre:");

        txtNombreManejoC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreManejoC.setEnabled(false);

        lblCargoManejoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCargoManejoC.setText("Cargo:");

        comboCargoManejoC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCargoManejoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Bibliotecologa", "Asistente de biblioteca", "Encargada de adquisiciones", "Tecnico de catalogacion", "Encargada de prestamo", "Asistente de prestamo", "Asistente de referencia", "Encargado de conservacion", "Asistente de conservacion", "Encargado de sistemas" }));
        comboCargoManejoC.setEnabled(false);

        javax.swing.GroupLayout panelEmpleadoManejoCLayout = new javax.swing.GroupLayout(panelEmpleadoManejoC);
        panelEmpleadoManejoC.setLayout(panelEmpleadoManejoCLayout);
        panelEmpleadoManejoCLayout.setHorizontalGroup(
            panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadoManejoCLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmpleadoManejoCLayout.createSequentialGroup()
                        .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdManejoC)
                            .addComponent(lblNombreManejoC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckManejoC)
                        .addGap(12, 12, 12))
                    .addGroup(panelEmpleadoManejoCLayout.createSequentialGroup()
                        .addComponent(lblCargoManejoC)
                        .addGap(337, 337, 337)))
                .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboCargoManejoC, 0, 295, Short.MAX_VALUE)
                    .addComponent(txtIdManejoC, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(txtNombreManejoC))
                .addContainerGap())
        );
        panelEmpleadoManejoCLayout.setVerticalGroup(
            panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadoManejoCLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdManejoC)
                    .addComponent(lblIdManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreManejoC)
                    .addComponent(lblNombreManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargoManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargoManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );

        btnCheckManejoC.setBackground(Color.WHITE);

        subPanelManejoConsultar.add(panelEmpleadoManejoC, "cardManejoEmpleado");

        tablaManejoC.setModel(modeloTabla);
        tablaManejoC.setRowHeight(25);
        scrollManejoC.setViewportView(tablaManejoC);

        javax.swing.GroupLayout panelEmpleadosManejoCLayout = new javax.swing.GroupLayout(panelEmpleadosManejoC);
        panelEmpleadosManejoC.setLayout(panelEmpleadosManejoCLayout);
        panelEmpleadosManejoCLayout.setHorizontalGroup(
            panelEmpleadosManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmpleadosManejoCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollManejoC, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelEmpleadosManejoCLayout.setVerticalGroup(
            panelEmpleadosManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEmpleadosManejoCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollManejoC, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        subPanelManejoConsultar.add(panelEmpleadosManejoC, "cardManejoEmpleados");

        javax.swing.GroupLayout panelManejoConsultarLayout = new javax.swing.GroupLayout(panelManejoConsultar);
        panelManejoConsultar.setLayout(panelManejoConsultarLayout);
        panelManejoConsultarLayout.setHorizontalGroup(
            panelManejoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelManejoConsultarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelManejoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subPanelManejoConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelManejoConsultarLayout.createSequentialGroup()
                        .addComponent(btnEmpleadoManejoC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmpleadosManejoC)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );
        panelManejoConsultarLayout.setVerticalGroup(
            panelManejoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManejoConsultarLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(panelManejoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpleadoManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleadosManejoC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(subPanelManejoConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );

        btnEmpleadoManejoC.setBackground(Color.WHITE);
        btnEmpleadosManejoC.setBackground(Color.WHITE);

        panelManejo.addTab("Consultar", panelManejoConsultar);

        txtIdManejoE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblIdManejoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdManejoE.setText("Identificación:");

        lblNombreManejoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNombreManejoE.setText("Nombre:");

        txtNombreManejoE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreManejoE.setEnabled(false);

        btnEliminarManejoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnEliminarManejoE.setText("Eliminar");
        btnEliminarManejoE.setFocusPainted(false);
        btnEliminarManejoE.setRequestFocusEnabled(false);

        lblCargoManejoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCargoManejoE.setText("Cargo:");

        comboCargoManejoE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCargoManejoE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCargoManejoE.setEnabled(false);

        btnCheckManejoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckManejoE.setText("Check");
        btnCheckManejoE.setFocusPainted(false);
        btnCheckManejoE.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelManejoEliminarLayout = new javax.swing.GroupLayout(panelManejoEliminar);
        panelManejoEliminar.setLayout(panelManejoEliminarLayout);
        panelManejoEliminarLayout.setHorizontalGroup(
            panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelManejoEliminarLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminarManejoE)
                    .addGroup(panelManejoEliminarLayout.createSequentialGroup()
                        .addGroup(panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCargoManejoE)
                            .addComponent(lblNombreManejoE)
                            .addGroup(panelManejoEliminarLayout.createSequentialGroup()
                                .addComponent(lblIdManejoE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                                .addComponent(btnCheckManejoE)))
                        .addGap(12, 12, 12)
                        .addGroup(panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreManejoE)
                            .addComponent(comboCargoManejoE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdManejoE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );
        panelManejoEliminarLayout.setVerticalGroup(
            panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelManejoEliminarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdManejoE)
                    .addComponent(lblIdManejoE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckManejoE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreManejoE)
                    .addComponent(lblNombreManejoE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargoManejoE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargoManejoE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(201, 201, 201)
                .addComponent(btnEliminarManejoE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        btnEliminarManejoE.setBackground(Color.WHITE);
        btnCheckManejoE.setBackground(Color.WHITE);

        panelManejo.addTab("Eliminar", panelManejoEliminar);

        panelPrincipal.add(panelManejo, "cardManejo");

        panelLibro.setFocusable(false);
        panelLibro.setRequestFocusEnabled(false);

        panelLibroAnadir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNombreLibroA.setText("Título:");
        panelLibroAnadir.add(lblNombreLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 148, 31));

        txtNombreLibroA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroAnadir.add(txtNombreLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 550, -1));

        lblIsbnLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnLibroA.setText("ISBN:");
        panelLibroAnadir.add(lblIsbnLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 79, 148, 32));

        txtIsbnLibroA.setEditable(false);
        txtIsbnLibroA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroAnadir.add(txtIsbnLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 80, 190, -1));

        lblPaginasLibroA.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPaginasLibroA.setText("Páginas:");
        panelLibroAnadir.add(lblPaginasLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 79, 82, 31));

        txtPaginasLibroA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroAnadir.add(txtPaginasLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 230, -1));

        lblAnoLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAnoLibroA.setText("Año publicación:");
        panelLibroAnadir.add(lblAnoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 129, -1, 33));

        txtAnoLibroA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroAnadir.add(txtAnoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 129, 190, -1));

        lblIdiomaLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdiomaLibroA.setText("Idioma:");
        panelLibroAnadir.add(lblIdiomaLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 133, 82, -1));

        lblEditorialLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEditorialLibroA.setText("Editorial:");
        panelLibroAnadir.add(lblEditorialLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 148, 31));

        comboEditorialLibroA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEditorialLibroA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ED001-McGraw-Hill", "ED002-Pearson Education", "ED003-Wiley", "ED004-Oxford University Press", "ED005-Cambridge University Press", "ED006-Springer", "ED007-Addison-Wesley", "ED008-Elsevier", "ED009-HarperCollins Publishers", "ED010-Cengage Learning" }));
        panelLibroAnadir.add(comboEditorialLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 180, 190, 31));

        lblAreaLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAreaLibroA.setText("Área:");
        panelLibroAnadir.add(lblAreaLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 82, 31));

        comboAreaLibroA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAreaLibroA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC001 - Matematicas", "AC002 - Fisica", "AC003 - Quimica", "AC004 - Biologia", "AC005 - Informatica", "AC006 - Ingenieria de Civil", "AC007 - Ingenieria Mecanica", "AC008 - Medicina", "AC009 - Psicologia", "AC010 - Filosofia", "AC011 - Algebra", "AC012 - Geometria", "AC013 - Calculo", "AC014 - Mecanica Clasica", "AC015 - Fisica Cuantica", "AC016 - Termodinamica", "AC017 - Quimica Organica", "AC018 - Quimica Inorganica", "AC019 - Algebra Lineal", "AC020 - Geometria Analitica", "AC021 - Calculo Vectorial", "AC022 - Fisica Nuclear", "AC023 - Fisica de Particulas", "AC024 - Mecanica de Fluidos", "AC025 - Electromagnetismo", "AC026 - Bioquimica", "AC027 - Quimica Analitica", "AC028 - Ingenieria Electrica", "AC029 - Ingenieria de Materiales", "AC030 - Neurociencia", "AC031 - Ciencias de la Computacion", "AC032 - Ingenieria de Software", "AC033 - Inteligencia Artificial", "AC034 - Redes y Comunicaciones", "AC035 - Sistemas Operativos", "AC036 - Literatura", "AC037 - Literatura Colombiana", "AC038 - Historia" }));
        panelLibroAnadir.add(comboAreaLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 230, 31));

        lblDigitalLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblDigitalLibroA.setText("Digital:");
        panelLibroAnadir.add(lblDigitalLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 229, 148, 31));

        btnSiLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnSiLibroA.setText("Si");
        btnSiLibroA.setFocusPainted(false);
        btnSiLibroA.setRequestFocusEnabled(false);
        panelLibroAnadir.add(btnSiLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));
        btnSiLibroA.setBackground(Color.WHITE);

        btnNoLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnNoLibroA.setText("No");
        btnNoLibroA.setFocusPainted(false);
        btnNoLibroA.setRequestFocusEnabled(false);
        panelLibroAnadir.add(btnNoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 230, -1, -1));
        btnNoLibroA.setBackground(Color.WHITE);

        lblUrlLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUrlLibroA.setText("URL:");
        panelLibroAnadir.add(lblUrlLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 233, 82, -1));

        txtUrlLibroA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroAnadir.add(txtUrlLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 229, 230, -1));

        lblTamanoLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTamanoLibroA.setText("Tamaño:");
        panelLibroAnadir.add(lblTamanoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 278, 148, 32));

        txtTamanoLibroA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroAnadir.add(txtTamanoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 278, 190, -1));

        lblFormatoLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFormatoLibroA.setText("Formato:");
        panelLibroAnadir.add(lblFormatoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 279, -1, 31));

        comboFormatoLibroA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFormatoLibroA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF", "EPUB" }));
        panelLibroAnadir.add(comboFormatoLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 278, 230, 32));

        btnAgregarLibroA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnAgregarLibroA.setText("Agregar");
        btnAgregarLibroA.setFocusPainted(false);
        btnAgregarLibroA.setRequestFocusEnabled(false);
        panelLibroAnadir.add(btnAgregarLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 358, -1, -1));
        btnAgregarLibroA.setBackground(Color.WHITE);

        comboIdiomaLibroA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboIdiomaLibroA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Inglés", "Portugués", "Alemán", "Chino mandarín" }));
        panelLibroAnadir.add(comboIdiomaLibroA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 131, 230, 31));

        panelLibro.addTab("Añadir", panelLibroAnadir);

        panelLibroModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIsbnLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnLibroM.setText("ISBN:");
        panelLibroModificar.add(lblIsbnLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 148, 31));

        txtIsbnLibroM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroModificar.add(txtIsbnLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 30, 190, -1));

        btnCheckLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckLibroM.setText("Check");
        btnCheckLibroM.setFocusPainted(false);
        btnCheckLibroM.setRequestFocusEnabled(false);
        panelLibroModificar.add(btnCheckLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 31, -1, -1));
        btnCheckLibroM.setBackground(Color.WHITE);

        lblTituloLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTituloLibroM.setText("Título:");
        panelLibroModificar.add(lblTituloLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 148, -1));

        txtTituloLibroM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTituloLibroM.setEnabled(false);
        panelLibroModificar.add(txtTituloLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 79, 190, -1));

        lblPaginasLibroM.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lblPaginasLibroM.setText("Páginas:");
        panelLibroModificar.add(lblPaginasLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 79, 90, 31));

        txtPaginasLibroM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPaginasLibroM.setEnabled(false);
        panelLibroModificar.add(txtPaginasLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 79, 230, -1));

        lblAnoLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAnoLibroM.setText("Año publicación:");
        panelLibroModificar.add(lblAnoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, -1, 33));

        txtAnoLibroM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAnoLibroM.setEnabled(false);
        panelLibroModificar.add(txtAnoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 128, 190, -1));

        lblIdiomaLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdiomaLibroM.setText("Idioma:");
        panelLibroModificar.add(lblIdiomaLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 129, 90, 31));

        lblEditorialLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEditorialLibroM.setText("Editorial:");
        panelLibroModificar.add(lblEditorialLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 179, 148, 32));

        comboEditorialLibroM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEditorialLibroM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ED001-McGraw-Hill", "ED002-Pearson Education", "ED003-Wiley", "ED004-Oxford University Press", "ED005-Cambridge University Press", "ED006-Springer", "ED007-Addison-Wesley", "ED008-Elsevier", "ED009-HarperCollins Publishers", "ED010-Cengage Learning" }));
        comboEditorialLibroM.setEnabled(false);
        panelLibroModificar.add(comboEditorialLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 180, 190, 31));

        lblAreaLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAreaLibroM.setText("Area:");
        panelLibroModificar.add(lblAreaLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 179, 90, 31));

        comboAreaLibroM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAreaLibroM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC001 - Matematicas", "AC002 - Fisica", "AC003 - Quimica", "AC004 - Biologia", "AC005 - Informatica", "AC006 - Ingenieria de Civil", "AC007 - Ingenieria Mecanica", "AC008 - Medicina", "AC009 - Psicologia", "AC010 - Filosofia", "AC011 - Algebra", "AC012 - Geometria", "AC013 - Calculo", "AC014 - Mecanica Clasica", "AC015 - Fisica Cuantica", "AC016 - Termodinamica", "AC017 - Quimica Organica", "AC018 - Quimica Inorganica", "AC019 - Algebra Lineal", "AC020 - Geometria Analitica", "AC021 - Calculo Vectorial", "AC022 - Fisica Nuclear", "AC023 - Fisica de Particulas", "AC024 - Mecanica de Fluidos", "AC025 - Electromagnetismo", "AC026 - Bioquimica", "AC027 - Quimica Analitica", "AC028 - Ingenieria Electrica", "AC029 - Ingenieria de Materiales", "AC030 - Neurociencia", "AC031 - Ciencias de la Computacion", "AC032 - Ingenieria de Software", "AC033 - Inteligencia Artificial", "AC034 - Redes y Comunicaciones", "AC035 - Sistemas Operativos", "AC036 - Literatura", "AC037 - Literatura Colombiana", "AC038 - Historia" }));
        comboAreaLibroM.setEnabled(false);
        panelLibroModificar.add(comboAreaLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 180, 230, 31));

        lblDigitalLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblDigitalLibroM.setText("Digital:");
        panelLibroModificar.add(lblDigitalLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 229, 148, 31));

        btnSiLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnSiLibroM.setText("Si");
        btnSiLibroM.setEnabled(false);
        btnSiLibroM.setFocusPainted(false);
        btnSiLibroM.setRequestFocusEnabled(false);
        panelLibroModificar.add(btnSiLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));
        btnSiLibroM.setBackground(Color.WHITE);

        btnNoLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnNoLibroM.setText("No");
        btnNoLibroM.setEnabled(false);
        btnNoLibroM.setFocusPainted(false);
        btnNoLibroM.setRequestFocusEnabled(false);
        panelLibroModificar.add(btnNoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 229, -1, -1));
        btnNoLibroM.setBackground(Color.WHITE);

        lblUrlLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUrlLibroM.setText("URL:");
        panelLibroModificar.add(lblUrlLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 233, 150, -1));

        txtUrlLibroM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUrlLibroM.setEnabled(false);
        panelLibroModificar.add(txtUrlLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 229, 230, -1));

        lblTamanoLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTamanoLibroM.setText("Tamaño:");
        panelLibroModificar.add(lblTamanoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 278, 148, 31));

        txtTamanoLibroM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTamanoLibroM.setEnabled(false);
        panelLibroModificar.add(txtTamanoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 278, 190, -1));

        lblFormatoLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFormatoLibroM.setText("Formato:");
        panelLibroModificar.add(lblFormatoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 278, 150, 33));

        comboFormatoLibroM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFormatoLibroM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF", "EPUB" }));
        comboFormatoLibroM.setEnabled(false);
        panelLibroModificar.add(comboFormatoLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 278, 230, 31));

        btnModificarLibroM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnModificarLibroM.setText("Modificar");
        btnModificarLibroM.setEnabled(false);
        btnModificarLibroM.setFocusPainted(false);
        btnModificarLibroM.setRequestFocusEnabled(false);
        panelLibroModificar.add(btnModificarLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 358, -1, -1));
        btnModificarLibroM.setBackground(Color.WHITE);

        comboIdiomaLibroM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboIdiomaLibroM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Inglés", "Portugués", "Alemán", "Chino mandarín" }));
        comboIdiomaLibroM.setEnabled(false);
        panelLibroModificar.add(comboIdiomaLibroM, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 130, 230, 31));

        panelLibro.addTab("Modificar", panelLibroModificar);

        panelLibroConsultar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIsbnLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnLibroC.setText("ISBN:");
        panelLibroConsultar.add(lblIsbnLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 148, 31));

        txtIsbnLibroC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroConsultar.add(txtIsbnLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 30, 190, -1));

        btnCheckLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckLibroC.setText("Check");
        btnCheckLibroC.setFocusPainted(false);
        btnCheckLibroC.setRequestFocusEnabled(false);
        panelLibroConsultar.add(btnCheckLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 31, -1, -1));
        btnCheckLibroC.setBackground(Color.WHITE);

        lblTituloLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTituloLibroC.setText("Título:");
        panelLibroConsultar.add(lblTituloLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 148, -1));

        txtTituloLibroC.setEditable(false);
        txtTituloLibroC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroConsultar.add(txtTituloLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 79, 190, -1));

        lblPaginasLibroC.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lblPaginasLibroC.setText("Páginas:");
        panelLibroConsultar.add(lblPaginasLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 79, 150, 31));

        txtPaginasLibroC.setEditable(false);
        txtPaginasLibroC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroConsultar.add(txtPaginasLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 79, 230, -1));

        lblAnoLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAnoLibroC.setText("Año publicación:");
        panelLibroConsultar.add(lblAnoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, -1, 33));

        txtAnoLibroC.setEditable(false);
        txtAnoLibroC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroConsultar.add(txtAnoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 128, 190, -1));

        lblIdiomaLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdiomaLibroC.setText("Idioma:");
        panelLibroConsultar.add(lblIdiomaLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 129, 150, 31));

        lblEditorialLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEditorialLibroC.setText("Editorial:");
        panelLibroConsultar.add(lblEditorialLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 179, 148, 32));

        comboEditorialLibroC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEditorialLibroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ED001-McGraw-Hill", "ED002-Pearson Education", "ED003-Wiley", "ED004-Oxford University Press", "ED005-Cambridge University Press", "ED006-Springer", "ED007-Addison-Wesley", "ED008-Elsevier", "ED009-HarperCollins Publishers", "ED010-Cengage Learning" }));
        comboEditorialLibroC.setEnabled(false);
        panelLibroConsultar.add(comboEditorialLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 180, 190, 31));

        lblAreaLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAreaLibroC.setText("Area:");
        panelLibroConsultar.add(lblAreaLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 179, 150, 31));

        comboAreaLibroC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAreaLibroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC001 - Matematicas", "AC002 - Fisica", "AC003 - Quimica", "AC004 - Biologia", "AC005 - Informatica", "AC006 - Ingenieria de Civil", "AC007 - Ingenieria Mecanica", "AC008 - Medicina", "AC009 - Psicologia", "AC010 - Filosofia", "AC011 - Algebra", "AC012 - Geometria", "AC013 - Calculo", "AC014 - Mecanica Clasica", "AC015 - Fisica Cuantica", "AC016 - Termodinamica", "AC017 - Quimica Organica", "AC018 - Quimica Inorganica", "AC019 - Algebra Lineal", "AC020 - Geometria Analitica", "AC021 - Calculo Vectorial", "AC022 - Fisica Nuclear", "AC023 - Fisica de Particulas", "AC024 - Mecanica de Fluidos", "AC025 - Electromagnetismo", "AC026 - Bioquimica", "AC027 - Quimica Analitica", "AC028 - Ingenieria Electrica", "AC029 - Ingenieria de Materiales", "AC030 - Neurociencia", "AC031 - Ciencias de la Computacion", "AC032 - Ingenieria de Software", "AC033 - Inteligencia Artificial", "AC034 - Redes y Comunicaciones", "AC035 - Sistemas Operativos", "AC036 - Literatura", "AC037 - Literatura Colombiana", "AC038 - Historia" }));
        comboAreaLibroC.setEnabled(false);
        panelLibroConsultar.add(comboAreaLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 180, 230, 31));

        lblDigitalLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblDigitalLibroC.setText("Digital:");
        panelLibroConsultar.add(lblDigitalLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 229, 148, 31));

        btnSiLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnSiLibroC.setText("Si");
        btnSiLibroC.setEnabled(false);
        btnSiLibroC.setFocusPainted(false);
        btnSiLibroC.setRequestFocusEnabled(false);
        panelLibroConsultar.add(btnSiLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));
        btnSiLibroC.setBackground(Color.WHITE);

        btnNoLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnNoLibroC.setText("No");
        btnNoLibroC.setEnabled(false);
        btnNoLibroC.setFocusPainted(false);
        btnNoLibroC.setRequestFocusEnabled(false);
        panelLibroConsultar.add(btnNoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 229, -1, -1));
        btnNoLibroC.setBackground(Color.WHITE);

        lblUrlLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUrlLibroC.setText("URL:");
        panelLibroConsultar.add(lblUrlLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 233, 150, -1));

        txtUrlLibroC.setEditable(false);
        txtUrlLibroC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroConsultar.add(txtUrlLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 229, 230, -1));

        lblTamanoLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTamanoLibroC.setText("Tamaño:");
        panelLibroConsultar.add(lblTamanoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 278, 148, 31));

        txtTamanoLibroC.setEditable(false);
        txtTamanoLibroC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroConsultar.add(txtTamanoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 278, 190, -1));

        lblFormatoLibroC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFormatoLibroC.setText("Formato:");
        panelLibroConsultar.add(lblFormatoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 278, 150, 33));

        comboFormatoLibroC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFormatoLibroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF", "EPUB" }));
        comboFormatoLibroC.setEnabled(false);
        panelLibroConsultar.add(comboFormatoLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 278, 230, 31));

        comboIdiomaLibroC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboIdiomaLibroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Inglés", "Portugués", "Alemán", "Chino mandarín" }));
        comboIdiomaLibroC.setEnabled(false);
        panelLibroConsultar.add(comboIdiomaLibroC, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 130, 230, 31));

        panelLibro.addTab("Consultar", panelLibroConsultar);

        panelLibroEliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIsbnLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnLibroE.setText("ISBN:");
        panelLibroEliminar.add(lblIsbnLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 148, 31));

        txtIsbnLibroE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelLibroEliminar.add(txtIsbnLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 30, 190, -1));

        btnCheckLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckLibroE.setText("Check");
        btnCheckLibroE.setFocusPainted(false);
        btnCheckLibroE.setRequestFocusEnabled(false);
        panelLibroEliminar.add(btnCheckLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 31, -1, -1));
        btnCheckLibroE.setBackground(Color.WHITE);

        lblTituloLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTituloLibroE.setText("Título:");
        panelLibroEliminar.add(lblTituloLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 83, 148, -1));

        txtTituloLibroE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTituloLibroE.setEnabled(false);
        panelLibroEliminar.add(txtTituloLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 79, 190, -1));

        lblPaginasLibroE.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        lblPaginasLibroE.setText("Páginas:");
        panelLibroEliminar.add(lblPaginasLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 79, 150, 31));

        txtPaginasLibroE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPaginasLibroE.setEnabled(false);
        panelLibroEliminar.add(txtPaginasLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 79, 230, -1));

        lblAnoLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAnoLibroE.setText("Año publicación:");
        panelLibroEliminar.add(lblAnoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 128, -1, 33));

        txtAnoLibroE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAnoLibroE.setEnabled(false);
        panelLibroEliminar.add(txtAnoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 128, 190, -1));

        lblIdiomaLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdiomaLibroE.setText("Idioma:");
        panelLibroEliminar.add(lblIdiomaLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 129, 150, 31));

        lblEditorialLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEditorialLibroE.setText("Editorial:");
        panelLibroEliminar.add(lblEditorialLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 179, 148, 32));

        comboEditorialLibroE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEditorialLibroE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ED001-McGraw-Hill", "ED002-Pearson Education", "ED003-Wiley", "ED004-Oxford University Press", "ED005-Cambridge University Press", "ED006-Springer", "ED007-Addison-Wesley", "ED008-Elsevier", "ED009-HarperCollins Publishers", "ED010-Cengage Learning" }));
        comboEditorialLibroE.setEnabled(false);
        panelLibroEliminar.add(comboEditorialLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 180, 190, 31));

        lblAreaLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblAreaLibroE.setText("Area:");
        panelLibroEliminar.add(lblAreaLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 179, 150, 31));

        comboAreaLibroE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboAreaLibroE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC001 - Matematicas", "AC002 - Fisica", "AC003 - Quimica", "AC004 - Biologia", "AC005 - Informatica", "AC006 - Ingenieria de Civil", "AC007 - Ingenieria Mecanica", "AC008 - Medicina", "AC009 - Psicologia", "AC010 - Filosofia", "AC011 - Algebra", "AC012 - Geometria", "AC013 - Calculo", "AC014 - Mecanica Clasica", "AC015 - Fisica Cuantica", "AC016 - Termodinamica", "AC017 - Quimica Organica", "AC018 - Quimica Inorganica", "AC019 - Algebra Lineal", "AC020 - Geometria Analitica", "AC021 - Calculo Vectorial", "AC022 - Fisica Nuclear", "AC023 - Fisica de Particulas", "AC024 - Mecanica de Fluidos", "AC025 - Electromagnetismo", "AC026 - Bioquimica", "AC027 - Quimica Analitica", "AC028 - Ingenieria Electrica", "AC029 - Ingenieria de Materiales", "AC030 - Neurociencia", "AC031 - Ciencias de la Computacion", "AC032 - Ingenieria de Software", "AC033 - Inteligencia Artificial", "AC034 - Redes y Comunicaciones", "AC035 - Sistemas Operativos", "AC036 - Literatura", "AC037 - Literatura Colombiana", "AC038 - Historia" }));
        comboAreaLibroE.setEnabled(false);
        panelLibroEliminar.add(comboAreaLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 180, 230, 31));

        lblDigitalLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblDigitalLibroE.setText("Digital:");
        panelLibroEliminar.add(lblDigitalLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 229, 148, 31));

        btnSiLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnSiLibroE.setText("Si");
        btnSiLibroE.setEnabled(false);
        btnSiLibroE.setFocusPainted(false);
        btnSiLibroE.setRequestFocusEnabled(false);
        panelLibroEliminar.add(btnSiLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));
        btnSiLibroE.setBackground(Color.WHITE);

        btnNoLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnNoLibroE.setText("No");
        btnNoLibroE.setEnabled(false);
        btnNoLibroE.setFocusPainted(false);
        btnNoLibroE.setRequestFocusEnabled(false);
        panelLibroEliminar.add(btnNoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 229, -1, -1));
        btnNoLibroE.setBackground(Color.WHITE);

        lblUrlLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUrlLibroE.setText("URL:");
        panelLibroEliminar.add(lblUrlLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 233, 150, -1));

        txtUrlLibroE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUrlLibroE.setEnabled(false);
        panelLibroEliminar.add(txtUrlLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 229, 230, -1));

        lblTamanoLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblTamanoLibroE.setText("Tamaño:");
        panelLibroEliminar.add(lblTamanoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 278, 148, 31));

        txtTamanoLibroE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTamanoLibroE.setEnabled(false);
        panelLibroEliminar.add(txtTamanoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 278, 190, -1));

        lblFormatoLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFormatoLibroE.setText("Formato:");
        panelLibroEliminar.add(lblFormatoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 278, 150, 33));

        comboFormatoLibroE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboFormatoLibroE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF", "EPUB" }));
        comboFormatoLibroE.setEnabled(false);
        panelLibroEliminar.add(comboFormatoLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 278, 230, 31));

        btnEliminarLibroE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnEliminarLibroE.setText("Eliminar");
        btnEliminarLibroE.setEnabled(false);
        btnEliminarLibroE.setFocusPainted(false);
        btnEliminarLibroE.setRequestFocusEnabled(false);
        panelLibroEliminar.add(btnEliminarLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 358, -1, -1));
        btnEliminarLibroE.setBackground(Color.WHITE);

        comboIdiomaLibroE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboIdiomaLibroE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Inglés", "Portugués", "Alemán", "Chino mandarín" }));
        comboIdiomaLibroE.setEnabled(false);
        panelLibroEliminar.add(comboIdiomaLibroE, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 130, 230, 31));

        panelLibro.addTab("Eliminar", panelLibroEliminar);

        tablaTodosLosLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaTodosLosLibros.setRowHeight(25);
        scrollTodosLosLibros.setViewportView(tablaTodosLosLibros);

        javax.swing.GroupLayout panelTablaTodosLosLibrosLayout = new javax.swing.GroupLayout(panelTablaTodosLosLibros);
        panelTablaTodosLosLibros.setLayout(panelTablaTodosLosLibrosLayout);
        panelTablaTodosLosLibrosLayout.setHorizontalGroup(
            panelTablaTodosLosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaTodosLosLibrosLayout.createSequentialGroup()
                .addComponent(scrollTodosLosLibros, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaTodosLosLibrosLayout.setVerticalGroup(
            panelTablaTodosLosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaTodosLosLibrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollTodosLosLibros, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelTodosLosLibrosLayout = new javax.swing.GroupLayout(panelTodosLosLibros);
        panelTodosLosLibros.setLayout(panelTodosLosLibrosLayout);
        panelTodosLosLibrosLayout.setHorizontalGroup(
            panelTodosLosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTodosLosLibrosLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(panelTablaTodosLosLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelTodosLosLibrosLayout.setVerticalGroup(
            panelTodosLosLibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTodosLosLibrosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelTablaTodosLosLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panelLibro.addTab("Todos los libros", panelTodosLosLibros);

        panelPrincipal.add(panelLibro, "cardLibro");

        panelPrestamo.setFocusable(false);
        panelPrestamo.setRequestFocusEnabled(false);

        lblNumPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNumPrestamoA.setText("Préstamo:");

        txtUsuarioPrestamoA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckPrestamoA.setText("Check");
        btnCheckPrestamoA.setFocusPainted(false);
        btnCheckPrestamoA.setRequestFocusEnabled(false);

        lblUsuarioPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUsuarioPrestamoA.setText("Código usuario:");

        txtNumPrestamoA.setEditable(false);
        txtNumPrestamoA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblIsbnPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnPrestamoA.setText("ISBN:");

        txtIsbnPrestamoA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIsbnPrestamoA.setEnabled(false);

        btnVerificarPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnVerificarPrestamoA.setText("Verificar");
        btnVerificarPrestamoA.setEnabled(false);
        btnVerificarPrestamoA.setFocusPainted(false);
        btnVerificarPrestamoA.setRequestFocusEnabled(false);

        lblEjemplarPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEjemplarPrestamoA.setText("Ejemplar:");

        comboEjemplarPrestamoA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEjemplarPrestamoA.setModel(modeloCombo);
        comboEjemplarPrestamoA.setEnabled(false);

        btnAgregarPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnAgregarPrestamoA.setText("Agregar");
        btnAgregarPrestamoA.setEnabled(false);
        btnAgregarPrestamoA.setFocusPainted(false);
        btnAgregarPrestamoA.setRequestFocusEnabled(false);

        tablaPrestamoA.setModel(modeloTabla);
        tablaPrestamoA.setRowHeight(25);
        scrollPrestamoA.setViewportView(tablaPrestamoA);

        btnRemoverPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnRemoverPrestamoA.setText("Remover libro");
        btnRemoverPrestamoA.setFocusPainted(false);
        btnRemoverPrestamoA.setRequestFocusEnabled(false);

        btnRealizarPrestamoA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnRealizarPrestamoA.setText("Realizar préstamo");
        btnRealizarPrestamoA.setFocusPainted(false);
        btnRealizarPrestamoA.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelPrestamoAnadirLayout = new javax.swing.GroupLayout(panelPrestamoAnadir);
        panelPrestamoAnadir.setLayout(panelPrestamoAnadirLayout);
        panelPrestamoAnadirLayout.setHorizontalGroup(
            panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrestamoAnadirLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPrestamoA)
                    .addGroup(panelPrestamoAnadirLayout.createSequentialGroup()
                        .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuarioPrestamoA)
                            .addComponent(lblIsbnPrestamoA)
                            .addComponent(lblEjemplarPrestamoA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIsbnPrestamoA)
                            .addComponent(txtUsuarioPrestamoA, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(comboEjemplarPrestamoA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarPrestamoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerificarPrestamoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckPrestamoA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(lblNumPrestamoA)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrestamoAnadirLayout.createSequentialGroup()
                        .addComponent(btnRemoverPrestamoA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRealizarPrestamoA)))
                .addGap(36, 36, 36))
        );
        panelPrestamoAnadirLayout.setVerticalGroup(
            panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamoAnadirLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioPrestamoA)
                    .addComponent(btnCheckPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumPrestamoA)
                    .addComponent(lblUsuarioPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnPrestamoA)
                    .addComponent(btnVerificarPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEjemplarPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEjemplarPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRealizarPrestamoA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );

        btnCheckPrestamoA.setBackground(Color.WHITE);
        btnVerificarPrestamoA.setBackground(Color.WHITE);
        btnAgregarPrestamoA.setBackground(Color.WHITE);
        btnRemoverPrestamoA.setBackground(Color.WHITE);
        btnRealizarPrestamoA.setBackground(Color.WHITE);

        panelPrestamo.addTab("Añadir", panelPrestamoAnadir);

        lblUsuarioPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUsuarioPrestamoM.setText("Código usuario:");

        txtPrestamoM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckPrestamoM.setText("Check");
        btnCheckPrestamoM.setFocusPainted(false);
        btnCheckPrestamoM.setRequestFocusEnabled(false);

        lblPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPrestamoM.setText("Préstamo:");

        txtUsuarioPrestamoM.setEditable(false);
        txtUsuarioPrestamoM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblIsbnPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnPrestamoM.setText("ISBN:");

        txtIsbnPrestamoM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIsbnPrestamoM.setEnabled(false);

        btnVerificarPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnVerificarPrestamoM.setText("Verificar");
        btnVerificarPrestamoM.setEnabled(false);
        btnVerificarPrestamoM.setFocusPainted(false);
        btnVerificarPrestamoM.setRequestFocusEnabled(false);

        lblEjemplarPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEjemplarPrestamoM.setText("Ejemplar:");

        comboEjemplarPrestamoM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboEjemplarPrestamoM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEjemplarPrestamoM.setEnabled(false);

        btnAgregarPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnAgregarPrestamoM.setText("Agregar");
        btnAgregarPrestamoM.setEnabled(false);
        btnAgregarPrestamoM.setFocusPainted(false);
        btnAgregarPrestamoM.setRequestFocusEnabled(false);

        tablaPrestamoM.setModel(modeloTabla);
        tablaPrestamoM.setRowHeight(25);
        scrollPrestamoM.setViewportView(tablaPrestamoM);

        btnRemoverPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnRemoverPrestamoM.setText("Remover libro");
        btnRemoverPrestamoM.setFocusPainted(false);
        btnRemoverPrestamoM.setRequestFocusEnabled(false);

        btnModificarPrestamoM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnModificarPrestamoM.setText("Modificar préstamo");
        btnModificarPrestamoM.setFocusPainted(false);
        btnModificarPrestamoM.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelPrestamoModificarLayout = new javax.swing.GroupLayout(panelPrestamoModificar);
        panelPrestamoModificar.setLayout(panelPrestamoModificarLayout);
        panelPrestamoModificarLayout.setHorizontalGroup(
            panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrestamoModificarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPrestamoM)
                    .addGroup(panelPrestamoModificarLayout.createSequentialGroup()
                        .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrestamoM)
                            .addComponent(lblIsbnPrestamoM)
                            .addComponent(lblEjemplarPrestamoM))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIsbnPrestamoM)
                            .addComponent(txtPrestamoM, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(comboEjemplarPrestamoM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarPrestamoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerificarPrestamoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckPrestamoM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(lblUsuarioPrestamoM)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsuarioPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrestamoModificarLayout.createSequentialGroup()
                        .addComponent(btnRemoverPrestamoM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarPrestamoM)))
                .addGap(36, 36, 36))
        );
        panelPrestamoModificarLayout.setVerticalGroup(
            panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamoModificarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrestamoM)
                    .addComponent(btnCheckPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioPrestamoM)
                    .addComponent(lblPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnPrestamoM)
                    .addComponent(btnVerificarPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEjemplarPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEjemplarPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoverPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarPrestamoM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );

        btnCheckPrestamoM.setBackground(Color.WHITE);
        btnVerificarPrestamoM.setBackground(Color.WHITE);
        btnAgregarPrestamoM.setBackground(Color.WHITE);
        btnRemoverPrestamoM.setBackground(Color.WHITE);
        btnModificarPrestamoM.setBackground(Color.WHITE);

        panelPrestamo.addTab("Modificar", panelPrestamoModificar);

        txtUsuarioPrestamoC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckPrestamoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckPrestamoC.setText("Check");
        btnCheckPrestamoC.setFocusPainted(false);
        btnCheckPrestamoC.setRequestFocusEnabled(false);

        lblUsuarioPrestamoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUsuarioPrestamoC.setText("Código usuario:");

        lblFechaPrestamoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFechaPrestamoC.setText("Fecha:");

        txtFechaPrestamoC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tablaPrestamoC.setModel(modeloTabla);
        tablaPrestamoC.setRowHeight(25);
        scrollPrestamoC.setViewportView(tablaPrestamoC);

        btnDevolverPrestamoC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnDevolverPrestamoC.setText("Devolver libro");
        btnDevolverPrestamoC.setFocusPainted(false);
        btnDevolverPrestamoC.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelPrestamoConsultarLayout = new javax.swing.GroupLayout(panelPrestamoConsultar);
        panelPrestamoConsultar.setLayout(panelPrestamoConsultarLayout);
        panelPrestamoConsultarLayout.setHorizontalGroup(
            panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrestamoConsultarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPrestamoC)
                    .addGroup(panelPrestamoConsultarLayout.createSequentialGroup()
                        .addGroup(panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuarioPrestamoC)
                            .addComponent(lblFechaPrestamoC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuarioPrestamoC, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtFechaPrestamoC))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckPrestamoC, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrestamoConsultarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDevolverPrestamoC)))
                .addGap(36, 36, 36))
        );
        panelPrestamoConsultarLayout.setVerticalGroup(
            panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamoConsultarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuarioPrestamoC)
                    .addComponent(btnCheckPrestamoC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuarioPrestamoC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaPrestamoC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaPrestamoC))
                .addGap(71, 71, 71)
                .addComponent(scrollPrestamoC, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDevolverPrestamoC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        btnCheckPrestamoC.setBackground(Color.WHITE);
        btnDevolverPrestamoC.setBackground(Color.WHITE);

        panelPrestamo.addTab("Consultar", panelPrestamoConsultar);

        txtPrestamoE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckPrestamoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckPrestamoE.setText("Check");
        btnCheckPrestamoE.setFocusPainted(false);
        btnCheckPrestamoE.setRequestFocusEnabled(false);

        lblPrestamoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPrestamoE.setText("Préstamo:");

        lblUsuarioPrestamoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUsuarioPrestamoE.setText("Código usuario:");

        txtUsuarioPrestamoE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tablaPrestamoE.setModel(modeloTabla);
        tablaPrestamoE.setRowHeight(25);
        scrollPrestamoE.setViewportView(tablaPrestamoE);

        btnEliminarPrestamoE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnEliminarPrestamoE.setText("Eliminar");
        btnEliminarPrestamoE.setFocusPainted(false);
        btnEliminarPrestamoE.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelPrestamoEliminarLayout = new javax.swing.GroupLayout(panelPrestamoEliminar);
        panelPrestamoEliminar.setLayout(panelPrestamoEliminarLayout);
        panelPrestamoEliminarLayout.setHorizontalGroup(
            panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrestamoEliminarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPrestamoE)
                    .addGroup(panelPrestamoEliminarLayout.createSequentialGroup()
                        .addGroup(panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrestamoE)
                            .addComponent(lblUsuarioPrestamoE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrestamoE, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(txtUsuarioPrestamoE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCheckPrestamoE, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrestamoEliminarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarPrestamoE)))
                .addGap(36, 36, 36))
        );
        panelPrestamoEliminarLayout.setVerticalGroup(
            panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamoEliminarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrestamoE)
                    .addComponent(btnCheckPrestamoE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrestamoE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioPrestamoE, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioPrestamoE))
                .addGap(71, 71, 71)
                .addComponent(scrollPrestamoE, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarPrestamoE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );

        btnCheckPrestamoE.setBackground(Color.WHITE);
        btnEliminarPrestamoE.setBackground(Color.WHITE);

        panelPrestamo.addTab("Eliminar", panelPrestamoEliminar);

        panelPrincipal.add(panelPrestamo, "cardPrestamo");

        panelMulta.setFocusable(false);
        panelMulta.setRequestFocusEnabled(false);

        subPanelMulta.setLayout(new java.awt.CardLayout());

        btnMultasUsuarioU.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnMultasUsuarioU.setText("Multas usuario");

        btnMultasTodasU.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnMultasTodasU.setText("Todas las multas");

        lblIdMultas.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdMultas.setText("ID:");

        txtIdMultas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckMultas.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckMultas.setText("Check");

        lblFechaMultas.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFechaMultas.setText("Fecha:");

        txtFechaMultas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblMultas.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        lblMultas.setText("Sus multas:");

        tableMultasU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMultasU.setRowHeight(25);
        scrollMultasU.setViewportView(tableMultasU);

        btnPagarMultas.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnPagarMultas.setText("Pagar multa");

        javax.swing.GroupLayout panelMultaUsuarioLayout = new javax.swing.GroupLayout(panelMultaUsuario);
        panelMultaUsuario.setLayout(panelMultaUsuarioLayout);
        panelMultaUsuarioLayout.setHorizontalGroup(
            panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultaUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMultaUsuarioLayout.createSequentialGroup()
                        .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFechaMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMultasUsuarioU))
                        .addGap(18, 18, 18)
                        .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFechaMultas)
                            .addGroup(panelMultaUsuarioLayout.createSequentialGroup()
                                .addComponent(txtIdMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(btnCheckMultas)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMultaUsuarioLayout.createSequentialGroup()
                        .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMultasTodasU)
                            .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblMultas)
                                .addComponent(scrollMultasU, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))))
            .addGroup(panelMultaUsuarioLayout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(btnPagarMultas)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMultaUsuarioLayout.setVerticalGroup(
            panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultaUsuarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMultasUsuarioU)
                    .addComponent(btnMultasTodasU))
                .addGap(18, 18, 18)
                .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdMultas)
                    .addComponent(txtIdMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckMultas))
                .addGap(18, 18, 18)
                .addGroup(panelMultaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaMultas)
                    .addComponent(txtFechaMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblMultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMultasU, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagarMultas)
                .addGap(12, 12, 12))
        );

        btnMultasUsuarioU.setBackground(Color.WHITE);
        btnMultasTodasU.setBackground(Color.WHITE);
        btnCheckMultas.setBackground(Color.WHITE);
        btnPagarMultas.setBackground(Color.WHITE);

        subPanelMulta.add(panelMultaUsuario, "cardMultaUsuario");

        btnMultasUsuarioT.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnMultasUsuarioT.setText("Multas usuario");

        btnMultasTodasT.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnMultasTodasT.setText("Todas las multas");

        tableMultasT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMultasT.setRowHeight(25);
        scrollMultasT.setViewportView(tableMultasT);

        javax.swing.GroupLayout panelMultaTodoLayout = new javax.swing.GroupLayout(panelMultaTodo);
        panelMultaTodo.setLayout(panelMultaTodoLayout);
        panelMultaTodoLayout.setHorizontalGroup(
            panelMultaTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultaTodoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMultaTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMultaTodoLayout.createSequentialGroup()
                        .addComponent(btnMultasUsuarioT)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMultaTodoLayout.createSequentialGroup()
                        .addGroup(panelMultaTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMultasTodasT)
                            .addComponent(scrollMultasT, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        panelMultaTodoLayout.setVerticalGroup(
            panelMultaTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultaTodoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelMultaTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMultasUsuarioT)
                    .addComponent(btnMultasTodasT))
                .addGap(18, 18, 18)
                .addComponent(scrollMultasT, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnMultasUsuarioT.setBackground(Color.WHITE);
        btnMultasTodasT.setBackground(Color.WHITE);

        subPanelMulta.add(panelMultaTodo, "cardMultaTodo");

        panelMulta.addTab("Consultar", subPanelMulta);

        panelPrincipal.add(panelMulta, "cardMulta");

        panelSolicitud.setFocusable(false);
        panelSolicitud.setRequestFocusEnabled(false);

        tableSolicitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableSolicitud.setRowHeight(25);
        scrollTableSolicitud.setViewportView(tableSolicitud);

        btnRechazarSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnRechazarSolicitud.setText("Rechazar");

        btnAprobarSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnAprobarSolicitud.setText("Aprobar");

        btnDescripcionSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnDescripcionSolicitud.setText("Mostrar descripción");

        txtAreaSolicitud.setColumns(20);
        txtAreaSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAreaSolicitud.setRows(4);
        scrollAreaSolicitud.setViewportView(txtAreaSolicitud);

        javax.swing.GroupLayout panelSolicitudConsultarLayout = new javax.swing.GroupLayout(panelSolicitudConsultar);
        panelSolicitudConsultar.setLayout(panelSolicitudConsultarLayout);
        panelSolicitudConsultarLayout.setHorizontalGroup(
            panelSolicitudConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolicitudConsultarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelSolicitudConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSolicitudConsultarLayout.createSequentialGroup()
                        .addComponent(btnRechazarSolicitud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(btnDescripcionSolicitud)
                        .addGap(149, 149, 149)
                        .addComponent(btnAprobarSolicitud))
                    .addComponent(scrollTableSolicitud)
                    .addComponent(scrollAreaSolicitud))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelSolicitudConsultarLayout.setVerticalGroup(
            panelSolicitudConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolicitudConsultarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrollTableSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSolicitudConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRechazarSolicitud)
                    .addComponent(btnAprobarSolicitud)
                    .addComponent(btnDescripcionSolicitud))
                .addGap(18, 18, 18)
                .addComponent(scrollAreaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnRechazarSolicitud.setBackground(Color.WHITE);
        btnAprobarSolicitud.setBackground(Color.WHITE);
        btnDescripcionSolicitud.setBackground(Color.WHITE);

        panelSolicitud.addTab("Consultar", panelSolicitudConsultar);

        panelPrincipal.add(panelSolicitud, "cardSolicitud");

        panelDescarga.setFocusable(false);
        panelDescarga.setRequestFocusEnabled(false);

        lblDescargas.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblDescargas.setText("Todas las descargas:");

        tableDescargas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDescargas.setRowHeight(25);
        scrollDescargas.setViewportView(tableDescargas);

        javax.swing.GroupLayout panelDescargaConsultarLayout = new javax.swing.GroupLayout(panelDescargaConsultar);
        panelDescargaConsultar.setLayout(panelDescargaConsultarLayout);
        panelDescargaConsultarLayout.setHorizontalGroup(
            panelDescargaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescargaConsultarLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelDescargaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescargas)
                    .addComponent(scrollDescargas, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panelDescargaConsultarLayout.setVerticalGroup(
            panelDescargaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescargaConsultarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblDescargas)
                .addGap(18, 18, 18)
                .addComponent(scrollDescargas, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        panelDescarga.addTab("Consultar", panelDescargaConsultar);

        panelPrincipal.add(panelDescarga, "cardDescarga");

        panelEjemplar.setFocusable(false);
        panelEjemplar.setRequestFocusEnabled(false);

        lblIsbnEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnEjemplarA.setText("ISBN:");

        txtIsbnEjemplarA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckEjemplarA.setText("Check");

        lblNumeroEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNumeroEjemplarA.setText("Número de ejemplar:");

        txtNumeroEjemplarA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblEstanteEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEstanteEjemplarA.setText("Estante:");

        txtEstanteEjemplarA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCajonEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCajonEjemplarA.setText("Número de cajón:");

        txtCajonEjemplarA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblPasilloEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPasilloEjemplarA.setText("Número de pasillo:");

        txtPasilloEjemplarA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblSalaEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblSalaEjemplarA.setText("Número de sala:");

        txtSalaEjemplarA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnAgregarEjemplarA.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnAgregarEjemplarA.setText("Agregar");

        javax.swing.GroupLayout panelEjemplarAnadirLayout = new javax.swing.GroupLayout(panelEjemplarAnadir);
        panelEjemplarAnadir.setLayout(panelEjemplarAnadirLayout);
        panelEjemplarAnadirLayout.setHorizontalGroup(
            panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarAnadirLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIsbnEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroEjemplarA)
                    .addComponent(lblEstanteEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCajonEjemplarA)
                    .addComponent(lblPasilloEjemplarA)
                    .addComponent(lblSalaEjemplarA))
                .addGap(109, 109, 109)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSalaEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarAnadirLayout.createSequentialGroup()
                            .addComponent(txtIsbnEjemplarA)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckEjemplarA))
                        .addComponent(txtNumeroEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarAnadirLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarEjemplarA)
                .addGap(330, 330, 330))
        );
        panelEjemplarAnadirLayout.setVerticalGroup(
            panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarAnadirLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckEjemplarA))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstanteEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCajonEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasilloEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalaEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalaEjemplarA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnAgregarEjemplarA)
                .addGap(28, 28, 28))
        );

        btnCheckEjemplarA.setBackground(Color.WHITE);
        btnAgregarEjemplarA.setBackground(Color.WHITE);

        panelEjemplar.addTab("Añadir", panelEjemplarAnadir);

        lblIsbnEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnEjemplarM.setText("ISBN:");

        txtIsbnEjemplarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckEjemplarM.setText("Check");

        lblNumeroEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNumeroEjemplarM.setText("Número de ejemplar:");

        txtNumeroEjemplarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblEstanteEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEstanteEjemplarM.setText("Estante:");

        txtEstanteEjemplarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCajonEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCajonEjemplarM.setText("Número de cajón:");

        txtCajonEjemplarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblPasilloEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPasilloEjemplarM.setText("Número de pasillo:");

        txtPasilloEjemplarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblSalaEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblSalaEjemplarM.setText("Número de sala:");

        txtSalaEjemplarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnModificarEjemplarM.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnModificarEjemplarM.setText("Modificar");

        javax.swing.GroupLayout panelEjemplarModificarLayout = new javax.swing.GroupLayout(panelEjemplarModificar);
        panelEjemplarModificar.setLayout(panelEjemplarModificarLayout);
        panelEjemplarModificarLayout.setHorizontalGroup(
            panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarModificarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIsbnEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroEjemplarM)
                    .addComponent(lblEstanteEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCajonEjemplarM)
                    .addComponent(lblPasilloEjemplarM)
                    .addComponent(lblSalaEjemplarM))
                .addGap(109, 109, 109)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSalaEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarModificarLayout.createSequentialGroup()
                            .addComponent(txtIsbnEjemplarM)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckEjemplarM))
                        .addComponent(txtNumeroEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarModificarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarEjemplarM)
                .addGap(321, 321, 321))
        );
        panelEjemplarModificarLayout.setVerticalGroup(
            panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarModificarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckEjemplarM))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstanteEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCajonEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasilloEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalaEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalaEjemplarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnModificarEjemplarM)
                .addGap(28, 28, 28))
        );

        btnCheckEjemplarM.setBackground(Color.WHITE);
        btnModificarEjemplarM.setBackground(Color.WHITE);

        panelEjemplar.addTab("Modificar", panelEjemplarModificar);

        lblIsbnEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnEjemplarC.setText("ISBN:");

        txtIsbnEjemplarC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckEjemplarC.setText("Check");

        lblNumeroEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNumeroEjemplarC.setText("Número de ejemplar:");

        txtNumeroEjemplarC.setEditable(false);
        txtNumeroEjemplarC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblEstanteEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEstanteEjemplarC.setText("Estante:");

        txtEstanteEjemplarC.setEditable(false);
        txtEstanteEjemplarC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCajonEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCajonEjemplarC.setText("Número de cajón:");

        txtCajonEjemplarC.setEditable(false);
        txtCajonEjemplarC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblPasilloEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPasilloEjemplarC.setText("Número de pasillo:");

        txtPasilloEjemplarC.setEditable(false);
        txtPasilloEjemplarC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblSalaEjemplarC.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblSalaEjemplarC.setText("Número de sala:");

        txtSalaEjemplarC.setEditable(false);
        txtSalaEjemplarC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelEjemplarConsultarLayout = new javax.swing.GroupLayout(panelEjemplarConsultar);
        panelEjemplarConsultar.setLayout(panelEjemplarConsultarLayout);
        panelEjemplarConsultarLayout.setHorizontalGroup(
            panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarConsultarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIsbnEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroEjemplarC)
                    .addComponent(lblEstanteEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCajonEjemplarC)
                    .addComponent(lblPasilloEjemplarC)
                    .addComponent(lblSalaEjemplarC))
                .addGap(109, 109, 109)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSalaEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarConsultarLayout.createSequentialGroup()
                            .addComponent(txtIsbnEjemplarC)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckEjemplarC))
                        .addComponent(txtNumeroEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panelEjemplarConsultarLayout.setVerticalGroup(
            panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarConsultarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckEjemplarC))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstanteEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCajonEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasilloEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalaEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalaEjemplarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        btnCheckEjemplarC.setBackground(Color.WHITE);

        panelEjemplar.addTab("Consultar", panelEjemplarConsultar);

        lblIsbnEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnEjemplarE.setText("ISBN:");

        txtIsbnEjemplarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnCheckEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnCheckEjemplarE.setText("Check");

        lblNumeroEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblNumeroEjemplarE.setText("Número de ejemplar:");

        txtNumeroEjemplarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblEstanteEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblEstanteEjemplarE.setText("Estante:");

        txtEstanteEjemplarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCajonEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblCajonEjemplarE.setText("Número de cajón:");

        txtCajonEjemplarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblPasilloEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblPasilloEjemplarE.setText("Número de pasillo:");

        txtPasilloEjemplarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblSalaEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblSalaEjemplarE.setText("Número de sala:");

        txtSalaEjemplarE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnEliminarEjemplarE.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnEliminarEjemplarE.setText("Eliminar");

        javax.swing.GroupLayout panelEjemplarEliminarLayout = new javax.swing.GroupLayout(panelEjemplarEliminar);
        panelEjemplarEliminar.setLayout(panelEjemplarEliminarLayout);
        panelEjemplarEliminarLayout.setHorizontalGroup(
            panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarEliminarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIsbnEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumeroEjemplarE)
                    .addComponent(lblEstanteEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCajonEjemplarE)
                    .addComponent(lblPasilloEjemplarE)
                    .addComponent(lblSalaEjemplarE))
                .addGap(109, 109, 109)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSalaEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarEliminarLayout.createSequentialGroup()
                            .addComponent(txtIsbnEjemplarE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckEjemplarE))
                        .addComponent(txtNumeroEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEjemplarEliminarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarEjemplarE)
                .addGap(325, 325, 325))
        );
        panelEjemplarEliminarLayout.setVerticalGroup(
            panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEjemplarEliminarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckEjemplarE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumeroEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstanteEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstanteEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCajonEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCajonEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPasilloEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasilloEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalaEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalaEjemplarE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnEliminarEjemplarE)
                .addGap(28, 28, 28))
        );

        btnCheckEjemplarE.setBackground(Color.WHITE);
        btnEliminarEjemplarE.setBackground(Color.WHITE);

        panelEjemplar.addTab("Eliminar", panelEjemplarEliminar);

        panelPrincipal.add(panelEjemplar, "cardEjemplar");

        panelFondo.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 760, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JScrollPane getScrollAreaSolicitud() {
        return scrollAreaSolicitud;
    }

    public JScrollPane getScrollDescargas() {
        return scrollDescargas;
    }

    public JScrollPane getScrollManejoC() {
        return scrollManejoC;
    }

    public JScrollPane getScrollMultasT() {
        return scrollMultasT;
    }

    public JScrollPane getScrollMultasU() {
        return scrollMultasU;
    }

    public JScrollPane getScrollPrestamoA() {
        return scrollPrestamoA;
    }

    public JScrollPane getScrollPrestamoC() {
        return scrollPrestamoC;
    }

    public JScrollPane getScrollPrestamoE() {
        return scrollPrestamoE;
    }

    public JScrollPane getScrollPrestamoM() {
        return scrollPrestamoM;
    }

    public JScrollPane getScrollTableSolicitud() {
        return scrollTableSolicitud;
    }

    public JScrollPane getScrollTodosLosLibros() {
        return scrollTodosLosLibros;
    }

    
    public String[] getCabeceraConsultarEmpleados() {
        return cabeceraConsultarEmpleados;
    }

    public String[] getCabeceraConsultarPrestamo() {
        return cabeceraConsultarPrestamo;
    }

    public String[] getCabeceraDescargas() {
        return cabeceraDescargas;
    }

    public String[] getCabeceraSolicitudes() {
        return cabeceraSolicitudes;
    }

    public String[] getCabeceraMultas() {
        return cabeceraMultas;
    }

    public String[] getCabeceraTodaLasMultas() {
        return cabeceraTodaLasMultas;
    }

    public String[] getCabeceraConsultarLibros() {
        return cabeceraConsultarLibros;
    }

    public JButton getBtnAgregarEjemplarA() {
        return btnAgregarEjemplarA;
    }

    public JButton getBtnAgregarLibroA() {
        return btnAgregarLibroA;
    }

    public JButton getBtnAprobarSolicitud() {
        return btnAprobarSolicitud;
    }

    public JButton getBtnCheckEjemplarA() {
        return btnCheckEjemplarA;
    }

    public JButton getBtnCheckEjemplarC() {
        return btnCheckEjemplarC;
    }

    public JButton getBtnCheckEjemplarE() {
        return btnCheckEjemplarE;
    }

    public JButton getBtnCheckEjemplarM() {
        return btnCheckEjemplarM;
    }

    public JButton getBtnCheckLibroC() {
        return btnCheckLibroC;
    }

    public JButton getBtnCheckLibroE() {
        return btnCheckLibroE;
    }

    public JButton getBtnCheckLibroM() {
        return btnCheckLibroM;
    }

    public JButton getBtnCheckMultas() {
        return btnCheckMultas;
    }

    public JButton getBtnDescargarInfo() {
        return btnDescargarInfo;
    }

    public JButton getBtnDescripcionSolicitud() {
        return btnDescripcionSolicitud;
    }

    public JButton getBtnEliminarEjemplarE() {
        return btnEliminarEjemplarE;
    }

    public JButton getBtnEliminarLibroE() {
        return btnEliminarLibroE;
    }

    public JButton getBtnModificarEjemplarM() {
        return btnModificarEjemplarM;
    }

    public JButton getBtnModificarLibroM() {
        return btnModificarLibroM;
    }

    public JButton getBtnMultasTodasT() {
        return btnMultasTodasT;
    }

    public JButton getBtnMultasTodasU() {
        return btnMultasTodasU;
    }

    public JButton getBtnMultasUsuarioT() {
        return btnMultasUsuarioT;
    }

    public JButton getBtnMultasUsuarioU() {
        return btnMultasUsuarioU;
    }

    public JButton getBtnNoLibroA() {
        return btnNoLibroA;
    }

    public JButton getBtnNoLibroC() {
        return btnNoLibroC;
    }

    public JButton getBtnNoLibroE() {
        return btnNoLibroE;
    }

    public JButton getBtnNoLibroM() {
        return btnNoLibroM;
    }

    public JButton getBtnPagarMultas() {
        return btnPagarMultas;
    }

    public JButton getBtnRechazarSolicitud() {
        return btnRechazarSolicitud;
    }

    public JButton getBtnSiLibroA() {
        return btnSiLibroA;
    }

    public JButton getBtnSiLibroC() {
        return btnSiLibroC;
    }

    public JButton getBtnSiLibroE() {
        return btnSiLibroE;
    }

    public JButton getBtnSiLibroM() {
        return btnSiLibroM;
    }

    public JComboBox<String> getComboAreaLibroA() {
        return comboAreaLibroA;
    }

    public JComboBox<String> getComboAreaLibroC() {
        return comboAreaLibroC;
    }

    public JComboBox<String> getComboAreaLibroE() {
        return comboAreaLibroE;
    }

    public JComboBox<String> getComboAreaLibroM() {
        return comboAreaLibroM;
    }

    public JComboBox<String> getComboEditorialLibroA() {
        return comboEditorialLibroA;
    }

    public JComboBox<String> getComboEditorialLibroC() {
        return comboEditorialLibroC;
    }

    public JComboBox<String> getComboEditorialLibroE() {
        return comboEditorialLibroE;
    }

    public JComboBox<String> getComboEditorialLibroM() {
        return comboEditorialLibroM;
    }

    public JComboBox<String> getComboFormatoLibroC() {
        return comboFormatoLibroC;
    }

    public JComboBox<String> getComboFormatoLibroE() {
        return comboFormatoLibroE;
    }

    public JComboBox<String> getComboFormatoLibroM() {
        return comboFormatoLibroM;
    }

    public JTable getTablaTodosLosLibros() {
        return tablaTodosLosLibros;
    }

    public JTable getTableDescargas() {
        return tableDescargas;
    }

    public JTable getTableMultasT() {
        return tableMultasT;
    }

    public JTable getTableMultasU() {
        return tableMultasU;
    }

    public JTable getTableSolicitud() {
        return tableSolicitud;
    }

    public JTextField getTxtAnoLibroA() {
        return txtAnoLibroA;
    }

    public JTextField getTxtAnoLibroC() {
        return txtAnoLibroC;
    }

    public JTextField getTxtAnoLibroE() {
        return txtAnoLibroE;
    }

    public JTextField getTxtAnoLibroM() {
        return txtAnoLibroM;
    }

    public JTextArea getTxtAreaSolicitud() {
        return txtAreaSolicitud;
    }

    public JTextField getTxtCajonEjemplarA() {
        return txtCajonEjemplarA;
    }

    public JTextField getTxtCajonEjemplarC() {
        return txtCajonEjemplarC;
    }

    public JTextField getTxtCajonEjemplarE() {
        return txtCajonEjemplarE;
    }

    public JTextField getTxtCajonEjemplarM() {
        return txtCajonEjemplarM;
    }

    public JTextField getTxtEstanteEjemplarA() {
        return txtEstanteEjemplarA;
    }

    public JTextField getTxtEstanteEjemplarC() {
        return txtEstanteEjemplarC;
    }

    public JTextField getTxtEstanteEjemplarE() {
        return txtEstanteEjemplarE;
    }

    public JTextField getTxtEstanteEjemplarM() {
        return txtEstanteEjemplarM;
    }

    public JTextField getTxtFechaMultas() {
        return txtFechaMultas;
    }

    public JTextField getTxtIdMultas() {
        return txtIdMultas;
    }

    public JComboBox<String> getComboIdiomaLibroA() {
        return comboIdiomaLibroA;
    }

    public JComboBox<String> getComboIdiomaLibroC() {
        return comboIdiomaLibroC;
    }

    public JComboBox<String> getComboIdiomaLibroE() {
        return comboIdiomaLibroE;
    }

    public JComboBox<String> getComboIdiomaLibroM() {
        return comboIdiomaLibroM;
    }

    public JComboBox<String> getComboFormatoLibroA() {
        return comboFormatoLibroA;
    }

    public JTextField getTxtIsbnEjemplarA() {
        return txtIsbnEjemplarA;
    }

    public JTextField getTxtIsbnEjemplarC() {
        return txtIsbnEjemplarC;
    }

    public JTextField getTxtIsbnEjemplarE() {
        return txtIsbnEjemplarE;
    }

    public JTextField getTxtIsbnEjemplarM() {
        return txtIsbnEjemplarM;
    }

    public JTextField getTxtIsbnLibroA() {
        return txtIsbnLibroA;
    }

    public JTextField getTxtIsbnLibroC() {
        return txtIsbnLibroC;
    }

    public JTextField getTxtIsbnLibroE() {
        return txtIsbnLibroE;
    }

    public JTextField getTxtIsbnLibroM() {
        return txtIsbnLibroM;
    }

    public JTextField getTxtNombreLibroA() {
        return txtNombreLibroA;
    }

    public JTextField getTxtNumeroEjemplarA() {
        return txtNumeroEjemplarA;
    }

    public JTextField getTxtNumeroEjemplarC() {
        return txtNumeroEjemplarC;
    }

    public JTextField getTxtNumeroEjemplarE() {
        return txtNumeroEjemplarE;
    }

    public JTextField getTxtNumeroEjemplarM() {
        return txtNumeroEjemplarM;
    }

    public JTextField getTxtPaginasLibroA() {
        return txtPaginasLibroA;
    }

    public JTextField getTxtPaginasLibroC() {
        return txtPaginasLibroC;
    }

    public JTextField getTxtPaginasLibroE() {
        return txtPaginasLibroE;
    }

    public JTextField getTxtPaginasLibroM() {
        return txtPaginasLibroM;
    }

    public JTextField getTxtPasilloEjemplarA() {
        return txtPasilloEjemplarA;
    }

    public JTextField getTxtPasilloEjemplarC() {
        return txtPasilloEjemplarC;
    }

    public JTextField getTxtPasilloEjemplarE() {
        return txtPasilloEjemplarE;
    }

    public JTextField getTxtPasilloEjemplarM() {
        return txtPasilloEjemplarM;
    }

    public JTextField getTxtSalaEjemplarA() {
        return txtSalaEjemplarA;
    }

    public JTextField getTxtSalaEjemplarC() {
        return txtSalaEjemplarC;
    }

    public JTextField getTxtSalaEjemplarE() {
        return txtSalaEjemplarE;
    }

    public JTextField getTxtSalaEjemplarM() {
        return txtSalaEjemplarM;
    }

    public JTextField getTxtTamanoLibroA() {
        return txtTamanoLibroA;
    }

    public JTextField getTxtTamanoLibroC() {
        return txtTamanoLibroC;
    }

    public JTextField getTxtTamanoLibroE() {
        return txtTamanoLibroE;
    }

    public JTextField getTxtTamanoLibroM() {
        return txtTamanoLibroM;
    }

    public JTextField getTxtTituloLibroC() {
        return txtTituloLibroC;
    }

    public JTextField getTxtTituloLibroE() {
        return txtTituloLibroE;
    }

    public JTextField getTxtTituloLibroM() {
        return txtTituloLibroM;
    }

    public JTextField getTxtUrlLibroA() {
        return txtUrlLibroA;
    }

    public JTextField getTxtUrlLibroC() {
        return txtUrlLibroC;
    }

    public JTextField getTxtUrlLibroE() {
        return txtUrlLibroE;
    }

    public JTextField getTxtUrlLibroM() {
        return txtUrlLibroM;
    }

    
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

    public JButton getBtnDescargas() {
        return btnDescargas;
    }

    public JButton getBtnEjemplar() {
        return btnEjemplar;
    }

    public JButton getBtnLibros() {
        return btnLibros;
    }

    public JButton getBtnManejoPersonal() {
        return btnManejoPersonal;
    }

    public JButton getBtnMultas() {
        return btnMultas;
    }

    public JButton getBtnPrestamos() {
        return btnPrestamos;
    }

    public JButton getBtnSolicitudes() {
        return btnSolicitudes;
    }

    public JTabbedPane getPanelDescarga() {
        return panelDescarga;
    }

    public JTabbedPane getPanelEjemplar() {
        return panelEjemplar;
    }

    public JTabbedPane getPanelLibro() {
        return panelLibro;
    }

    public JTabbedPane getPanelManejo() {
        return panelManejo;
    }

    public JTabbedPane getPanelMulta() {
        return panelMulta;
    }

    public JTabbedPane getPanelPrestamo() {
        return panelPrestamo;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public JTabbedPane getPanelSolicitud() {
        return panelSolicitud;
    }

    public JButton getBtnAgregarPrestamoA() {
        return btnAgregarPrestamoA;
    }

    public JButton getBtnAgregarPrestamoM() {
        return btnAgregarPrestamoM;
    }

    public JButton getBtnAnadirManejoA() {
        return btnAnadirManejoA;
    }

    public JButton getBtnCheckManejoC() {
        return btnCheckManejoC;
    }

    public JButton getBtnCheckManejoE() {
        return btnCheckManejoE;
    }

    public JButton getBtnCheckManejoM() {
        return btnCheckManejoM;
    }

    public JButton getBtnCheckPrestamoA() {
        return btnCheckPrestamoA;
    }

    public JButton getBtnCheckPrestamoC() {
        return btnCheckPrestamoC;
    }

    public JButton getBtnCheckPrestamoE() {
        return btnCheckPrestamoE;
    }

    public JButton getBtnCheckPrestamoM() {
        return btnCheckPrestamoM;
    }

    public JButton getBtnDevolverPrestamoC() {
        return btnDevolverPrestamoC;
    }

    public JButton getBtnEliminarManejoE() {
        return btnEliminarManejoE;
    }

    public JButton getBtnEliminarPrestamoE() {
        return btnEliminarPrestamoE;
    }

    public JButton getBtnEmpleadoManejoC() {
        return btnEmpleadoManejoC;
    }

    public JButton getBtnEmpleadosManejoC() {
        return btnEmpleadosManejoC;
    }

    public JButton getBtnModificarManejoM() {
        return btnModificarManejoM;
    }

    public JButton getBtnModificarPrestamoM() {
        return btnModificarPrestamoM;
    }

    public JButton getBtnRealizarPrestamoA() {
        return btnRealizarPrestamoA;
    }

    public JButton getBtnRemoverPrestamoA() {
        return btnRemoverPrestamoA;
    }

    public JButton getBtnRemoverPrestamoM() {
        return btnRemoverPrestamoM;
    }

    public JButton getBtnVerificarPrestamoA() {
        return btnVerificarPrestamoA;
    }

    public JButton getBtnVerificarPrestamoM() {
        return btnVerificarPrestamoM;
    }

    public JCheckBox getCheckPasswordManejoA() {
        return checkPasswordManejoA;
    }

    public JCheckBox getCheckPasswordManejoM() {
        return checkPasswordManejoM;
    }

    public JComboBox<String> getComboCargoManejoA() {
        return comboCargoManejoA;
    }

    public JComboBox<String> getComboCargoManejoC() {
        return comboCargoManejoC;
    }

    public JComboBox<String> getComboCargoManejoE() {
        return comboCargoManejoE;
    }

    public JComboBox<String> getComboCargoManejoM() {
        return comboCargoManejoM;
    }

    public JComboBox<String> getComboEjemplarPrestamoA() {
        return comboEjemplarPrestamoA;
    }

    public JComboBox<String> getComboEjemplarPrestamoM() {
        return comboEjemplarPrestamoM;
    }

    public JTextField getTxtFechaPrestamoC() {
        return txtFechaPrestamoC;
    }

    public JTextField getTxtIdManejoA() {
        return txtIdManejoA;
    }

    public JTextField getTxtIdManejoC() {
        return txtIdManejoC;
    }

    public JTextField getTxtIdManejoE() {
        return txtIdManejoE;
    }

    public JTextField getTxtIdManejoM() {
        return txtIdManejoM;
    }

    public JTextField getTxtIsbnPrestamoA() {
        return txtIsbnPrestamoA;
    }

    public JTextField getTxtIsbnPrestamoM() {
        return txtIsbnPrestamoM;
    }

    public JTextField getTxtNombreManejoA() {
        return txtNombreManejoA;
    }

    public JTextField getTxtNombreManejoC() {
        return txtNombreManejoC;
    }

    public JTextField getTxtNombreManejoE() {
        return txtNombreManejoE;
    }

    public JTextField getTxtNombreManejoM() {
        return txtNombreManejoM;
    }

    public JTextField getTxtNumPrestamoA() {
        return txtNumPrestamoA;
    }

    public JPasswordField getTxtPasswordManejoA() {
        return txtPasswordManejoA;
    }

    public JPasswordField getTxtPasswordManejoM() {
        return txtPasswordManejoM;
    }

    public JTextField getTxtPrestamoE() {
        return txtPrestamoE;
    }

    public JTextField getTxtPrestamoM() {
        return txtPrestamoM;
    }

    public JTextField getTxtUsuarioPrestamoA() {
        return txtUsuarioPrestamoA;
    }

    public JTextField getTxtUsuarioPrestamoC() {
        return txtUsuarioPrestamoC;
    }

    public JTextField getTxtUsuarioPrestamoE() {
        return txtUsuarioPrestamoE;
    }

    public JTextField getTxtUsuarioPrestamoM() {
        return txtUsuarioPrestamoM;
    }

    public JLabel getLblFormatoLibroA() {
        return lblFormatoLibroA;
    }

    public JLabel getLblFormatoLibroC() {
        return lblFormatoLibroC;
    }

    public JLabel getLblFormatoLibroE() {
        return lblFormatoLibroE;
    }

    public JLabel getLblFormatoLibroM() {
        return lblFormatoLibroM;
    }

    public JLabel getLblTamanoLibroA() {
        return lblTamanoLibroA;
    }

    public JLabel getLblTamanoLibroC() {
        return lblTamanoLibroC;
    }

    public JLabel getLblTamanoLibroE() {
        return lblTamanoLibroE;
    }

    public JLabel getLblTamanoLibroM() {
        return lblTamanoLibroM;
    }

    public JLabel getLblUrlLibroA() {
        return lblUrlLibroA;
    }

    public JLabel getLblUrlLibroC() {
        return lblUrlLibroC;
    }

    public JLabel getLblUrlLibroE() {
        return lblUrlLibroE;
    }

    public JLabel getLblUrlLibroM() {
        return lblUrlLibroM;
    }

    
    public JTable getTablaManejoC() {
        return tablaManejoC;
    }

    public JTable getTablaPrestamoA() {
        return tablaPrestamoA;
    }

    public JTable getTablaPrestamoC() {
        return tablaPrestamoC;
    }

    public JTable getTablaPrestamoE() {
        return tablaPrestamoE;
    }

    public JTable getTablaPrestamoM() {
        return tablaPrestamoM;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarEjemplarA;
    private javax.swing.JButton btnAgregarLibroA;
    private javax.swing.JButton btnAgregarPrestamoA;
    private javax.swing.JButton btnAgregarPrestamoM;
    private javax.swing.JButton btnAnadirManejoA;
    private javax.swing.JButton btnAprobarSolicitud;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCheckEjemplarA;
    private javax.swing.JButton btnCheckEjemplarC;
    private javax.swing.JButton btnCheckEjemplarE;
    private javax.swing.JButton btnCheckEjemplarM;
    private javax.swing.JButton btnCheckLibroC;
    private javax.swing.JButton btnCheckLibroE;
    private javax.swing.JButton btnCheckLibroM;
    private javax.swing.JButton btnCheckManejoC;
    private javax.swing.JButton btnCheckManejoE;
    private javax.swing.JButton btnCheckManejoM;
    private javax.swing.JButton btnCheckMultas;
    private javax.swing.JButton btnCheckPrestamoA;
    private javax.swing.JButton btnCheckPrestamoC;
    private javax.swing.JButton btnCheckPrestamoE;
    private javax.swing.JButton btnCheckPrestamoM;
    private javax.swing.JButton btnDescargarInfo;
    private javax.swing.JButton btnDescargas;
    private javax.swing.JButton btnDescripcionSolicitud;
    private javax.swing.JButton btnDevolverPrestamoC;
    private javax.swing.JButton btnEjemplar;
    private javax.swing.JButton btnEliminarEjemplarE;
    private javax.swing.JButton btnEliminarLibroE;
    private javax.swing.JButton btnEliminarManejoE;
    private javax.swing.JButton btnEliminarPrestamoE;
    private javax.swing.JButton btnEmpleadoManejoC;
    private javax.swing.JButton btnEmpleadosManejoC;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnManejoPersonal;
    private javax.swing.JButton btnModificarEjemplarM;
    private javax.swing.JButton btnModificarLibroM;
    private javax.swing.JButton btnModificarManejoM;
    private javax.swing.JButton btnModificarPrestamoM;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton btnMultasTodasT;
    private javax.swing.JButton btnMultasTodasU;
    private javax.swing.JButton btnMultasUsuarioT;
    private javax.swing.JButton btnMultasUsuarioU;
    private javax.swing.JButton btnNoLibroA;
    private javax.swing.JButton btnNoLibroC;
    private javax.swing.JButton btnNoLibroE;
    private javax.swing.JButton btnNoLibroM;
    private javax.swing.JButton btnPagarMultas;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnRealizarPrestamoA;
    private javax.swing.JButton btnRechazarSolicitud;
    private javax.swing.JButton btnRemoverPrestamoA;
    private javax.swing.JButton btnRemoverPrestamoM;
    private javax.swing.JButton btnSiLibroA;
    private javax.swing.JButton btnSiLibroC;
    private javax.swing.JButton btnSiLibroE;
    private javax.swing.JButton btnSiLibroM;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JButton btnVerificarPrestamoA;
    private javax.swing.JButton btnVerificarPrestamoM;
    private javax.swing.JCheckBox checkPasswordManejoA;
    private javax.swing.JCheckBox checkPasswordManejoM;
    private javax.swing.JComboBox<String> comboAreaLibroA;
    private javax.swing.JComboBox<String> comboAreaLibroC;
    private javax.swing.JComboBox<String> comboAreaLibroE;
    private javax.swing.JComboBox<String> comboAreaLibroM;
    private javax.swing.JComboBox<String> comboCargoManejoA;
    private javax.swing.JComboBox<String> comboCargoManejoC;
    private javax.swing.JComboBox<String> comboCargoManejoE;
    private javax.swing.JComboBox<String> comboCargoManejoM;
    private javax.swing.JComboBox<String> comboEditorialLibroA;
    private javax.swing.JComboBox<String> comboEditorialLibroC;
    private javax.swing.JComboBox<String> comboEditorialLibroE;
    private javax.swing.JComboBox<String> comboEditorialLibroM;
    private javax.swing.JComboBox<String> comboEjemplarPrestamoA;
    private javax.swing.JComboBox<String> comboEjemplarPrestamoM;
    private javax.swing.JComboBox<String> comboFormatoLibroA;
    private javax.swing.JComboBox<String> comboFormatoLibroC;
    private javax.swing.JComboBox<String> comboFormatoLibroE;
    private javax.swing.JComboBox<String> comboFormatoLibroM;
    private javax.swing.JComboBox<String> comboIdiomaLibroA;
    private javax.swing.JComboBox<String> comboIdiomaLibroC;
    private javax.swing.JComboBox<String> comboIdiomaLibroE;
    private javax.swing.JComboBox<String> comboIdiomaLibroM;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblAnoLibroA;
    private javax.swing.JLabel lblAnoLibroC;
    private javax.swing.JLabel lblAnoLibroE;
    private javax.swing.JLabel lblAnoLibroM;
    private javax.swing.JLabel lblAreaLibroA;
    private javax.swing.JLabel lblAreaLibroC;
    private javax.swing.JLabel lblAreaLibroE;
    private javax.swing.JLabel lblAreaLibroM;
    private javax.swing.JLabel lblCajonEjemplarA;
    private javax.swing.JLabel lblCajonEjemplarC;
    private javax.swing.JLabel lblCajonEjemplarE;
    private javax.swing.JLabel lblCajonEjemplarM;
    private javax.swing.JLabel lblCargoManejoA;
    private javax.swing.JLabel lblCargoManejoC;
    private javax.swing.JLabel lblCargoManejoE;
    private javax.swing.JLabel lblCargoManejoM;
    private javax.swing.JLabel lblDescargas;
    private javax.swing.JLabel lblDigitalLibroA;
    private javax.swing.JLabel lblDigitalLibroC;
    private javax.swing.JLabel lblDigitalLibroE;
    private javax.swing.JLabel lblDigitalLibroM;
    private javax.swing.JLabel lblEditorialLibroA;
    private javax.swing.JLabel lblEditorialLibroC;
    private javax.swing.JLabel lblEditorialLibroE;
    private javax.swing.JLabel lblEditorialLibroM;
    private javax.swing.JLabel lblEjemplarPrestamoA;
    private javax.swing.JLabel lblEjemplarPrestamoM;
    private javax.swing.JLabel lblEstanteEjemplarA;
    private javax.swing.JLabel lblEstanteEjemplarC;
    private javax.swing.JLabel lblEstanteEjemplarE;
    private javax.swing.JLabel lblEstanteEjemplarM;
    private javax.swing.JLabel lblFechaMultas;
    private javax.swing.JLabel lblFechaPrestamoC;
    private javax.swing.JLabel lblFormatoLibroA;
    private javax.swing.JLabel lblFormatoLibroC;
    private javax.swing.JLabel lblFormatoLibroE;
    private javax.swing.JLabel lblFormatoLibroM;
    private javax.swing.JLabel lblIdManejoA;
    private javax.swing.JLabel lblIdManejoC;
    private javax.swing.JLabel lblIdManejoE;
    private javax.swing.JLabel lblIdManejoM;
    private javax.swing.JLabel lblIdMultas;
    private javax.swing.JLabel lblIdiomaLibroA;
    private javax.swing.JLabel lblIdiomaLibroC;
    private javax.swing.JLabel lblIdiomaLibroE;
    private javax.swing.JLabel lblIdiomaLibroM;
    private javax.swing.JLabel lblIsbnEjemplarA;
    private javax.swing.JLabel lblIsbnEjemplarC;
    private javax.swing.JLabel lblIsbnEjemplarE;
    private javax.swing.JLabel lblIsbnEjemplarM;
    private javax.swing.JLabel lblIsbnLibroA;
    private javax.swing.JLabel lblIsbnLibroC;
    private javax.swing.JLabel lblIsbnLibroE;
    private javax.swing.JLabel lblIsbnLibroM;
    private javax.swing.JLabel lblIsbnPrestamoA;
    private javax.swing.JLabel lblIsbnPrestamoM;
    private javax.swing.JLabel lblMultas;
    private javax.swing.JLabel lblNombreLibroA;
    private javax.swing.JLabel lblNombreManejoA;
    private javax.swing.JLabel lblNombreManejoC;
    private javax.swing.JLabel lblNombreManejoE;
    private javax.swing.JLabel lblNombreManejoM;
    private javax.swing.JLabel lblNumPrestamoA;
    private javax.swing.JLabel lblNumeroEjemplarA;
    private javax.swing.JLabel lblNumeroEjemplarC;
    private javax.swing.JLabel lblNumeroEjemplarE;
    private javax.swing.JLabel lblNumeroEjemplarM;
    private javax.swing.JLabel lblPaginasLibroA;
    private javax.swing.JLabel lblPaginasLibroC;
    private javax.swing.JLabel lblPaginasLibroE;
    private javax.swing.JLabel lblPaginasLibroM;
    private javax.swing.JLabel lblPasilloEjemplarA;
    private javax.swing.JLabel lblPasilloEjemplarC;
    private javax.swing.JLabel lblPasilloEjemplarE;
    private javax.swing.JLabel lblPasilloEjemplarM;
    private javax.swing.JLabel lblPasswordManejoA;
    private javax.swing.JLabel lblPasswordManejoM;
    private javax.swing.JLabel lblPrestamoE;
    private javax.swing.JLabel lblPrestamoM;
    private javax.swing.JLabel lblSalaEjemplarA;
    private javax.swing.JLabel lblSalaEjemplarC;
    private javax.swing.JLabel lblSalaEjemplarE;
    private javax.swing.JLabel lblSalaEjemplarM;
    private javax.swing.JLabel lblTamanoLibroA;
    private javax.swing.JLabel lblTamanoLibroC;
    private javax.swing.JLabel lblTamanoLibroE;
    private javax.swing.JLabel lblTamanoLibroM;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloLibroC;
    private javax.swing.JLabel lblTituloLibroE;
    private javax.swing.JLabel lblTituloLibroM;
    private javax.swing.JLabel lblUrlLibroA;
    private javax.swing.JLabel lblUrlLibroC;
    private javax.swing.JLabel lblUrlLibroE;
    private javax.swing.JLabel lblUrlLibroM;
    private javax.swing.JLabel lblUsuarioPrestamoA;
    private javax.swing.JLabel lblUsuarioPrestamoC;
    private javax.swing.JLabel lblUsuarioPrestamoE;
    private javax.swing.JLabel lblUsuarioPrestamoM;
    private javax.swing.JTabbedPane panelDescarga;
    private javax.swing.JPanel panelDescargaConsultar;
    private javax.swing.JTabbedPane panelEjemplar;
    private javax.swing.JPanel panelEjemplarAnadir;
    private javax.swing.JPanel panelEjemplarConsultar;
    private javax.swing.JPanel panelEjemplarEliminar;
    private javax.swing.JPanel panelEjemplarModificar;
    private javax.swing.JPanel panelEmpleadoManejoC;
    private javax.swing.JPanel panelEmpleadosManejoC;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTabbedPane panelLibro;
    private javax.swing.JPanel panelLibroAnadir;
    private javax.swing.JPanel panelLibroConsultar;
    private javax.swing.JPanel panelLibroEliminar;
    private javax.swing.JPanel panelLibroModificar;
    private javax.swing.JTabbedPane panelManejo;
    private javax.swing.JPanel panelManejoAnadir;
    private javax.swing.JPanel panelManejoConsultar;
    private javax.swing.JPanel panelManejoEliminar;
    private javax.swing.JPanel panelManejoModificar;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTabbedPane panelMulta;
    private javax.swing.JPanel panelMultaTodo;
    private javax.swing.JPanel panelMultaUsuario;
    private javax.swing.JTabbedPane panelPrestamo;
    private javax.swing.JPanel panelPrestamoAnadir;
    private javax.swing.JPanel panelPrestamoConsultar;
    private javax.swing.JPanel panelPrestamoEliminar;
    private javax.swing.JPanel panelPrestamoModificar;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTabbedPane panelSolicitud;
    private javax.swing.JPanel panelSolicitudConsultar;
    private javax.swing.JPanel panelTablaTodosLosLibros;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panelTodosLosLibros;
    private javax.swing.JScrollPane scrollAreaSolicitud;
    private javax.swing.JScrollPane scrollDescargas;
    private javax.swing.JScrollPane scrollManejoC;
    private javax.swing.JScrollPane scrollMultasT;
    private javax.swing.JScrollPane scrollMultasU;
    private javax.swing.JScrollPane scrollPrestamoA;
    private javax.swing.JScrollPane scrollPrestamoC;
    private javax.swing.JScrollPane scrollPrestamoE;
    private javax.swing.JScrollPane scrollPrestamoM;
    private javax.swing.JScrollPane scrollTableSolicitud;
    private javax.swing.JScrollPane scrollTodosLosLibros;
    private javax.swing.JPanel subPanelManejoConsultar;
    private javax.swing.JPanel subPanelMulta;
    private javax.swing.JTable tablaManejoC;
    private javax.swing.JTable tablaPrestamoA;
    private javax.swing.JTable tablaPrestamoC;
    private javax.swing.JTable tablaPrestamoE;
    private javax.swing.JTable tablaPrestamoM;
    private javax.swing.JTable tablaTodosLosLibros;
    private javax.swing.JTable tableDescargas;
    private javax.swing.JTable tableMultasT;
    private javax.swing.JTable tableMultasU;
    private javax.swing.JTable tableSolicitud;
    private javax.swing.JTextField txtAnoLibroA;
    private javax.swing.JTextField txtAnoLibroC;
    private javax.swing.JTextField txtAnoLibroE;
    private javax.swing.JTextField txtAnoLibroM;
    private javax.swing.JTextArea txtAreaSolicitud;
    private javax.swing.JTextField txtCajonEjemplarA;
    private javax.swing.JTextField txtCajonEjemplarC;
    private javax.swing.JTextField txtCajonEjemplarE;
    private javax.swing.JTextField txtCajonEjemplarM;
    private javax.swing.JTextField txtEstanteEjemplarA;
    private javax.swing.JTextField txtEstanteEjemplarC;
    private javax.swing.JTextField txtEstanteEjemplarE;
    private javax.swing.JTextField txtEstanteEjemplarM;
    private javax.swing.JTextField txtFechaMultas;
    private javax.swing.JTextField txtFechaPrestamoC;
    private javax.swing.JTextField txtIdManejoA;
    private javax.swing.JTextField txtIdManejoC;
    private javax.swing.JTextField txtIdManejoE;
    private javax.swing.JTextField txtIdManejoM;
    private javax.swing.JTextField txtIdMultas;
    private javax.swing.JTextField txtIsbnEjemplarA;
    private javax.swing.JTextField txtIsbnEjemplarC;
    private javax.swing.JTextField txtIsbnEjemplarE;
    private javax.swing.JTextField txtIsbnEjemplarM;
    private javax.swing.JTextField txtIsbnLibroA;
    private javax.swing.JTextField txtIsbnLibroC;
    private javax.swing.JTextField txtIsbnLibroE;
    private javax.swing.JTextField txtIsbnLibroM;
    private javax.swing.JTextField txtIsbnPrestamoA;
    private javax.swing.JTextField txtIsbnPrestamoM;
    private javax.swing.JTextField txtNombreLibroA;
    private javax.swing.JTextField txtNombreManejoA;
    private javax.swing.JTextField txtNombreManejoC;
    private javax.swing.JTextField txtNombreManejoE;
    private javax.swing.JTextField txtNombreManejoM;
    private javax.swing.JTextField txtNumPrestamoA;
    private javax.swing.JTextField txtNumeroEjemplarA;
    private javax.swing.JTextField txtNumeroEjemplarC;
    private javax.swing.JTextField txtNumeroEjemplarE;
    private javax.swing.JTextField txtNumeroEjemplarM;
    private javax.swing.JTextField txtPaginasLibroA;
    private javax.swing.JTextField txtPaginasLibroC;
    private javax.swing.JTextField txtPaginasLibroE;
    private javax.swing.JTextField txtPaginasLibroM;
    private javax.swing.JTextField txtPasilloEjemplarA;
    private javax.swing.JTextField txtPasilloEjemplarC;
    private javax.swing.JTextField txtPasilloEjemplarE;
    private javax.swing.JTextField txtPasilloEjemplarM;
    private javax.swing.JPasswordField txtPasswordManejoA;
    private javax.swing.JPasswordField txtPasswordManejoM;
    private javax.swing.JTextField txtPrestamoE;
    private javax.swing.JTextField txtPrestamoM;
    private javax.swing.JTextField txtSalaEjemplarA;
    private javax.swing.JTextField txtSalaEjemplarC;
    private javax.swing.JTextField txtSalaEjemplarE;
    private javax.swing.JTextField txtSalaEjemplarM;
    private javax.swing.JTextField txtTamanoLibroA;
    private javax.swing.JTextField txtTamanoLibroC;
    private javax.swing.JTextField txtTamanoLibroE;
    private javax.swing.JTextField txtTamanoLibroM;
    private javax.swing.JTextField txtTituloLibroC;
    private javax.swing.JTextField txtTituloLibroE;
    private javax.swing.JTextField txtTituloLibroM;
    private javax.swing.JTextField txtUrlLibroA;
    private javax.swing.JTextField txtUrlLibroC;
    private javax.swing.JTextField txtUrlLibroE;
    private javax.swing.JTextField txtUrlLibroM;
    private javax.swing.JTextField txtUsuarioPrestamoA;
    private javax.swing.JTextField txtUsuarioPrestamoC;
    private javax.swing.JTextField txtUsuarioPrestamoE;
    private javax.swing.JTextField txtUsuarioPrestamoM;
    // End of variables declaration//GEN-END:variables
}

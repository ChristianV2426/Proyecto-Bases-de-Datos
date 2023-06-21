/*
  Archivo: vistaEmpleado.java
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

package co.edu.univalle.vistas;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import co.edu.univalle.modelo.Ejemplar;

public class VistaEmpleado extends javax.swing.JFrame {
    
    private final CardLayout cardLayout;
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    private DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    
    public VistaEmpleado(String titulo) {
        initComponents();
        setVisible(true);
        setTitle(titulo);
        setResizable(false);
        setLocationRelativeTo(null);
        cardLayout = (CardLayout) panelPrincipal.getLayout();
        cardLayout.show(panelPrincipal, "cardManejo");
        llenarColumnas(tablaPrestamoA);
        disenoTabla(tablaPrestamoA, scrollPrestamoA);
    }
    
    public void llenarColumnas(JTable tablaGenerica){
        if (tablaGenerica == tablaPrestamoA) {
            modeloTabla.addColumn("ISBN");
            modeloTabla.addColumn("Titulo");
            modeloTabla.addColumn("Ejemplar");
            modeloTabla.addColumn("Fecha devolución");
        }
    }
    
    public void disenoTabla(JTable tablaGenerica, JScrollPane scrollGenerico){
        
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

    public void agregarEjemplares(ArrayList<String> ejemplares){
        
        //Se agregan los ejemplares disponibles al comboBox
        modeloCombo.addAll(ejemplares);
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
        panelLibroModificar = new javax.swing.JPanel();
        panelLibroConsultar = new javax.swing.JPanel();
        panelLibroEliminar = new javax.swing.JPanel();
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
        panelMultaConsultar = new javax.swing.JPanel();
        panelSolicitud = new javax.swing.JTabbedPane();
        panelSolicitudConsultar = new javax.swing.JPanel();
        panelDescarga = new javax.swing.JTabbedPane();
        panelDescargaConsultar = new javax.swing.JPanel();
        panelEjemplar = new javax.swing.JTabbedPane();
        panelEjemplarAnadir = new javax.swing.JPanel();
        panelEjemplarModificar = new javax.swing.JPanel();
        panelEjemplarConsultar = new javax.swing.JPanel();
        panelEjemplarEliminar = new javax.swing.JPanel();

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

        lblAdmin.setText("Admin");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSolicitudes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrestamos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMultas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDescargas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnManejoPersonal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLibros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEjemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(lblAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
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
                .addContainerGap(22, Short.MAX_VALUE)
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
        comboCargoManejoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
                    .addGroup(panelEmpleadoManejoCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIdManejoC, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addComponent(txtNombreManejoC)))
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

        javax.swing.GroupLayout panelLibroAnadirLayout = new javax.swing.GroupLayout(panelLibroAnadir);
        panelLibroAnadir.setLayout(panelLibroAnadirLayout);
        panelLibroAnadirLayout.setHorizontalGroup(
            panelLibroAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelLibroAnadirLayout.setVerticalGroup(
            panelLibroAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelLibro.addTab("Añadir", panelLibroAnadir);

        javax.swing.GroupLayout panelLibroModificarLayout = new javax.swing.GroupLayout(panelLibroModificar);
        panelLibroModificar.setLayout(panelLibroModificarLayout);
        panelLibroModificarLayout.setHorizontalGroup(
            panelLibroModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelLibroModificarLayout.setVerticalGroup(
            panelLibroModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelLibro.addTab("Modificar", panelLibroModificar);

        javax.swing.GroupLayout panelLibroConsultarLayout = new javax.swing.GroupLayout(panelLibroConsultar);
        panelLibroConsultar.setLayout(panelLibroConsultarLayout);
        panelLibroConsultarLayout.setHorizontalGroup(
            panelLibroConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelLibroConsultarLayout.setVerticalGroup(
            panelLibroConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelLibro.addTab("Consultar", panelLibroConsultar);

        javax.swing.GroupLayout panelLibroEliminarLayout = new javax.swing.GroupLayout(panelLibroEliminar);
        panelLibroEliminar.setLayout(panelLibroEliminarLayout);
        panelLibroEliminarLayout.setHorizontalGroup(
            panelLibroEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelLibroEliminarLayout.setVerticalGroup(
            panelLibroEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelLibro.addTab("Eliminar", panelLibroEliminar);

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

        javax.swing.GroupLayout panelMultaConsultarLayout = new javax.swing.GroupLayout(panelMultaConsultar);
        panelMultaConsultar.setLayout(panelMultaConsultarLayout);
        panelMultaConsultarLayout.setHorizontalGroup(
            panelMultaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelMultaConsultarLayout.setVerticalGroup(
            panelMultaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelMulta.addTab("Consultar", panelMultaConsultar);

        panelPrincipal.add(panelMulta, "cardMulta");

        panelSolicitud.setFocusable(false);
        panelSolicitud.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelSolicitudConsultarLayout = new javax.swing.GroupLayout(panelSolicitudConsultar);
        panelSolicitudConsultar.setLayout(panelSolicitudConsultarLayout);
        panelSolicitudConsultarLayout.setHorizontalGroup(
            panelSolicitudConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelSolicitudConsultarLayout.setVerticalGroup(
            panelSolicitudConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelSolicitud.addTab("Consultar", panelSolicitudConsultar);

        panelPrincipal.add(panelSolicitud, "cardSolicitud");

        panelDescarga.setFocusable(false);
        panelDescarga.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelDescargaConsultarLayout = new javax.swing.GroupLayout(panelDescargaConsultar);
        panelDescargaConsultar.setLayout(panelDescargaConsultarLayout);
        panelDescargaConsultarLayout.setHorizontalGroup(
            panelDescargaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelDescargaConsultarLayout.setVerticalGroup(
            panelDescargaConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelDescarga.addTab("Consultar", panelDescargaConsultar);

        panelPrincipal.add(panelDescarga, "cardDescarga");

        panelEjemplar.setFocusable(false);
        panelEjemplar.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelEjemplarAnadirLayout = new javax.swing.GroupLayout(panelEjemplarAnadir);
        panelEjemplarAnadir.setLayout(panelEjemplarAnadirLayout);
        panelEjemplarAnadirLayout.setHorizontalGroup(
            panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelEjemplarAnadirLayout.setVerticalGroup(
            panelEjemplarAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelEjemplar.addTab("Añadir", panelEjemplarAnadir);

        javax.swing.GroupLayout panelEjemplarModificarLayout = new javax.swing.GroupLayout(panelEjemplarModificar);
        panelEjemplarModificar.setLayout(panelEjemplarModificarLayout);
        panelEjemplarModificarLayout.setHorizontalGroup(
            panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelEjemplarModificarLayout.setVerticalGroup(
            panelEjemplarModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelEjemplar.addTab("Modificar", panelEjemplarModificar);

        javax.swing.GroupLayout panelEjemplarConsultarLayout = new javax.swing.GroupLayout(panelEjemplarConsultar);
        panelEjemplarConsultar.setLayout(panelEjemplarConsultarLayout);
        panelEjemplarConsultarLayout.setHorizontalGroup(
            panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelEjemplarConsultarLayout.setVerticalGroup(
            panelEjemplarConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelEjemplar.addTab("Consultar", panelEjemplarConsultar);

        javax.swing.GroupLayout panelEjemplarEliminarLayout = new javax.swing.GroupLayout(panelEjemplarEliminar);
        panelEjemplarEliminar.setLayout(panelEjemplarEliminarLayout);
        panelEjemplarEliminarLayout.setHorizontalGroup(
            panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelEjemplarEliminarLayout.setVerticalGroup(
            panelEjemplarEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

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
    private javax.swing.JButton btnAgregarPrestamoA;
    private javax.swing.JButton btnAgregarPrestamoM;
    private javax.swing.JButton btnAnadirManejoA;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCheckManejoC;
    private javax.swing.JButton btnCheckManejoE;
    private javax.swing.JButton btnCheckManejoM;
    private javax.swing.JButton btnCheckPrestamoA;
    private javax.swing.JButton btnCheckPrestamoC;
    private javax.swing.JButton btnCheckPrestamoE;
    private javax.swing.JButton btnCheckPrestamoM;
    private javax.swing.JButton btnDescargas;
    private javax.swing.JButton btnDevolverPrestamoC;
    private javax.swing.JButton btnEjemplar;
    private javax.swing.JButton btnEliminarManejoE;
    private javax.swing.JButton btnEliminarPrestamoE;
    private javax.swing.JButton btnEmpleadoManejoC;
    private javax.swing.JButton btnEmpleadosManejoC;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnManejoPersonal;
    private javax.swing.JButton btnModificarManejoM;
    private javax.swing.JButton btnModificarPrestamoM;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnRealizarPrestamoA;
    private javax.swing.JButton btnRemoverPrestamoA;
    private javax.swing.JButton btnRemoverPrestamoM;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JButton btnVerificarPrestamoA;
    private javax.swing.JButton btnVerificarPrestamoM;
    private javax.swing.JCheckBox checkPasswordManejoA;
    private javax.swing.JCheckBox checkPasswordManejoM;
    private javax.swing.JComboBox<String> comboCargoManejoA;
    private javax.swing.JComboBox<String> comboCargoManejoC;
    private javax.swing.JComboBox<String> comboCargoManejoE;
    private javax.swing.JComboBox<String> comboCargoManejoM;
    private javax.swing.JComboBox<String> comboEjemplarPrestamoA;
    private javax.swing.JComboBox<String> comboEjemplarPrestamoM;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblCargoManejoA;
    private javax.swing.JLabel lblCargoManejoC;
    private javax.swing.JLabel lblCargoManejoE;
    private javax.swing.JLabel lblCargoManejoM;
    private javax.swing.JLabel lblEjemplarPrestamoA;
    private javax.swing.JLabel lblEjemplarPrestamoM;
    private javax.swing.JLabel lblFechaPrestamoC;
    private javax.swing.JLabel lblIdManejoA;
    private javax.swing.JLabel lblIdManejoC;
    private javax.swing.JLabel lblIdManejoE;
    private javax.swing.JLabel lblIdManejoM;
    private javax.swing.JLabel lblIsbnPrestamoA;
    private javax.swing.JLabel lblIsbnPrestamoM;
    private javax.swing.JLabel lblNombreManejoA;
    private javax.swing.JLabel lblNombreManejoC;
    private javax.swing.JLabel lblNombreManejoE;
    private javax.swing.JLabel lblNombreManejoM;
    private javax.swing.JLabel lblNumPrestamoA;
    private javax.swing.JLabel lblPasswordManejoA;
    private javax.swing.JLabel lblPasswordManejoM;
    private javax.swing.JLabel lblPrestamoE;
    private javax.swing.JLabel lblPrestamoM;
    private javax.swing.JLabel lblTitulo;
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
    private javax.swing.JPanel panelMultaConsultar;
    private javax.swing.JTabbedPane panelPrestamo;
    private javax.swing.JPanel panelPrestamoAnadir;
    private javax.swing.JPanel panelPrestamoConsultar;
    private javax.swing.JPanel panelPrestamoEliminar;
    private javax.swing.JPanel panelPrestamoModificar;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTabbedPane panelSolicitud;
    private javax.swing.JPanel panelSolicitudConsultar;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollManejoC;
    private javax.swing.JScrollPane scrollPrestamoA;
    private javax.swing.JScrollPane scrollPrestamoC;
    private javax.swing.JScrollPane scrollPrestamoE;
    private javax.swing.JScrollPane scrollPrestamoM;
    private javax.swing.JPanel subPanelManejoConsultar;
    private javax.swing.JTable tablaManejoC;
    private javax.swing.JTable tablaPrestamoA;
    private javax.swing.JTable tablaPrestamoC;
    private javax.swing.JTable tablaPrestamoE;
    private javax.swing.JTable tablaPrestamoM;
    private javax.swing.JTextField txtFechaPrestamoC;
    private javax.swing.JTextField txtIdManejoA;
    private javax.swing.JTextField txtIdManejoC;
    private javax.swing.JTextField txtIdManejoE;
    private javax.swing.JTextField txtIdManejoM;
    private javax.swing.JTextField txtIsbnPrestamoA;
    private javax.swing.JTextField txtIsbnPrestamoM;
    private javax.swing.JTextField txtNombreManejoA;
    private javax.swing.JTextField txtNombreManejoC;
    private javax.swing.JTextField txtNombreManejoE;
    private javax.swing.JTextField txtNombreManejoM;
    private javax.swing.JTextField txtNumPrestamoA;
    private javax.swing.JPasswordField txtPasswordManejoA;
    private javax.swing.JPasswordField txtPasswordManejoM;
    private javax.swing.JTextField txtPrestamoE;
    private javax.swing.JTextField txtPrestamoM;
    private javax.swing.JTextField txtUsuarioPrestamoA;
    private javax.swing.JTextField txtUsuarioPrestamoC;
    private javax.swing.JTextField txtUsuarioPrestamoE;
    private javax.swing.JTextField txtUsuarioPrestamoM;
    // End of variables declaration//GEN-END:variables
}

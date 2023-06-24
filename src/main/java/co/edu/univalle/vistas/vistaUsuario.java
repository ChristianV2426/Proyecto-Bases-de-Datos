/*
  Archivo: VistaUsuario.java
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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VistaUsuario extends javax.swing.JFrame {

    private JPanel panelConsultar;
    private JTextField txtIsbn;
    private JLabel lblIsbn;
    private JLabel lblConsulteTodos;
    private JButton btnConsultarLibro;
    private JButton btnConsultarLibros;
    private JButton btnDescargar;
    private JTable tablaConsultar;
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    private JScrollPane scrollConsultar;
    private final CardLayout cardLayout;
    
    public VistaUsuario(String titulo) {
        initComponents();
        componentesConsultar();
        llenarColumnas(tablaConsultar);
        disenoTabla(tablaConsultar, scrollConsultar);
        setVisible(true);
        setTitle(titulo);
        setResizable(false);
        setLocationRelativeTo(null);
        cardLayout = (CardLayout) panelPrincipal.getLayout();
        cardLayout.show(panelPrincipal, "cardConsultar");
    }
    
    public void componentesConsultar(){
        
        //Creando componentes
        panelConsultar = new JPanel();
        txtIsbn = new JTextField();
        lblIsbn = new JLabel();
        lblConsulteTodos = new JLabel();
        btnConsultarLibro = new JButton();
        btnConsultarLibros = new JButton();
        btnDescargar = new JButton();
        tablaConsultar = new JTable();
        scrollConsultar = new JScrollPane();
        panelConsultar.setLayout(null);
        
        //Configurando el panelConsultar
        panelConsultar.setVisible(true);
        panelConsultar.setOpaque(true);
        panelConsultar.setBounds(0, 0, 770, 440);
        panelConsultar.setBackground(new Color(219, 213, 213));
        panelPrincipal.add(panelConsultar, "cardConsultar");
        
        //Añadiendo componentes a panelConsultar
        txtIsbn.setFont(new Font("Segoe UI", 0, 18));
        txtIsbn.setBounds(200, 30, 210, 30);
        txtIsbn.setOpaque(true);
        panelConsultar.add(txtIsbn);
        
        lblIsbn.setText("Consulte un libro:");
        lblIsbn.setFont(new Font("Georgia", 0, 20));
        lblIsbn.setBounds(15, 30, 190, 30);
        lblIsbn.setOpaque(false);
        lblIsbn.setBorder(null);
        panelConsultar.add(lblIsbn);
        
        btnConsultarLibro.setText("Consultar");
        btnConsultarLibro.setFont(new Font("Georgia", 0, 20));
        btnConsultarLibro.setBounds(560, 30, 150, 30);
        btnConsultarLibro.setBackground(Color.WHITE);
        btnConsultarLibro.setFocusPainted(false);
        btnConsultarLibro.setRequestFocusEnabled(false);
        panelConsultar.add(btnConsultarLibro);
        
        lblConsulteTodos.setText("Todos los libros:");
        lblConsulteTodos.setFont(new Font("Georgia", 0, 20));
        lblConsulteTodos.setBounds(15, 90, 190, 30);
        lblConsulteTodos.setOpaque(false);
        lblConsulteTodos.setBorder(null);
        panelConsultar.add(lblConsulteTodos);
        
        btnConsultarLibros.setText("Consultar");
        btnConsultarLibros.setFont(new Font("Georgia", 0, 20));
        btnConsultarLibros.setBounds(560, 90, 150, 30);
        btnConsultarLibros.setBackground(Color.WHITE);
        btnConsultarLibros.setFocusPainted(false);
        btnConsultarLibros.setRequestFocusEnabled(false);
        panelConsultar.add(btnConsultarLibros);
        
        tablaConsultar.setFont(new Font("Agency FB", 1, 18));
        tablaConsultar.setModel(modeloTabla);
        tablaConsultar.setRowHeight(30);
        tablaConsultar.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaConsultar.getTableHeader().setReorderingAllowed(false);
        scrollConsultar.setViewportView(tablaConsultar);
        scrollConsultar.setBounds(15, 150, 695, 220);
        panelConsultar.add(scrollConsultar);
        
        btnDescargar.setText("Descargar");
        btnDescargar.setFont(new Font("Georgia", 0, 20));
        btnDescargar.setBounds(560, 395, 150, 30);
        btnDescargar.setBackground(Color.WHITE);
        btnDescargar.setFocusPainted(false);
        btnDescargar.setRequestFocusEnabled(false);
        panelConsultar.add(btnDescargar);
    }
    
    public void llenarColumnas(JTable tablaGenerica){
        
        if (tablaGenerica == tablaConsultar) {
            modeloTabla.addColumn("ISBN");
            modeloTabla.addColumn("Titulo");
            modeloTabla.addColumn("Ejemplares");
            modeloTabla.addColumn("Escritor");
            modeloTabla.addColumn("Editorial");
            modeloTabla.addColumn("Idioma");
            modeloTabla.addColumn("Digital");
        }
        
        if (tablaGenerica == tablaPrestamo) {
            modeloTabla.addColumn("PréstamoID");
            modeloTabla.addColumn("Libros");
            modeloTabla.addColumn("Ejemplar");
            modeloTabla.addColumn("Préstamo");
            modeloTabla.addColumn("Devolución");
            modeloTabla.addColumn("Estado");
        }
        
        if (tablaGenerica == tablaMulta) {
            modeloTabla.addColumn("Multa ID");
            modeloTabla.addColumn("Préstamo");
            modeloTabla.addColumn("ISBN");
            modeloTabla.addColumn("Título");
            modeloTabla.addColumn("Fecha");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Valor");
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JButton();
        btnSolicitud = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnMultas = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelSolicitud = new javax.swing.JPanel();
        lblUsuarioSolicitud = new javax.swing.JLabel();
        lblIsbnSolicitud = new javax.swing.JLabel();
        lblFechaSolicitud = new javax.swing.JLabel();
        txtUsuarioSolicitud = new javax.swing.JTextField();
        txtIsbnSolicitud = new javax.swing.JTextField();
        txtFechaSolicitud = new javax.swing.JTextField();
        lblIdSolicitud = new javax.swing.JLabel();
        txtIdSolicitud = new javax.swing.JTextField();
        scrollSolicitud = new javax.swing.JScrollPane();
        txtAreaSolicitud = new javax.swing.JTextArea();
        lblDescribaSolicitud = new javax.swing.JLabel();
        btnSolicitar = new javax.swing.JButton();
        panelPrestamo = new javax.swing.JPanel();
        txtNomPrestamo = new javax.swing.JTextField();
        txtFechaPrestamo = new javax.swing.JTextField();
        scrollPrestamo = new javax.swing.JScrollPane();
        tablaPrestamo = new javax.swing.JTable();
        panelMulta = new javax.swing.JPanel();
        txtNomMulta = new javax.swing.JTextField();
        txtFechaMulta = new javax.swing.JTextField();
        scrollMulta = new javax.swing.JScrollPane();
        tablaMulta = new javax.swing.JTable();

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

        btnConsultar.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnConsultar.setText("Consultar libros");
        btnConsultar.setFocusPainted(false);
        btnConsultar.setRequestFocusEnabled(false);

        btnSolicitud.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnSolicitud.setText("Solicitud de libros");
        btnSolicitud.setFocusPainted(false);
        btnSolicitud.setPreferredSize(new java.awt.Dimension(75, 27));
        btnSolicitud.setRequestFocusEnabled(false);

        btnPrestamos.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnPrestamos.setText("Mis préstamos");
        btnPrestamos.setFocusPainted(false);
        btnPrestamos.setPreferredSize(new java.awt.Dimension(75, 27));
        btnPrestamos.setRequestFocusEnabled(false);

        btnMultas.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnMultas.setText("Mis multas");
        btnMultas.setFocusPainted(false);
        btnMultas.setPreferredSize(new java.awt.Dimension(75, 27));
        btnMultas.setRequestFocusEnabled(false);

        btnCerrar.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        btnCerrar.setText("Cerrar sesión");
        btnCerrar.setFocusPainted(false);
        btnCerrar.setPreferredSize(new java.awt.Dimension(75, 27));
        btnCerrar.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnMultas, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(btnSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMultas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnConsultar.setBackground(Color.WHITE);
        btnSolicitud.setBackground(Color.WHITE);
        btnPrestamos.setBackground(Color.WHITE);
        btnMultas.setBackground(Color.WHITE);
        btnCerrar.setBackground(Color.WHITE);

        panelFondo.add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 210, 480));

        panelPrincipal.setLayout(new java.awt.CardLayout());

        lblUsuarioSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblUsuarioSolicitud.setText("Usuario:");

        lblIsbnSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIsbnSolicitud.setText("ISBN:");

        lblFechaSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblFechaSolicitud.setText("Fecha:");

        txtUsuarioSolicitud.setEditable(false);
        txtUsuarioSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtIsbnSolicitud.setEditable(false);
        txtIsbnSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtFechaSolicitud.setEditable(false);
        txtFechaSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblIdSolicitud.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        lblIdSolicitud.setText("Solicitud");

        txtIdSolicitud.setEditable(false);
        txtIdSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtAreaSolicitud.setColumns(20);
        txtAreaSolicitud.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAreaSolicitud.setRows(5);
        scrollSolicitud.setViewportView(txtAreaSolicitud);

        lblDescribaSolicitud.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        lblDescribaSolicitud.setText("Describa el motivo de su solicitud:");

        btnSolicitar.setFont(new java.awt.Font("Georgia", 0, 20)); // NOI18N
        btnSolicitar.setText("Solicitar libro");
        btnSolicitar.setFocusPainted(false);
        btnSolicitar.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelSolicitudLayout = new javax.swing.GroupLayout(panelSolicitud);
        panelSolicitud.setLayout(panelSolicitudLayout);
        panelSolicitudLayout.setHorizontalGroup(
            panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolicitudLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSolicitar)
                    .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollSolicitud)
                        .addComponent(lblDescribaSolicitud)
                        .addGroup(panelSolicitudLayout.createSequentialGroup()
                            .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblFechaSolicitud)
                                .addComponent(lblIsbnSolicitud)
                                .addComponent(lblUsuarioSolicitud))
                            .addGap(18, 18, 18)
                            .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIsbnSolicitud, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(txtUsuarioSolicitud)
                                .addComponent(txtFechaSolicitud))
                            .addGap(32, 32, 32)
                            .addComponent(lblIdSolicitud)
                            .addGap(18, 18, 18)
                            .addComponent(txtIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelSolicitudLayout.setVerticalGroup(
            panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolicitudLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuarioSolicitud)
                    .addComponent(lblIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSolicitud))
                .addGap(18, 18, 18)
                .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsbnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIsbnSolicitud))
                .addGap(18, 18, 18)
                .addGroup(panelSolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaSolicitud))
                .addGap(18, 18, 18)
                .addComponent(lblDescribaSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        btnSolicitar.setBackground(Color.WHITE);

        panelPrincipal.add(panelSolicitud, "cardSolicitud");

        txtNomPrestamo.setEditable(false);
        txtNomPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNomPrestamo.setFocusable(false);

        txtFechaPrestamo.setEditable(false);
        txtFechaPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFechaPrestamo.setFocusable(false);

        tablaPrestamo.setModel(modeloTabla);
        scrollPrestamo.setViewportView(tablaPrestamo);

        javax.swing.GroupLayout panelPrestamoLayout = new javax.swing.GroupLayout(panelPrestamo);
        panelPrestamo.setLayout(panelPrestamoLayout);
        panelPrestamoLayout.setHorizontalGroup(
            panelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrestamoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(panelPrestamoLayout.createSequentialGroup()
                        .addComponent(txtNomPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        panelPrestamoLayout.setVerticalGroup(
            panelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrestamoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelPrestamo, "cardPrestamo");

        txtNomMulta.setEditable(false);
        txtNomMulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNomMulta.setFocusable(false);

        txtFechaMulta.setEditable(false);
        txtFechaMulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFechaMulta.setFocusable(false);

        tablaMulta.setModel(modeloTabla);
        scrollMulta.setViewportView(tablaMulta);

        javax.swing.GroupLayout panelMultaLayout = new javax.swing.GroupLayout(panelMulta);
        panelMulta.setLayout(panelMultaLayout);
        panelMultaLayout.setHorizontalGroup(
            panelMultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMultaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelMultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollMulta, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(panelMultaLayout.createSequentialGroup()
                        .addComponent(txtNomMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        panelMultaLayout.setVerticalGroup(
            panelMultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelMultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelMulta, "cardMulta");

        panelFondo.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 740, 440));

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

    public JPanel getPanelConsultar() {
        return panelConsultar;
    }

    public JTextField getTxtIsbn() {
        return txtIsbn;
    }

    public JButton getBtnConsultarLibro() {
        return btnConsultarLibro;
    }

    public JButton getBtnConsultarLibros() {
        return btnConsultarLibros;
    }

    public JButton getBtnDescargar() {
        return btnDescargar;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnMultas() {
        return btnMultas;
    }

    public JButton getBtnPrestamos() {
        return btnPrestamos;
    }

    public JButton getBtnSolicitud() {
        return btnSolicitud;
    }
    
    public JTextField getTxtNomPrestamo() {
        return txtNomPrestamo;
    }
    
    public JTextField getTxtFechaPrestamo() {
        return txtFechaPrestamo;
    }
    
    public JScrollPane getScrollPrestamo() {
        return scrollPrestamo;
    }
    
    public JTable getTablaPrestamo() {
        return tablaPrestamo;
    }
    
    public JTextField getTxtNomMulta() {
        return txtNomMulta;
    }
    
    public JTextField getTxtFechaMulta() {
        return txtFechaMulta;
    }
    
    public JScrollPane getScrollMulta() {
        return scrollMulta;
    }
    
    public JTable getTablaMulta() {
        return tablaMulta;
    }

    public JTable getTablaConsultar() {
        return tablaConsultar;
    }

    public JScrollPane getScrollConsultar() {
        return scrollConsultar;
    }

    public JScrollPane getScrollSolicitud() {
        return scrollSolicitud;
    }

    public JTextArea getTxtAreaSolicitud() {
        return txtAreaSolicitud;
    }

    public JTextField getTxtFechaSolicitud() {
        return txtFechaSolicitud;
    }

    public JTextField getTxtIdSolicitud() {
        return txtIdSolicitud;
    }

    public JTextField getTxtIsbnSolicitud() {
        return txtIsbnSolicitud;
    }

    public JTextField getTxtUsuarioSolicitud() {
        return txtUsuarioSolicitud;
    }

    public JButton getBtnSolicitar() {
        return btnSolicitar;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnSolicitud;
    private javax.swing.JLabel lblDescribaSolicitud;
    private javax.swing.JLabel lblFechaSolicitud;
    private javax.swing.JLabel lblIdSolicitud;
    private javax.swing.JLabel lblIsbnSolicitud;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuarioSolicitud;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMulta;
    private javax.swing.JPanel panelPrestamo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSolicitud;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JScrollPane scrollMulta;
    private javax.swing.JScrollPane scrollPrestamo;
    private javax.swing.JScrollPane scrollSolicitud;
    private javax.swing.JTable tablaMulta;
    private javax.swing.JTable tablaPrestamo;
    private javax.swing.JTextArea txtAreaSolicitud;
    private javax.swing.JTextField txtFechaMulta;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtFechaSolicitud;
    private javax.swing.JTextField txtIdSolicitud;
    private javax.swing.JTextField txtIsbnSolicitud;
    private javax.swing.JTextField txtNomMulta;
    private javax.swing.JTextField txtNomPrestamo;
    private javax.swing.JTextField txtUsuarioSolicitud;
    // End of variables declaration//GEN-END:variables
}

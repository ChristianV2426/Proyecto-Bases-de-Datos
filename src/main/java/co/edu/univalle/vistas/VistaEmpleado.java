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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VistaEmpleado extends javax.swing.JFrame {
    
    private final CardLayout cardLayout;
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    
    public VistaEmpleado(String titulo) {
        initComponents();
        setVisible(true);
        setTitle(titulo);
        setResizable(false);
        setLocationRelativeTo(null);
        cardLayout = (CardLayout) panelPrincipal.getLayout();
        cardLayout.show(panelPrincipal, "cardManejo");
    }
    
    public void llenarColumnas(JTable tablaGenerica){
        
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
        btnManejoPersonal = new javax.swing.JButton();
        btnLibros = new javax.swing.JButton();
        btnPrestamos = new javax.swing.JButton();
        btnMultas = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnSolicitudes = new javax.swing.JButton();
        btnDescargas = new javax.swing.JButton();
        btnEjemplar = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        panelManejo = new javax.swing.JTabbedPane();
        panelManejoAnadir = new javax.swing.JPanel();
        panelManejoModificar = new javax.swing.JPanel();
        panelManejoConsultar = new javax.swing.JPanel();
        panelManejoEliminar = new javax.swing.JPanel();
        panelLibro = new javax.swing.JTabbedPane();
        panelLibroAnadir = new javax.swing.JPanel();
        panelLibroModificar = new javax.swing.JPanel();
        panelLibroConsultar = new javax.swing.JPanel();
        panelLibroEliminar = new javax.swing.JPanel();
        panelPrestamo = new javax.swing.JTabbedPane();
        panelPrestamoAnadir = new javax.swing.JPanel();
        panelPrestamoModificar = new javax.swing.JPanel();
        panelPrestamoConsultar = new javax.swing.JPanel();
        panelPrestamoEliminar = new javax.swing.JPanel();
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

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSolicitudes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrestamos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMultas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDescargas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManejoPersonal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLibros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEjemplar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
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

        javax.swing.GroupLayout panelManejoAnadirLayout = new javax.swing.GroupLayout(panelManejoAnadir);
        panelManejoAnadir.setLayout(panelManejoAnadirLayout);
        panelManejoAnadirLayout.setHorizontalGroup(
            panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelManejoAnadirLayout.setVerticalGroup(
            panelManejoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelManejo.addTab("Añadir", panelManejoAnadir);

        javax.swing.GroupLayout panelManejoModificarLayout = new javax.swing.GroupLayout(panelManejoModificar);
        panelManejoModificar.setLayout(panelManejoModificarLayout);
        panelManejoModificarLayout.setHorizontalGroup(
            panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelManejoModificarLayout.setVerticalGroup(
            panelManejoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelManejo.addTab("Modificar", panelManejoModificar);

        javax.swing.GroupLayout panelManejoConsultarLayout = new javax.swing.GroupLayout(panelManejoConsultar);
        panelManejoConsultar.setLayout(panelManejoConsultarLayout);
        panelManejoConsultarLayout.setHorizontalGroup(
            panelManejoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelManejoConsultarLayout.setVerticalGroup(
            panelManejoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelManejo.addTab("Consultar", panelManejoConsultar);

        javax.swing.GroupLayout panelManejoEliminarLayout = new javax.swing.GroupLayout(panelManejoEliminar);
        panelManejoEliminar.setLayout(panelManejoEliminarLayout);
        panelManejoEliminarLayout.setHorizontalGroup(
            panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelManejoEliminarLayout.setVerticalGroup(
            panelManejoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout panelPrestamoAnadirLayout = new javax.swing.GroupLayout(panelPrestamoAnadir);
        panelPrestamoAnadir.setLayout(panelPrestamoAnadirLayout);
        panelPrestamoAnadirLayout.setHorizontalGroup(
            panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelPrestamoAnadirLayout.setVerticalGroup(
            panelPrestamoAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelPrestamo.addTab("Añadir", panelPrestamoAnadir);

        javax.swing.GroupLayout panelPrestamoModificarLayout = new javax.swing.GroupLayout(panelPrestamoModificar);
        panelPrestamoModificar.setLayout(panelPrestamoModificarLayout);
        panelPrestamoModificarLayout.setHorizontalGroup(
            panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelPrestamoModificarLayout.setVerticalGroup(
            panelPrestamoModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelPrestamo.addTab("Modificar", panelPrestamoModificar);

        javax.swing.GroupLayout panelPrestamoConsultarLayout = new javax.swing.GroupLayout(panelPrestamoConsultar);
        panelPrestamoConsultar.setLayout(panelPrestamoConsultarLayout);
        panelPrestamoConsultarLayout.setHorizontalGroup(
            panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelPrestamoConsultarLayout.setVerticalGroup(
            panelPrestamoConsultarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        panelPrestamo.addTab("Consultar", panelPrestamoConsultar);

        javax.swing.GroupLayout panelPrestamoEliminarLayout = new javax.swing.GroupLayout(panelPrestamoEliminar);
        panelPrestamoEliminar.setLayout(panelPrestamoEliminarLayout);
        panelPrestamoEliminarLayout.setHorizontalGroup(
            panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        panelPrestamoEliminarLayout.setVerticalGroup(
            panelPrestamoEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDescargas;
    private javax.swing.JButton btnEjemplar;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnManejoPersonal;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnSolicitudes;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTabbedPane panelDescarga;
    private javax.swing.JPanel panelDescargaConsultar;
    private javax.swing.JTabbedPane panelEjemplar;
    private javax.swing.JPanel panelEjemplarAnadir;
    private javax.swing.JPanel panelEjemplarConsultar;
    private javax.swing.JPanel panelEjemplarEliminar;
    private javax.swing.JPanel panelEjemplarModificar;
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
    // End of variables declaration//GEN-END:variables
}

/*
  Archivo: vistaUConsultarLibro.java
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

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class vistaUsuario extends javax.swing.JFrame {

    private JPanel panelConsultar;
    private JPanel panelSolicitar;
    private JPanel panelPrestamos;
    private JPanel panelMultas;
    private JTextField txtIsbn;
    private JLabel lblIsbn;
    private JLabel lblConsulteTodos;
    private JButton btnConsultarLibro;
    private JButton btnConsultarLibros;
    private JButton btnDescargar;
    private JTable tablaLibro;
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    private JScrollPane scroll;
    
    public vistaUsuario(String titulo) {
        initComponents();
        componentesConsultar();
        llenarColumnas();
        diseñoTabla();
        setVisible(true);
        setTitle(titulo);
        setResizable(false);
        setLocationRelativeTo(null);
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
        tablaLibro = new JTable();
        scroll = new JScrollPane();
        panelConsultar.setLayout(null);
        
        //Configurando el panelConsultar
        panelConsultar.setVisible(true);
        panelConsultar.setOpaque(true);
        panelConsultar.setBackground(new Color(219, 213, 213));
        panelFondo.add(panelConsultar, new AbsoluteConstraints(220, 120, 770, 440));
        
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
        btnConsultarLibro.setBounds(600, 30, 150, 30);
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
        btnConsultarLibros.setBounds(600, 90, 150, 30);
        btnConsultarLibros.setBackground(Color.WHITE);
        btnConsultarLibros.setFocusPainted(false);
        btnConsultarLibros.setRequestFocusEnabled(false);
        panelConsultar.add(btnConsultarLibros);
        
        tablaLibro.setFont(new Font("Agency FB", 1, 18));
        tablaLibro.setModel(modeloTabla);
        tablaLibro.setRowHeight(30);
        tablaLibro.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaLibro.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tablaLibro);
        scroll.setBounds(15, 150, 740, 210);
        panelConsultar.add(scroll);
        
        btnDescargar.setText("Descargar");
        btnDescargar.setFont(new Font("Georgia", 0, 20));
        btnDescargar.setBounds(600, 395, 150, 30);
        btnDescargar.setBackground(Color.WHITE);
        btnDescargar.setFocusPainted(false);
        btnDescargar.setRequestFocusEnabled(false);
        panelConsultar.add(btnDescargar);
    }
    
    public void componentesSolicitud(){
        panelSolicitar = new JPanel();
        
    }
    
    public void componentesPrestamo(){
        panelPrestamos = new JPanel();
        
    }
    
    public void componentesMulta(){
        panelMultas = new JPanel();
    }
    
    public void llenarColumnas(){
        modeloTabla.addColumn("ISBN");
        modeloTabla.addColumn("Titulo");
        modeloTabla.addColumn("Ejemplares");
        modeloTabla.addColumn("Escritor");
        modeloTabla.addColumn("Editorial");
        modeloTabla.addColumn("Idioma");
        modeloTabla.addColumn("Digital");
    }
    
    public void diseñoTabla(){
        
        //Fuente de cabecera
        th = tablaLibro.getTableHeader();
        Font fuente = new Font("Georgia", Font.BOLD, 17);
        th.setFont(fuente);
        
        //Color cabecera
        tablaLibro.setOpaque(false);
        Color colorCabecera = new Color(178, 130, 76); //Color café
        th.setBackground(colorCabecera);
        
        //Color fondo
        Color colorFondo = new Color(255, 255, 255);
        scroll.getViewport().setBackground(colorFondo);
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
        Solicitud = new javax.swing.JPanel();
        prestamos = new javax.swing.JPanel();
        txtNomPrestamo = new javax.swing.JTextField();
        txtFechaPrestamo = new javax.swing.JTextField();
        scrollPrestamo = new javax.swing.JScrollPane();
        tablaPrestamo = new javax.swing.JTable();
        multas = new javax.swing.JPanel();
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

        javax.swing.GroupLayout SolicitudLayout = new javax.swing.GroupLayout(Solicitud);
        Solicitud.setLayout(SolicitudLayout);
        SolicitudLayout.setHorizontalGroup(
            SolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        SolicitudLayout.setVerticalGroup(
            SolicitudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        panelPrincipal.add(Solicitud, "card4");

        txtNomPrestamo.setEditable(false);
        txtNomPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNomPrestamo.setText("jTextField1");
        txtNomPrestamo.setFocusable(false);

        txtFechaPrestamo.setEditable(false);
        txtFechaPrestamo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFechaPrestamo.setText("jTextField1");
        txtFechaPrestamo.setFocusable(false);

        tablaPrestamo.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPrestamo.setViewportView(tablaPrestamo);

        javax.swing.GroupLayout prestamosLayout = new javax.swing.GroupLayout(prestamos);
        prestamos.setLayout(prestamosLayout);
        prestamosLayout.setHorizontalGroup(
            prestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prestamosLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(prestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addGroup(prestamosLayout.createSequentialGroup()
                        .addComponent(txtNomPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        prestamosLayout.setVerticalGroup(
            prestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prestamosLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(prestamosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelPrincipal.add(prestamos, "card2");

        txtNomMulta.setEditable(false);
        txtNomMulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNomMulta.setText("jTextField1");
        txtNomMulta.setFocusable(false);

        txtFechaMulta.setEditable(false);
        txtFechaMulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFechaMulta.setText("jTextField1");
        txtFechaMulta.setFocusable(false);

        tablaMulta.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollMulta.setViewportView(tablaMulta);

        javax.swing.GroupLayout multasLayout = new javax.swing.GroupLayout(multas);
        multas.setLayout(multasLayout);
        multasLayout.setHorizontalGroup(
            multasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, multasLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(multasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollMulta, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(multasLayout.createSequentialGroup()
                        .addComponent(txtNomMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFechaMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        multasLayout.setVerticalGroup(
            multasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multasLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(multasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollMulta, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        panelPrincipal.add(multas, "card3");

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

    public JPanel getPanelSolicitar() {
        return panelSolicitar;
    }

    public JPanel getPanelPrestamos() {
        return panelPrestamos;
    }

    public JPanel getPanelMultas() {
        return panelMultas;
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Solicitud;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnMultas;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JButton btnSolicitud;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel multas;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel prestamos;
    private javax.swing.JScrollPane scrollMulta;
    private javax.swing.JScrollPane scrollPrestamo;
    private javax.swing.JTable tablaMulta;
    private javax.swing.JTable tablaPrestamo;
    private javax.swing.JTextField txtFechaMulta;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtNomMulta;
    private javax.swing.JTextField txtNomPrestamo;
    // End of variables declaration//GEN-END:variables
}

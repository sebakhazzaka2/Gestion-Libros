package Interfaz;

import Dominio.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustin Gonzatto (277693)
 */
public class VentanaMenu extends javax.swing.JFrame {

    private Sistema modelo;

    public VentanaMenu(Sistema modelo) {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cargar el sistema viejo?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            Sistema sistema = modelo.cargarSistema();
            if (sistema != null) {
                this.modelo = sistema;
            } else {
                System.out.println("Error al cargar el sistema.");
                this.modelo = modelo;
            }
        } else {
            System.out.println("No se cargó el sistema.");
            this.modelo = modelo;
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        moRegistros = new javax.swing.JMenu();
        moREditorial = new javax.swing.JMenuItem();
        moRGenero = new javax.swing.JMenuItem();
        moRAutor = new javax.swing.JMenuItem();
        moRLibro = new javax.swing.JMenuItem();
        moVentas = new javax.swing.JMenu();
        moRVentas = new javax.swing.JMenuItem();
        moAVenta = new javax.swing.JMenuItem();
        moConsultas = new javax.swing.JMenu();
        moCLibros = new javax.swing.JMenuItem();
        moCVentas = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Librerias - Realizado por Agustín Gonzatto (277693)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        moRegistros.setText("Registros");

        moREditorial.setText("Registrar editorial");
        moREditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moREditorialActionPerformed(evt);
            }
        });
        moRegistros.add(moREditorial);

        moRGenero.setText("Registrar género");
        moRGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moRGeneroActionPerformed(evt);
            }
        });
        moRegistros.add(moRGenero);

        moRAutor.setText("Registrar autor");
        moRAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moRAutorActionPerformed(evt);
            }
        });
        moRegistros.add(moRAutor);

        moRLibro.setText("Registrar libro");
        moRLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moRLibroActionPerformed(evt);
            }
        });
        moRegistros.add(moRLibro);

        jMenuBar1.add(moRegistros);

        moVentas.setText("Ventas");

        moRVentas.setText("Registro de ventas");
        moRVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moRVentasActionPerformed(evt);
            }
        });
        moVentas.add(moRVentas);

        moAVenta.setText("Anular venta");
        moAVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moAVentaActionPerformed(evt);
            }
        });
        moVentas.add(moAVenta);

        jMenuBar1.add(moVentas);

        moConsultas.setText("Consultas");

        moCLibros.setText("Consulta de libros");
        moCLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moCLibrosActionPerformed(evt);
            }
        });
        moConsultas.add(moCLibros);

        moCVentas.setText("Consulta de ventas");
        moCVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moCVentasActionPerformed(evt);
            }
        });
        moConsultas.add(moCVentas);

        jMenuBar1.add(moConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void moREditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moREditorialActionPerformed
        VentanaRegistrarEditorial vent = new VentanaRegistrarEditorial(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moREditorialActionPerformed

    private void moRGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moRGeneroActionPerformed
        VentanaRegistrarGenero vent = new VentanaRegistrarGenero(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moRGeneroActionPerformed

    private void moRAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moRAutorActionPerformed
        VentanaRegistrarAutor vent = new VentanaRegistrarAutor(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moRAutorActionPerformed

    private void moRLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moRLibroActionPerformed
        VentanaRegistrarLibro vent = new VentanaRegistrarLibro(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moRLibroActionPerformed

    private void moCLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moCLibrosActionPerformed
        VentanaConsultaLibros vent = new VentanaConsultaLibros(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moCLibrosActionPerformed

    private void moRVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moRVentasActionPerformed
        VentanaRegistrarVenta vent = new VentanaRegistrarVenta(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moRVentasActionPerformed

    private void moAVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moAVentaActionPerformed
        VentanaAnulacionVenta vent = new VentanaAnulacionVenta(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moAVentaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        modelo.guardarSistema();
    }//GEN-LAST:event_formWindowClosing

    private void moCVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moCVentasActionPerformed
        VentanaConsultaVentasLibro vent = new VentanaConsultaVentasLibro(this.modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_moCVentasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem moAVenta;
    private javax.swing.JMenuItem moCLibros;
    private javax.swing.JMenuItem moCVentas;
    private javax.swing.JMenu moConsultas;
    private javax.swing.JMenuItem moRAutor;
    private javax.swing.JMenuItem moREditorial;
    private javax.swing.JMenuItem moRGenero;
    private javax.swing.JMenuItem moRLibro;
    private javax.swing.JMenuItem moRVentas;
    private javax.swing.JMenu moRegistros;
    private javax.swing.JMenu moVentas;
    // End of variables declaration//GEN-END:variables
}

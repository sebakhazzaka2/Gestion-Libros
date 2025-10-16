package Interfaz;

import Dominio.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Agustin Gonzatto (277693)
 */
public class VentanaConsultaVentasLibro extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private DefaultTableModel modeloTabla;
    private boolean visible;
    private String isbn;

    public VentanaConsultaVentasLibro(Sistema modelo) {
        this.modelo = modelo;
        this.visible = false;
        this.isbn = "";
        modelo.addObserver(this);
        initComponents();
        initTableModel();
        mostrarLista();
    }

    @Override
    public void update(Observable o, Object arg) {
        consultarVentas();
    }

    private void initTableModel() {
        modeloTabla = new DefaultTableModel(
                new String[]{"Fecha", "Cliente", "Número de Factura", "Cantidad", "Precio Venta", "Total"},
                0
        );
        tablaVentas.setModel(modeloTabla);
    }

    private void consultarVentas() {
        String isbn = txtIsbn.getText().trim();
        this.isbn = isbn;
        if (isbn.isEmpty()) {
            mostrarMensaje("Por favor, ingrese un ISBN valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Venta> ventas = modelo.obtenerVentasOrdenadasPorFactura(isbn);
        if (ventas.isEmpty()) {
            mostrarMensaje("No se encontraron ventas para este libro.", "Atención", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        actualizarTablaVentas(ventas);
        mostrarResumenVentas(isbn);
    }

    private void mostrarLista() {
        jScrollPane2.setVisible(this.visible);
        listaLibros.setVisible(this.visible);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void actualizarTablaVentas(ArrayList<Venta> ventas) {
        modeloTabla.setRowCount(0);
        for (Venta venta : ventas) {
            int cantidad = venta.getCantidad(isbn);
            int precioVenta = venta.getPrecioVenta(this.isbn);
            modeloTabla.addRow(new Object[]{
                venta.getFecha(),
                venta.getCliente(),
                venta.getNumeroFactura(),
                cantidad,
                precioVenta,
               cantidad * precioVenta
            });
        }
    }

    private void mostrarResumenVentas(String isbn) {
        Libro libro = modelo.obtenerLibroPorISBN(isbn);
        if (libro == null) {
            lblNombreLibro.setText("Libro no encontrado");
            lblEjemplaresVendidos.setText("0");
            lblTotalRecaudado.setText("0.00");
            lblTotalGanancias.setText("0.00");
            return;
        }
        lblNombreLibro.setText(libro.getTitulo());
        Map<String, Double> resumen = modelo.calcularResumenVentas(isbn);
        lblEjemplaresVendidos.setText(String.valueOf(resumen.get("ejemplaresVendidos")));
        lblTotalRecaudado.setText(String.format("%.2f", resumen.get("totalRecaudado")));
        lblTotalGanancias.setText(String.format("%.2f", resumen.get("totalGanancia")));
    }

    private void mostrarMensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        btnBuscarLibro = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEjemplaresVendidos = new javax.swing.JLabel();
        lblTotalRecaudado = new javax.swing.JLabel();
        lblTotalGanancias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaLibros = new javax.swing.JList<>();
        lblNombreLibro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de libros vendidos");

        jLabel1.setText("Isbn");

        btnBuscarLibro.setText("...");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaVentas);

        jLabel2.setText("Ejemplares vendidos");

        jLabel3.setText("Total recaudado");

        jLabel4.setText("Total ganancia");

        listaLibros.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaLibrosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaLibros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jLabel2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(lblEjemplaresVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(77, 77, 77)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(61, 61, 61)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTotalRecaudado, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(84, 84, 84)
                                                .addComponent(lblTotalGanancias, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblNombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarLibro)
                        .addGap(36, 36, 36)
                        .addComponent(btnConsultar)
                        .addGap(32, 32, 32)
                        .addComponent(btnExportar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibro)
                    .addComponent(btnConsultar)
                    .addComponent(btnExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblNombreLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEjemplaresVendidos)
                            .addComponent(lblTotalRecaudado)
                            .addComponent(lblTotalGanancias)))
                    .addComponent(jScrollPane2))
                .addContainerGap(52, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            ArchivoGrabacion archivoGrabacion = new ArchivoGrabacion();

            StringBuilder contenido = new StringBuilder();
            contenido.append("Fecha;Cliente;Número de Factura;Cantidad;Precio Venta;Total\n");

            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String fecha = (String) modeloTabla.getValueAt(i, 0);
                String cliente = (String) modeloTabla.getValueAt(i, 1);
                String numFactura = String.valueOf(modeloTabla.getValueAt(i, 2));
                String cantidad = String.valueOf(modeloTabla.getValueAt(i, 3));
                String precioVenta = String.valueOf(modeloTabla.getValueAt(i, 4));
                String total = String.valueOf(modeloTabla.getValueAt(i, 5));

                contenido.append(String.join(";", fecha, cliente, numFactura, cantidad, precioVenta, total));
                contenido.append("\n");
            }

            archivoGrabacion.grabarVentasCSV("VENTAS.csv", contenido.toString());
            JOptionPane.showMessageDialog(this, "Archivo exportado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al exportar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        consultarVentas();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
        this.visible = !this.visible;
        listaLibros.setListData(this.modelo.getListaLibros().toArray(new Libro[0]));
        mostrarLista();
    }//GEN-LAST:event_btnBuscarLibroActionPerformed

    private void listaLibrosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaLibrosValueChanged
        if (!listaLibros.isSelectionEmpty()) {
            txtIsbn.setText(listaLibros.getSelectedValue().getIsbn());
            consultarVentas();
            this.visible = false;
            mostrarLista();
        }


    }//GEN-LAST:event_listaLibrosValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEjemplaresVendidos;
    private javax.swing.JLabel lblNombreLibro;
    private javax.swing.JLabel lblTotalGanancias;
    private javax.swing.JLabel lblTotalRecaudado;
    private javax.swing.JList<Libro> listaLibros;
    public javax.swing.JTable tablaVentas;
    private javax.swing.JTextField txtIsbn;
    // End of variables declaration//GEN-END:variables
}

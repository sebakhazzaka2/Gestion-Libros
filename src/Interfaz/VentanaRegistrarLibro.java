package Interfaz;

import Dominio.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Agustin Gonzatto (277693)
 */
public class VentanaRegistrarLibro extends javax.swing.JFrame implements Observer {

    private Sistema modelo;
    private File selectedFile;
    private String extension;

    public VentanaRegistrarLibro(Sistema modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
        initComponents();
        cargarGeneros(modelo.getListaGeneros());
        cargarEditoriales(modelo.getListaEditoriales());

    }

    @Override
    public void update(Observable o, Object arg) {
        cargarGeneros(modelo.getListaGeneros());
        cargarEditoriales(modelo.getListaEditoriales());
        cargarAutores();
    }

    public void setSelectedFile(File unFile) {
        this.selectedFile = unFile;
    }

    public void cargarGeneros(ArrayList<Genero> generos) {
        lstGenero.setListData(generos.toArray(new Genero[0]));
    }

    public void cargarEditoriales(ArrayList<Editorial> editoriales) {
        lstEditorial.setListData(editoriales.toArray(new Editorial[0]));
    }

    public void cargarAutores() {
        Genero genero = lstGenero.getSelectedValue();
        if (genero != null) {
            lstAutor.setListData(this.modelo.getListaDeAutoresPorGenero(genero).toArray(new Autor[0]));
        }
    }
    
    public void limpiarCampos(){
        txtisbn.setText("");
        txtTitulo.getText();
        txtPC.setText("");
        txtPv.setText("");
        txtStock.setText("");
        lblImagen.setText("Sin Imagen");
        lblImagen.setIcon(null);
        txtTitulo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEditorial = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstGenero = new javax.swing.JList<>();
        txtTitulo = new javax.swing.JTextField();
        txtisbn = new javax.swing.JTextField();
        txtPv = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstAutor = new javax.swing.JList<>();
        lblImagen = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtPC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar un libro");

        jLabel1.setText("Autor:");

        jLabel2.setText("Género:");

        jLabel3.setText("Editorial:");

        jLabel4.setText("ISBN:");

        jLabel5.setText("Título:");

        jLabel6.setText("Precio de costo:");

        jLabel7.setText("Precio de venta:");

        btnSelect.setText("Seleccionar Imágen");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstEditorial);

        lstGenero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstGeneroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstGenero);

        jScrollPane4.setViewportView(lstAutor);

        lblImagen.setText("Sin Imagen");

        jLabel8.setText("Stock:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSelect)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtPC))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtPv, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnSelect)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton2)
                    .addComponent(txtPv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstGeneroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstGeneroMouseClicked
        cargarAutores();
    }//GEN-LAST:event_lstGeneroMouseClicked

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            this.extension = "";
            this.setSelectedFile(fileChooser.getSelectedFile());
            String nombreArchivo = selectedFile.getName();
            int indicePunto = nombreArchivo.lastIndexOf('.');
            this.extension = (nombreArchivo.substring(indicePunto));
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            Image img = imageIcon.getImage();
            Image imgEscalada = img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
            lblImagen.setText("");
            lblImagen.setIcon(iconoEscalado);
        } else {
            System.out.println("Selección de archivo cancelada.");
        }
    }//GEN-LAST:event_btnSelectActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String isbn = txtisbn.getText();
        String titulo = txtTitulo.getText();
        Editorial editorial = lstEditorial.getSelectedValue();
        Genero genero = lstGenero.getSelectedValue();
        Autor autor = lstAutor.getSelectedValue();
        String foto = "";
        try {
            if (txtPC.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingrese el precio de costo.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int costo = Integer.parseInt(txtPC.getText()); // Validación en try-catch
                if (txtPv.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Ingrese el precio de venta.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int venta = Integer.parseInt(txtPv.getText());
                    if (txtStock.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Ingrese el stock.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int stock = Integer.parseInt(txtStock.getText());
                        if (stock < 0) {
                            JOptionPane.showMessageDialog(this, "El stock debe ser mayor o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (isbn.equals("")) {
                                JOptionPane.showMessageDialog(this, "Ingrese un isbn.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                if (titulo.equals("")) {
                                    JOptionPane.showMessageDialog(this, "Ingrese un título.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    if (editorial == null) {
                                        JOptionPane.showMessageDialog(this, "Seleccione una editorial.", "Error", JOptionPane.ERROR_MESSAGE);
                                    } else {
                                        if (genero == null) {
                                            JOptionPane.showMessageDialog(this, "Seleccione un género.", "Error", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            if (autor == null) {
                                                JOptionPane.showMessageDialog(this, "Seleccione un autor.", "Error", JOptionPane.ERROR_MESSAGE);
                                            } else {
                                                if (!lblImagen.getText().equalsIgnoreCase("Sin Imagen")) {
                                                    foto = modelo.getDir()+"/Imagenes/"+isbn+this.extension;
                                                }
                                                if (this.modelo.registrarLibro(isbn, titulo, editorial, genero, autor, costo, venta, foto, stock)) {
                                                    modelo.guardarPortada(selectedFile, foto);
                                                    JOptionPane.showMessageDialog(this, "Libro registrado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                                                    limpiarCampos();
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "El ISBN ingresado ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Se deben ingresar números válidos en los campos de costo, venta y stock.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JList<Autor> lstAutor;
    private javax.swing.JList<Editorial> lstEditorial;
    private javax.swing.JList<Genero> lstGenero;
    private javax.swing.JTextField txtPC;
    private javax.swing.JTextField txtPv;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtisbn;
    // End of variables declaration//GEN-END:variables
}

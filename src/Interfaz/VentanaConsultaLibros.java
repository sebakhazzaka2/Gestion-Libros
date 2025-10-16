package Interfaz;
import Dominio.*;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Agustin Gonzatto (277693)
 */
public class VentanaConsultaLibros extends javax.swing.JFrame implements Observer {
    
    private Sistema modelo;
    private DefaultListModel<Libro> modeloListaLibros;
    
    public VentanaConsultaLibros(Sistema modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
        this.modeloListaLibros = new DefaultListModel<>();
        initComponents();
        cargarLibros();
    }
    
    @Override
    public void update(Observable o, Object arg) {
    }
    
    private void cargarLibros() {
        ArrayList<Libro> listaLibros = modelo.getListaLibros();
        panelLibros.removeAll(); 

        for (Libro libro : listaLibros) {
            JButton libroButton = crearBotonLibro(libro);
            panelLibros.add(libroButton);
        }

        panelLibros.revalidate();
        panelLibros.repaint();
    }
    
    private void cargarLibrosFiltrados(ArrayList<Libro> librosFiltrados) {
        panelLibros.removeAll(); 

        for (Libro libro : librosFiltrados) {
            JButton libroButton = crearBotonLibro(libro);
            panelLibros.add(libroButton);
        }

        panelLibros.revalidate();
        panelLibros.repaint();
    }
    
    private JButton crearBotonLibro(Libro libro) {
        JButton botonLibro = new JButton();

        if (libro.getFoto() != "") {
            ImageIcon imagenIcon = new ImageIcon(libro.getFoto());
            Image imagenEscalada = imagenIcon.getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);
            botonLibro.setIcon(new ImageIcon(imagenEscalada));
            System.out.println("Añadiendo botón con foto para el libro: " + libro.getTitulo()+" "+libro.getFoto());
        } else {
            botonLibro.setText(libro.getIsbn());
            System.out.println("Añadiendo botón sin foto para el libro: " + libro.getFoto() + " " + libro.getTitulo());
        }
        botonLibro.addActionListener(new LibroListener(libro));
        return botonLibro;
    }
    
    private class LibroListener implements ActionListener {
        private Libro libro;

        public LibroListener(Libro libro) {
            this.libro = libro;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null,
                "ISBN: " + libro.getIsbn() + "\n" +
                "Título: " + libro.getTitulo() + "\n" +
                "Autor: " + libro.getAutor().getNombre() + "\n" +
                "Género: " + libro.getGenero().getNombre() + "\n" +
                "Costo: " + libro.getCosto() + "\n" +
                "Stock: " + libro.getStock(),
                "Detalles del Libro",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        generoField = new javax.swing.JTextField();
        tituloField = new javax.swing.JTextField();
        autorField = new javax.swing.JTextField();
        consultarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelLibros = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de libros");

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Genero");

        jLabel2.setText("Autor");

        jLabel3.setText("Libro");

        jScrollPane1.setToolTipText("");
        jScrollPane1.setViewportView(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tituloField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(autorField)
                    .addComponent(generoField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(consultarButton)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(generoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(autorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tituloField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jScrollPane1.getAccessibleContext().setAccessibleName("");

        panelLibros.setLayout(new java.awt.GridLayout(0, 4));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
    String titulo = tituloField.getText().toLowerCase();
    String autor = autorField.getText().toLowerCase();
    String genero = generoField.getText().toLowerCase();
    ArrayList<Libro> librosFiltrados = this.modelo.getLibrosFiltrados(titulo,autor,genero);
    if (librosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron libros con los criterios proporcionados.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE); 
        }
        else { 
            cargarLibrosFiltrados(librosFiltrados);
            System.out.println("Se encontraron " + librosFiltrados.size() + " libros.");
        }

        tituloField.setText("");
        autorField.setText("");
        generoField.setText("");
    }//GEN-LAST:event_consultarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autorField;
    private javax.swing.JButton consultarButton;
    private javax.swing.JTextField generoField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelLibros;
    private javax.swing.JTextField tituloField;
    // End of variables declaration//GEN-END:variables
}


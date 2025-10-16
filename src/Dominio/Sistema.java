package Dominio;

import java.util.ArrayList;
import Interfaz.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import javax.swing.table.DefaultTableModel;


public class Sistema extends Observable implements Serializable {

    private ArrayList<Editorial> listaEditoriales;
    private ArrayList<Genero> listaGeneros;
    private ArrayList<Autor> listaAutores;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Venta> listaVentas;
    private Map<Libro, Integer> ventas;
    private int contadorFacturas;

    private static final long serialVersionUID = 1L;

    public Sistema(ArrayList<Editorial> listaEditoriales, ArrayList<Genero> listaGeneros, ArrayList<Autor> listaAutores, ArrayList<Libro> listaLibros, ArrayList<Venta> listaVentas, int contadorFacturas) {
        this.listaEditoriales = listaEditoriales;
        this.listaGeneros = listaGeneros;
        this.listaAutores = listaAutores;
        this.listaLibros = listaLibros;
        this.listaVentas = listaVentas;
        this.contadorFacturas = contadorFacturas;
    }

    public Sistema() {
        this.listaEditoriales = new ArrayList<Editorial>();
        this.listaGeneros = new ArrayList<Genero>();
        this.listaAutores = new ArrayList<Autor>();
        this.listaLibros = new ArrayList<Libro>();
        this.listaVentas = new ArrayList<Venta>();
        this.ventas = new HashMap<Libro, Integer>();
        this.contadorFacturas = 1;
    }

    public void setVentas(Map<Libro, Integer> ventas) {
        this.ventas = ventas;
    }

    public void setListaEditoriales(ArrayList<Editorial> listaEditoriales) {
        this.listaEditoriales = listaEditoriales;
    }

    public void setListaGeneros(ArrayList<Genero> listaGeneros) {
        this.listaGeneros = listaGeneros;
    }

    public void setListaAutores(ArrayList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void setContadorFacturas(int contadorFacturas) {
        this.contadorFacturas = contadorFacturas;
    }

    public ArrayList<Editorial> getListaEditoriales() {
        return listaEditoriales;
    }

    public ArrayList<Genero> getListaGeneros() {
        return listaGeneros;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public Map<Libro, Integer> getVentas() {
        return ventas;
    }

    public int getContadorFacturas() {
        return contadorFacturas;
    }

    public String getDir() {
        return System.getProperty("user.dir");
    }

    public void guardarSistema() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("salida"));
            out.writeObject(this);
            out.close();
            System.out.println("Sistema guardado correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sistema cargarSistema() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("salida"));
            Sistema sistema = (Sistema) in.readObject();
            in.close();
            System.out.println("Sistema cargado correctamente");
            return sistema;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existeEditorial(String nombre) {
        for (Editorial e : this.getListaEditoriales()) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarEditorial(String nombre, String pais) {
        boolean hecho = false;
        if (!existeEditorial(nombre)) {
            Editorial e = new Editorial(nombre, pais);
            this.getListaEditoriales().add(e);
            setChanged();
            notifyObservers();
            hecho = true;
        }
        return hecho;
    }

    public boolean existeGenero(String nombre) {
        for (Genero g : this.getListaGeneros()) {
            if (g.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarGenero(String nombre, String desc) {
        boolean hecho = false;
        if (!existeGenero(nombre)) {
            Genero g = new Genero(nombre, desc);
            this.getListaGeneros().add(g);
            setChanged();
            notifyObservers();
            hecho = true;
        }
        return hecho;
    }

    public boolean existeAutor(String nombre) {
        for (Autor a : this.getListaAutores()) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarAutor(String nombre, String nacionalidad, ArrayList<Genero> generos) {
        boolean hecho = false;
        if (!existeAutor(nombre)) {
            Autor a = new Autor(nombre, nacionalidad, generos);
            this.getListaAutores().add(a);
            setChanged();
            notifyObservers();
            hecho = true;
        }
        return hecho;
    }

    public ArrayList<Autor> getListaDeAutoresPorGenero(Genero unGenero) {
        ArrayList<Autor> res = new ArrayList<Autor>();
        for (Autor a : this.getListaAutores()) {
            if (a.getGeneros().contains(unGenero)) {
                res.add(a);
            }
        }
        return res;
    }

    public String registrarVenta(String fecha, String nombre, int total) {
        int sum = 0;
        boolean hayVenta = false;
        String mensaje = "Venta realizada correctamente\n";
        for (Map.Entry<Libro, Integer> entry : this.getVentas().entrySet()) {
            Libro libroAComprar = entry.getKey();
            int cantidadAComprar = entry.getValue();
            for (Libro libro : this.getListaLibros()) {
                if (libro.getIsbn().equals(libroAComprar.getIsbn())) {
                    if (libro.getStock() > 0) {
                        hayVenta = true;
                        if (libro.getStock() < cantidadAComprar) {
                            mensaje += "Solo quedan: " + libro.getStock() + " ejemplares de " + libro.getTitulo() + "\n";
                            entry.setValue(libro.getStock());
                            libro.setStock(0);
                        } else {
                            libro.setStock(libro.getStock() - cantidadAComprar);
                        }
                    }

                    break;
                }
            }
            sum += libroAComprar.getVenta() * cantidadAComprar;
        }
        if (sum != total) {
            mensaje += "Se ajustó el total a " + sum;
        }
        if (hayVenta){
            this.getListaVentas().add(new Venta(fecha, nombre, this.getContadorFacturas(), new HashMap<>(this.getVentas()), sum));
            this.setContadorFacturas(getContadorFacturas() + 1);
        }else{
            mensaje = "No hay ejemplares en stock. No se realizó la venta";
        }
        this.getVentas().clear();
        setChanged();
        notifyObservers();
        return mensaje;
    }

    public boolean existeISBN(String isbn) {
        for (Libro l : this.getListaLibros()) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    public boolean registrarLibro(String isbn, String titulo, Editorial editorial, Genero genero, Autor autor, int costo, int venta, String foto, int stock) {
        boolean res = false;
        if (!this.existeISBN(isbn)) {
            Libro nuevoLibro = new Libro(isbn, titulo, editorial, genero, autor, costo, venta, foto, stock);
            ArrayList<Libro> listaLibros = this.getListaLibros();
            int i = 0;
            while (i < listaLibros.size() && listaLibros.get(i).getTitulo().compareToIgnoreCase(titulo) < 0) {
                i++;
            }
            listaLibros.add(i, nuevoLibro);
            res = true;
        }
        setChanged();
        notifyObservers();
        return res;
    }

    public void guardarPortada(File selectedFile, String destino) {
        if (selectedFile != null) {
            File carpeta = new File(getDir() + "/Imagenes");
            if (carpeta.exists() && carpeta.isDirectory()) {
                System.out.println("La carpeta existe.");
            } else {
                System.out.println("Creo la carpeta");
                if (carpeta.mkdir()) {
                    System.out.println("Carpeta creada exitosamente.");
                } else {
                    System.out.println("No se pudo crear la carpeta.");
                    return;
                }
            }
            try {
                System.out.println(selectedFile.toPath());
                System.out.println(Paths.get(destino).toString());
                System.out.println(destino);
                Files.copy(selectedFile.toPath(), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Archivo copiado exitosamente a: " + destino);
            } catch (IOException e) {
                System.out.println("Error al copiar el archivo: " + e.getMessage() + "\n" + e.getLocalizedMessage());
            }
        } else {
            System.out.println("No hay archivo seleccionado para copiar.");
        }
        setChanged();
        notifyObservers();
    }

    public Venta obtenerFacturaPorNumero(int numero) {
        Venta res = null;
        for (Venta venta : this.getListaVentas()) {
            if (venta.getNumeroFactura() == numero) {
                res = venta;
            }
        }
        return res;
    }

    public void borrarVenta(Venta venta) {
        for (Map.Entry<Libro, Integer> entry : venta.getLibrosVendidos().entrySet()) {
            for (Libro l : this.getListaLibros()) {
                if (l.getIsbn().equals(entry.getKey().getIsbn())) {
                    l.setStock(l.getStock() + entry.getValue());
                    System.out.println("bajo los stocks");
                }
            }
        }
        getListaVentas().removeIf(v -> v.getNumeroFactura() == venta.getNumeroFactura());
        System.out.println(venta);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Libro> getLibrosFiltrados(String titulo, String autor, String genero) {
        ArrayList<Libro> listaLibros = getListaLibros();
        ArrayList<Libro> librosFiltrados = new ArrayList<>();

        titulo = titulo.trim().toLowerCase();
        autor = autor.trim().toLowerCase();
        genero = genero.trim().toLowerCase();

        System.out.println("Buscando libros con Título: " + titulo + ", Autor: " + autor + ", Género: " + genero);
        for (Libro libro : listaLibros) {
            boolean coincideTitulo = !titulo.isEmpty() && libro.getTitulo().toLowerCase().equals(titulo);
            boolean coincideAutor = !autor.isEmpty() && libro.getAutor() != null && libro.getAutor().getNombre().toLowerCase().equals(autor);
            boolean coincideGenero = !genero.isEmpty() && libro.getGenero() != null && libro.getGenero().getNombre().toLowerCase().equals(genero);

            if (coincideTitulo || coincideAutor || coincideGenero) {
                librosFiltrados.add(libro);
            }
        }

        return librosFiltrados;
    }

    public boolean existeLibro(String isbn) {
        for (Libro libro : this.getListaLibros()) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Venta> obtenerVentasOrdenadasPorFactura(String isbn) {
        ArrayList<Venta> ventasFiltradas = new ArrayList<>();
        for (Venta venta : listaVentas) {
            for (Libro libro : venta.getLibrosVendidos().keySet()) {
                if (libro.getIsbn().equals(isbn)) {
                    ventasFiltradas.add(venta);
                    break;
                }
            }
        }
        ventasFiltradas.sort((v1, v2) -> Integer.compare(v2.getNumeroFactura(), v1.getNumeroFactura()));
        return ventasFiltradas;
    }

    public Map<String, Double> calcularResumenVentas(String isbn) {
        if (!existeLibro(isbn)) {
            throw new IllegalArgumentException("Libro no encontrado con ISBN: " + isbn);
        }

        ArrayList<Venta> ventas = obtenerVentasOrdenadasPorFactura(isbn);
        int totalEjemplares = 0;
        double totalRecaudado = 0;
        double totalGanancia = 0;

        Libro libro = null;
        for (Libro l : this.getListaLibros()) {
            if (l.getIsbn().equalsIgnoreCase(isbn)) {
                libro = l;
                break;
            }
        }

        for (Venta venta : ventas) {
            Map<Libro, Integer> librosVendidos = venta.getLibrosVendidos();

            if (librosVendidos.containsKey(libro)) {
                int cantidadVendida = librosVendidos.get(libro);
                double ganancia = (venta.getPrecioVenta(isbn) - libro.getCosto()) * cantidadVendida;
                totalEjemplares += cantidadVendida;
                totalRecaudado += cantidadVendida * venta.getPrecioVenta(isbn);
                totalGanancia += ganancia;
            }
        }

        Map<String, Double> resumen = new HashMap<>();
        resumen.put("ejemplaresVendidos", (double) totalEjemplares);
        resumen.put("totalRecaudado", totalRecaudado);
        resumen.put("totalGanancia", totalGanancia);

        return resumen;
    }

    public ArrayList<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(listaLibros);
    }

    public ArrayList<Libro> obtenerLibrosPorIsbn(String isbn) {
        ArrayList<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                librosEncontrados.add(libro);
            }
        }

        return librosEncontrados;
    }

    public void exportarVentasAArchivo(File archivo, DefaultTableModel modelo) throws IOException {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("Fecha,Cliente,Numero de Factura,Cantidad,Precio Venta,Total\n");

            for (int i = 0; i < modelo.getRowCount(); i++) {
                String fecha = (String) modelo.getValueAt(i, 0);
                String cliente = (String) modelo.getValueAt(i, 1);
                String factura = (String) modelo.getValueAt(i, 2);
                String cantidad = String.valueOf(modelo.getValueAt(i, 3));
                String precioVenta = String.valueOf(modelo.getValueAt(i, 4));
                String total = String.valueOf(modelo.getValueAt(i, 5));

                writer.write(fecha + "," + cliente + "," + factura + "," + cantidad + "," + precioVenta + "," + total + "\n");
            }
        }
    }

    public Libro obtenerLibroPorISBN(String isbn) {
        for (Libro libro : this.getListaLibros()) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }
    
   

    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        VentanaMenu vent = new VentanaMenu(sistema);
        vent.setVisible(true);
    }

}

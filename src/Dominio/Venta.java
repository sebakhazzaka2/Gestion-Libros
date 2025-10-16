package Dominio;

import java.io.Serializable;
import java.util.Map;


public class Venta implements Serializable {

    private String fecha;
    private String cliente;
    private int numeroFactura;
    private Map<Libro, Integer> librosVendidos;
    private int total;
    private int precioVenta;
    private int cantidad;

    public Venta(String fecha, String cliente, int numeroFactura, Map<Libro, Integer> librosVendidos, int total) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroFactura = numeroFactura;
        this.librosVendidos = librosVendidos;
        this.total = total;

    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setLibrosVendidos(Map<Libro, Integer> librosVendidos) {
        this.librosVendidos = librosVendidos;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public Map<Libro, Integer> getLibrosVendidos() {
        return librosVendidos;
    }

    public int getPrecioVenta(String isbn) {
        int precioVenta = 0;
        for (Libro libro : this.librosVendidos.keySet()) {
            if (libro.getIsbn().equals(isbn)) {
                precioVenta = libro.getVenta();
            }
        }
        return precioVenta;
    }

    public int getCantidad(String isbn) {
        int cantidad = 0;
        for (Libro libro : this.librosVendidos.keySet()) {
            if (libro.getIsbn().equals(isbn)) {
                cantidad = this.librosVendidos.get(libro);
            }
        }
        return cantidad;
    }

}

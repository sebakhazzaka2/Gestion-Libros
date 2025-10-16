package Dominio;

import java.awt.Image;
import java.io.File;
import java.io.Serializable;


public class Libro implements  Serializable{

    private String isbn;
    private String titulo;
    private Editorial editorial;
    private Genero genero;
    private Autor autor;
    private int costo;
    private int venta;
    private String foto;
    private int stock;

    public Libro(String isbn, String titulo, Editorial editorial, Genero genero, Autor autor, int costo, int venta, String foto, int stock) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.genero = genero;
        this.autor = autor;
        this.costo = costo;
        this.venta = venta;
        this.foto = foto;
        this.stock = stock;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public Genero getGenero() {
        return genero;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getCosto() {
        return costo;
    }

    public int getVenta() {
        return venta;
    }

    public String getFoto() {
        return foto;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString (){
        return this.getIsbn() + " - " + this.getTitulo();
    }
}

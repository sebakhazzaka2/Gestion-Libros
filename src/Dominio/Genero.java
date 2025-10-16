package Dominio;

import java.io.Serializable;


public class Genero implements  Serializable{

    private String nombre; //Unico
    private String descripcion;

    public Genero(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString(){
        return this.getNombre() + " - " + this.getDescripcion();
    }
}

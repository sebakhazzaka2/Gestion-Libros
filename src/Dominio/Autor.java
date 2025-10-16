package Dominio;

import java.io.Serializable;
import java.util.ArrayList;


public class Autor implements  Serializable{

    private String nombre; //Unico
    private String nacionalidad;
    private ArrayList<Genero> generos;

    public Autor(String nombre, String nacionalidad, ArrayList<Genero> generos) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.generos = generos;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    @Override
    public String toString(){
        return this.getNombre() + " - " + this.getNacionalidad();
    }
    
}

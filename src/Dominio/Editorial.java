package Dominio;

import java.io.Serializable;


public class Editorial implements  Serializable{

    private String nombre; //Unico
    private String pais;

    public Editorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString(){
        return this.getNombre();
    }
}

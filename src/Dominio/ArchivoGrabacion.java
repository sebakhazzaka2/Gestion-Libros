/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Formatter;
/**
 *
 * @author Usuario
 */
public class ArchivoGrabacion {

    private Formatter out;

    public ArchivoGrabacion() {
    }
    
    public void ArchivoGrabacion(String unNombre, boolean ext) throws IOException {
        try {
            this.out = new Formatter(new FileWriter(unNombre, ext));
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    public void grabarLineas(String linea) {
        this.out.format("%s%n", linea);
    }

    public void cerrar() {
        this.out.close();
    }
    
    public void grabarVentasCSV(String nombreArchivo, String contenido) throws IOException {
        File archivo = new File(nombreArchivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido);
        }
    }    
}
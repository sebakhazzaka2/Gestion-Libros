/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Usuario
 */
public class ArchivoLectura {
    private BufferedReader reader;

    public void ArchivoLectura(String unNombre) throws IOException {
        try {
            this.reader = new BufferedReader(new FileReader(unNombre));
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo para lectura: " + e);
            throw e;
        }
    }

    public String leerLinea() throws IOException {
        return reader.readLine(); 
    }

    public void cerrar() throws IOException {
        if (reader != null) {
            reader.close();
        }
    }
    
    public String leerArchivo(String nombreArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        File archivo = new File(nombreArchivo);
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }
}


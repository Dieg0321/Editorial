/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorial.views;

import editorial.models.PropertiesLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Properties;
/**
 *
 * @author Diego
 */
public class Vista {

    private BufferedReader br;

    public Vista() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void mostrarString(String texto) {
        System.out.println(texto);
    }

    public void mostrarMensajeError(String textoError) {
        System.err.println(textoError);
    }

    public int ObtenerInt(String mensaje, String mensajeError) {
        System.out.println(mensaje);
        try {
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException ex) {
            System.err.println(mensajeError);
        }
        return ObtenerInt(mensaje, mensajeError);
    }

    public double ObtenerDouble(String mensaje, String mensajeError) {
        System.out.println(mensaje);
        try {
            return Double.parseDouble(br.readLine());
        } catch (NumberFormatException | IOException ex) {
            System.err.println(mensajeError);
        }
        return ObtenerInt(mensaje, mensajeError);
    }

    public String obtenerString(String mensaje, String mensajeError) {
        System.out.println(mensaje);
        try {
            return br.readLine();
        } catch (IOException ex) {
            System.err.println(mensajeError);
        }
        return obtenerString(mensaje, mensajeError);
    }

    public LocalDate obtenerFecha(String mensaje, String mensajeError) {
        System.out.println(mensaje);
        try {
            return LocalDate.parse(br.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException | IOException ex) {
            System.err.println(mensajeError);
        }
        return obtenerFecha(mensaje, mensajeError);
    }

    public void mostrarMensajeFinal(String mensaje, int estado) {
        System.out.println(mensaje);
        System.exit(estado);
    }

    public void mostrarStringFormateado(String texto, Object[] datos) {
        System.out.printf(texto, datos);
    }

 
}

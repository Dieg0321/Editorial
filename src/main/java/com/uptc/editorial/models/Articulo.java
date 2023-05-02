/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONObject;

/**
 *
 * @author Diego
 */
public class Articulo extends Publicacion {

    private String DOI;
    private LocalDate fechaPublicacion;
    private String tipo;

    public Articulo(String DOI, String titulo, String autor, double precio, LocalDate fechaPublicacion, String tipo) {
        super(titulo, autor, precio);
        this.DOI = DOI;
        this.fechaPublicacion = fechaPublicacion;
        this.tipo = tipo;
    }
    
    public Articulo(){
    }

    public String getDOI() {
        return DOI;
    }

    public void setDOI(String DOI) {
        this.DOI = DOI;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTipoArticulo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format(PropertiesLoader.loadProperties().getProperty("output.DOI")
                + PropertiesLoader.loadProperties().getProperty("output.fecha_publicacion")
                + PropertiesLoader.loadProperties().getProperty("output.publicacion")
                + PropertiesLoader.loadProperties().getProperty("output.tipo")
                + PropertiesLoader.loadProperties().getProperty("output.precio"),
                getObjetoDatos());
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        json.put("DOI", DOI);
        json.put("Publicacion", fechaPublicacion.toString());
        json.put("Tipo", tipo);
        return json;
    }

    @Override
    public void fromJson(JSONObject volJson) {
        super.fromJson(volJson);
        this.DOI = volJson.get("DOI").toString();
        this.fechaPublicacion = LocalDate.parse(volJson.get("Publicacion").toString());
        this.tipo = volJson.get("Tipo").toString();
    }

    @Override
    public Object[] getObjetoDatos() {
        return new Object[]{getDOI(), getFechaPublicacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), getTitulo(), getAutor(), getTipoArticulo(), getPrecio()};
    }

}

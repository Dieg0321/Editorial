/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Diego
 */
public class Patente extends Publicacion {

    private String CPAT;
    private String asignatario;
    private LocalDate fechaSolicitud;
    private LocalDate fechaConcesion;
    private int vigencia;

    public Patente(String CPAT, String asignatario, LocalDate fechaSolicitud, LocalDate fechaConcesion, int vigencia, String titulo, String autor, double precio) {
        super(titulo, autor, precio);
        this.CPAT = CPAT;
        this.asignatario = asignatario;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaConcesion = fechaConcesion;
        this.vigencia = vigencia;
    }

    public Patente(){   
    }
    
    public String getCPAT() {
        return CPAT;
    }

    public void setCPAT(String CPAT) {
        this.CPAT = CPAT;
    }

    public String getAsignatario() {
        return asignatario;
    }

    public void setAsignatario(String asignatario) {
        this.asignatario = asignatario;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaConcesion() {
        return fechaConcesion;
    }

    public void setFechaConcesion(LocalDate fechaConcesion) {
        this.fechaConcesion = fechaConcesion;
    }

    public int getDuracion() {
        return vigencia;
    }

    public void setDuracion(int duracion) {
        this.vigencia = duracion;
    }

    @Override
    public String toString() {
        return String.format(PropertiesLoader.loadProperties().getProperty("output.CPAT")
                + PropertiesLoader.loadProperties().getProperty("output.pat_fechas")
                + PropertiesLoader.loadProperties().getProperty("output.publicacion")
                + PropertiesLoader.loadProperties().getProperty("output.patente")
                + PropertiesLoader.loadProperties().getProperty("output.precio"),
                getObjetoDatos());
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        json.put("CPAT", CPAT);
        json.put("Asignatario", asignatario);
        json.put("Solicitud", fechaSolicitud.toString());
        json.put("Concesion", fechaConcesion.toString());
        json.put("Vigencia", vigencia);
        return json;
    }
    
    @Override
    public void fromJson(JSONObject json) {
        super.fromJson(json);
        this.CPAT = json.get("CPAT").toString();
        this.asignatario = json.get("Asignatario").toString();
        this.fechaSolicitud = LocalDate.parse(json.get("Solicitud").toString());
        this.fechaConcesion = LocalDate.parse(json.get("Concesion").toString());
        this.vigencia = Integer.parseInt(json.get("Vigencia").toString());
    }

    @Override
    public Object[] getObjetoDatos() {
        return new Object[]{getCPAT(), getFechaSolicitud(), getFechaConcesion(), getTitulo(), getAutor(), getAsignatario(), getDuracion(), getPrecio()};
    }

}

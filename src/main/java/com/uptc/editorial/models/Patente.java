/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.time.LocalDate;

/**
 *
 * @author Diego
 */
public class Patente extends Publicacion {

    private String CPAT;
    private String asignatario;
    private LocalDate fechaSolicitud;
    private LocalDate fechaConcesion;
    private int duracion;

    public Patente(String CPAT, String asignatario, LocalDate fechaSolicitud, LocalDate fechaConcesion, int duracion, String titulo, String autor, double precio) {
        super(titulo, autor, precio);
        this.CPAT = CPAT;
        this.asignatario = asignatario;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaConcesion = fechaConcesion;
        this.duracion = duracion;
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
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
    public Object[] getObjetoDatos() {
        return new Object[]{getCPAT(), getFechaSolicitud(), getFechaConcesion(), getTitulo(), getAutor(), getAsignatario(), getDuracion(), getPrecio()};
    }

}

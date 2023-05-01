/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import org.json.simple.JSONObject;
/**
 *
 * @author Diego
 */
public abstract class Publicacion {

    private String titulo;
    private String autor;
    private double precio;

    public Publicacion(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public Publicacion() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return getClass().getSimpleName();
    }

    public abstract Object[] getObjetoDatos();
         

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("TipoPublicacion", this.getClass().getSimpleName());
        json.put("Titulo", this.titulo);
        json.put("Autor", this.autor);
        json.put("Precio", this.precio);
        return json;
    }

}

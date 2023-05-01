/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Diego
 */
public class Libro extends Publicacion {

    private String ISBN;
    private List<Tomo> listaVolumenes;

    public Libro() {
    }

    public Libro(String titulo, String autor, String ISBN, double precio) {
        super(titulo, autor, precio);
        this.ISBN = ISBN;
        listaVolumenes = new ArrayList<>();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumeroVolumenes() {
        return listaVolumenes.size();
    }

    public List<Tomo> getListaVolumenes() {
        return listaVolumenes;
    }

    public void setListaVolumenes(List<Tomo> listaVolumenes) {
        this.listaVolumenes = listaVolumenes;
    }

    @Override
    public String toString() {
        return String.format(PropertiesLoader.loadProperties().getProperty("output.ISBN")
                + PropertiesLoader.loadProperties().getProperty("output.publicacion")
                + PropertiesLoader.loadProperties().getProperty("output.precio"),
                getObjetoDatos());
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = super.toJSON();
        JSONArray jsonArray = new JSONArray();
        json.put("ISBN", ISBN);
        for (Tomo vol : listaVolumenes) {
            jsonArray.add(vol.toJSON());
        }
        json.put("Volumenes", jsonArray);
        return json;
    }

    @Override
    public Object[] getObjetoDatos() {
        return new Object[]{getISBN(), getTitulo(), getAutor(), getPrecio()};
    }

}

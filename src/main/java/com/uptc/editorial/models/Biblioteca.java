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
 * @author bgdie
 */
public class Biblioteca {

    private JSONArray publicacionesJson;
    private List<Publicacion> publicaciones;

    public Biblioteca(){
        publicaciones = new ArrayList<>();
        publicacionesJson = new JSONArray();
    }
    
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }
    
    public void agregarPublicacionJson(Publicacion publicacion){
        publicacionesJson.add(publicacion.toJSON());
    }
    
    public void agregarLibro(Libro libro){
        publicaciones.add(libro);
    }
    
    public void agregarRevista(Revista revista){
        publicaciones.add(revista);
    }
    
    public void agregarArticulo(Articulo articulo){
        publicaciones.add(articulo);
    }

    public int getTamañoLista(){
        return publicaciones.size();
    }
    
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public JSONArray getPublicacionesJson() {
        return publicacionesJson;
    }

    public void setPublicacionesJson(JSONArray publicacionesJson) {
        this.publicacionesJson = publicacionesJson;
    }
    
    
    
}

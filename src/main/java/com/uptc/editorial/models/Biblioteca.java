/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bgdie
 */
public class Biblioteca {

    private List<Publicacion> publicaciones;

    public Biblioteca(){
        publicaciones = new ArrayList<>();
    }
    
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
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
    
    
    
}

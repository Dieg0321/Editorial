/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorial.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public abstract class Publicacion {
    
    private String titulo;
    private String autor;
    private double precio;
    List<Tomo> listaVolumenes;

    public Publicacion(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.listaVolumenes = new ArrayList<>();
    }
    
    public Publicacion(){
        
    }
    
    protected abstract void setExtension(Object informacionExtension);
    
    protected abstract Object getExtension();

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

    public List<Tomo> getListaVolumenes() {
        return listaVolumenes;
    }
    
    public String getTipo(){
        return getClass().getSimpleName();
    }
    
    public abstract boolean agregarVolumen(Tomo tomo);

    public abstract Object[] getObjetoDatos();
    
}

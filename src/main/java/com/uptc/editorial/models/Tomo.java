/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

/**
 *
 * @author Diego
 */
public class Tomo {
    
    private byte numeroVolumen;
    private String titulo;
    private int numeroPaginas;

    public Tomo(byte numeroVolumen, String titulo, int numeroPaginas) {
        this.numeroVolumen = numeroVolumen;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
    }

    public Tomo() {
    }
    
    public byte getNumeroVolumen(){
        return numeroVolumen;
    }
    
    public void SetNumeroVolumen (byte numeroVolumen){
        this.numeroVolumen=numeroVolumen;
    }
    
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public int getNumeroPaginas() {
    return numeroPaginas;
    }

    public void setNumeroPaginas(int NumeroPaginas) {
        this.numeroPaginas = NumeroPaginas;
    }
    
    public Object[] getObjetoDatos(){
        return new Object[]{getNumeroVolumen(), getTitulo(), getNumeroPaginas()};
    }
}

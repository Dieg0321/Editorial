/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorial.models;

/**
 *
 * @author Diego
 */
public class Revista extends Publicacion {

    private String ISSN;
    private String periodicidad;
    private int numero;
    private int numeroPaginas;

    public Revista(String ISSN, String periodicidad, int numero, int numeroPaginas, String titulo, String autor, double precio) {
        super(titulo, autor, precio);
        this.ISSN = ISSN;
        this.periodicidad = periodicidad;
        this.numero = numero;
        this.numeroPaginas = numeroPaginas;
    }

    public Revista() {
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setExtension(Object informacionExtension) {
        numeroPaginas = ((Integer) informacionExtension);
    }

    @Override
    public Object getExtension() {
        return numeroPaginas;
    }

    @Override
    public boolean agregarVolumen(Tomo tomo) {
        return this.listaVolumenes.add(tomo);
    }

    @Override
    public String toString() {
        return String.format(PropertiesLoader.loadProperties().getProperty("output.ISSN")
                + PropertiesLoader.loadProperties().getProperty("output.publicacion")
                + PropertiesLoader.loadProperties().getProperty("output.revista")
                + PropertiesLoader.loadProperties().getProperty("output.precio"),
                 getObjetoDatos());
    }

    @Override
    public Object[] getObjetoDatos() {
        return new Object[]{getISSN(), getTitulo(), getAutor(), getNumero(), getNumeroPaginas(), getPeriodicidad(), getPrecio()};
    }
}

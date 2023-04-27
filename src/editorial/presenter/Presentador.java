/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorial.presenter;

import editorial.models.PropertiesLoader;
import editorial.models.Articulo;
import editorial.models.Biblioteca;
import editorial.models.Libro;
import editorial.models.Patente;
import editorial.models.Publicacion;
import editorial.models.Revista;
import editorial.models.Tomo;
import editorial.views.Vista;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Diego Beltran
 */
public class Presentador {

    private final Properties properties;
    private Biblioteca biblioteca;
    private Vista vista;

    public Presentador() {
        vista = new Vista();
        biblioteca = new Biblioteca();
        properties = PropertiesLoader.loadProperties(); //Carga los mensajes para mostrar por consola
    }

    public void administrarMenuPrincipal() {
        int inputUsuario = vista.ObtenerInt(properties.getProperty("menu.principal"), properties.getProperty("error.no_valido"));
        Publicacion publicacion = null;
        switch (inputUsuario) {
            case 1:
                publicacion = crearLibro();
                administrarAgregarVolumen(publicacion);
                
                break;
            case 2:
                publicacion = crearRevista();
                administrarAgregarVolumen(publicacion);
                break;
            case 3:
                publicacion = crearArticulo();
                break;
            case 4:
                publicacion = crearPatente();
                break;
                
            case 5:
                mostrarPublicaciones();
                administrarMenuPrincipal();
            case 0:
                vista.mostrarMensajeFinal(properties.getProperty("correcto.final"), inputUsuario);
            default:
                vista.mostrarMensajeError(properties.getProperty("error.no_valido"));
                administrarMenuPrincipal();
        }
        biblioteca.agregarPublicacion(publicacion);
        administrarMenuPrincipal();
    }

    public void administrarAgregarVolumen(Publicacion publicacion) {
        String inputUsuario = vista.obtenerString(properties.getProperty("menu.volumen"), properties.getProperty("error.no_valido"));
        if (inputUsuario.equalsIgnoreCase("s") || inputUsuario.equalsIgnoreCase("si")) {
            int cantidadVolumenes = vista.ObtenerInt(properties.getProperty("input.cantidad_volumen"), properties.getProperty("error.no_valido"));
            for (int i = 0; i < cantidadVolumenes; i++) {
                if (publicacion.agregarVolumen(crearVolumen())) {
                    vista.mostrarString(properties.getProperty("correcto.tomo"));
                } else {
                    vista.mostrarMensajeError(properties.getProperty("error.tomo"));
                }
            }
        } else if (!inputUsuario.equalsIgnoreCase("n") && !inputUsuario.equalsIgnoreCase("no")) {
            vista.mostrarMensajeError(properties.getProperty("error.no_valido"));
            administrarAgregarVolumen(publicacion);
        }

    }

    private Tomo crearVolumen() {
        byte numeroVolumen = (byte) vista.ObtenerInt(properties.getProperty("input.volumen"), properties.getProperty("error.no_valido"));
        String titulo = vista.obtenerString(properties.getProperty("input.titulo"), properties.getProperty("error.no_valido"));
        int numeroPaginas = vista.ObtenerInt(properties.getProperty("input.numero_paginas"), properties.getProperty("error.no_valido"));
        return new Tomo(numeroVolumen, titulo, numeroPaginas);
    }

    private Libro crearLibro() {
        String titulo = vista.obtenerString(properties.getProperty("input.titulo"), properties.getProperty("error.no_valido"));
        String autor = vista.obtenerString(properties.getProperty("input.autor"), properties.getProperty("error.no_valido"));
        String ISBN = vista.obtenerString(properties.getProperty("input.ISBN"), properties.getProperty("error.no_valido"));
        double precio = vista.ObtenerDouble(properties.getProperty("input.precio"), properties.getProperty("error.no_valido"));
        return new Libro(titulo, autor, ISBN, precio);
    }

    private Revista crearRevista() {
        String titulo = vista.obtenerString(properties.getProperty("input.titulo"), properties.getProperty("error.no_valido"));
        String autor = vista.obtenerString(properties.getProperty("input.autor"), properties.getProperty("error.no_valido"));
        String ISSN = vista.obtenerString(properties.getProperty("input.ISSN"), properties.getProperty("error.no_valido"));
        int numero = vista.ObtenerInt(properties.getProperty("input.numero_revista"), properties.getProperty("error.no_valido"));
        int numeroPaginas = vista.ObtenerInt(properties.getProperty("input.numero_paginas"), properties.getProperty("error.no_valido"));
        String periodicidad = vista.obtenerString(properties.getProperty("input.periodicidad"), properties.getProperty("error.no_valido"));
        double precio = vista.ObtenerDouble(properties.getProperty("input.precio"), properties.getProperty("error.no_valido"));
        return new Revista(ISSN, periodicidad, numero, numeroPaginas, titulo, autor, precio);
    }

    private Articulo crearArticulo() {
        String titulo = vista.obtenerString(properties.getProperty("input.titulo"), properties.getProperty("error.no_valido"));
        String autor = vista.obtenerString(properties.getProperty("input.autor"), properties.getProperty("error.no_valido"));
        String DOI = vista.obtenerString(properties.getProperty("input.DOI"), properties.getProperty("error.no_valido"));
        LocalDate fechaPublicacion = vista.obtenerFecha(properties.getProperty("input.fecha_publicacion"), properties.getProperty("error.no_valido"));
        String tipo = vista.obtenerString(properties.getProperty("input.tipo"), properties.getProperty("error.no_valido"));
        double precio = vista.ObtenerDouble(properties.getProperty("input.precio"), properties.getProperty("error.no_valido"));
        return new Articulo(DOI, titulo, autor, precio, fechaPublicacion, tipo);
    }

    private Patente crearPatente() {
        String titulo = vista.obtenerString(properties.getProperty("input.titulo"), properties.getProperty("error.no_valido"));
        String autor = vista.obtenerString(properties.getProperty("input.autor"), properties.getProperty("error.no_valido"));
        String CPAT = vista.obtenerString(properties.getProperty("input.CPAT"), properties.getProperty("error.no_valido"));
        LocalDate fechaSolicitud = vista.obtenerFecha(properties.getProperty("input.fecha_solicitud"), properties.getProperty("error.no_valido"));
        LocalDate fechaConcesion = vista.obtenerFecha(properties.getProperty("input.fecha_concesion"), properties.getProperty("error.no_valido"));
        int duracion = vista.ObtenerInt(properties.getProperty("input.duracion"), properties.getProperty("error.no_valido"));
        String asignatario = vista.obtenerString(properties.getProperty("input.asignatario"), properties.getProperty("error.no_valido"));
        double precio = vista.ObtenerDouble(properties.getProperty("input.precio"), properties.getProperty("error.no_valido"));
        return new Patente(CPAT, asignatario, fechaSolicitud, fechaConcesion, duracion, titulo, autor, precio);
    }

    public void mostrarPublicaciones() {
        List<Publicacion> publicaciones = biblioteca.getPublicaciones();
        if (!publicaciones.isEmpty()) {
            for (Publicacion publicacion : publicaciones) {
                List<Tomo> volumenes = publicacion.getListaVolumenes();
                vista.mostrarStringFormateado(properties.getProperty("output.header"), new Object[]{publicacion.getTipo()});
                vista.mostrarString(publicacion.toString());
                if (!volumenes.isEmpty()) {
                    vista.mostrarString(properties.getProperty("output.separador"));
                    vista.mostrarString(properties.getProperty("output.volumenes"));
                    vista.mostrarString(properties.getProperty("output.separador"));
                    vista.mostrarStringFormateado(properties.getProperty("output.numero_volumenes"), new Object[]{volumenes.size()});
                    for (Tomo tomo : volumenes) {
                        vista.mostrarString(properties.getProperty("output.separador"));
                        vista.mostrarStringFormateado(properties.getProperty("output.tomo"), tomo.getObjetoDatos());
                    }
                }
                vista.mostrarString(properties.getProperty("output.separador"));
            }
        } else {
            vista.mostrarMensajeError(properties.getProperty("error.sin_publicacion"));
        }
    }

    public static void main(String[] args) {
        Presentador presentador = new Presentador();
        presentador.administrarMenuPrincipal();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Diego Beltran
 */
public class JSONReader {

    public static JSONArray readJsonArray() {
        JSONParser jsonParser = new JSONParser();
        JSONArray publicaciones = new JSONArray();

        try (FileReader reader = new FileReader("publicaciones.json")) {
            publicaciones = (JSONArray) jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            System.out.println("No esta");
        } catch (IOException e) {
            System.out.println("error lectura");
        } catch (ParseException ex) {
            System.out.println("error parseo");
        }
        return publicaciones;
    }

    public static List<Publicacion> readJson() {
        List<Publicacion> publicaciones = new ArrayList<>();
        JSONArray jsonArray = readJsonArray();
        
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            String tipoPublicacion = (String) jsonObject.get("TipoPublicacion");
            
            switch (tipoPublicacion) {
                case "Libro" -> {
                    Libro libro = new Libro();
                    libro.fromJson(jsonObject);
                    publicaciones.add(libro);
                }
                case "Revista" -> {
                    Revista revista = new Revista();
                    revista.fromJson(jsonObject);
                    publicaciones.add(revista);
                }
                case "Articulo" -> {
                    Articulo articulo = new Articulo();
                    articulo.fromJson(jsonObject);
                    publicaciones.add(articulo);
                }
                default -> {
                    Patente patente = new Patente();
                    patente.fromJson(jsonObject);
                    publicaciones.add(patente);
                }
            }
        }

        return publicaciones;
    }

}

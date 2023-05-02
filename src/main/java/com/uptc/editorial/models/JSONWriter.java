/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;

/**
 *
 * @author bgdie
 */
public class JSONWriter {

    public static void write(String publicacion) {
        try (FileWriter file = new FileWriter("publicaciones.json")) {
            //try (FileWriter file = new FileWriter("D:\\archivos_creados_Java\\personas.json")) {
            file.write(publicacion); // para convertir a String en json
            file.flush();// para que escriba o cierre el archivo json en este caso

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeList(List<Publicacion> lista) {
        JSONArray publicaciones = new JSONArray();
        for (int i = 0; i < lista.size(); i++) {
            publicaciones.add(lista.get(i).toJSON());
        }

        try (FileWriter file = new FileWriter("publicaciones.json")) {
            //try (FileWriter file = new FileWriter("D:\\archivos_creados_Java\\personas.json")) {
            file.write(publicaciones.toJSONString()); // para convertir a String en json
            file.flush();// para que escriba o cierre el archivo json en este caso

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeJsonList(JSONArray publicaciones){
        try (FileWriter file = new FileWriter("publicaciones.json")) {
            //try (FileWriter file = new FileWriter("D:\\archivos_creados_Java\\personas.json")) {
            file.write(publicaciones.toJSONString()); // para convertir a String en json
            file.flush();// para que escriba o cierre el archivo json en este caso

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

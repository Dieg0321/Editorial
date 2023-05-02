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
            file.write(publicacion); 
            file.flush();

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
            file.write(publicaciones.toJSONString()); 
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeJsonList(JSONArray publicaciones){
        try (FileWriter file = new FileWriter("publicaciones.json")) {
            
            file.write(publicaciones.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

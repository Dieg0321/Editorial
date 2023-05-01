/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uptc.editorial.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Diego
 */
public class PropertiesLoader {

    public static final String PROPERTIES_FILE_NAME = "D:\\Progra_III\\Editorial\\src\\main\\java\\com\\uptc\\editorial\\resources\\MensajesConsola.properties";

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(PROPERTIES_FILE_NAME);    
            properties.load(inputStream);
        } catch (IOException ex) {
            
        }
        return properties;
    }
}

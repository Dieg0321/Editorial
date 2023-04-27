/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorial.models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Diego
 */
public class PropertiesLoader {

    private static final String PROPERTIES_FILE_NAME = "editorial/resources/MensajesConsola.properties";

    public static Properties loadProperties() {
        Properties properties = new Properties();
        InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);
        try {
            properties.load(inputStream);
        } catch (IOException ex) {

        }
        return properties;
    }
}

package org.estafeta.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Aleksey Smiyan on 21.04.18.
 */
public class PropertiesReader {

    private static Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        URL prop = ClassLoader.getSystemResource("config.properties");
        try {
            PROPERTIES.load(prop.openStream());
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return PROPERTIES.getProperty(key);
    }
}

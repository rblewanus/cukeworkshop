package cuke.common.testutil;

import cuke.common.OmgevingConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created on 09-01-2017.
 *//***/
public class PropertiesHelper {

    public static Properties loadProperties(String file) {
        String basepath = file + "." + OmgevingConfig.getOmgeving() + ".";
        return loadPropertiesFromBase(file, basepath);
    }

    public static Properties loadPropertiesNoEnv(String file) {
        String basepath = file + ".";
        return loadPropertiesFromBase(file, basepath);
    }

    private static Properties loadPropertiesFromBase(String file, String basepath) {
        String path = "properties/" + basepath + "properties";
        return _loadProperties(path, file);
    }

    private static Properties _loadProperties(String path, String file) {
        Properties result = new Properties();
        try {
            // Eerst het meegegeven pad proberen, is inclusief eventuele omgeving
            InputStream inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(path);
            result.load(inputStream);
        } catch (NullPointerException e) {
            // Daarna nogmaals proberen, maar dan zonder eventuele omgeving
            String newPath = "properties/" + file + ".properties";
            try {
                InputStream inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(newPath);
                result.load(inputStream);
            } catch (IOException | NullPointerException e1) {
                throw new RuntimeException("Couldn't open " + path + "; also couldn't open " + newPath, e1);
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't open " + path, e);
        }
        return result;
    }
}

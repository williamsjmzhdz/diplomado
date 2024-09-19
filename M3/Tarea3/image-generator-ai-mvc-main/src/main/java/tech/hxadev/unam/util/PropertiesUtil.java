package tech.hxadev.unam.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @author <a href="https://github.com/hxadev">HXADEV</a>
 * @since 1.0
 */
public class PropertiesUtil {

    private static PropertiesUtil instance;

    private PropertiesUtil() {}

    public static PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }

        return instance;
    }

    private String getProperty(String property, String propFile) {
        Properties properties = new Properties();
        try (InputStream st = PropertiesUtil.class.getClassLoader().getResourceAsStream(propFile + ".properties")) {
            properties.load(st);
        } catch (IOException ex) {
        }
        return properties.getProperty(property);
    }

    public  String getPropertyCore(String property) {
        return getProperty(property, "application");
    }

    public  String getPropertyMessages(String property) {
        return getProperty(property, "errorMessages");
    }

}

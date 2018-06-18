package in.ramakant.rpg.common.context;

import in.ramakant.rpg.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {
    private static final Properties properties;

    static {
        properties = loadProperties();
    }

    private PropertyProvider() {

    }

    private static Properties loadProperties() {
        Properties prop = new Properties();
        InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            prop.load(input);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop;
    }

    public static String getPropertyValue(String key) {
        return properties.getProperty(key);
    }
}

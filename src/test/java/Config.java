import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties properties;

    public Config() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public int getPropertyAsInt(String key) {
        String property = getProperty(key);
        return property != null ? Integer.parseInt(property) : 0;
    }
    
    public String[] getPropertyAsArray(String key) {
        String property = getProperty(key);
        return property != null ? property.split(",") : new String[]{};
    }
}

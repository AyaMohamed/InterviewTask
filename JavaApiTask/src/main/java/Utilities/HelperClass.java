package Utilities;

import java.io.InputStream;
import java.util.Properties;

public class HelperClass {

    private static Properties properties;

    public HelperClass() {
        properties = new Properties();
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream resourceStream = loader.getResourceAsStream("properties.properties");
            properties.load(resourceStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    public String getRequestParametersUsingProperties(String parameterName)
    {
        String value="";
        value=properties.getProperty(parameterName);
        return value;
    }

}

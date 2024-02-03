package pom.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigLoader
{
    private final Properties properties;
    private static ConfigLoader configloader;

    private ConfigLoader() throws IOException {
        properties = PropertyUtils.propertyLoader("src/test/Resources/Config.properties");
    }

    public static ConfigLoader getInstance() throws IOException {
        if(configloader == null)
        {
            configloader = new ConfigLoader();
        }
        return configloader;
    }

    public String getBaseURL()
    {
        String prop = properties.getProperty("baseUrl");
        if(prop!=null)
            return prop;
        else
            throw new RuntimeException("Property baseurl is not defined!!");
    }

    public String getUsername()
    {
        String prop = properties.getProperty("username");
        if(prop!=null)
            return prop;
        else
            throw new RuntimeException("Property username is not defined!!");
    }

    public String getPassword()
    {
        String prop = properties.getProperty("password");
        if(prop!=null)
            return prop;
        else
            throw new RuntimeException("Property password is not defined!!");
    }
}

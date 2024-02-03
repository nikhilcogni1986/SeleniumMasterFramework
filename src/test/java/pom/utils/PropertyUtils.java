package pom.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils
{
    public static Properties propertyLoader(String filePath) throws IOException {
        FileInputStream fis;
        Properties prop = new Properties();
        try
        {
            fis = new FileInputStream(filePath);
            try
            {
                prop.load(fis);
                fis.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                throw new RuntimeException("Failed to load properties file");
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException("File not found");
        }
        return prop;
    }
}

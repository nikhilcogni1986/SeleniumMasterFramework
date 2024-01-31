package pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonDataBind
{
    public static <T> T deserializeJSON(String fileName, Class <T> T) throws IOException {
        InputStream is = JacksonDataBind.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(is, T);
    }
}

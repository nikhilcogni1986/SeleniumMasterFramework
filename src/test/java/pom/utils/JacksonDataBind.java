package pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonDataBind
{
    public static BillingAddress deserializeJSON(InputStream is, BillingAddress billingAddress) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.readValue(is, billingAddress.getClass());
    }
}

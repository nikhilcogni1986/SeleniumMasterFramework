package pom.DataProviders;

import org.testng.annotations.DataProvider;
import pom.objects.Product;
import pom.utils.JacksonDataBind;

import java.io.IOException;

public class MyDataProvider
{
    @DataProvider(name = "getFeaturedProducts",parallel = false)
    protected Object[] getFeaturedProducts() throws IOException {
        return JacksonDataBind.deserializeJSON("products.json", Product[].class);
    }
}

package pom.objects;

import pom.utils.JacksonDataBind;

import java.io.IOException;

public class Product
{
    private String productName;
    private int id;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product(){}

    public Product(int id) throws IOException {
        Product[] products = JacksonDataBind.deserializeJSON("products.json", Product[].class);
        for(Product prod : products)
        {
            if(prod.id == id)
            {
                this.id = id;
                this.productName = prod.getProductName();
            }
        }
    }
}

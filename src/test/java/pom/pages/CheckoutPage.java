package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;

public class CheckoutPage extends BasePage
{
    protected WebDriver driver;

    private final By txtFirstName = By.id("billing_first_name");
    private final By txtLastName = By.id("billing_last_name");
    private final By txtAddress1 = By.id("billing_address_1");
    private final By txtCity = By.id("billing_city");
    private final By txtPostcode = By.id("billing_postcode");
    private final By txtEmail = By.id("billing_email");
    private final By btnPlaceOrder = By.id("place_order");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CheckoutPage enterFirstName(String firstName)
    {
        driver.findElement(txtFirstName).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName)
    {
        driver.findElement(txtLastName).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddress1(String address1)
    {
        driver.findElement(txtAddress1).sendKeys(address1);
        return this;
    }

    public CheckoutPage enterCity(String city)
    {
        driver.findElement(txtCity).sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostcode(String postcode)
    {
        driver.findElement(txtPostcode).sendKeys(postcode);
        return this;
    }

    public CheckoutPage enterEmailAddress(String emailAddress)
    {
        driver.findElement(txtEmail).sendKeys(emailAddress);
        return this;
    }

    public CheckoutPage placeOrder()
    {
        driver.findElement(btnPlaceOrder).click();
        return this;
    }
}
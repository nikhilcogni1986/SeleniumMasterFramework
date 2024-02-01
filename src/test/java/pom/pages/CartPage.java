package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;

public class CartPage extends BasePage
{
    protected WebDriver driver;

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By btnCheckout = By.cssSelector(".checkout-button.button.alt.wc-forward");

    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public String getProductName()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public CheckoutPage checkout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
        return new CheckoutPage(driver);
    }
}
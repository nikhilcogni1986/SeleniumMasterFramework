package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;

public class CartPage extends BasePage
{
    protected WebDriver driver;

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By btnCheckout = By.cssSelector(".checkout-button.button.alt.wc-forward");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }

    public void clickCheckoutBtn()
    {
        driver.findElement(btnCheckout).click();
    }
}

package pom.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;
import pom.pages.CartPage;

public class Thumbnails extends BasePage
{
    private final By btnViewCart = By.cssSelector("a[title='View cart']");

    public Thumbnails(WebDriver driver)
    {
        super(driver);
    }

    public Thumbnails clickAddToCartBtn(String productName)
    {
        By btnAddToCart = getAddToCartBtn(productName);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
        return this;
    }

    private By getAddToCartBtn(String productName)
    {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public CartPage clickOnViewCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(btnViewCart)).click();
        return new CartPage(driver);
    }
}
package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;

import java.io.IOException;

public class HomePage extends BasePage
{
    protected WebDriver driver;

    private final By lnkStoreMenu = By.cssSelector("#menu-item-1227  a");
    private final By btnViewCart = By.cssSelector("a[title='View cart']");

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public StorePage navigateToStoreUsingMenu()
    {
        wait.until(ExpectedConditions.elementToBeClickable(lnkStoreMenu)).click();
        return new StorePage(driver);
    }

    public HomePage load() throws IOException {
        load("/");
        return this;
    }

    public StorePage clickAddToCartBtn(String productName)
    {
        By btnAddToCart = getAddToCartBtn(productName);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
        return new StorePage(driver);
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

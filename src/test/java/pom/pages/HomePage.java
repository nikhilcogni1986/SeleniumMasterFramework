package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;

public class HomePage extends BasePage
{
    protected WebDriver driver;

    private final By lnkStoreMenu = By.cssSelector("#menu-item-1227  a");

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public StorePage navigateToStoreUsingMenu()
    {
        driver.findElement(lnkStoreMenu).click();
        return new StorePage(driver);
    }
}

package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.elementToBeClickable(lnkStoreMenu)).click();
        return new StorePage(driver);
    }

    public HomePage load()
    {
        load("/");
        return this;
    }
}

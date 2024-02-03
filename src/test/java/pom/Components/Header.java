package pom.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.base.BasePage;
import pom.pages.StorePage;

public class Header extends BasePage
{
    private final By lnkStoreMenu = By.cssSelector("#menu-item-1227  a");

    public Header(WebDriver driver) {
        super(driver);
    }

    public StorePage navigateToStoreUsingMenu()
    {
        wait.until(ExpectedConditions.elementToBeClickable(lnkStoreMenu)).click();
        return new StorePage(driver);
    }
}
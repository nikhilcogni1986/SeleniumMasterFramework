package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pom.Components.Thumbnails;
import pom.base.BasePage;

public class StorePage extends BasePage
{

    private final By txtSearchFld = By.id("woocommerce-product-search-field-0");
    private final By btnSearch = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector("h1.woocommerce-products-header__title.page-title");

    private Thumbnails thumbnails;

    public StorePage(WebDriver driver) {
        super(driver);
        thumbnails = new Thumbnails(driver);
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    private StorePage enterTextInSearchFld(String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(txtSearchFld)).sendKeys(text);
        return this;
    }

    private StorePage clickSearchBtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
        return this;
    }

    public StorePage search(String productName)
    {
        enterTextInSearchFld(productName).clickSearchBtn();
        return this;
    }

    public String getTitle()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
}
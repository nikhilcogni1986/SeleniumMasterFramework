package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.base.BasePage;

public class StorePage extends BasePage
{
    protected WebDriver driver;

    private final By txtSearchFld = By.id("woocommerce-product-search-field-0");
    private final By btnSearch = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector("h1.woocommerce-products-header__title.page-title");
    private final By btnViewCart = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    private StorePage enterTextInSearchFld(String text)
    {
        driver.findElement(txtSearchFld).sendKeys(text);
        return this;
    }

    private StorePage clickSearchBtn()
    {
        driver.findElement(btnSearch).click();
        return this;
    }

    public StorePage search(String productName)
    {
        enterTextInSearchFld(productName).clickSearchBtn();
        return this;
    }

    public String getTitle()
    {
        return driver.findElement(title).getText();
    }

    public StorePage clickAddToCartBtn(String productName)
    {
        By btnAddToCart = getAddToCartBtn(productName);
        driver.findElement(btnAddToCart).click();
        return this;
    }

    private By getAddToCartBtn(String productName)
    {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public StorePage clickOnViewCart()
    {
        driver.findElement(btnViewCart).click();
        return this;
    }
}
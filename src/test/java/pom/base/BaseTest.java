package pom.base;

import org.testng.annotations.Parameters;
import pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }

    public WebDriver getDriver()
    {
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser)
    {
        String browserName = System.getProperty("browser",browser);
        setDriver(new DriverManager().initializeDriver(browserName));
    }

    @AfterMethod
    public void quitDriver()
    {
        getDriver().quit();
    }
}

package pom.base;

import pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeMethod
    public void startDriver()
    {
        String browserName = System.getProperty("browser");
        driver = new DriverManager().initializeDriver(browserName);
    }

    @AfterMethod
    public void quitDriver()
    {
        driver.quit();
    }
}

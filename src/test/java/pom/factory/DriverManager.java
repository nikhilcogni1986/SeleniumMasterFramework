package pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.constants.BrowserType;

public class DriverManager
{
    public WebDriver driver;
    public WebDriver initializeDriver(String browser)
    {
        String browserName = System.getProperty("browser",browser);
        switch (BrowserType.valueOf(browserName))
        {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name:" + browserName);
        }
        driver.manage().window().maximize();
        return driver;
    }
}

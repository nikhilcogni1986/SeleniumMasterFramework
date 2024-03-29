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
        switch (BrowserType.valueOf(browser))
        {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Invalid browser name:" + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}

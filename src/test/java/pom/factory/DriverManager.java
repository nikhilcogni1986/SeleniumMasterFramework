package pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager
{
    public WebDriver driver;
    public WebDriver initializeDriver(String browserName)
    {
        switch (browserName)
        {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}

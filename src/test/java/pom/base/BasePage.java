package pom.base;

import org.openqa.selenium.WebDriver;

public class BasePage
{
    private WebDriver driver;

    BasePage(WebDriver driver)
    {
        this.driver = driver;
    }
}
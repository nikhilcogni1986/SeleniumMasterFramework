package pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.utils.ConfigLoader;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasePage
{
    protected WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public void load(String endpoint) throws IOException {
        driver.get(ConfigLoader.getInstance().getBaseURL() +endpoint);
    }

    public void waitForOverlays(By overlay)
    {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("Overlays with size: "+overlays.size());
        if(overlays.size() > 0)
        {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                    ExpectedConditions.invisibilityOfAllElements(overlays));
        }
        else
            System.out.println("Overlays are not invisible");
    }
}
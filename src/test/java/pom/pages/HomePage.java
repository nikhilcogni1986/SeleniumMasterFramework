package pom.pages;

import org.openqa.selenium.WebDriver;
import pom.Components.Header;
import pom.Components.Thumbnails;
import pom.base.BasePage;

import java.io.IOException;

public class HomePage extends BasePage
{
    private Thumbnails thumbnails;
    private Header header;

    public HomePage(WebDriver driver)
    {
        super(driver);
        thumbnails = new Thumbnails(driver);
        header = new Header(driver);
    }

    public HomePage load() throws IOException {
        load("/");
        return this;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public Header getHeader() {
        return header;
    }
}
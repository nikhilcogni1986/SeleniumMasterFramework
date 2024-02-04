package pom.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pom.factory.DriverManager;

import java.io.File;
import java.io.IOException;

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
    public synchronized void startDriver(@Optional String browser)
    {
        //String browser = "CHROME";
        String browserName = System.getProperty("browser","CHROME");
        setDriver(new DriverManager().initializeDriver(browserName));
    }

    @AfterMethod
    public synchronized void quitDriver(ITestResult result, @Optional String browser) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            File destFile = new File("scr" + File.separator+
                    browser+File.separator+result.getTestClass().getRealClass().getSimpleName()+
                    "_"+result.getMethod().getMethodName()+".png");
            takeScreenshot(destFile);
        }
        getDriver().quit();
    }

    private void takeScreenshot(File destFile) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot)getDriver();
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyDirectory(srcFile, destFile);
    }
}

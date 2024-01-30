import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pom.BaseTest;

import java.time.Duration;

public class MyFirstTestCase extends BaseTest
{
    @Test
    public void guestCheckoutUsingBankTransfer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://askomdch.com");

        driver.findElement(By.cssSelector("#menu-item-1227  a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("h1.woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();

        Assert.assertEquals(
                            driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                      "Blue Shoes"
                           );
        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();

        driver.findElement(By.id("billing_first_name")).sendKeys("Rakesh");
        driver.findElement(By.id("billing_last_name")).sendKeys("Hejaji");
        driver.findElement(By.id("billing_address_1")).sendKeys("ADDr1");
        driver.findElement(By.id("billing_city")).sendKeys("California");
        driver.findElement(By.id("billing_postcode")).sendKeys("CF233HL");
        driver.findElement(By.id("billing_email")).sendKeys("rakesh@test.com");
        driver.findElement(By.id("place_order")).click();
    }

    @Test
    public void loginCheckoutBankTransfer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://askomdch.com");

        driver.findElement(By.cssSelector("#menu-item-1227  a")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("h1.woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Blue Shoes"
        );
        driver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();

        driver.findElement(By.cssSelector(".showlogin")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("username")).sendKeys("nikhiltest@test.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("button[value='Login']")).click();

        driver.findElement(By.id("billing_first_name")).sendKeys("Rakesh");
        driver.findElement(By.id("billing_last_name")).sendKeys("Hejaji");
        driver.findElement(By.id("billing_address_1")).sendKeys("ADDr1");
        driver.findElement(By.id("billing_city")).sendKeys("California");
        driver.findElement(By.id("billing_postcode")).sendKeys("CF233HL");
        driver.findElement(By.id("billing_email")).sendKeys("rakesh@test.com");
        driver.findElement(By.id("place_order")).click();

    }
}

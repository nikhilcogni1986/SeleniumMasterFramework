import org.junit.Assert;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pages.CartPage;
import pom.pages.CheckoutPage;
import pom.pages.HomePage;
import pom.pages.StorePage;

import java.time.Duration;

public class MyFirstTestCase extends BaseTest {
  @Test
  public void guestCheckoutUsingBankTransfer() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://askomdch.com");

    HomePage homePage = new HomePage(driver);
    StorePage storePage = homePage.navigateToStoreUsingMenu();

    storePage.search("Blue");
    Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

    storePage.clickAddToCartBtn("Blue Shoes");
    Thread.sleep(5000);
    CartPage cartPage = storePage.clickOnViewCart();

    Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    CheckoutPage checkoutPage = cartPage.checkout();
    checkoutPage
        .enterFirstName("Rakesh")
        .enterLastName("Hejjaji")
        .enterAddress1("91 Street")
        .enterCity("California")
        .enterPostcode("94188")
        .enterEmailAddress("nikhilrao@test.com")
        .placeOrder();
  }

  @Test
  public void loginCheckoutBankTransfer() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://askomdch.com");

    HomePage homePage = new HomePage(driver);
    StorePage storePage = homePage.navigateToStoreUsingMenu();

    storePage.search("Blue");
    Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

    storePage.clickAddToCartBtn("Blue Shoes");
    Thread.sleep(5000);
    CartPage cartPage = storePage.clickOnViewCart();

    Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    CheckoutPage checkoutPage = cartPage.checkout();
    checkoutPage.clickHereLoginLink();
    Thread.sleep(4000);
    checkoutPage
        .login("nikhilrao@test.com", "password1234")
        .enterFirstName("Rakesh")
        .enterLastName("Hejjaji")
        .enterAddress1("91 Street")
        .enterCity("California")
        .enterPostcode("94188")
        .enterEmailAddress("nikhilrao@test.com")
        .placeOrder();
    Thread.sleep(5000);
    Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
  }
}

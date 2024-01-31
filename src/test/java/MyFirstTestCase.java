import org.testng.Assert;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.objects.BillingAddress;
import pom.pages.CartPage;
import pom.pages.CheckoutPage;
import pom.pages.HomePage;
import pom.pages.StorePage;
import pom.utils.JacksonDataBind;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class MyFirstTestCase extends BaseTest {
  @Test
  public void guestCheckoutUsingBankTransfer() throws InterruptedException, IOException {

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    BillingAddress billingAddress = JacksonDataBind.deserializeJSON("myBillingAddress.json", BillingAddress.class);

    StorePage storePage = new HomePage(driver).load().navigateToStoreUsingMenu().search("Blue");
    Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

    storePage.clickAddToCartBtn("Blue Shoes");
    Thread.sleep(5000);
    CartPage cartPage = storePage.clickOnViewCart();

    Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    CheckoutPage checkoutPage = cartPage.
             checkout().
             setBillingAddress(billingAddress).
             placeOrder();
  }

  @Test
  public void loginCheckoutBankTransfer() throws InterruptedException {

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    BillingAddress billingAddress = new BillingAddress();
    billingAddress
            .setFirstName("Rakesh")
            .setLastName("Hejjaji")
            .setAddress1("91 street")
            .setCity("San Franscisco")
            .setPostalCode("94138")
            .setEmailAddress("nikhilrao@test.com");

    StorePage storePage = new HomePage(driver).load().navigateToStoreUsingMenu().search("Blue");
    Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

    storePage.clickAddToCartBtn("Blue Shoes");
    Thread.sleep(5000);
    CartPage cartPage = storePage.clickOnViewCart();

    Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    CheckoutPage checkoutPage = cartPage.checkout();
    checkoutPage.clickHereLoginLink();
    Thread.sleep(4000);
    checkoutPage.setBillingAddress(billingAddress)
        .login("nikhilrao@test.com", "password1234")
        .placeOrder();
    Thread.sleep(5000);
    Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
  }
}

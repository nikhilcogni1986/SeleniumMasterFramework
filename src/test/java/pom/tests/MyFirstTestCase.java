package pom.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.DataProviders.MyDataProvider;
import pom.base.BaseTest;
import pom.objects.BillingAddress;
import pom.objects.Product;
import pom.objects.User;
import pom.pages.CartPage;
import pom.pages.CheckoutPage;
import pom.pages.HomePage;
import pom.pages.StorePage;
import pom.utils.ConfigLoader;
import pom.utils.JacksonDataBind;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {
  @Test
  public void guestCheckoutUsingBankTransfer() throws IOException {

    String searchFor = "Blue";
    BillingAddress billingAddress = JacksonDataBind.deserializeJSON("myBillingAddress.json", BillingAddress.class);
    Product product = new Product(1215);

    StorePage storePage = new HomePage(getDriver()).load().
            getHeader().
            navigateToStoreUsingMenu().search(searchFor);
    Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”");

    CartPage cartPage = storePage.getThumbnails().
            clickAddToCartBtn(product.getProductName())
            .clickOnViewCart();

    Assert.assertEquals(cartPage.getProductName(), product.getProductName());
    CheckoutPage checkoutPage = cartPage.
             checkout().
             setBillingAddress(billingAddress).
             placeOrder();
  }

  @Test
  public void loginCheckoutBankTransfer() throws IOException {

    String searchFor = "Blue";
    BillingAddress billingAddress = JacksonDataBind.deserializeJSON("myBillingAddress.json", BillingAddress.class);
    Product product = new Product(1215);
    User user = new User(ConfigLoader.getInstance().getUsername(),ConfigLoader.getInstance().getPassword());

    StorePage storePage = new HomePage(getDriver()).load().getHeader().navigateToStoreUsingMenu().search("Blue");
    Assert.assertEquals(storePage.getTitle(), "Search results: “"+searchFor+"”");

    storePage.getThumbnails().clickAddToCartBtn(product.getProductName());
    CartPage cartPage = storePage.getThumbnails().clickOnViewCart();

    Assert.assertEquals(cartPage.getProductName(), product.getProductName());
    CheckoutPage checkoutPage = cartPage.checkout();
    checkoutPage.clickHereLoginLink();
    checkoutPage
        .login(user)
        .setBillingAddress(billingAddress)
        .placeOrder();
    Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
  }

  @Test(dataProvider = "getFeaturedProducts", dataProviderClass = MyDataProvider.class)
  public void addToCartFeaturedProducts(Product product) throws IOException {
    CartPage cartPage = new HomePage(getDriver()).
            load().
            getThumbnails().
            clickAddToCartBtn(product.getProductName()).
            clickOnViewCart();
    Assert.assertEquals(cartPage.getProductName(), product.getProductName());
  }
}

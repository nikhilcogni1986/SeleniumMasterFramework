package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.base.BasePage;
import pom.objects.BillingAddress;
import pom.objects.User;

import java.time.Duration;
import java.util.List;

public class CheckoutPage extends BasePage {
  private final By txtFirstName = By.id("billing_first_name");
  private final By txtLastName = By.id("billing_last_name");
  private final By txtAddress1 = By.id("billing_address_1");
  private final By txtCity = By.id("billing_city");
  private final By txtPostcode = By.id("billing_postcode");
  private final By txtEmail = By.id("billing_email");
  private final By btnPlaceOrder = By.id("place_order");
  private final By lnkLogin = By.cssSelector(".showlogin");
  private final By txtUsername = By.id("username");
  private final By txtPassword = By.id("password");
  private final By btnLogin = By.cssSelector("button[value='Login']");
  private final By successNotice =
      By.cssSelector(".woocommerce-notice.woocommerce-notice--success");
  private final By overlay = By.cssSelector(".blockUI.blockOverlay");

  protected WebDriver driver;

  public CheckoutPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public CheckoutPage enterFirstName(String firstName) {
    driver.findElement(txtFirstName).clear();
    driver.findElement(txtFirstName).sendKeys(firstName);
    return this;
  }

  public CheckoutPage enterLastName(String lastName) {
    driver.findElement(txtLastName).sendKeys(lastName);
    return this;
  }

  public CheckoutPage enterAddress1(String address1) {
    driver.findElement(txtAddress1).sendKeys(address1);
    return this;
  }

  public CheckoutPage enterCity(String city) {
    driver.findElement(txtCity).sendKeys(city);
    return this;
  }

  public CheckoutPage enterPostcode(String postcode) {
    driver.findElement(txtPostcode).sendKeys(postcode);
    return this;
  }

  public CheckoutPage enterEmailAddress(String emailAddress) {
    driver.findElement(txtEmail).clear();
    driver.findElement(txtEmail).sendKeys(emailAddress);
    return this;
  }

  public CheckoutPage placeOrder() {
    List<WebElement> overlays = driver.findElements(overlay);
    System.out.println("Overlays with size: "+overlays.size());
    if(overlays.size() > 0)
    {
      new WebDriverWait(driver, Duration.ofSeconds(15)).until(
              ExpectedConditions.invisibilityOfAllElements(overlays));
    }
    System.out.println("Overlays are not invisible");
    driver.findElement(btnPlaceOrder).click();
    return this;
  }

  public CheckoutPage enterUsername(String username) {
    driver.findElement(txtUsername).clear();
    driver.findElement(txtUsername).sendKeys(username);
    return this;
  }

  public CheckoutPage enterPassword(String password) {
    driver.findElement(txtPassword).clear();
    driver.findElement(txtPassword).sendKeys(password);
    return this;
  }

  public String getNotice() {
    return driver.findElement(successNotice).getText();
  }

  public CheckoutPage clickLogin() {
    driver.findElement(btnLogin).click();
    return new CheckoutPage(driver);
  }

  public CheckoutPage clickHereLoginLink() {
    driver.findElement(lnkLogin).click();
    return new CheckoutPage(driver);
  }

  public CheckoutPage login(User user) {
    enterUsername(user.getUsername())
    .enterPassword(user.getPassword())
    .clickLogin();
    return this;
  }

  public CheckoutPage setBillingAddress(BillingAddress billingAddress)
  {
    return enterFirstName(billingAddress.getFirstName()).
    enterLastName(billingAddress.getLastName()).
    enterAddress1(billingAddress.getAddress1()).
    enterCity(billingAddress.getCity()).
    enterPostcode(billingAddress.getPostalCode()).
    enterEmailAddress(billingAddress.getEmailAddress());
  }
}
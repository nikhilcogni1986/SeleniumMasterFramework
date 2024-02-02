package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pom.base.BasePage;
import pom.objects.BillingAddress;
import pom.objects.User;

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
  private final By drpDwnCountry = By.id("billing_country");
  private final By drpDwnState = By.id("billing_state");
  private final By altDrpDwnCountry = By.id("select2-billing_country-container");
  private final By altDrpDwnState = By.id("select2-billing_state-container");

  protected WebDriver driver;

  public CheckoutPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public CheckoutPage enterFirstName(String firstName) {
    wait.until(ExpectedConditions.elementToBeClickable(txtFirstName)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtFirstName)).sendKeys(firstName);
    return this;
  }

  public CheckoutPage enterLastName(String lastName)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtLastName)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtLastName)).sendKeys(lastName);
    return this;
  }

  public CheckoutPage selectCountry(String country)
  {
//    Select select = new Select(driver.findElement(drpDwnCountry));
//    select.selectByVisibleText(country);

    wait.until(ExpectedConditions.elementToBeClickable(altDrpDwnCountry)).click();
    WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+country+"']")));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",countryOption);
    countryOption.click();
    return this;
  }

  public CheckoutPage enterAddress1(String address1)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtAddress1)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtAddress1)).sendKeys(address1);
    return this;
  }

  public CheckoutPage enterCity(String city)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtCity)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtCity)).sendKeys(city);
    return this;
  }

  public CheckoutPage selectState(String state)
  {
//    Select select = new Select(driver.findElement(drpDwnState));
//    select.selectByVisibleText(state);

    wait.until(ExpectedConditions.elementToBeClickable(altDrpDwnState)).click();
    WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+state+"']")));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",stateOption);
    stateOption.click();
    return this;
  }

  public CheckoutPage enterPostcode(String postcode)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtPostcode)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtPostcode)).sendKeys(postcode);
    return this;
  }

  public CheckoutPage enterEmailAddress(String emailAddress)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtEmail)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtEmail)).sendKeys(emailAddress);
    return this;
  }

  public CheckoutPage placeOrder() {
    waitForOverlays(overlay);
    driver.findElement(btnPlaceOrder).click();
    return this;
  }

  public CheckoutPage enterUsername(String username)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtUsername)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtUsername)).sendKeys(username);
    return this;
  }

  public CheckoutPage enterPassword(String password)
  {
    wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).clear();
    wait.until(ExpectedConditions.elementToBeClickable(txtPassword)).sendKeys(password);
    return this;
  }

  public String getNotice() {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
  }

  public CheckoutPage clickLogin()
  {
    wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    return new CheckoutPage(driver);
  }

  public CheckoutPage clickHereLoginLink() {
    wait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
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
    selectCountry(billingAddress.getCountry()).
    enterAddress1(billingAddress.getAddress1()).
    enterCity(billingAddress.getCity()).
    selectState(billingAddress.getState()).
    enterPostcode(billingAddress.getPostalCode()).
    enterEmailAddress(billingAddress.getEmailAddress());
  }
}
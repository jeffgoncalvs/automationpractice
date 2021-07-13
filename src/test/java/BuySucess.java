import ActionSteps.LoginSteps;
import Helper.*;
import PageObject.Site.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class BuySucess {

    private WebDriver driver;
    private LoginSteps loginSteps;
    private Random numberEmail;
    private CartPage cartPage;

    @Before
    public void initBorwser() {
        driver = new DriverSetup().getDriver();
        numberEmail = new Random();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void BuySucess() {
        String url = new PropertyHelper().getUrlBase("automationpractice");
        System.out.println(url);
        driver.get(url);
        HomePage homePage = new HomePage(driver);
        homePage.getTitlePage();
        ProductPage productPage = homePage.findAndClickProduct();
        CartPage cartPage = productPage.clickToAddCart();
        LoginPage loginPage = cartPage.checkProductCart();
        loginPage.insertEmailForCreateAccount(numberEmail.nextInt(10000) + "@mailinator.com");
        loginPage.clickCreateAccount();
        loginSteps = new LoginSteps(driver);
        loginSteps.doRegister();
        cartPage.verifyAddressCheckout(driver);
        cartPage.acceptTermOfService();
        cartPage.verifyCarrierCheckout(driver);
        cartPage.payByBankWire(driver);
        cartPage.confirmMyOrder(driver);
        cartPage.confirmPayment(driver);
    }
}
package StepDefinition;

import Helper.DriverSetup;
import Helper.PropertyHelper;
import PageObject.Site.CartPage;
import PageObject.Site.LoginPage;
import PageObject.Site.ProductPage;
import PageObject.Site.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.cucumber.junit.Cucumber;
import io.cucumber.messages.internal.com.google.gson.internal.bind.util.ISO8601Utils;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Random;

@RunWith(Cucumber.class)
public class LoginSteps {

    private WebDriver driver;
    private String email;
    private String password;
    private CartPage cartPage;
    private ProductPage productPage;
    private Random numberEmail = new Random();


    @Dado("Que estou no site My Store")
    public void acessMyStore() {
        String url = new PropertyHelper().getUrlBase("automationpractice");
        System.out.println("Acessei Site MyStore " + url.toString());
        driver.get(url);
    }

    @Dado("estou na tela principal")
    public void acessLogin() {
        System.out.println("Estou na tela principal");
        HomePage homePage = new HomePage(driver);
    }

    @Quando("adiciona o meu produto no carrinho")
    public void buyProduct() {
        HomePage homePage = new HomePage(driver);
        productPage = homePage.findAndClickProduct();
        cartPage = productPage.clickToAddCart();
        System.out.println("adicionei o produto no carrinho");

    }

    @E("preencho o meu cadastrado")
    public void preencherCadastro() {
        ActionSteps.LoginSteps loginSteps = new ActionSteps.LoginSteps(driver);
        LoginPage loginPage = cartPage.checkProductCart();
        loginPage.insertEmailForCreateAccount(numberEmail.nextInt(10000) + "@mailinator.com");
        loginPage.clickCreateAccount();
        loginSteps.doRegister();
        cartPage.verifyAddressCheckout(driver);
        cartPage.acceptTermOfService();
        cartPage.verifyCarrierCheckout(driver);
        cartPage.payByBankWire(driver);
        cartPage.confirmMyOrder(driver);
        System.out.println("preenchi o me cadastro");
    }

    @Entao("finalizo a compra")
    public void buyfinalizada() {
        cartPage.confirmPayment(driver);
        System.out.println("finalizei a minha compra");
    }

    @Before
    public void initBorwser() {
        driver = new DriverSetup().getDriver();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

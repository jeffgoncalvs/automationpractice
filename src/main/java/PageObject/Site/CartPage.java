package PageObject.Site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Locale;

public class CartPage extends BasePage {

    private String productCart;

    CartPage(WebDriver driver) {
        super(driver);
        productCart = new String();
    }

    public String getProductCart() {
        return productCart;
    }

    public void setProductCart(String product) {
        productCart = product;
    }

    public LoginPage checkProductCart() {
        assertEquals(driver.findElement(By.id("product_1_1_0_0")).isDisplayed(), true);
        WebElement product = driver.findElement(By.id("product_1_1_0_0"));
        driver.findElement(By.className("standard-checkout")).click();
        return new LoginPage(driver);
    }

    public void verifyAddressCheckout(WebDriver driver) {
        driver = this.driver;
        assertEquals(driver.findElement(By.id("address_delivery")).isDisplayed(), true);
        assertEquals(driver.findElement(By.id("address_invoice")).isDisplayed(), true);
        assertEquals(driver.findElement(By.name("processAddress")).isDisplayed(), true);
        driver.findElement(By.name("processAddress")).click();
    }

    public void verifyCarrierCheckout(WebDriver driver) {
        driver = this.driver;
        assertEquals(driver.findElement(By.className("delivery_options")).isDisplayed(), true);
        assertEquals(driver.findElement(By.name("processCarrier")).isDisplayed(), true);
        driver.findElement(By.name("processCarrier")).click();
    }

    public void acceptTermOfService() {
        assertEquals(driver.findElement(By.id("uniform-cgv")).isDisplayed(), true);
        driver.findElement(By.id("cgv")).click();
    }

    public void payByBankWire(WebDriver driver) {
        driver = this.driver;
        assertEquals(driver.findElement(By.className("bankwire")).isDisplayed(), true);
        driver.findElement(By.className("bankwire")).click();
    }

    public void payByCheck(WebDriver driver) {
        driver = this.driver;
        assertEquals(driver.findElement(By.className("cheque")).isDisplayed(), true);
        driver.findElement(By.className("cheque")).click();
    }

    public void confirmMyOrder(WebDriver driver) {
        driver = this.driver;
        List<WebElement> webElementList = driver.findElements(By.className("button-medium"));
        assertEquals(webElementList.get(1).getText().toUpperCase(), "I confirm my order".toUpperCase());
        webElementList.get(1).click();
    }

    public void confirmPayment(WebDriver driver) {
        assertEquals(driver.findElement(By.className("cheque-indent")).getText().toUpperCase(), "Your order on My Store is complete.".toUpperCase());
    }
}

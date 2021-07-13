package PageObject.Site;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    CartPage cartPage;

    //busca o botão login
    @FindBy(className = "login")
    WebElement btnLogIn;

    public HomePage(WebDriver driver) {
        super(driver);
        cartPage = new CartPage(driver);
    }

    public void getTitlePage() {
        System.out.println("Titulo da pagina " + driver.toString());
    }

    public WebElement getFirstProductCover() {
        List<WebElement> listWebElements = driver.findElements(By.className("product-container"));
        WebElement product = listWebElements.stream()
                .findFirst()
                .orElse(null);
        return product;
    }

    public ProductPage findAndClickProduct() {
        WebElement product = getFirstProductCover();
        clickProduct(product);
        return new ProductPage(driver);
    }

    //clicar no produto
    public ProductPage clickProduct(WebElement product) {
        scrollToElement(product);
        product.click();
        return new ProductPage(driver);
    }
}

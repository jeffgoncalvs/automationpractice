package PageObject.Site;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickToAddCart() {
        scrollToElement(driver.findElement(By.id("add_to_cart")));
        driver.findElement(By.id("add_to_cart")).click();
        driver.findElement(By.className("button-medium")).click();
        return new CartPage(driver);
    }
}

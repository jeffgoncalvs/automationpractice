package PageObject.Site;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnSignIn;

    @FindBy(id = "email_create")
    WebElement textCreateAccount;

    @FindBy(id = "SubmitCreate")
    WebElement btnCreateAccount;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void insertEmailLogin(String email) {
        txtEmail.sendKeys(email);
    }

    public void insertPasswordLogin(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickSignIN() {
        btnSignIn.click();
    }

    public void insertEmailForCreateAccount(String email) {
        textCreateAccount.sendKeys(email);
    }

    public void clickCreateAccount() {
        btnCreateAccount.click();
    }

    public void selectTitle() {
        driver.findElement(By.id("id_gender1")).click();
    }

    public void insertFirstName(String firstName) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
    }

    public void insertEmailCreateAccount(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void insertPasswordCreateAccount(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void insertDayOfBirth(String day) {
        WebElement fieldDay = driver.findElement(By.id("days"));
        fieldDay.click();
        fieldDay.sendKeys(day);
    }

    public void insertMothOfBirth(String moth) {
        WebElement fieldMoth = driver.findElement(By.id("months"));
        fieldMoth.click();
        fieldMoth.sendKeys(moth);
    }

    public void insertYearOfBirth(String year) {
        WebElement fieldYear = driver.findElement(By.id("years"));
        fieldYear.click();
        fieldYear.sendKeys(year);
    }

    public void insertFirstNameAddress(String firstName) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    public void insertLastNameAddress(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    public void insertCompanyAddress(String company) {
        driver.findElement(By.id("company")).sendKeys(company);
    }

    public void insertAddressLineOne(String address) {
        driver.findElement(By.id("address1")).sendKeys(address);
    }

    public void insertAddressLinetwo(String address) {
        driver.findElement(By.id("address2")).sendKeys(address);
    }

    public void insertCityAddress(String city) {
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void insertStateAddress(String state) {
        driver.findElement(By.id("id_state")).sendKeys(state);
    }

    public void insertZipPostalCodeAddress(String zipPostalCode) {
        driver.findElement(By.id("postcode")).sendKeys(zipPostalCode);
    }

    public void insertCountryAddress(String country) {
        driver.findElement(By.id("postcode")).sendKeys(country);
    }

    public void insertAdditionalInformation(String additionalInformation) {
        driver.findElement(By.id("other")).sendKeys(additionalInformation);
    }

    public void insertHomePhone(String homePhone) {
        driver.findElement(By.id("phone")).sendKeys(homePhone);
    }

    public void insertMobilePhone(String mobilePhone) {
        driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
    }

    public void clickRegister() {
        driver.findElement(By.id("submitAccount")).click();
    }
}

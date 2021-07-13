package ActionSteps;

import PageObject.Site.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public LoginSteps(LoginPage loginPage){
        this.loginPage = loginPage;
    }

    public void doRegister(){
        loginPage.selectTitle();
        loginPage.insertFirstName("João");
        loginPage.insertLastName("Silva");
        loginPage.insertPasswordCreateAccount("teste123");
        loginPage.insertDayOfBirth("3");
        loginPage.insertMothOfBirth("april");
        loginPage.insertYearOfBirth("2000");
        loginPage.insertCompanyAddress("Teste automatico");
        loginPage.insertAddressLineOne("Rua X");
        loginPage.insertAddressLinetwo("Da esquina Y");
        loginPage.insertCityAddress("POrto Alegre");
        loginPage.insertStateAddress("Florida");
        loginPage.insertZipPostalCodeAddress("00000");
        loginPage.insertAdditionalInformation("teste automatizado");
        loginPage.insertHomePhone("5554321");
        loginPage.insertMobilePhone("5554321");
        loginPage.clickRegister();
    }

}

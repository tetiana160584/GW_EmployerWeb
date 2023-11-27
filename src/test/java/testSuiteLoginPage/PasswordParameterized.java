package testSuiteLoginPage;

import configuration.BaseClass;
import org.checkerframework.checker.calledmethods.qual.RequiresCalledMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import parameterizedTestData.PasswordOptions;
import java.time.Duration;
import java.util.List;

import static configuration.BaseClass.driver;

public class PasswordParameterized extends BaseClass {
    LoginPage loginPage;
    WebElement signInPanel;


    WebElement headerSignIn;
    @BeforeMethod
    public void openLoginPage(){
        String siteUrl = "https://polite-stone-09089fb1e.3.azurestaticapps.net/";
        driver.get(siteUrl);
        loginPage= PageFactory.initElements(driver,pages.LoginPage.class);

        loginPage.waitForSignInPanel();
    }


    @Test(dataProviderClass = PasswordOptions.class, dataProvider = "getPasswordVariable")
    public void loginWithPasswordParameterized(String password, List<String> expectedErrorMessage) {
        loginPage.enterEmail();
        loginPage.enterPasswordParameterized(password);
        loginPage.clickSignInButton();
        loginPage.getErrorMessage();

        // Здесь вы можете добавить проверку для получения сообщения об ошибке
         String actualErrorMessage = loginPage.getErrorMessage();
         Assert.assertEquals(actualErrorMessage, expectedErrorMessage.get(0), "The result is not what was expected");
    }
    }









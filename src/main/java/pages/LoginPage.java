package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static configuration.BaseClass.driver;

public class LoginPage {
    @FindBy(id = "page_header")
    private WebElement headerSignIn;

    @FindBy(id = "forgotPassword")
    private WebElement forgotPasswordLink;

    @FindBy(id = "email")
    private WebElement emailLine;

    @FindBy(id = "password")
    private WebElement passwordLine;

    @FindBy(id = "next")
    private WebElement signInButton;

    public void checkStringText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(headerSignIn));// Ожидаем, что визард станет видимы

        String expectedTextSignIn = "Sign In";
        String expectedTextForgotPassword = "Forgot your password?";
        String expectedPlaceHolderEmail = "Email Address";
        String expectedPlaceHolderPassword = "Password";
        String[] expectedStrings = {expectedTextSignIn, expectedTextForgotPassword, expectedPlaceHolderEmail
                , expectedPlaceHolderPassword};

        for (int i = 0; i < expectedStrings.length; i++) {
            String actualText;
            if (i == 0) {
                actualText = headerSignIn.getText();
            } else if (i == 1) {
                actualText = forgotPasswordLink.getText();
            } else if (i == 2) {
                actualText = emailLine.getAttribute("placeholder");
            } else if (i == 3) {
                actualText = passwordLine.getAttribute("placeholder");
            } else {
                actualText = ""; // Установка значения по умолчанию, если ни одно из условий не выполнено
            }

            Assert.assertEquals(actualText, expectedStrings[i], "The text is not what you expected: " + expectedStrings[i]);
        }
    }

        public void enterEmail () {
            emailLine.sendKeys("tetiana.kostyhina+12213@gmail.com");
        }

        public void enterPassword () {
            passwordLine.sendKeys("Ktm160584");
        }

        public void clickSignInButton () {
            signInButton.click();
        }


    }


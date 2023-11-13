package pages.wizard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Instructions {
    @FindBy(xpath = "//div[@class=\"k-expander-title\" and text()=\"Employee Instructions\"]\n")
    private WebElement headerExpanderEmplInstr;

    @FindBy(className = "text")
    private WebElement instrPageSaveAndNextButton;


    public void expanderHeaderText(){
        Assert.assertTrue(headerExpanderEmplInstr.isDisplayed());
        String actualText = headerExpanderEmplInstr.getText();
        String expectedText = "Employee Instructions";

        // Преобразование текста в верхний регистр для сравнения
        String actualTextUpperCase = actualText.toUpperCase();
        String expectedTextUpperCase = expectedText.toUpperCase();

        Assert.assertEquals(actualTextUpperCase, expectedTextUpperCase, "The text is not what you expected: " + expectedText);
    }
    public void nextButton(){
        instrPageSaveAndNextButton.click();
    }

}

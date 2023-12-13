package pages.wizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static configuration.BaseClass.driver;

public class PublishPage {
    @FindBy(xpath = "//div[@class=\"d-flex justify-content-center\"]//span[@class=\"text\"]")
    private WebElement publishButton;
    @FindBy(xpath = "//div[@class=\"k-expander-header\"]//div[@class=\"k-expander-title\"and text()=\"General\"]")
    private WebElement generalTitle;
    @FindBy(xpath = "//div[@class=\"k-expander-header\"]//div[@class=\"k-expander-title\"and text()=\"Schedule\"]")
    private WebElement scheduleTitle;
    @FindBy(xpath = "//div[@class=\"k-expander-header\"]//div[@class=\"k-expander-title\"and text()=\"Employee Instructions\"]")
    private WebElement employeeInstructionsTitle;
    @FindBy(xpath = "//div[@class=\"k-expander-header\"]//div[@class=\"k-expander-title\"and text()=\"Attachments\"]")
    private WebElement attachmentsTitle;
    @FindBy(xpath = "//button[@type=\"button\" and text()=\" Cancel Job \"]")
    private WebElement cancelJobButton;
    @FindBy(xpath = "//div[@role=\"dialog\"]")
    private WebElement cancelConfirmPopup;
    @FindBy(xpath = "//div[@role=\"dialog\"]//button[@class=\"k-button k-primary ng-star-inserted\"]")
    private WebElement cancelJobButtonYes;

    public void checkElements() {
        publishButton.isDisplayed();
        generalTitle.isDisplayed();
        scheduleTitle.isDisplayed();
//      employeeInstructionsTitle.isDisplayed();
        attachmentsTitle.isDisplayed();
    }
    public void clickPublishButton() {
    String currentUrl = driver.getCurrentUrl(); // Получаем текущий URL перед кликом
    publishButton.click();
    //  ожидание изменения URL
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
    // Теперь вы можено добавить проверку заголовка новой страницы или выполнение других действий

}
public void clickCancelJobButton(){
        cancelJobButton.click();
}
public void checkCancelConfirmPopup(){
        cancelConfirmPopup.isDisplayed();
}
public void clickYesCancelJob(){
        cancelJobButtonYes.click();
}

}

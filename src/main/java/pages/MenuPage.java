package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static configuration.BaseClass.driver;

public class MenuPage {

    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/kendo-grid/kendo-grid-toolbar/app-grid-header/div[2]/button")
    private WebElement newJobButton;

    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window")
    private WebElement wizard;

    public void clickNewJobButton() {
        newJobButton.click();
    }

    public void wizardAppears(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(wizard));// Ожидаем, что визард станет видимым
        Assert.assertTrue(wizard.isDisplayed(), "The wizard did not appear after performing the action.");
    }// Проверяем, что визард успешно появился на странице


}














package pages.wizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

import static configuration.BaseClass.driver;

public class GeneralPage {


    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div/form/job-information-step/form/app-job-create-information/form/div/div[1]/div/kendo-formfield[1]/div/kendo-dropdownlist")
    private WebElement propertyLine;
    @FindBy(xpath = "//div[@class=\"k-list-scroller\"]//ul[@class=\"k-list k-reset\"]")
    private WebElement listProperty;

    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div/form/job-information-step/form/app-job-create-information/form/div/div[1]/div/kendo-formfield[2]/div/kendo-dropdownlist")
    private WebElement departmentLine;
    @FindBy(xpath = "//div[@class=\"k-list-scroller\"]//ul[@class=\"k-list k-reset\"]")
    private WebElement listDepartment;

    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div/form/job-information-step/form/app-job-create-information/form/div/div[1]/div/kendo-formfield[3]/div/kendo-dropdownlist")
    private WebElement jobClassificationLine;
    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/span/input")
    private WebElement jobFilterLineByName;
    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/kendo-list/div[2]")
    private WebElement jobClassifList;

    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div/form/job-information-step/form/app-job-create-information/form/div/div[1]/div/kendo-formfield[4]/div/kendo-dropdownlist")
    private WebElement tipTypeLine;
    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/kendo-list/div")
    private WebElement listTipType;

    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div/form/job-information-step/form/app-job-create-information/form/div/div[2]/div/kendo-formfield[2]/div/kendo-dropdownlist")
    private WebElement contactPersonLine;
    @FindBy(xpath = "/html/body/app-root/kendo-popup/div/kendo-list/div")
    private WebElement contactPersonList;

    @FindBy(className = "float-end")
    private WebElement saveAndNextButton;


    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div/div[1]/kendo-stepper/ol/li[1]")
    private WebElement secondStepSchedule;


    public void clickPropertyLine() { //выводит список всех проперти в списке, пока не использую в тесте пост джоб
        propertyLine.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"k-list-scroller\"]//ul[@class=\"k-list k-reset\"]")));

        List<WebElement> propertyElements = listProperty.findElements(By.tagName("li"));

        for (WebElement propertyElement : propertyElements) {
            String propertyName = propertyElement.getText();
            System.out.println(propertyName);
        }
    }

    public void selectCasinoProperty() { //кликаем на Казино
        propertyLine.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"k-list-scroller\"]//ul[@class=\"k-list k-reset\"]")));

        List<WebElement> propertyElements = listProperty.findElements(By.tagName("li"));

        for (WebElement propertyElement : propertyElements) {
            String propertyName = propertyElement.getText();

            if (propertyName.contains("Casino")) { // Проверяем, содержит ли текст элемента "Casino"
                propertyElement.click(); // Кликаем на элемент, если текст соответствует "Casino"
                break; // Мы можем выйти из цикла, так как нашли нужный элемент
            }
        }
    }

    public void selectItalianRestDepartment() {
        departmentLine.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"k-list-scroller\"]//ul[@class=\"k-list k-reset\"]")));

        List<WebElement> departmentElements = listDepartment.findElements(By.tagName("li"));

        for (WebElement departmentElement : departmentElements) {
            String propertyName = departmentElement.getText();

            if (propertyName.contains("Italian restaurant")) { // Проверяем, содержит ли текст элемента "Italian restaurant"

                WebDriverWait clickWait = new WebDriverWait(driver, Duration.ofSeconds(20));//ожидпние перед кликом, так как элемент перекрывался
                WebElement italianRestaurantElement = clickWait.until(ExpectedConditions.elementToBeClickable(departmentElement));

                italianRestaurantElement.click(); // Кликаем на элемент, если текст соответствует "Casino"
                break; // Мы можем выйти из цикла, так как нашли нужный элемент
            }
        }
    }

    public void clickJobClassificationLine() { //вести имя джоб в стрроку фильтра и выбрать её
        jobClassificationLine.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/kendo-popup/div/kendo-list/div[2]")));
    }

    public void enterJobName() {//вводим имя Джобы и ждём сто она появится в списке т.е отфильтруется
        jobFilterLineByName.sendKeys("clean");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/kendo-popup/div/kendo-list/div[2]"))); //список джобов

    }

    public void clickCleanerJobClass() { // находим джобу в списке и кликаем
        List<WebElement> jobClassNames = jobClassifList.findElements(By.tagName("li"));

        for (WebElement jobElement : jobClassNames) {
            String jobName = jobElement.getText();
            if (jobName.contains("Cleaner")) { // Проверяем, содержит ли текст элемента "Cleaner"
                jobElement.click(); // Кликаем на элемент, если текст соответствует "Casino"
                break; // Мы можем выйти из цикла, так как нашли нужный элемент
            }
        }
    }

    public void clickTipTypeLine() {
        tipTypeLine.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/kendo-popup/div/kendo-list/div")));

        List<WebElement> tipTipeElements = listTipType.findElements(By.tagName("li"));

        for (WebElement tipTypeElement : tipTipeElements) {
            String tipTypeName = tipTypeElement.getText();

            if (tipTypeName.contains("NonTipped")) { // Проверяем, содержит ли текст элемента "NonTipped"
                tipTypeElement.click(); // Кликаем на элемент, если текст соответствует "NonTipped"
                break; // Мы можем выйти из цикла, так как нашли нужный элемент
            }
        }
    }

    public void clickContactPerson() {
        contactPersonLine.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/kendo-popup/div/kendo-list/div")));
        List<WebElement> contactPersonElements = contactPersonList.findElements(By.tagName("li"));
        for (WebElement contactPersonElement : contactPersonElements) {
            String contactPersonName = contactPersonElement.getText();
            if (contactPersonName.contains("Elizabeth Harris")) {
                contactPersonElement.click();
                break;
            }
        }

    }

    public void clickSaveAndNextButton() {
        saveAndNextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(secondStepSchedule));// Ожидаем, что визард станет видимым
        Assert.assertTrue(secondStepSchedule.isDisplayed(), "The second step did not appear after performing the action.");
    }// Проверяем, что визард успешно появился на странице

}





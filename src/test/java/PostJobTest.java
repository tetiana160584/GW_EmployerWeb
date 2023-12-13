import configuration.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MenuPage;
import pages.LoginPage;
import pages.wizard.GeneralPage;
import pages.wizard.SchedulePage;
import pages.wizard.Instructions;
import pages.wizard.CandidatesPage;
import pages.wizard.PublishPage;

import java.time.Duration;

public class PostJobTest extends BaseClass {
    MenuPage menuPage; //главная страница page
    LoginPage loginPage; //логин страница
    GeneralPage generalPage;
    SchedulePage schedulePage;
    Instructions instructions;
    CandidatesPage candidatesPage;
    PublishPage publishPage;
    @BeforeClass
    public void openSite() {
        // url сайта
        String siteUrl = "https://polite-stone-09089fb1e.3.azurestaticapps.net/";
        driver.get(siteUrl);
        menuPage = PageFactory.initElements(driver, MenuPage.class);//инициализация page
        loginPage=PageFactory.initElements(driver,pages.LoginPage.class);//инициализ страницы логин
        generalPage=PageFactory.initElements(driver,pages.wizard.GeneralPage.class); //иниц страницы 1-й визарда
        schedulePage=PageFactory.initElements(driver, pages.wizard.SchedulePage.class);
        instructions=PageFactory.initElements(driver,pages.wizard.Instructions.class);
        candidatesPage=PageFactory.initElements(driver,pages.wizard.CandidatesPage.class);
        publishPage=PageFactory.initElements(driver,pages.wizard.PublishPage.class);
    }

    @Test(priority = 0)
    public void testCheckStringsText(){
        loginPage.checkStringText();
    }
    @Test(priority = 1, dependsOnMethods = {"testCheckStringsText"})
    public void testEnterEmail() {
        loginPage.enterEmail();
    }

    @Test(priority = 2)
    public void testEnterPassword() {
        loginPage.enterPassword();
    }

    @Test(priority = 3)
    public void testClickSignInButton() {
        loginPage.clickSignInButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinner"))); //перекрывается элемент поэтому ожидпние
    }
    @Test(priority = 4)
    public void testClickNewJobButton() {
        menuPage.clickNewJobButton();

    }
    @Test(priority = 5)
    public void testCheckWizard() {
        menuPage.wizardAppears(driver);
    }

//    @Test(priority = 5, dependsOnMethods = {"testCheckWizard"}) //тест с выводом списка проперти
//    public void testClickPropertyLine() {
//        postJobPage.clickPropertyLine();
//    }
    @Test(priority =6, dependsOnMethods ={"testCheckWizard"}) //кликает на Казино
    public void testSelectCasino() {
        generalPage.selectCasinoProperty();

    }
    @Test(priority = 7, dependsOnMethods = {"testSelectCasino"})
    public void testSelectDepartment(){
        generalPage.selectItalianRestDepartment();
    }

    @Test(priority = 8, dependsOnMethods = {"testSelectDepartment"})
    public void testSelectCleanerJobClasByName(){
        generalPage.clickJobClassificationLine();
    }

    @Test(priority = 9, dependsOnMethods = {"testSelectCleanerJobClasByName"})
    public void testEnterCleanerJobClass()  {
        generalPage.enterJobName();
    }
    @Test(priority = 10, dependsOnMethods = {"testEnterCleanerJobClass"})
    public void getJobClassNames()  {
        generalPage.clickCleanerJobClass();
    }

    @Test(priority = 11, dependsOnMethods = {"getJobClassNames"})
    public void testEnterTipType(){
        generalPage.clickTipTypeLine();
    }

    @Test(priority = 12, dependsOnMethods = {"testEnterTipType"})
    public void testEnterContactPerson(){
        generalPage.clickContactPerson();
    }

    @Test(priority = 13, dependsOnMethods = {"testEnterContactPerson"})
    public void testClickSaveAndNextButton(){
        generalPage.clickSaveAndNextButton();
    }

    @Test(priority = 14, dependsOnMethods = {"testClickSaveAndNextButton"})
    public void testClickIconCalendar(){
        schedulePage.clickIconCalendar();
    }

    @Test (priority = 15,dependsOnMethods = {"testClickIconCalendar"})
    public void testClickSaveAndNext (){
        schedulePage.clickSaveAndNextButton();
    }

    @Test(priority = 16,dependsOnMethods = {"testClickSaveAndNext"})
    public void testHeaderText(){
        instructions.expanderHeaderText();
    }

    @Test(priority = 17, dependsOnMethods = {"testHeaderText"})
    public void testClickNext(){
       instructions.nextButton();
    }
    @Test(priority = 18, dependsOnMethods = {"testClickNext"})
    public void testClickSkipButton(){
        candidatesPage.clickSkipButton();
    }

    @Test(priority = 19, dependsOnMethods = {"testClickSkipButton"})
    public void testCheckElements(){
        publishPage.checkElements();
    }

    @Test(priority = 20)
    public void testClickPublishButton(){
        publishPage.clickPublishButton();
    }

    @Test(priority = 21)
    public void testClickCancelJobButton(){
        publishPage.clickCancelJobButton();
    }
    @Test(priority = 22)
    public void testCheckConfirmPopup(){
        publishPage.checkCancelConfirmPopup();
        publishPage.clickYesCancelJob();
    }

}

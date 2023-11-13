package pages.wizard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static configuration.BaseClass.driver;

public class SchedulePage {
    @FindBy(xpath = "/html/body/app-root/app-layout/main/div/div[2]/div/app-jobs/app-job-create-publish-wizard/app-job-create-publish-wizard-common/app-form-window-layout/kendo-window/div/div[1]/form/app-job-shifts-step/app-job-create-publish-shifts/form/div/div[2]/kendo-formfield/div/kendo-datepicker/span/span/span")
    private WebElement iconCalendar;

    @FindBy(xpath = "// table[@class=\"k-calendar-table\"]")
    private WebElement calendarList;

    @FindBy(className = "text")
    private WebElement saveAndNextButton;



    public void clickIconCalendar()  {
        iconCalendar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("// table[@class=\"k-calendar-table\"]")));

//        // Найдем все строки (недели) в календаре. Эта часть не нужна, итак ищет
//        List<WebElement> weekLines = calendarList.findElements(By.tagName("tr"));
//        for (WebElement weekLine : weekLines) {

            List<WebElement> calendarElements = calendarList.findElements(By.tagName("td"));  // Найдем все ячейки (дни) в календаре

            // Найдем ячейку с текущей датой и кликнем на следующую после нее
            for (WebElement todayData : calendarElements) {
                if (todayData.getAttribute("class").contains("k-today")) {
                    int currentIndex = calendarElements.indexOf(todayData);
                    int nextIndex = currentIndex + 1;

                    // Проверяем, что следующий индекс находится в пределах списка и кликаем на эту ячейку
                    if (nextIndex < calendarElements.size()) {
                        calendarElements.get(nextIndex).click();
                        break;
                    }
                }
            }
        }
//   }

   public void clickSaveAndNextButton()  {
        saveAndNextButton.click();


   }
}



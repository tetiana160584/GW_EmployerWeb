package pages.wizard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublishPage {
    @FindBy(className = "text")
    private WebElement publishButton;

    public void clickPublishButton(){
        publishButton.click();
    }
}

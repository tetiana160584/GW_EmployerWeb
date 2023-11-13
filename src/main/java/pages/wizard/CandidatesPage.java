package pages.wizard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CandidatesPage {
    @FindBy(className = "text")
    private WebElement skipButton;

    public void clickSkipButton() {
        skipButton.click();
    }
}

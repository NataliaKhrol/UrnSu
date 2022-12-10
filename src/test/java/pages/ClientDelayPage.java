package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClientDelayPage extends BasePage{
    public ClientDelayPage(WebDriver driver) {
        super(driver);
    }
    private By BUTTON_TRIGGERING = By.xpath("//button[contains(text(), \"Button Triggering Client Side Logic\")]");
    private By TEXT = By.xpath("//p[contains(text(), \"Data calculated on the client side.\")]");

    public void triggerText() {
        driver.findElement(BUTTON_TRIGGERING).click();

    }

    public String textMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT)).getText();
        return text;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickPage extends BasePage{
    public ClickPage(WebDriver driver) {
        super(driver);
    }
    private By CLICK_BUTTON = By.id("badButton");

    public void openPage() {
        driver.get(BASE_URL+"/click");
    }

    public void tryClick() {
        driver.findElement(CLICK_BUTTON).click();
    }
}

package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassAttributePage extends BasePage {
    public ClassAttributePage(WebDriver driver) {
        super(driver);
    }

    private By BLUE_BUTTON = By.xpath("//button[@class='btn class3 btn-primary btn-test']");

    public void openPage() {
        driver.get(BASE_URL + "/classattr");
    }

    public void newPage() {
        driver.get(BASE_URL + "/clientdelay");
    }
    public void record() {
        driver.findElement(BLUE_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

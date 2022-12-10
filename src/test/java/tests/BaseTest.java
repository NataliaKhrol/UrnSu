package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import pages.ClassAttributePage;
import pages.ClientDelayPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    BasePage basePage;
    ClassAttributePage classAttributePage;
    ClientDelayPage clientDelayPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening the browser")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
          //  options.setHeadless(true);
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        basePage = new BasePage(driver);
        classAttributePage = new ClassAttributePage(driver);
        clientDelayPage = new ClientDelayPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void close() {
        if (driver != null) {
         //   driver.quit();
        }
    }
}

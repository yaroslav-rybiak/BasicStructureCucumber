package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

@CucumberOptions(features = "src/test/java/features", glue = "steps")
public class TestRunner extends AbstractTestNGCucumberTests {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 1);
    }

    @AfterSuite(alwaysRun = true)
    public void stopDriver() {
        driver.quit();
        driver = null;
    }
}
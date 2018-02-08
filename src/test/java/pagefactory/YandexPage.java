package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YandexPage extends PageBase {

    //constructor
    public YandexPage(WebDriver driver){
        URL = "https://ya.ru/";
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="text")
    @CacheLookup
    private WebElement searchField;

    public void search(String query) {
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isOnResultPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("serp-adv__counter")));
        return driver.getCurrentUrl().contains("/search/?");
    }
}

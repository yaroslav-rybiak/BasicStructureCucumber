package pagefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends PageBase {

    //constructor
    public GooglePage(WebDriver driver){
        URL = "https://www.google.com/ncr";
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="q")
    @CacheLookup
    private WebElement searchField;

    public void search(String query) {
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean isOnResultPage() {
        return driver.getCurrentUrl().contains("/search?");
    }
}

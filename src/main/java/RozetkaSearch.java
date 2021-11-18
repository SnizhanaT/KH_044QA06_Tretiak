import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaSearch {
    static String url = "https://rozetka.com.ua/";
    static String query = "чашка";
    static By inputSearch = By.cssSelector("input.search-form__input");
    static By searchResults = By.cssSelector(".catalog-grid li");
    static By buyButton = By.cssSelector(".toOrder.ng-star-inserted");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        try {
            driver1.manage().window().maximize();
            WebDriverWait wait1 = new WebDriverWait(driver1, 15);
            driver1.get(url);

            wait1.until(ExpectedConditions.visibilityOfElementLocated(inputSearch));
            WebElement searchInput = driver1.findElement(inputSearch);
            searchInput.clear();
            searchInput.sendKeys(query);
            searchInput.sendKeys(Keys.ENTER);

            wait1.until(driver2 -> driver1.findElement(searchResults).isDisplayed());
            List<WebElement> results = driver1.findElements(searchResults);
            WebElement firstResult = results.get(0);
            firstResult.click();

            wait1.until(ExpectedConditions.visibilityOfElementLocated(buyButton));
            WebElement buttonBuy = driver1.findElement(buyButton);
            Actions actions = new Actions(driver1);
            actions.moveToElement(buttonBuy).click().build().perform();
        } finally {
            driver1.quit();
        }
    }
}

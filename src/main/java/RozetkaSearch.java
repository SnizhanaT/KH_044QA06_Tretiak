import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 8);
        driver.get(url);

        wait.until(ExpectedConditions.visibilityOfElementLocated(inputSearch));
        WebElement searchInput = driver.findElement(inputSearch);
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.ENTER);

        wait.until(driver1 -> driver.findElement(searchResults).isDisplayed());
        List<WebElement> results = driver.findElements(searchResults);
        WebElement firstResult = results.get(0);
        firstResult.click();

        wait.until(ExpectedConditions.elementToBeClickable(buyButton));
        WebElement buttonBuy = driver.findElement(buyButton);
        buttonBuy.click();

        driver.quit();
    }
}

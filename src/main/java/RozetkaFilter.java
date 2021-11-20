import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaFilter {
    static String url = "https://rozetka.com.ua/";
    static String filter = "продавец";
    static By catalog = By.cssSelector("#fat-menu");
    static By monitors = By.xpath("(//a[contains(@href,'monitors')])[2]");
    //static By filterList = By.xpath("//ul[@class='checkbox-filter']//li");
    static By checkboxRozetka = By.xpath("//label[contains(text(),'Rozetka')]/../input[@type='checkbox']/..");
    static By filterResults = By.cssSelector(".catalog-grid li");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.get(url);

            wait.until(ExpectedConditions.visibilityOfElementLocated(catalog));
            WebElement catalogButton = driver.findElement(catalog);
            catalogButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(monitors));
            WebElement monitorsButton = driver.findElement(monitors);
            monitorsButton.click();

            //wait.until(driver1 -> driver.findElement(filterList).isDisplayed());
            //List<WebElement> filterOptions = driver.findElements(filterList);
            //filterOptions.get(1).click();
            wait.until(ExpectedConditions.elementToBeClickable(checkboxRozetka));
            WebElement sellerRozetka = driver.findElement(checkboxRozetka);
            Actions actions = new Actions(driver);
            actions.moveToElement(sellerRozetka).click().build().perform();

            wait.until(driver1 -> driver.findElement(filterResults).isDisplayed());
            List<WebElement> results = driver.findElements(filterResults);
            WebElement firstResult = results.get(0);
            firstResult.click();
        }
        finally {
            driver.quit();
        }

    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");

            WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            searchField.clear();
            searchField.sendKeys("rozetka ua");
            searchField.sendKeys(Keys.ENTER);
        /*
        WebElement searchButton = driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]"));
        searchButton.click();
        */

            WebElement rozetkaLink = driver.findElement(By.xpath("(//div[@class='yuRUbf']//a)[1]"));
            rozetkaLink.click();

            WebElement rozetkasearchField = driver.findElement(By.xpath("//input[@search-input]"));
            rozetkasearchField.clear();
            rozetkasearchField.sendKeys("шапка");
            rozetkasearchField.sendKeys(Keys.ENTER);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement firstProduct = driver.findElement(By.xpath("(//div[@data-goods-id='106452141']//a)[2]"));
            firstProduct.click();

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement buyButton = driver.findElement(By.cssSelector("button.button_size_large"));
            buyButton.click();

            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            driver.quit();
        }
    }
}

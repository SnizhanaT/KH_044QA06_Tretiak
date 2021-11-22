import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver = null;
    WebDriverWait wait = null;

    @BeforeSuite(alwaysRun = true)
    public void setDriverProperties() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://rozetka.com.ua/");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}

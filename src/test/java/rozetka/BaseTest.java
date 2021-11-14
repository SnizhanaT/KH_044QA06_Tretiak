package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver = null;

    @BeforeSuite
    public void setDriverProperties() {
        System.out.println("BaseTestClass before suite method - driver properties");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void setUpDriver() {
        System.out.println("BaseTest before method - open browser and get url");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rozetka.com.ua/");
    }

    @AfterMethod
    public void closeDriver() {
        System.out.println("BaseTest After method - quit browser");
        driver.quit();
    }
}

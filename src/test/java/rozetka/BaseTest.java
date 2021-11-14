package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver = null;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BaseTestClass before suite method - driver properties");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BaseTest before method - open browser and get url");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("BaseTest After method - quit browser");
        driver.quit();
    }
}

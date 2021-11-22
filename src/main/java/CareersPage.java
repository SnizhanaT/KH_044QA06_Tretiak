import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage extends BasePage {
    private By vacanciesLink = new By.ByXPath("//a[contains(@href,'careers')]");
    private By wantWork = new By.ByXPath("//button[contains(@class,'want-work')]");
    private By formFirstNameInput = new By.ByXPath("//input[@id='first_name']");

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCareersPage() {
        WebElement careersPage = driver.findElement(vacanciesLink);
        careersPage.click();
    }

    public void openWantWorkForm() {
        WebElement wantWorkButton = driver.findElement(wantWork);
        Actions actions = new Actions(driver);
        actions.moveToElement(wantWorkButton).click().build().perform();
    }

    public void setFormFirstName(String firstName) {
       // WebDriverWait wait = new WebDriverWait(driver,15);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(formFirstNameInput));
        WebElement firstNameRowInput = driver.findElement(formFirstNameInput);
        firstNameRowInput.sendKeys(firstName);
        firstNameRowInput.sendKeys(Keys.ENTER);
    }

}

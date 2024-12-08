import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WantWorkFormTest extends BaseTest {
    @BeforeMethod
    public void setUpWantWorkForm() {
        HomePage homePage = new HomePage(driver);
        homePage.openHeaderMenu();

        CareersPage careersPage = new CareersPage(driver);
        careersPage.openCareersPage();
        careersPage.openWantWorkForm();
    }

    @Test
    public void getFirstNameValidationMessage(){
        String invalidFirstName = "Name";
        CareersPage careersPage = new CareersPage(driver);
        careersPage.setFormFirstName(invalidFirstName);
        WebElement formError = driver.findElement(By.xpath("//form-error"));
        Assert.assertTrue(formError.isDisplayed());
    }

    @Test
    public void attachFile() {
        CareersPage careersPage = new CareersPage(driver);
        String javascript = "document.getElementById('files')";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement chooseFileButton = (WebElement) js.executeScript(javascript);
        chooseFileButton.sendKeys("src/main/resources/testcv.docx"); //як передати сюди документ

    }

}

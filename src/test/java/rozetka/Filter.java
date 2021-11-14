package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

public class Filter extends BaseTest{

    static By catalog = By.cssSelector("#fat-menu");
    static By monitors = By.xpath("(//a[contains(@href,'monitors')])[2]");
    static By checkboxRozetka = By.xpath("//label[contains(text(),'Rozetka')]/../input[@type='checkbox']/..");
    static By checkboxBrandAsus = By.xpath("//label[contains(text(),'Asus')]/../input[@type='checkbox']/..");
    static By filterResults = By.cssSelector(".catalog-grid li");
    WebDriverWait wait;

    @Test(groups = {"functest"})
    public void getRozetkaSellerFilterResult(){
        System.out.println("FilterClass method 1 - filter on seller rozetka");
        WebElement catalogButton = driver.findElement(catalog);
        catalogButton.click();

        wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(monitors));
        WebElement monitorsButton = driver.findElement(monitors);
        monitorsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkboxRozetka));
        WebElement sellerRozetka = driver.findElement(checkboxRozetka);
        Actions actions = new Actions(driver);
        actions.moveToElement(sellerRozetka).click().build().perform();

        wait.until(driver1 -> driver.findElement(filterResults).isDisplayed());
        List<WebElement> results = driver.findElements(filterResults);
        WebElement firstResult = results.get(0);
        firstResult.click();
    }

    @Test(groups = {"positivetest"})
    public void getBrandFilterResult(){
        System.out.println("FilterClass method 2 - filter on brand asus");
        WebElement catalogButton = driver.findElement(catalog);
        catalogButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(monitors));
        WebElement monitorsButton = driver.findElement(monitors);
        monitorsButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(checkboxBrandAsus));
        WebElement brandAsus = driver.findElement(checkboxBrandAsus);
        Actions actions = new Actions(driver);
        actions.moveToElement(brandAsus).click().build().perform();

    }

}

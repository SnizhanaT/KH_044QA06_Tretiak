import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class FilterTest extends BaseTest {

    static By monitors = By.xpath("(//a[contains(@href,'monitors')])[2]");
    static By checkboxRozetka = By.xpath("//label[contains(text(),'Rozetka')]/../input[@type='checkbox']/..");
    static By checkboxBrandAsus = By.xpath("//label[contains(text(),'Asus')]/../input[@type='checkbox']/..");
    static By filterResults = By.cssSelector(".catalog-grid li");

    @Test(groups = {"functest"})
    public void getRozetkaSellerFilterResult() {
        HomePage homepage = new HomePage(driver);
        homepage.openCatalog();

        homepage.openCategoryPageFromCatalog(monitors);

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
    public void getBrandFilterResult() {
        HomePage homepage = new HomePage(driver);
        homepage.openCatalog();

        homepage.openCategoryPageFromCatalog(monitors);

        wait.until(ExpectedConditions.elementToBeClickable(checkboxBrandAsus));
        WebElement brandAsus = driver.findElement(checkboxBrandAsus);
        Actions actions = new Actions(driver);
        actions.moveToElement(brandAsus).click().build().perform();
    }

}

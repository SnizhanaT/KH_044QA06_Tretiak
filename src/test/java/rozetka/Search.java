package rozetka;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

public class Search extends BaseTest{

    @DataProvider(name = "searchInput")
    public Object[][] getSearchWord() {
        return new Object[][] {
                { "Cup" },
                { "Чашка" },
        };
    }

    @Test(dataProvider = "searchInput", groups = {"functest"})
    public void setSearchInput(String searchInput){
        System.out.println("SearchClass getRozetkaSellerFilterResult - search in Eng, Ukr");
        WebElement searchField = driver.findElement(By.xpath("//input[@search-input]"));
        searchField.clear();
        searchField.sendKeys(searchInput);
        searchField.sendKeys(Keys.ENTER);
    }

    @Test(groups = {"positivetest"})
    public void getFirstSearchResult(){
        System.out.println("SearchClass getOtherSellerFilterResult - open first search result");
        WebElement searchField = driver.findElement(By.xpath("//input[@search-input]"));
        searchField.clear();
        searchField.sendKeys("чашка");
        searchField.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(driver1 -> driver.findElement(By.cssSelector(".catalog-grid li")).isDisplayed());
        List<WebElement> results = driver.findElements(By.cssSelector(".catalog-grid li"));
        WebElement firstResult = results.get(0);
        firstResult.click();
    }
}

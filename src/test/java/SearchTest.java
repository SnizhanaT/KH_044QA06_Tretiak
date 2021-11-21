import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

public class SearchTest extends BaseTest {

    @DataProvider(name = "searchInput")
    public Object[][] getSearchWord() {
        return new Object[][]{
                {"Cup"},
                {"Чашка"},
        };
    }

    @Test(dataProvider = "searchInput", groups = {"functest"})
    public void searchInputTest(String searchInput) {
        WebElement searchField = driver.findElement(By.xpath("//input[@search-input]"));
        searchField.clear();
        searchField.sendKeys(searchInput);
        searchField.sendKeys(Keys.ENTER);
    }

    @Test(groups = {"positivetest"})
    public void searchResultsTitleTest() {
        String query = "чашка";
        HomePage homepage = new HomePage(driver);
        homepage.search(query);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<String> resultsTitles = searchResultsPage.getResultsTitles();
        for (String title : resultsTitles) {
            System.out.println(title);
            Assert.assertTrue(title.toLowerCase().contains(query));
        }
    }
}

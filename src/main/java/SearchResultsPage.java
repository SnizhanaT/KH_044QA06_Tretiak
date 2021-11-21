import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {
    private By results = new By.ByCssSelector("section.content .goods-tile");
    private By titleXPath = new By.ByXPath(".//span[@class='goods-tile__title']");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getResultsTitles() {
        List<WebElement> resultsWebElements = driver.findElements(results);
        List<String> titles = new ArrayList<>();
        for (WebElement result : resultsWebElements) {
            WebElement titleWebElement = driver.findElement(titleXPath);
            titles.add(titleWebElement.getText());
        }
        return titles;
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    private By searchInput = new By.ByXPath("//input[@name='search']");
    private By searchButton = new By.ByCssSelector("button.search-form__submit");
    private By headerMenu = new By.ByXPath("//button[@class='header__button']");
    private By catalog = By.cssSelector("#fat-menu");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHeaderMenu() {
        WebElement headerMenuButton = driver.findElement(headerMenu);
        headerMenuButton.click();
    }

    public void openCatalog() {
        WebElement catalogButton = driver.findElement(catalog);
        catalogButton.click();
    }

    public void openCategoryPageFromCatalog(By categoryXpath) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryXpath));
        WebElement category = driver.findElement(categoryXpath);
        category.click();
    }

    public SearchResultsPage search(String searchQuery) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchQuery);
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }

}

import entity.SearchFlight;
import exceptions.MaximumPassengerNumberException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class Main {

    public static void previous(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        // go to the webpage
        driver.get("https://www.opodo.com");
        Thread.sleep(5000);

        // click on passenger input
        WebElement webTaxElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pax-selector")));
        webTaxElement.click();

        Thread.sleep(5000);

        // Click 8 times on add adult passenger button to make maximum of adults
        WebElement addAdults = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.od-aside-button.inc")));
        for (int i = 0; i < 8; i++) {
            addAdults.click();
        }

        Thread.sleep(5000);

        // Compare actual value with expected
        String actual = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.cssSelector("span.od-ui-paxSelector-info-txt.ui_paxSelector_info_txt"))).getText();
        String expected = "The maximum number of passengers is 9.";

        System.out.println(actual.equals(expected) ? "Expected equals actual" : "Expected not equal actual");
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://www.opodo.com");

        MainPage mainPage = new MainPage(driver);

        try {
            mainPage.searchFlights(new SearchFlight("", "", "", "", 8, 0, 0));
        } catch (MaximumPassengerNumberException e) {
            String expected = "The maximum number of passengers is 9.";
            System.out.println(e.getMessage().equals(expected)? "ACTUAL equals EXPECTED" : "ACTUAL NOT equals EXPECTED");
        }

        driver.close();
    }
}

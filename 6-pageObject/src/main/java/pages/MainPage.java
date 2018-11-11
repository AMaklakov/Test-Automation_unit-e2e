package pages;

import entity.SearchFlight;
import exceptions.MaximumPassengerNumberException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private static String URL_MATCH = "/";
    private WebDriver driver;

    @FindBy(id = "pax-selector")
    private WebElement bOpenDropdown;

    @FindBy(css = "div.od-aside-button.inc")
    private WebElement bAddAdults;

    @FindBy(css = "span.od-ui-paxSelector-info-txt.ui_paxSelector_info_txt")
    private WebElement textPassengerError;

    @FindBy(className = "od-flightsManager-search-flight-button od-button-overlay search_flight_button wl-bookingcom-button")
    private WebElement bSearchFlights;


    public MainPage(WebDriver driver) {
        if (!driver.getCurrentUrl().contains(URL_MATCH)) {
            throw new IllegalStateException("This is not the page you are expected");
        }

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void searchFlights(SearchFlight searchFlight) throws MaximumPassengerNumberException {
        chooseAirports(searchFlight.from, searchFlight.to);
        setDate(searchFlight.departureDate, searchFlight.returnDate);
        setPassengers(searchFlight.adults, searchFlight.children, searchFlight.infants);

        bSearchFlights.click();
    }

    private void chooseAirports(String airportFrom, String airportTo) {
        // I don't need it for my spec
    }

    private void setDate(String dateFrom, String dateTo) {
        // I don't need it for my spec
    }

    private void setPassengers(int adults, int children, int infants) throws MaximumPassengerNumberException {
        waitForVisibility(bOpenDropdown).click();    // open dropdown

        if (adults > 0) {
            System.out.println("HERE1");
            addPassengersTimes(bAddAdults, adults);

            if (checkMaxPassengerInfo()) {
                throw new MaximumPassengerNumberException(textPassengerError.getText());
            }
        }

        if (children > 0) {
            // add children
        }

        if (infants > 0) {
            // add infants
        }
    }

    private void addPassengersTimes(WebElement element, int times) {
        if (times > 0) {
            for (int i = 0; i < times; i++) {
                element.click();
            }
        }
    }

    private boolean checkMaxPassengerInfo() {
        try {
            textPassengerError.getText();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
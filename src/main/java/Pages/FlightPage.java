package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightPage{

    WebDriver driver;
    WebDriverWait wait;

    //click on flight
    @FindBy(css = "button[class='nav-link w-100 active waves-effect'] span")
    WebElement flight;

    //oneway
    @FindBy(css = "#one-way")
    WebElement oneWay;

    //flyingFrom dropdown1
    @FindBy(css = "[data-select2-id='2'] b")
    WebElement dropDown1;

    //search box
    @FindBy(css = "input[type='search']")
    WebElement dropDownSearch;

//    //select berlin from the list
//    @FindBy(xpath = "//*[@id='select2--results']//li[contains(text(), '')]")
//    WebElement berlinName;

    //destination dropdown2
    @FindBy(css = "[data-select2-id='5'] b")
    WebElement destinationDropDown;

    // type into the search box
    @FindBy(css = "input[role='searchbox']")
    WebElement destinationSearch;

//    //select Istanbul from the dropdown
//    @FindBy(xpath = "//span[@class='select2-container select2-container--default select2-container--open']//div[2]")
//    WebElement delhi;

    //departure date
    @FindBy(css = "div.form-floating input[name='depart']")
    WebElement departureDate;

    @FindBy(xpath = "(//td[contains(text(),'26')])[2]")
    WebElement datee;

    @FindBy(xpath = "//select[@id='flight_type']")
    WebElement bus;

    @FindBy(xpath = "//button[@id='flights-search']")
    WebElement search;

    //traverller drop down
    @FindBy(css = ".dropdown-toggle.dropdown-btn.travellers.waves-effect")
    WebElement travel;

    @FindBy(xpath = "body > main:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > svg:nth-child(1) > line:nth-child(3)")
    WebElement adult;


public FlightPage(WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    PageFactory.initElements(driver,this);
}
public void scrollPage(int pixels){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,"+pixels+")");
}
    public void selectBusiness(String buss) {
        Select select = new Select(bus);
        select.selectByVisibleText(buss);
    }

public void OneWayFlight(String berlin, String destination, String bus){
    try {
        //click on oneWay
        oneWay.click();
        System.out.println("oneway");

        //click on Flying from dropdown
        dropDown1.click();

        //type inside the search box
        dropDownSearch.sendKeys(berlin);
        Thread.sleep(4000);

        //click on berlin from the search box

//        berlinName.click();
        System.out.println("berlin ");

        //click on the drop down of the destination
        destinationDropDown.click();

        //search for destination
        destinationSearch.sendKeys(destination);

        //click on delhi from the search box


        //departure date
        wait.until(ExpectedConditions.elementToBeClickable(departureDate)).click();
        departureDate.clear();
        departureDate.sendKeys("25-09-2024");
        System.out.println("departure");
        scrollPage(100);


        selectBusiness(bus);
        System.out.println("select economy business");



        travel.click();
        System.out.println("travel");
        wait.until(ExpectedConditions.elementToBeClickable(adult)).click();
        System.out.println("adult selected");

        Thread.sleep(4000);
        //click on search
        search.click();

        System.out.println("search");
        Thread.sleep(4000);




        Thread.sleep(3000);






    }
    catch (NoSuchElementException e){
        System.out.println("No such element");
        throw e;
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}



}

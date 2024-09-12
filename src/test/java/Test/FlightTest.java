package Test;

import Pages.FlightPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightTest extends BrowserFactory {

    @BeforeTest
    public void setUpTest(){
        String browserType = "chrome";
        String url = "https://www.phptravels.net/";
        setUp(url,browserType);
    }

    @Test
    public void firstPage(){
        WebDriver driver = BrowserFactory.getDriver();
        String title = driver.getTitle();
        System.out.println(title);

        FlightPage page = new FlightPage(driver);

        page.OneWayFlight("Berlin","Istanbul","Economy");

    }

    @AfterTest
    public void tearDown(){
        super.tearDown();
    }

}

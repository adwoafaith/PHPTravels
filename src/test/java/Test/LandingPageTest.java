package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LandingPageTest extends BrowserFactory {

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
    }

    @AfterTest
    public void tearDown(){
        super.tearDown();
    }

}

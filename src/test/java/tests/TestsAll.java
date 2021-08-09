package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

public class TestsAll {

    protected WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    private void setUp() {
        Log.info("Open page: Address Book - Sign In");
        driver.get("http://a.testaddressbook.com/sign_in");

        Log.info("Header check");
        String header = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", header,
                "The wrong page is open");
    }

    @AfterAll
    private void tearDown() {
        Log.info("Close browser");
        driver.quit();
    }

}

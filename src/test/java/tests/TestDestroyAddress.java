package tests;

import org.junit.jupiter.api.*;
import utils.Log;
import utils.LoginUtil;

import static locators.AddressLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDestroyAddress extends LoginUtil {

    @Test
    @Order(1)
    @DisplayName("User destroy one address.")
    public void openProfile() {
        getToLogin();

        Log.info("Click on 'Addresses'");
        driver.findElement(SEARCH_BUTTON_ADDRESSES).click();
        Log.info("Click on 'Destroy'");
        Assertions.assertTrue(driver.findElement(SEARCH_BUTTON_DESTROY).isDisplayed());
        driver.findElement(SEARCH_BUTTON_DESTROY).click();
        driver.switchTo().alert().accept();

        String currentNotice = driver.findElement(CURRENT_NOTICE).getText();
        Assertions.assertEquals(ALERT_DESTROY_NOTICE, currentNotice,
                "You couldn't destroy an address successfully.");
    }
}

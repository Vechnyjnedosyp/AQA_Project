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
    @DisplayName("User is logging on website.")
    public void openProfile() {
        getToLogin();
    }

    @Test
    @Order(2)
    @DisplayName("Destroy one address.")
    public void deleteAddress() {
        Log.info("Click on 'Addresses'");
        driver.findElement(SEARCH_BUTTON_ADDRESSES).click();
        Log.info("Click on 'Destroy'");
        driver.findElement(SEARCH_BUTTON_DESTROY).click();
        driver.switchTo().alert().accept();
        String currentNotice = driver.findElement(CURRENT_NOTICE).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(ALERT_DESTROY_NOTICE));
    }
}

package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.Log;
import utils.LoginUtil;

import static locators.LoginLocators.SEARCH_BUTTON_SIGN_OUT;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSignOut extends LoginUtil {

    @Test
    @DisplayName("It's test, which check opportunity to logout on website.")
    public void testSignOut() {
        Log.info("User is logging on website.");
        getToLogin();
        Log.info("User sign out a profile.");
        Assertions.assertTrue(driver.findElement(SEARCH_BUTTON_SIGN_OUT).isDisplayed());
        driver.findElement(SEARCH_BUTTON_SIGN_OUT).click();
    }
}

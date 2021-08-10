package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.Log;
import utils.LoginUtil;

import static locators.LoginLocators.SEARCH_BUTTON_SIGN_OUT;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSignOut extends LoginUtil {

    @Test
    public void testSignOut() {
        Log.info("User is logging on website.");
        getToLogin();
        Log.info("User sign out a profile.");
        driver.findElement(SEARCH_BUTTON_SIGN_OUT).click();
    }
}

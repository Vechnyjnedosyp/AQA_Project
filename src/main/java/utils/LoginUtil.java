package utils;

import static locators.LoginLocators.*;

public class LoginUtil extends TestsAll {

    public void getToLogin() {
        Log.info("Enter e-mail");
        driver.findElement(SEARCH_FIELD_EMAIL).sendKeys("bibaboba@test.com");
        Log.info("Enter password");
        driver.findElement(SEARCH_FIELD_PASSWORD).sendKeys("test1234");
        Log.info("Click on 'Sign in'");
        driver.findElement(SEARCH_BUTTON_SIGN_IN).click();
    }

}

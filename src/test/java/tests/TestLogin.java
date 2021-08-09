package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.Log;

import static locators.LoginLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLogin extends TestsAll {

    @Test
    @DisplayName("It's test, which check opportunity to login on website.")
    public void testLogin() {

        Log.info("Enter e-mail");
        driver.findElement(SEARCH_FIELD_EMAIL).sendKeys("bibaboba@test.com");
        Log.info("Enter password");
        driver.findElement(SEARCH_FIELD_PASSWORD).sendKeys("test1234");
        Log.info("Click on 'Sign in'");
        driver.findElement(SEARCH_BUTTON).click();

        Log.info("Check main header on page");
        String actualTitle = driver.findElement(ACTUAL_TITLE).getText();
        String currentUser = driver.findElement(CURRENT_USER).getText();
        Log.info("Check user's email on navigation");
        String expectedTitle = "Welcome to Address Book";
        System.out.println("Result actualTitle.equals(expectedTitle) " + actualTitle.contains(expectedTitle));
        System.out.println("Result currentUser.contains(userLogin) " + currentUser.contains("bibaboba@test.com"));
    }
}


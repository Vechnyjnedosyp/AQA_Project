package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.ui.Select;
import utils.Log;
import utils.LoginUtil;

import static locators.AddressLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestNewAddress extends LoginUtil {

    String testInfo = "Test";
    String testAge = "25";
    String testNumber = "+12345678";
    String testWebsite = "https://www.google.com/";
    String testNote = "It's my first autotests!";

    @Test
    @DisplayName("User make a new address.")
    public void openProfile() {
        getToLogin();
        Log.info("Click on 'Addresses'");
        driver.findElement(SEARCH_BUTTON_ADDRESSES).click();
        Log.info("Click on 'New Address'");
        driver.findElement(SEARCH_LINK_NEW_ADDRESS).click();

        Log.info("Enter first name");
        driver.findElement(SEARCH_FIELD_FIRST_NAME).sendKeys(testInfo);

        Log.info("Enter last name");
        driver.findElement(SEARCH_FIELD_LAST_NAME).sendKeys(testInfo);

        Log.info("Enter address1");
        driver.findElement(SEARCH_FIELD_ADDRESS1).sendKeys(testInfo);

        Log.info("Enter address2");
        driver.findElement(SEARCH_FIELD_ADDRESS2).sendKeys(testInfo);

        Log.info("Enter city");
        driver.findElement(SEARCH_FIELD_CITY).sendKeys(testInfo);

        Log.info("Enter zip code");
        driver.findElement(SEARCH_FIELD_ZIP_CODE).sendKeys(testInfo);

        Log.info("Choose a state");
        Select state = new Select(driver.findElement(SEARCH_FIELD_STATE));
        state.selectByValue("DE");

        Log.info("Choose a country");
        driver.findElement(SEARCH_BUTTON_COUNTRY).click();

        Log.info("Enter birthday");
        driver.findElement(SEARCH_FIELD_BIRTHDAY).sendKeys("20.07.2021");

        Log.info("Choose a color");
        driver.findElement(SEARCH_FIELD_COLOR).sendKeys("#ffc107");

        Log.info("Enter age");
        driver.findElement(SEARCH_FIELD_AGE).sendKeys(testAge);

        Log.info("Enter link of website");
        driver.findElement(SEARCH_FIELD_WEBSITE).sendKeys(testWebsite);

        Log.info("Add a picture");
        driver.findElement(SEARCH_FIELD_PICTURE).sendKeys("D:\\AQA\\AQA_Project\\src\\main\\resources\\Tests.png");

        Log.info("Enter a phone number");
        driver.findElement(SEARCH_FIELD_PHONE).sendKeys(testNumber);

        Log.info("Click on 'Reading'");
        driver.findElement(SEARCH_BUTTON_READ).click();

        Log.info("Enter a note");
        driver.findElement(SEARCH_FIELD_NOTE).sendKeys(testNote);

        Log.info("Click on 'Commit'");
        Assertions.assertTrue(driver.findElement(SEARCH_BUTTON_COMMIT).isDisplayed());
        driver.findElement(SEARCH_BUTTON_COMMIT).click();

        Log.info("Checking whether the address has been saved. ");
        String currentNotice = driver.findElement(CURRENT_NOTICE).getText();
        Assertions.assertEquals(ALERT_SAVE_NOTICE, currentNotice,
                "You couldn't make a new address successfully.");

    }

}


package tests;

import org.junit.jupiter.api.*;
import utils.Log;
import utils.LoginUtil;

import static locators.AddressLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEditAddress extends LoginUtil {

    String testEditInfo = "TestEdit";

    @Test
    @Order(1)
    @DisplayName("User edit one of addresses.")
    public void openProfile() {
        getToLogin();

        Log.info("Click on 'Addresses'");
        driver.findElement(SEARCH_BUTTON_ADDRESSES).click();
        Log.info("Click on 'Edit'");
        driver.findElement(SEARCH_BUTTON_EDIT).click();

        Log.info("Clear field 'first name'");
        driver.findElement(SEARCH_FIELD_FIRST_NAME).clear();
        Log.info("Enter new first name");
        driver.findElement(SEARCH_FIELD_FIRST_NAME).sendKeys(testEditInfo);

        Log.info("Clear field 'last name'");
        driver.findElement(SEARCH_FIELD_LAST_NAME).clear();
        Log.info("Enter new last name");
        driver.findElement(SEARCH_FIELD_LAST_NAME).sendKeys(testEditInfo);

        Log.info("Clear field 'address1'");
        driver.findElement(SEARCH_FIELD_ADDRESS1).clear();
        Log.info("Enter new address1");
        driver.findElement(SEARCH_FIELD_ADDRESS1).sendKeys(testEditInfo);

        Log.info("Clear field 'address2'");
        driver.findElement(SEARCH_FIELD_ADDRESS2).clear();
        Log.info("Enter new address2");
        driver.findElement(SEARCH_FIELD_ADDRESS2).sendKeys(testEditInfo);

        Log.info("Clear field 'city'");
        driver.findElement(SEARCH_FIELD_CITY).clear();
        Log.info("Enter new city");
        driver.findElement(SEARCH_FIELD_CITY).sendKeys(testEditInfo);

        Log.info("Clear field 'note'");
        driver.findElement(SEARCH_FIELD_NOTE).clear();
        Log.info("Enter new note");
        driver.findElement(SEARCH_FIELD_NOTE).sendKeys("This is the edited address.");


        Assertions.assertNotNull(SEARCH_BUTTON_UPDATE_ADDRESS);
        driver.findElement(SEARCH_BUTTON_UPDATE_ADDRESS).click();


        String currentNotice = driver.findElement(CURRENT_NOTICE).getText();
        Assertions.assertEquals(ALERT_EDIT_NOTICE, currentNotice,
                "You couldn't edit an address successfully.");

        Assertions.assertTrue(driver.findElement(SEARCH_LINK_LIST).isDisplayed());
        driver.findElement(SEARCH_LINK_LIST).click();
    }
}

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
    @DisplayName("User is logging on website.")
    public void openProfile() {
        getToLogin();
    }

    @Test
    @Order(2)
    @DisplayName("Open list of Addresses.")
    public void getListAddresses() {
        Log.info("Click on 'Addresses'");
        driver.findElement(SEARCH_BUTTON_ADDRESSES).click();
        Log.info("Click on 'Edit'");
        driver.findElement(SEARCH_BUTTON_EDIT).click();
    }

    @Test
    @Order(3)
    @DisplayName("User edit 'first name'")
    public void testEditFirstName() {
        Log.info("Clear field 'first name'");
        driver.findElement(SEARCH_FIELD_FIRST_NAME).clear();
        Log.info("Enter new first name");
        driver.findElement(SEARCH_FIELD_FIRST_NAME).sendKeys(testEditInfo);
    }

    @Test
    @Order(4)
    @DisplayName("User edit 'last name'")
    public void testEditLastName() {
        Log.info("Clear field 'last name'");
        driver.findElement(SEARCH_FIELD_LAST_NAME).clear();
        Log.info("Enter new last name");
        driver.findElement(SEARCH_FIELD_LAST_NAME).sendKeys(testEditInfo);
    }

    @Test
    @Order(5)
    @DisplayName("User edit 'address1'")
    public void testEditAddress1() {
        Log.info("Clear field 'address1'");
        driver.findElement(SEARCH_FIELD_ADDRESS1).clear();
        Log.info("Enter new address1");
        driver.findElement(SEARCH_FIELD_ADDRESS1).sendKeys(testEditInfo);
    }

    @Test
    @Order(6)
    @DisplayName("User edit 'address2'")
    public void testEditAddress2() {
        Log.info("Clear field 'address2'");
        driver.findElement(SEARCH_FIELD_ADDRESS2).clear();
        Log.info("Enter new address2");
        driver.findElement(SEARCH_FIELD_ADDRESS2).sendKeys(testEditInfo);
    }

    @Test
    @Order(7)
    @DisplayName("User edit 'city'")
    public void testEditCity() {
        Log.info("Clear field 'city'");
        driver.findElement(SEARCH_FIELD_CITY).clear();
        Log.info("Enter new city");
        driver.findElement(SEARCH_FIELD_CITY).sendKeys(testEditInfo);
    }

    @Test
    @Order(8)
    @DisplayName("User edit 'note'")
    public void testEditNote() {
        Log.info("Clear field 'note'");
        driver.findElement(SEARCH_FIELD_NOTE).clear();
        Log.info("Enter new note");
        driver.findElement(SEARCH_FIELD_NOTE).sendKeys("This is the edited address.");
    }

    @Test
    @Order(9)
    @DisplayName("User save a edited address")
    public void testSaveEditedAddress() {
        driver.findElement(SEARCH_BUTTON_UPDATE_ADDRESS).click();
        String currentNotice = driver.findElement(CURRENT_NOTICE).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(ALERT_SAVE_NOTICE));
        driver.findElement(SEARCH_LINK_LIST).click();
    }
}

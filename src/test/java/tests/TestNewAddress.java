package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.Select;
import utils.Log;
import utils.LoginUtil;

import static locators.AddressLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestNewAddress extends LoginUtil {

    String testInfo = "Test";
    String testAge = "25";
    String testNumber = "+12345678";
    String testWebsite = "https://www.google.com/";
    String testNote = "It's my first autotests!";

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
        Log.info("Click on 'New Address'");
        driver.findElement(SEARCH_LINK_NEW_ADDRESS).click();
    }

    @Test
    @Order(3)
    @DisplayName("Check field 'first name'.")
    public void testFirstName() {
        Log.info("Enter first name");
        driver.findElement(SEARCH_FIELD_FIRST_NAME).sendKeys(testInfo);
    }

    @Test
    @Order(4)
    @DisplayName("Check field 'last name'.")
    public void testLastName() {
        Log.info("Enter last name");
        driver.findElement(SEARCH_FIELD_LAST_NAME).sendKeys(testInfo);
    }

    @Test
    @Order(5)
    @DisplayName("Check field 'address1'.")
    public void testAddress1() {
        Log.info("Enter address1");
        driver.findElement(SEARCH_FIELD_ADDRESS1).sendKeys(testInfo);
    }

    @Test
    @Order(6)
    @DisplayName("Check field 'address2'.")
    public void testAddress2() {
        Log.info("Enter address2");
        driver.findElement(SEARCH_FIELD_ADDRESS2).sendKeys(testInfo);
    }

    @Test
    @Order(7)
    @DisplayName("Check field 'city'.")
    public void testCity() {
        Log.info("Enter city");
        driver.findElement(SEARCH_FIELD_CITY).sendKeys(testInfo);
    }

    @Test
    @Order(8)
    @DisplayName("Check field 'zip code'.")
    public void testZipCode() {
        Log.info("Enter zip code");
        driver.findElement(SEARCH_FIELD_ZIP_CODE).sendKeys(testInfo);
    }

    @Test
    @Order(9)
    @DisplayName("Check field 'state'.")
    public void testState() {
        Log.info("Choose a state");
        Select state = new Select(driver.findElement(SEARCH_FIELD_STATE));
        state.selectByValue("DE");
    }

    @Test
    @Order(10)
    @DisplayName("Check field 'country'.")
    public void testCountry() {
        Log.info("Choose a country");
        driver.findElement(SEARCH_BUTTON_COUNTRY).click();
    }

    @Test
    @Order(10)
    @DisplayName("Check field 'birthday'.")
    public void testBirthday() {
        Log.info("Enter birthday");
        driver.findElement(SEARCH_FIELD_BIRTHDAY).sendKeys("20.07.2021");
    }

    @Test
    @Order(11)
    @DisplayName("Check field 'color'.")
    public void testColor() {
        Log.info("Choose a color");
        driver.findElement(SEARCH_FIELD_COLOR).sendKeys("#ffc107");
    }

    @Test
    @Order(12)
    @DisplayName("Check field 'age'.")
    public void testAge() {
        Log.info("Enter age");
        driver.findElement(SEARCH_FIELD_AGE).sendKeys(testAge);
    }

    @Test
    @Order(13)
    @DisplayName("Check field 'website'.")
    public void testWebsite() {
        Log.info("Enter link of website");
        driver.findElement(SEARCH_FIELD_WEBSITE).sendKeys(testWebsite);
    }

    @Test
    @Order(17)
    @DisplayName("Check field 'picture'.")
    public void testPicture() {
        Log.info("Add a picture");
        driver.findElement(SEARCH_FIELD_PICTURE).sendKeys("D:\\AQA\\AQA_Project\\src\\main\\resources\\Tests.png");
    }

    @Test
    @Order(15)
    @DisplayName("Check field 'phone number'.")
    public void testPhoneNumber() {
        Log.info("Enter a phone number");
        driver.findElement(SEARCH_FIELD_PHONE).sendKeys(testNumber);
    }

    @Test
    @Order(16)
    @DisplayName("Check field 'interests'.")
    public void testInterests() {
        Log.info("Click on 'Reading'");
        driver.findElement(SEARCH_BUTTON_READ).click();
    }

    @Test
    @Order(14)
    @DisplayName("Check field 'note'.")
    public void testNote() {
        Log.info("Enter a note");
        driver.findElement(SEARCH_FIELD_NOTE).sendKeys(testNote);
    }

    @Test
    @Order(18)
    @DisplayName("Check button 'commit'.")
    public void testCommit() {
        Log.info("Click on 'Commit'");
        driver.findElement(SEARCH_BUTTON_COMMIT).click();
        String currentNotice = driver.findElement(CURRENT_NOTICE).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(ALERT_SAVE_NOTICE));
    }

}


package locators;

import org.openqa.selenium.By;

public class AddressLocators {

    public static final By SEARCH_BUTTON_ADDRESSES = By.xpath("//a[@data-test= 'addresses']");
    public static final By SEARCH_LINK_NEW_ADDRESS = By.linkText("New Address");
    public static final By SEARCH_FIELD_FIRST_NAME = By.name("address[first_name]");
    public static final By SEARCH_FIELD_LAST_NAME = By.name("address[last_name]");
    public static final By SEARCH_FIELD_ADDRESS1 = By.name("address[address1]");
    public static final By SEARCH_FIELD_ADDRESS2 = By.name("address[address1]");
    public static final By SEARCH_FIELD_CITY = By.name("address[city]");
    public static final By SEARCH_FIELD_ZIP_CODE = By.name("address[zip_code]");
    public static final By SEARCH_FIELD_STATE = By.name("address[state]");
    public static final By SEARCH_BUTTON_COUNTRY = By.name("address[country]");
    public static final By SEARCH_FIELD_BIRTHDAY = By.name("address[birthday]");
    public static final By SEARCH_FIELD_COLOR = By.id("address_color");
    public static final By SEARCH_FIELD_AGE = By.name("address[age]");
    public static final By SEARCH_FIELD_WEBSITE = By.name("address[website]");
    public static final By SEARCH_FIELD_PICTURE = By.name("address[picture]");
    public static final By SEARCH_FIELD_PHONE = By.name("address[phone]");
    public static final By SEARCH_BUTTON_READ = By.id("address_interest_read");
    public static final By SEARCH_FIELD_NOTE = By.name("address[note]");
    public static final By SEARCH_BUTTON_COMMIT = By.name("commit");
    public static final By SEARCH_BUTTON_EDIT = By.linkText("Edit");
    public static final By SEARCH_BUTTON_UPDATE_ADDRESS = By.xpath("//input[@value= 'Update Address']");
    public static final By SEARCH_LINK_LIST = By.linkText("List");
    public static final By SEARCH_BUTTON_DESTROY = By.linkText("Destroy");

    public static final By CURRENT_NOTICE = By.xpath("//div[@data-test= 'notice']");

    public static final String ALERT_SAVE_NOTICE = "Address was successfully created.";
    public static final String ALERT_EDIT_NOTICE = "Address was successfully updated.";
    public static final String ALERT_DESTROY_NOTICE = "Address was successfully destroyed.";

}

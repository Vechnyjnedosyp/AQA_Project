package locators;

import org.openqa.selenium.By;

public class LoginLocators {

    public static final By SEARCH_FIELD_EMAIL = By.id("session_email");
    public static final By SEARCH_FIELD_PASSWORD = By.name("session[password]");
    public static final By SEARCH_BUTTON = By.cssSelector("input[value='Sign in']");
    public static final By ACTUAL_TITLE = By.xpath("//div[@class= 'text-center']");
    public static final By CURRENT_USER = By.xpath("//span[@data-test= 'current-user']");

}

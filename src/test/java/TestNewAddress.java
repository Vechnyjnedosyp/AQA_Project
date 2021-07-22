import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestNewAddress {
    final String alertNotice = "Address was successfully created.";

    public void testNewAddress() {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";
        String testInfo = "Test";
        String testAge = "25";
        String testNumber = "+12345678";
        String testWebsite = "https://www.google.com/";
        String testNote = "It's my first autotests!";

        System.setProperty("webdriver.chrome.driver", "D:\\AQA\\AQA_Project\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);

        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.xpath("//a[@data-test= 'addresses']")).click();
        driver.findElement(By.linkText("New Address")).click();
        driver.findElement(By.name("address[first_name]")).sendKeys(testInfo);
        driver.findElement(By.name("address[last_name]")).sendKeys(testInfo);
        driver.findElement(By.name("address[address1]")).sendKeys(testInfo);
        driver.findElement(By.name("address[address2]")).sendKeys(testInfo);
        driver.findElement(By.name("address[city]")).sendKeys(testInfo);
        driver.findElement(By.name("address[zip_code]")).sendKeys(testInfo);
        Select state = new Select(driver.findElement(By.name("address[state]")));
        state.selectByValue("DE");
        driver.findElement(By.name("address[country]")).click();
        driver.findElement(By.name("address[birthday]")).sendKeys("20.07.2021");
        driver.findElement(By.id("address_color")).sendKeys("#ffc107");
        driver.findElement(By.name("address[age]")).sendKeys(testAge);
        driver.findElement(By.name("address[website]")).sendKeys(testWebsite);
        driver.findElement(By.name("address[picture]")).sendKeys("D:\\AQA\\AQA_Project\\src\\main\\resources\\Tests.png");
        driver.findElement(By.name("address[phone]")).sendKeys(testNumber);
        driver.findElement(By.id("address_interest_read")).click();
        driver.findElement(By.name("address[note]")).sendKeys(testNote);
        driver.findElement(By.name("commit")).click();
        String currentNotice = driver.findElement(By.xpath("//div[@data-test= 'notice']")).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(alertNotice));
        driver.quit();
    }
}


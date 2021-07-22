import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestEditAddress {

    final String alertNotice = "Address was successfully updated.";

    public void testEditAddress() {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";
        String testEditInfo = "TestEdit";
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
        driver.findElement(By.linkText("Edit")).click();

        driver.findElement(By.name("address[first_name]")).clear();
        driver.findElement(By.name("address[last_name]")).clear();
        driver.findElement(By.name("address[address1]")).clear();
        driver.findElement(By.name("address[address2]")).clear();
        driver.findElement(By.name("address[note]")).clear();
        driver.findElement(By.name("address[city]")).clear();
        driver.findElement(By.name("address[first_name]")).sendKeys(testEditInfo);
        driver.findElement(By.name("address[last_name]")).sendKeys(testEditInfo);
        driver.findElement(By.name("address[address1]")).sendKeys(testEditInfo);
        driver.findElement(By.name("address[address2]")).sendKeys(testEditInfo);
        driver.findElement(By.name("address[city]")).sendKeys(testEditInfo);
        driver.findElement(By.name("address[note]")).sendKeys("This is the edited address.");
        driver.findElement(By.xpath("//input[@value= 'Update Address']")).click();
        String currentNotice = driver.findElement(By.xpath("//div[@data-test= 'notice']")).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(alertNotice));
        driver.findElement(By.linkText("List")).click();

        driver.quit();
    }
}

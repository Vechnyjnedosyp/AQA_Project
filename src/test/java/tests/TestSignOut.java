package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestSignOut {

    public void testSignOut() {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";

        System.setProperty("webdriver.chrome.driver", "D:\\AQA\\AQA_Project\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);
        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.xpath("//a[@data-test= 'sign-out']")).click();

        driver.quit();
    }
}

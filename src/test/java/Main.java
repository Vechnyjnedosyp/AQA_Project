import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Main {

    public static void main(String []args) throws InterruptedException {
        new TestLogin().testLogin();
        new TestNewAddress().testNewAddress();
        new TestEditAddress().testEditAddress();
        new TestDestroyAddress().testDestroyAddress();
        new TestSignOut().testSignOut();
    }
}

class TestLogin {

    final String expectedTitle = "Welcome to Address Book";

    public void testLogin() throws InterruptedException {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";
        System.setProperty("webdriver.chrome.driver", "D:\\Nonsense\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.get(baseUrl);
        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        String actualTitle = driver.findElement(By.xpath("//div[@class= 'text-center']")).getText();
        String currentUser = driver.findElement(By.xpath("//span[@data-test= 'current-user']")).getText();
        System.out.println("Result actualTitle.equals(expectedTitle) " + actualTitle.contains(expectedTitle));
        System.out.println("Result currentUser.contains(userLogin) " + currentUser.contains(userLogin));

        Thread.sleep(6000L);
        driver.close();
        driver.quit();
    }
}

class TestNewAddress {
    final String alertNotice = "Address was successfully created.";

    public void testNewAddress() throws InterruptedException {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";
        String testInfo = "Main";
        String testAge = "25";
        String testNumber = "+12345678";
        String testWebsite = "https://www.google.com/";
        String testNote = "It's my first autotests!";

        System.setProperty("webdriver.chrome.driver", "D:\\Nonsense\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.get(baseUrl);

        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.xpath("//div[@class= 'navbar-nav mr-auto']/a[@data-test= 'addresses']")).click();
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
        driver.findElement(By.name("address[picture]")).sendKeys("D:\\Nonsense\\Tests.png");
        driver.findElement(By.name("address[phone]")).sendKeys(testNumber);
        driver.findElement(By.id("address_interest_read")).click();
        driver.findElement(By.name("address[note]")).sendKeys(testNote);
        driver.findElement(By.name("commit")).click();
        String currentNotice = driver.findElement(By.xpath("//div[@class= 'container']/div[@data-test= 'notice']")).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(alertNotice));

        Thread.sleep(6000L);
        driver.close();
        driver.quit();
    }
}

class TestEditAddress {

    final String alertNotice = "Address was successfully updated.";

    public void testEditAddress() throws InterruptedException {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";
        String testEditInfo = "TestEdit";
        System.setProperty("webdriver.chrome.driver", "D:\\Nonsense\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.get(baseUrl);

        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.xpath("//div[@class= 'navbar-nav mr-auto']/a[@data-test= 'addresses']")).click();
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
        String currentNotice = driver.findElement(By.xpath("//div[@class= 'container']/div[@data-test= 'notice']")).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(alertNotice));
        driver.findElement(By.linkText("List")).click();

        Thread.sleep(6000L);
        driver.close();
        driver.quit();
    }
}

class TestDestroyAddress {

    final String alertNotice = "Address was successfully destroyed.";

    public void testDestroyAddress() throws InterruptedException {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";

        System.setProperty("webdriver.chrome.driver", "D:\\Nonsense\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.get(baseUrl);

        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.xpath("//div[@class= 'navbar-nav mr-auto']/a[@data-test= 'addresses']")).click();
        driver.findElement(By.linkText("New Address")).click();
        driver.findElement(By.linkText("Destroy")).click();
        driver.switchTo().alert().accept();
        String currentNotice = driver.findElement(By.xpath("//div[@class= 'container']/div[@data-test= 'notice']")).getText();
        System.out.println("currentNotice " + currentNotice);
        System.out.println("currentNotice.contains(alertNotice) " + currentNotice.contains(alertNotice));
        Thread.sleep(6000L);
        driver.close();
        driver.quit();
    }
}

class TestSignOut {

    public void testSignOut() throws InterruptedException {
        String baseUrl = "http://a.testaddressbook.com/sign_in";
        String userLogin = "bibaboba@test.com";

        System.setProperty("webdriver.chrome.driver", "D:\\Nonsense\\Webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
        driver.get(baseUrl);
        driver.findElement(By.id("session_email")).sendKeys(userLogin);
        driver.findElement(By.name("session[password]")).sendKeys("test1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.xpath("//div[@class= 'navbar-nav mr-auto']/a[@data-test= 'sign-out']")).click();
        Thread.sleep(6000L);
        driver.close();
        driver.quit();
    }
}
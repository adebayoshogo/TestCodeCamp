import org.example.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SeleniumWebSignupTest {

    //Import the Selenium Driver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        //Locate where the Chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open chrome browser
        driver = new ChromeDriver();
        //2. Input your Selenium Demo page Url
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        //3. Maximize the Browser
        driver.manage().window().maximize();
        //4. Click the Signup button to open Signup page
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("shogo20");
        //6.Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("shogo20@mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin20");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickMeaghanItem() throws InterruptedException {
        //9. Click on Meaghan item on the listPage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //10. Search for an item (Using Python with Selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        Thread.sleep(5000);

        //11. Click on Logout
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();

    }

    @AfterTest
    public void closeBrowser() {
        //Quit the browser
        driver.quit();
    }


}
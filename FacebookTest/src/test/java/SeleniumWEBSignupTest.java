import io.github.bonigarcia.wdm.WebDriverManager;
import lambdacd_testng.Test;
import org.example.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class SeleniumWEBSignupTest
{
    @BeforeTest
    public void setUp() throws InterruptedException
    {   //1. Open Chrome browser
        //Import the Selenium Driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Locate where the Chrome driver is
        //driver = new ChromeDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(option);


        //2. Input your Selenium Demo page Url
        driver.get("https://selenium-blog.herokuapp.com");
        /* Test1.  Verify the user input the right url and his on the right webpage */
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct WebPage");
        else
            //Fail
            System.out.println("Wrong WebPage");
        Thread.sleep(5000);
        //3. Maximize the Browser
        driver.manage().window().maximize();
        //4. Click the Signup button to open Signup page
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void negativeSignup() throws InterruptedException
    {
        //Test2.  Verify that user cannot signUp with username less than 3 characters
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("sh");
        //6.Input your email on the email field
        driver.findElement(By.id("user_email")).sendKeys("shogo20@mailinator.com");
        //7. Input your password on the password field
        driver.findElement(By.id("user_password")).sendKeys("admin20");
        //8. Click on the Signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void clickMeaghanItem() throws InterruptedException
    {
        //9. Click on Meaghan item on the listPage
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void verifyItem() throws InterruptedException
    {
        //10. Search for an item (Using Python with Selenium) and confirm if it is present
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        Thread.sleep(5000);

        //11. Click on Logout
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();

    }

    @AfterTest
    public void closeBrowser()
    {
        //Quit the browser
        driver.quit();
    }


}

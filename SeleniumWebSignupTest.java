import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
    //Import Selenium WebDriver

    private WebDriver driver;

    @BeforeTest
    public void begin() throws InterruptedException{
        //Locate WebDriver
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver111.exe");
        //1. Open Edge browser
        driver = new EdgeDriver();
        //2. Input the Selenium Demo page Url (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test1. Verify the user input the right url and his on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the Signup button to click the Signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        }
    @Test (priority = 0)
    public void usernameLessThanThree() throws InterruptedException {
        //Test3. Verify that user cannot signUp with username less than 3 characters
        //5. Enter less than three characters username in the username button
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("sh");
        //6. Enter email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("shogo1@mailinator.com");
        //7. Enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void InvalidEmail() throws InterruptedException {
        //Test3. Verify that user cannot signUp with username less than 3 characters
        //5. Enter less than three characters username in the username button
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("shogo");
        //6. Enter email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("shogo1@mailinator");
        //7. Enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void wrongPassword() throws InterruptedException {
        //Test3. Verify that user cannot signUp with username less than 3 characters
        //5. Enter less than three characters username in the username button
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("shogo");
        //6. Enter email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("shogo1@mailinator.com");
        //7. Enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin11");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void blankUsername() throws InterruptedException {
        //Test3. Verify that user cannot signUp with username less than 3 characters
        //5. Enter less than three characters username in the username button
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("");
        //6. Enter email in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("shogo1@mailinator.com");
        //7. Enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        //8. Click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void verifyItem() throws InterruptedException {
        //Test8. Verify that Meaghan item is present on the item list page
        String expectedUrl = "https://selenium-blog.herokuapp.com/users.557";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct List Page");
        else
            //Fail
            System.out.println("Wrong List Page");
        Thread.sleep(5000);
    }
    @Test (priority = 2)
    public void clickItem() throws InterruptedException {
        //17. Click on Meaghan Item on the listPage
        //Test2. Verify that when user clicks on the signup button, the user is directed to the signUp page
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
        public void verifyItem2() throws InterruptedException {
        //Test9. Verify that the item searched for on the Meaghan page (Using Python with Selenium) is present
        String expectedUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Meaghan Page");
        else
            //Fail
            System.out.println("Wrong Meaghan Page");
        Thread.sleep(5000);
    }
    @Test (priority = 4)
    public void positiveSignup() throws InterruptedException {
        //9. Clear the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).clear();
        //10. Clear the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).clear();
        //11. Clear password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).clear();
        //Test7. Verify that user is successfully signed up when valid details are inputted
        //12. Enter username in the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("shogo");
        //13. Enter email in th email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("shogo11@mailinator.com");
        //14. Enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        Thread.sleep(5000);
        }

     @Test (priority = 5)
    public void LogoutSuccessfully() throws InterruptedException{
        //Test10. Verify that when the user logout, he/she is directed back to the home page
        //15. Click on Logout
        driver.close();
         }

    @AfterTest
    public void closeBrowser(){
        //Quit browser
        driver.quit();
    }

}

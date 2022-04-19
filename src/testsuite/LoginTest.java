package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String BaseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(BaseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //locate ‘Sign In’ link and click on it
        WebElement signIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();

        // Verify the text ‘Welcome Back!’
        String expectedMessage = "Welcome Back!";
        WebElement actualMessageElements = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageElements.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void verifyTheErrorMessage(){

        //locate ‘Sign In’ link and click on it
        WebElement signIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();

        // Enter invalid username
        WebElement usernameField = driver.findElement(By.id("user[email]"));
        usernameField.sendKeys("rlobo@gmail.co.uk");

        // /Enter invalid password
        WebElement passwordField = driver.findElement(By.id("user[password]"));
        passwordField.sendKeys("rlobo123?");

        // Click on Login button
        WebElement loginBtn = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        loginBtn.click();

        // Verify the error message ‘Invalid email or password.’
        String expectedMessage = "Invalid email or password.";
        WebElement actualMessageElements = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElements.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }


    @After
    public void tearDown(){
        closeBrowser();
    }




}

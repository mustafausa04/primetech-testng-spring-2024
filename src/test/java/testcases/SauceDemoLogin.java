package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//do not put the annotation @Test here because it will treat all class as one test case
public class SauceDemoLogin {
    //since we don't have main method so we don't need to make the methods here static
    //with cucumber we have to create gherkin , features files and step definitions files but with testNG we can start
    //automation right away.
    //to make this a testNG just add @Test on top of the method and this will be treated as s test case

    @Test
    public void loginWithValidUserNameAndPassword() throws InterruptedException {
        //1.	Navigate to sauce demo login page.
        //2.	Enter a valid email address “standard_user”.
        //3.	Enter a valid password “secret_sauce”.
        //4.	Click on the Login button.
        //5.	Verify that "Products" label is displayed.

        String expectedLabel = "Products"; //this is what im expecting based on the requirement

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(4000);

        WebElement productLabel = driver.findElement(By.xpath("//span[text()='Products']"));
        String actualLabel = productLabel.getText();

        Assert.assertEquals(actualLabel,expectedLabel);
        driver.quit();
    }


}

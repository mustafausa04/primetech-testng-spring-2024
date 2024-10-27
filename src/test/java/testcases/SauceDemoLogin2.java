package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoLogin2 {

    @Test
    public void loginWithValidUserNameAndPassword() throws InterruptedException {
        //Navigate to sauce demo login page.
        //2.Enter a valid email address “standard_user”.
        //3.Enter a valid password “secret_sauce”.
        //4.Click on the Login button.
        //5.Verify that "Products" label is displayed.

        String expectedLabel = "Products"; //this is what im expecting based on the requirement

        WebDriver driver = new ChromeDriver();
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

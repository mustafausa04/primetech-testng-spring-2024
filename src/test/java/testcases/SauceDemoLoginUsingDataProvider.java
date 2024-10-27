package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtility;

//do not put the annotation @Test here because it will treat all class as one test case
public class SauceDemoLoginUsingDataProvider {
    //since we don't have main method so we don't need to make the methods here static
    //with cucumber we have to create gherkin , features files and step definitions files but with testNG we can start
    //automation right away.
    //to make this a testNG just add @Test on top of the method and this will be treated as s test case

    @Test(dataProvider = "data-provider-login")//this will link to the method in bottom to get the user name, password
    public void loginWithValidUserNameAndPassword(String username, String password1) throws InterruptedException {
        //1.	Navigate to sauce demo login page.
        //2.	Enter a valid email address “standard_user”.
        //3.	Enter a valid password “secret_sauce”.
        //4.	Click on the Login button.
        System.out.println("I'm using username " + username + " and password " + password1);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));

        userName.sendKeys(username);
        password.sendKeys(password1);
        loginButton.click();
        Thread.sleep(4000);

        driver.quit();
    }


    //this will return the user name and password
    @DataProvider(name = "data-provider-login")
    public Object[][] loginDataProvider(){
        //here we call the first method to read and ope the file
        ExcelUtility.getExcelInstance("dataset/data.xlsx","Sheet1");
        //here we will get the data inside that cell in that file
        Object[][] myUsernamePassword = ExcelUtility.getDataSet();
        return myUsernamePassword;
    }


}

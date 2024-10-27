package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviderExample {
    //(DataProvider) used in testNG is similar to (scenario outline) in cucumber we used it for (data driven testing)
    //which means if we want to test our test case by entering different data sets to execute it.

    //Option 1 using the attribute name
    @DataProvider(name = "data-provider-example")//we give it name
    public String[] dataProvider(){//we create a string method
        String [] abc = {"primetech","prime1234","abc1230","xyz123"};
        return abc;
    }

    //in order to link this method to the one above we need to get the attribute or annotation name of the one above
    @Test(dataProvider = "data-provider-example")//now it is connected to the method above
    public void myTest(String username){
      System.out.println(username);
    }


    //Option 2 using the method name
    @DataProvider()
    public String[] dataProvider1(){
        String [] abc = {"primetech","prime1234","abc1230","xyz123"};
        return abc;
    }

    //in order to link this method to the one above we need to use the method name from above method
    @Test(dataProvider = "dataProvider1") //now it is connected to the method above through the method name
    public void myTest1(String username){
        System.out.println(username);
    }


    //--------------------------- Example 2-----------------
    //if we use this array Object[] userNameAndPassword = {"primetech","primepassword"} it will not work because the
    //("primetech","primepassword") will be feeding the parameter (String username) only in the second method
    //(loginUsingUserNameAndPassword) that's why we need to use a multi dimension array by adding one more [] and one
    //more{} to be like below, we also choose Object[] array because we have mix of strings and int so Object[] will be
    //used for mix datatype, if we use String[] or int[] we will have error
    @DataProvider(name = "data-provider-username-password")//we give it a name
    public Object[][] dataProvideForUserNameAndPassword(){
        Object[][] userNameAndPassword = {{"primetech","primepassword", 23}, { "prime2User" , "prime2pass" ,24}};
        return userNameAndPassword;
    }

    //we will connect this method to the one above through the name of the above one
    @Test(dataProvider = "data-provider-username-password")
    public void loginUsingUserNameAndPassword(String username, String password , int age){
        System.out.println("Username is " +username);
        System.out.println("Password is " + password);
        System.out.println("age is " + age);
    }


    //--------------------------- Example 3 -----------------
    @DataProvider(name ="data-provider-calculator")
    public Object[][] dataProviderCalculator(){
        Object[][] number = { {3,3}  , { 4,5}  , { 6,8 } , {10,5}  };
        return number;
    }

    @Test(dataProvider = "data-provider-calculator")
    public void calculator(int number1, int number2){
        int total = number1 + number2;
        System.out.println("The total of adding " +number1 + " and " + number2 +" is " + total);
    }


}

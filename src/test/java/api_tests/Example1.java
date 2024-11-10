package api_tests;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
//import static utilities.ExcelUtility.getDataSet;

public class Example1 {

    @Test
    public void demoOne(){

        //we will use RestAssured.get() and put in it the url that we got it from (reqres.in) website, which it has the
        //response body but we need to save it so if we hover over the (get) we will see it return for us
        //(Response) so we can save the response body in the return type (Response)
        Response response =  RestAssured.get("https://reqres.in/api/users?page=2");

        //now we can get anything from the response body
        System.out.println(response.getStatusCode());//this will print the status code
        System.out.println("=======================================");
        //to get any type of header, you need to go to the (reqres.in) where you get the response body back, right click
        //inspect, network, look at the Headers get any key for ex "content-type" and put like below you will get its
        //value back in console
        System.out.println(response.getHeader("content-type"));
        System.out.println("=======================================");
        System.out.println(response.getBody().prettyPrint());

        //to verify the status code we will use the Assert class and let's assume the status 200 is from the AC
        //we will compare what we getting from the response body to the 200 from the AC, also do the negative test by
        //changing the 200 to 201 or any number
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void demoTwo(){
        //this is another example to get a full body from google
        Response response = RestAssured.get("https://www.google.com");
        System.out.println(response.getBody().prettyPrint());//we use prettyPrint() to make the response look nicer
    }                                                        //format

    @Test
    public void demoThree(){
        //here we can remove the (RestAssured) before(get) but we have to add this import at the top
        //  import static io.restassured.RestAssured.get;
        //or we can simply leave it as is   RestAssured.get("https://www.google.com");
        Response response = get("https://www.google.com");
        System.out.println(response.getBody().prettyPrint());

        //we also learn from before that we can call the method by its class for ex  ExcelUtility.getDataSet();
        //but in RestAssured u can cll the method just by its name like this getDataSet(); but you have hover over it
        //and import its static method like the ex below and its import in the top
        //getDataSet();
    }


}

package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.*;//use this import all
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.get;

import static org.hamcrest.Matchers.*;//use this import all
//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasItems;


public class Example2 {
    //go to the web site (https://regres.in), click on the GET LIST USERS you will get status 200 and response body.
    // and get the base url then get the end point to append it to the base url

    @Test
    public void testCaseOne(){
        //RestAssured is to test API mean while it has its own assertion like below
        baseURI = "https://reqres.in";//here we put the base url
        given()
                .get("/api/users?page=2")//here we will append the end point to the url
                .then()
                .statusCode(200);
    }


    @Test
    public void testCaseTwo(){
        //go to the website "https://reqres.in", get the response body, copy it and go to this web site
        //https://www.site24x7.com/tools/jsonpath-finder-validator.html
        //paste the response body in the left screen and on the right screen get your path you need then execute them
        //in the code below
        baseURI = "https://reqres.in";
        given()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[1].id", equalTo(8))//once you hover over (equalTo) import from Matchers.equalTo
                .body("support.url", equalTo("https://reqres.in/#support-heading"))
                .body("data.first_name" , hasItems("Michael","Lindsay","Byron"));//import Matcher.hasItems
    }


    @Test
    public void testCaseThree(){
        //we getting the response body and save it
        Response response = get("https://reqres.in/api/users?page=2");

        //here we will use path() to get the path of "total_pages" which is a number 2 if you go and look at it in this
        //website /https://www.site24x7.com/tools/jsonpath-finder-validator.html that's why we save it in integer then
        //print it, same thing with "support.url" but we save it in a String not integer
        int totalPages = response.path("total_pages");
        System.out.println(totalPages);
        String supportURL = response.path("support.url");
        System.out.println(supportURL);

        //we could use path() to get a path for single item not for a list of items
        String firstElementEmail = response.path("data[0].email");//to get a first element email
        System.out.println(firstElementEmail);
        System.out.println("------------------");

        //here we have to use jsonPath() because we will get a list of emails, if you look at the response you will see
        //data.email then another dat.email.... so it will be a list and with list we have to use jsonPath() because
        //with jsonPath() we could use more collection like jsonPath().getList() and more
        //if you hover over getList() you will see the method has < > this means it is a genetic which means you can
        //return any type you want of data String, Int, List<String>....
        List<String> listOfEmails = response.jsonPath().getList("data.email");
        System.out.println(listOfEmails);

        //when you use assertion you will not get anything in the console is the matches was true but if it was false
        //then it will print in the console
        Assert.assertEquals(firstElementEmail , "michael.lawson@reqres.in");
    }


}

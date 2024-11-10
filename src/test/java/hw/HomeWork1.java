package hw;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HomeWork1 {

    //Testcase 1:
    //Perform a GET request to find a pet with id 22112
    //Verify the status code is 200
    //Verify the content type is application/json
    //Verify the pet name is booboo status is available

    @Test
    public void test1(){
        //Go to (https://petstore.swagger.io), click on GET /pet/{petId}, try it, put in the id box 22112, execute, it
        //will tell you the pet is not found because the website rest itself every day so we need to create a new pet
        //with that id, go to PUT /pet, put in the body where you see the id put 22112 and in the name put booboo, then
        //execute it will give you a response body back with 200 status code so it will create that pet for you, now
        //you can go back to GET and run it again after you put the id 22112 you will get the response body back with
        //that pet, now you can perform the automation below
        //option 1: we will use the old way here
        //here we will use RestAssured to get the response and save it using Response class
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/22112");

        //here we will get the status code then we print it
        response.then().statusCode(200);
        System.out.println(response.getStatusCode());

        //here we will get the content type then we will print it
        response.then().contentType("application/json");
        System.out.println(response.getHeader("content-type"));

        //here we will print the name which is booboo
        System.out.println(response.jsonPath().getString("name"));

        //here we will match the name to booboo
        response.then().body("name", Matchers.equalTo("booboo"));

        //option 2
        RestAssured.given()
                .when()//this is optional
                .get("https://petstore.swagger.io/v2/pet/22112")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("name", Matchers.equalTo("booboo"));
    }


    //Testcase 2:
    //Perform a GET request to find a pet with 201029
    //Verify the status code is 404 and content type is application.json
    //Verify message is Pet not found

    @Test
    public void test2(){
        //Go to (https://petstore.swagger.io), click on GET /pet/{petId}, try it, put in the id box 201029, execute, it
        //will tell you the pet is not found and the status code is 404 this will be the manual now below is the
        //automation
        //here will go the website and use RestAssured the save the response
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet/201029");

        //we will get the status code the print it
        response.then().statusCode(404);
        System.out.println(response.getStatusCode());

        //to get the content type and print it
        response.then().contentType("application/json");
        System.out.println(response.getHeader("content-type"));

        //here we will print the "message" which is "Pet not found"
        System.out.println(response.jsonPath().getString("message"));

        //here we will match the "message" is "Pet not found"
        response.then().body("message", Matchers.equalTo("Pet not found"));
    }


}

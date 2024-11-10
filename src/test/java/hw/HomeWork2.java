package hw;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class HomeWork2 {

    //URL :https://petstore.swagger.io/#/ you can add any id you like
    //Testcase 1:
    //Perform a POST request to upload a PET
    //Verify the status code is 200
    //Verify the content type is application.json
    //Verify the pet name and status match your request body input

    @Test
    public void createNewPet(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        //we have to use JSONObject class to convert the body we create into json format to let server read it
        JSONObject requestBody = new JSONObject();
        requestBody.put("id" , 88888);
        requestBody.put("name", "luckyAnimal");

        Response response = RestAssured.given()
                .contentType("application/json")//this is optional
                .body(requestBody.toJSONString())//we will put the request body here and convert it to json so server
                                                 //can read it
                .when()//optional
                .post("/pet");

        //to get the response status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());

        //to get the content type then print it
        response.then().contentType(ContentType.JSON);
        System.out.println(response.getHeader("content-type"));

        //to get the response body and print it
        response.getBody().prettyPrint();

        //to match if the "name" is equal to "luckyAnimal"
        response.then().body("name", Matchers.equalTo("luckyAnimal"));
    }


}

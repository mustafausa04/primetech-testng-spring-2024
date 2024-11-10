package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutExample4 {

    @Test
    public void putExample(){
        //this is the put example we will leave the same exact thing like the post example in HomeWork2 we just change
        //the name for ex to something different and the post to put

        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        //we have to use JSONObject class to convert the body we create into json format to let server read it
        JSONObject requestBody = new JSONObject();
        requestBody.put("id" , 88888);
        requestBody.put("name", "luckyAnimal - Option 2");//we change the name than what we have in the post example

        Response response = RestAssured.given()
                .contentType("application/json")//this is optional
                .body(requestBody.toJSONString())//we will put the request body here and convert it to json so server
                //can read it
                .when()//optional
                .put("/pet");//we change to put

        //to get the response status code
        response.then().statusCode(200);
        //to print the status code
        System.out.println(response.getStatusCode());

        //to get the content type then print it
        response.then().contentType(ContentType.JSON);
        System.out.println(response.getHeader("content-type"));

        //to get the response body and print it
        response.getBody().prettyPrint();//or we could use this   response.prettyPrint();

        //to match if the "name" is equal to "luckyAnimal"
        response.then().body("name", Matchers.equalTo("luckyAnimal - Option 2"));
    }


}

package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostExample3 {

    @Test
    public void postExampleOption1(){
        //go to website (https://reqres.in/), click on POST CREATE,
        //Option 1 using the body as a JSON String
        RestAssured.baseURI = "https://reqres.in";//get the base url

        //copy the request body and put " " and paste it inside of them the intellij will make organized like below
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        Response response = RestAssured.given()
                .header("Content-Type","application/json")//optional
                .body(requestBody)//we will put the request body here
                .when()//optional
                .post("/api/users");//we will append this to the base url after we get it from request body in the
                                       //website above then use post to create a new user

        //to get the response status code
        response.then().statusCode(201);//we could replace this step with line 40 both are the same

        //to print the status code
        System.out.println(response.getStatusCode());

        //to get the response body and print it
        response.getBody().prettyPrint();

        //to get the response status code and compare it to 201
        Assert.assertEquals(response.getStatusCode(), 201);
    }


    @Test
    public void postExampleOption2(){
        //Option 2 use this one not the one above
        RestAssured.baseURI = "https://reqres.in";

        //we need to add json dependency to pom.xml file the we import JSONObject class here so we can send java as a
        //json format (serialization) which means converting the java object to json so the server can read it
        //Serialization --> The process of converting a data object (like json, java object) into a format
        //that could be easily transmitted
        //Deserialization --> The reverse process of serialization, it involves converting data like json or
        //xml back into java object

        //We need below code to help us serialize the Java Object into json Meaning converting the java object into json
        //format so the server can read it
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheussss");
        requestBody.put("job", "leader");

        Response response = RestAssured.given()
                .header("Content-Type","application/json")//optional
                .body(requestBody.toJSONString())//we will put the request body here and convert it to json so server
                                                 //can read it
                .when()//optional
                .post("/api/users");//we will append this to the base url after we get it from request body in the
                                       //website above then use post to create a new user

        //to get the response status code
        response.then().statusCode(201);//we could replace this step with line 40 both are the same

        //to print the status code
        System.out.println(response.getStatusCode());

        //to get the response body and print it
        response.getBody().prettyPrint();

        //to get the response status code and compare it to 201
        Assert.assertEquals(response.getStatusCode(), 201);
    }


}

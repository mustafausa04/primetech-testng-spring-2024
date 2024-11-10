package api_tests;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class JSONSchemaValidatorExample {

    @Test
    public void schemaValidatoExampleForPetStoreGetRequest(){
        //when we get the response back we can take it to this web site
        //  https://www.liquid-technologies.com/online-json-to-schema-converter
        //to get the schema, then we have to validate the schema which means for ex the id has to be integer type or
        //the name has to be string type

        //here we will use get request to get the pet with id 88888
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Response response = RestAssured.given()
                .when()
                .get("/pet/88888");

        //to print the response body
        response.prettyPrint();

        //we will copy the schema that we got from the website mentioned above and create a file called
        //"json-schema-example.json" and paste the schema inside that file then add a dependency in the pom.xml
        //regarding the schema, this dependency has class called JsonSchemaValidator that matches the schema in the
        //file "json-schema-example.json" like the code below
        //so basically we matching the response back with the schema that we stored in that file
        response
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json-schema-example.json"));
    }

}

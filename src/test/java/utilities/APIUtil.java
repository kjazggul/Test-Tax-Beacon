package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class APIUtil {

    // CRUD Operation. One method for each operation.
    // One method should handle any APIs we are hitting.
    //static RestAssured  responseBody;
     @BeforeClass
     public static void setup(){
         RestAssured.baseURI = "";
     }

    public static void getRequest() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                        .param("postId", "2")
                                .when()
                                        .get()
                                                .then()
                                                        .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("street1","jasonparse.response.tostring(street1) ");

    }

    public static void hitGE(String resource) throws Exception{
        String uri = Config.getProperty("baseURL") + resource;
        Response response = RestAssured.get(uri);
        Assert.assertEquals(response.statusCode(), "200");
        ObjectMapper objectMapper = new ObjectMapper();

        io.restassured.response.ResponseBody responseBody = objectMapper.readValue(response.asString(), io.restassured.response.ResponseBody.class);



    }


    public static void hitPOST() {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body("")
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assert.assertEquals(201, response.statusCode());

    }


    public static void hitDELETE(String resource) {
        String uri = Config.getProperty("baseURL") + resource;

        Response response = RestAssured.delete(uri);

        System.out.println(response.asString());
        System.out.println("STATUS CODE: " + response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();


    }
    @Test
    public void VerifyCityInJsonResponse()
    {
      //  RestAssured.baseURI = "https://restapi.demoqa.com/utilities/weather/city";
        Response response = RestAssured.get("https://restapi.demoqa.com/utilities/weather/city/Hyderabad");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String city = jsonPathEvaluator.get("City");

        // Let us print the city variable to see what we got
        System.out.println("City received from Response " + city);

        // Validate the response
        Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");

    }


    public static void hitPUT() {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body("")
                .when()
                .put("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }

}

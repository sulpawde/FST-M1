package activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity4 {
    // Declare request specification
    RequestSpecification requestSpec;
    // Declare response specification
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                // Set base URL
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                // Build request specification
                .build();

        responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                .expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
                // Check if response contains name property
                .expectBody("status", equalTo("available"))
                // Check response time less than 3 sec
                .expectResponseTime(lessThanOrEqualTo(3000L))
                // Build response specification
                .build();
    }

    @DataProvider
    public Object[][] petInfoProvider() {
        // Setting parameters to pass to test case
        Object[][] testData = new Object[][] { 
            { 1111, "Test1111", "available" }, 
            { 2222, "Test2222", "available" }
        };
        return testData;
    }

    @Test(priority=1)
    // Test case using a DataProvider
    public void addPets() {
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 1111);
		reqBody.put("name", "Test1111");
		reqBody.put("status", "available");
		
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request

		reqBody.put("id", 2222);
		reqBody.put("name", "Test2222");
		reqBody.put("status", "available");
        response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post(); // Send POST request

        // Assertions
        response.then().spec(responseSpec); // Use responseSpec
    }

    // Test case using a DataProvider
    @Test(dataProvider = "petInfoProvider", priority=2)
    public void getPets(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().get("/{petId}"); // Send GET request

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
        response.then()
        .spec(responseSpec) // Use responseSpec
        .body("name", equalTo(name)); // Additional Assertion
    }

    // Test case using a DataProvider
    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("petId", id) // Add path parameter
                .when().delete("/{petId}"); // Send GET request

        // Assertions
        response.then().body("code", equalTo(200));
    }

}
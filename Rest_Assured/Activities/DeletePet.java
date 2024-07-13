package examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class DeletePet {

    // Set Base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test
    public void AddNewPet() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().delete(ROOT_URI + "/77232"); // Send DELETE request

        // Assert DELETE operation
        /* However, this will only work the first time
         * the DELETE request is run, because
         * the pet with id 77232 has already been deleted.
         */
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }
}
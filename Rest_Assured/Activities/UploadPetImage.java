package examples;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UploadPetImage {

    // Set base URL
    String ROOT_URI = "https://petstore.swagger.io/v2/pet/{petId}/uploadImage";

    @Test
    public void addPetImage() {
        // Get file to upload
        File petImage = new File("src/test/resources/GoldenPuppy.jpg");
        Response response = given().multiPart(petImage) // Add image to upload
                .pathParam("petId", "77238") // Set petId parameter
                .when().post(ROOT_URI); // Send POST request

        // Print response
        System.out.println(response.asPrettyString());

        // Assertion
        response.then().body("code", equalTo(200));
    }
}
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

public class GitHub_RestAssured_Project_Activity {

	String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICQLWlQwX/G48UmAyUfz2UMgtwCNwik8x+Kp95J7OKn0";
	int myID ;

	
	RequestSpecification requestSepc;
	ResponseSpecification responseSepc;
	int petId;

	@BeforeClass
	public void setUp() {
		//Request Specification
		requestSepc = new RequestSpecBuilder().
				addHeader("Content-Type", "application/json").
				addHeader("Authorization", "token ghp_xxxx5g1szUfPE7KKpkTmOH058zMLVw3xxxx").
				setBaseUri("https://api.github.com").
				build();

		//Response Specification
		responseSepc = new ResponseSpecBuilder().
				expectResponseTime(lessThanOrEqualTo(5000L)).
				build();

	}
	//	https://api.github.com/user/keys

	/* Add a 3 @Test annotation methods:
		One for sending a POST request to add a SSH key to your account
		One for sending a GET request to get all the SSH keys attached to your account
		One for sending a DELETE request to delete the key attached to your account.
	 */

	// POST sending a POST request to add a SSH key to your account
	@Test(priority = 1)
	public void postRequest() {

		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("title","TestAPIKey");
		reqBody.put("key",sshkey);


		// Send request, save response
		Response response = given().spec(requestSepc).body(reqBody).
				when().post("/user/keys");
		//Extract the id
		myID = response.then().extract().path("id");
		//Assertions
		response.then().log().all().assertThat().statusCode(201);  
	}

	// GET /user/keys/{keyId} 

	@Test(priority = 2) 
	public void getRequest() {

		Response response = given().spec(requestSepc).pathParam("keyId", myID).
				when().get("/user/keys/{keyId}");	  

		response.then().log().all().assertThat().statusCode(200); 

	}

	// DELETE /user/keys/{keyId}

	@Test(priority = 3) public void deleteRequest() {

		Response response =	given().spec(requestSepc).pathParam("keyId", myID).
		when().delete("/user/keys/{keyId}");
		
		response.then().log().all().assertThat().statusCode(204); 

	}

}

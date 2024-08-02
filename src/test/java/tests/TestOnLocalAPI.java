package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {
	//@Test
	public void get() {
		baseURI="http://localhost:8000";
		given().get("/users")
		.then().statusCode(200).log().all();
		
	}
	//@Test
	public void post() {
		JSONObject request=new JSONObject();
		request.put("firstName", "Albert");
		request.put("lastName","Edison");
		request.put("subjectId",1);
		baseURI="http://localhost:8000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201);	
	}
	//@Test
	public void put() {
		JSONObject request=new JSONObject();
	
		request.put("firstName", "Thomas");
		request.put("lastName","Einstein");
		request.put("subjectId",2);
		baseURI="http://localhost:8000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/4")
		.then()
		.statusCode(200);	
	}
	//@Test
	public void patch() {
		JSONObject request=new JSONObject();
		request.put("lastName","Doe");
		baseURI="http://localhost:8000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("/users/4")
		.then() 
		.statusCode(200);	
	}
	@Test
	public void delete() {
		baseURI="http://localhost:8000";
		 when()
		.delete("/users/4")
		.then()
		.statusCode(200);	
	}
	
	

}

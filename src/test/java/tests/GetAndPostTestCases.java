package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostTestCases {
	//@Test
	public void testGet()
	{
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].first_name",equalTo("Lindsay"))
		.body("data.first_name",hasItems("Michael","Lindsay"));
		
	}
	@Test
	public void testPost()
	{

		Map<String,Object> map=new HashMap<String,Object>();
		//map.put("name","morpheus");
		//map.put("job","Teacher");
		//System.out.println(map);
		JSONObject request=new JSONObject(map);
		request.put("name","morpheus");
		request.put("job","Teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201)
		.log().all();
	   	
	}

}

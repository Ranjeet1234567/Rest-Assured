package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class SerializationObject {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        BlogPost bp1 = new BlogPost();
        bp1.setName("Ranjeet");
        bp1.setJob("Nagarro");
        String url = "https://reqres.in/api/users";
        String json = MAPPER.writeValueAsString(bp1);
        Response response = RestAssured
                .given()
                .contentType("application/json")
                .log()
                .all(true)
                .body(json)
                .post(url)
                .andReturn();
        System.out.println(response.statusCode());
        assertEquals(response.getStatusCode(), 201, "HTTP Message");
    }
}

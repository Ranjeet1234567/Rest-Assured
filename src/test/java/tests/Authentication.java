package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Authentication {
@Test
    public void test1()
    {
        int code=RestAssured.given()
                .auth().preemptive()
                .basic("postman", "password")
                .when()
                .get("https://postman-echo.com/basic-auth")
                .getStatusCode();
        System.out.println("Response Code from server is " +code) ;

    }
}

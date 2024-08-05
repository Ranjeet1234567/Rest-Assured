package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Download {
    public static void main(String[] args) throws IOException {
        String excelSheetPath = "/testData/Test.json";
        String currentDir = System.getProperty("user.dir");
        String filename = (currentDir + excelSheetPath);
        Response response= RestAssured
                .given()
                .log()
                .all()
                .when()
                .get("https://reqres.in/api/users")
                .andReturn();
        byte[] bytes=response.getBody().asByteArray();
        File file=new File(filename);
        Files.write(file.toPath(),bytes);
    }
}

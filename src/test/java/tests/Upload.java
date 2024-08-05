package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class Upload {
    public static void main(String[] args) {
        String excelSheetPath = "/testData/data.xlsx";
        String currentDir = System.getProperty("user.dir");
        String filename = (currentDir + excelSheetPath);
        File file= new File(filename);
        Response response= RestAssured
                .given()
                .multiPart("file",file,"multipart/form-data")
                .post("https://the-internet.herokuapp.com/upload")
                .thenReturn();
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());

    }
}

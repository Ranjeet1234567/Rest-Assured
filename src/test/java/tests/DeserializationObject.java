package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import com.fasterxml.jackson.core.type.TypeReference;

import java.lang.reflect.Type;
import java.util.List;

public class DeserializationObject {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) {
        String url = "https://reqres.in/api/users";
        BlogPost blogPost_Nagarro = RestAssured
                .given()
                .get(url)
                .as(BlogPost.class);
        System.out.println("blogPost_Nagarro" + blogPost_Nagarro.toString());
        String url1 = "https://reqres.in/api";
        Type type = new TypeReference<List<BlogPost>>() {
        }.getType();
        List<BlogPost> blogPostList = RestAssured.given().get(url1).as(type);
        System.out.println("All blogs" + blogPostList.toString());
        BlogPost allBlog[] = RestAssured.get(url1).as(BlogPost[].class);
        System.out.println("All blogs1" + allBlog.toString());

    }
}

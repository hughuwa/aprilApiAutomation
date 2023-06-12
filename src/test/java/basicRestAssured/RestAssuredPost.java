package basicRestAssured;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredPost {
    @Test
    public void CreateSpecificPost(){
        HashMap<String,String> postBody = new HashMap<>();
        postBody.put("userId", "1");
        postBody.put("Id", "1");
        postBody.put("title","My latest holiday");
        postBody.put("body", "I spent my time in egypt and had a wonderful time");
        given().log().all().contentType(ContentType.JSON).with().body(postBody).
                when().post("https://jsonplaceholder.typicode.com/posts").
                then().log().all().statusCode(201).body("title", equalTo("My latest holiday")).body("body", equalTo("I spent my time in egypt and had a wonderful time"));
    }
}

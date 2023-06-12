package basicRestAssured;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredGet {
    @Test
    public void GetSpecificPost(){
        given().log().all().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts/{id}",14).
                then().log().all().statusCode(200).body("title", equalTo("voluptatem eligendi optio")).body("body", equalTo("fuga et accusamus dolorum perferendis illo voluptas\nnon doloremque neque facere\nad qui dolorum molestiae beatae\nsed aut voluptas totam sit illum"));

    }
}

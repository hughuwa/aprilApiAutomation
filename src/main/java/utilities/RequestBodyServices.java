package utilities;

import com.jayway.jsonpath.DocumentContext;

public class RequestBodyServices {
    public void setRequestBodyForPost(DocumentContext requestBody, String userId, String title, String body){
        requestBody.set("userId",userId);
        requestBody.set("title", title);
        requestBody.set("body", body);
    }
    public void setRequestBodyForComment(DocumentContext requestBody, String postId, String name, String email, String body){
        requestBody.set("postId",postId);
        requestBody.set("name", name);
        requestBody.set("email", email);
        requestBody.set("body", body);
    }
}

package stepDefinitions;


import io.restassured.http.Header;
import io.restassured.http.Headers;

public class BaseSteps2 {
    public Headers headers;
    String ServiceUrl;
    String PostUrl;
    String CommentsUrl;


    public BaseSteps2(){
        ServiceUrl = "https://jsonplaceholder.typicode.com/";
        PostUrl = ServiceUrl + "post/";
        CommentsUrl = ServiceUrl + "comments/";
    }

    public void setHeaders(Headers value){
        restHeader();
        headers = value;
    }
    private void restHeader(){ headers = null; }

    public void setHeadersWithContentType(){
        headers = new Headers(
                new Header("Content-Type","application/json"));
        setHeaders(headers);
    }

}


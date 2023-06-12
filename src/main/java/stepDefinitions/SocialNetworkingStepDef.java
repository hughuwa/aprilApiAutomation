package stepDefinitions;

import com.jayway.jsonpath.DocumentContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.RequestBodyServices;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class SocialNetworkingStepDef extends BaseSteps {
    Response responseForPost;
    Response responseForGetComment;
    RequestBodyServices requestBodyServices;
    Response responseForCreatePost;
    Response responseForCreateComment;

    @Given("service is up and running")
    public void service_is_up_and_running() {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(ServiceUrl);
        getCall();
        Response responseForService = getResponse();
        assertThat(responseForService.statusCode(),is(200));
    }

    @When("I send GET request to get a specific post with {string}")
    public void i_send_get_request_to_get_a_specific_post_with(String id) {
        // Write code here that turns the phrase above into concrete actions
        setHeadersWithContentType();
        setEndpointPath(PostUrl + id);
        getCall();
        responseForPost = getResponse();

    }

    @Then("{string}, {string} and {string} request are returned with status code of {int}")
    public void and_request_are_returned_with_status_code_of(String id, String title, String body, Integer sCode) {
        // Write code here that turns the phrase above into concrete actions
        assertThat(responseForPost.statusCode(), is(sCode));
        assertThat(responseForPost.body().jsonPath().get("id"), is(Integer.parseInt(id)));
        assertThat(responseForPost.body().jsonPath().get("title"), is(equalTo(title)));
        assertThat(responseForPost.body().jsonPath().get("body"), is(equalTo(body)));
    }

    @When("I create a new post with the following details {string}, {string} and {string}")
    public void iCreateANewPostWithTheFollowingDetailsAnd(String uId, String title, String body) {
        setHeadersWithContentType();
        setEndpointPath(PostUrl);
        requestBodyServices = new RequestBodyServices();
        DocumentContext requestBody = loadJsonTemplate(PostPayloadPath);
        requestBodyServices.setRequestBodyForPost(requestBody, uId, title, body);
        getPostCall();
        responseForCreatePost = getPostCall();
    }

    @Then("I should get reponse of {string}, {string} and {string} returned with status code of {int}")
    public void iShouldGetReponseOfAndReturnedWithStatusCodeOf(String uId, String title, String body, int sCode) {
        assertThat(responseForCreatePost.statusCode(), is(sCode));
        assertThat(responseForCreatePost.body().jsonPath().get("userId"), is(uId));
        assertThat(responseForCreatePost.body().jsonPath().get("title"), is(title));
        assertThat(responseForCreatePost.body().jsonPath().get("body"), is(body));
    }

    @When("I send GET request to get a specific comment with {string}")
    public void iSendGETRequestToGetASpecificCommentWith(String id) {
        setHeadersWithContentType();
        setEndpointPath(CommentUrl + id);
//        getCall();
        responseForGetComment = getCall();
    }

    @Then("{string}, {string}, {string} and {string} request are returned with status code of {int}")
    public void andRequestAreReturnedWithStatusCodeOf(String id, String name, String email, String body, int sCode) {
        assertThat(responseForGetComment.statusCode(), is(sCode));
        assertThat(responseForGetComment.body().jsonPath().get("id"), is(Integer.parseInt(id)));
        assertThat(responseForGetComment.body().jsonPath().get("name"), is(equalTo(name)));
        assertThat(responseForGetComment.body().jsonPath().get("email"), is(equalTo(email)));
        assertThat(responseForGetComment.body().jsonPath().get("body"), is(equalTo(body)));
    }

    @When("I create a new comment with the following details {string}, {string}, {string} and {string}")
    public void iCreateANewCommentWithTheFollowingDetailsAnd(String postId, String name, String email, String body) {
        setHeadersWithContentType();
        setEndpointPath(CommentUrl);
        requestBodyServices = new RequestBodyServices();
        DocumentContext requestBody = loadJsonTemplate(CommentPayloadPath);
        requestBodyServices.setRequestBodyForComment(requestBody, postId, name, email, body);
        getPostCall();
        responseForCreateComment = getPostCall();

    }

    @Then("I should get response of {string}, {string}, {string} and {string} returned with status code of {int}")
    public void iShouldGetResponseOfAndReturnedWithStatusCodeOf(String postId, String name, String email, String body, int sCode) {
        assertThat(responseForCreateComment.statusCode(), is(sCode));
        assertThat(responseForCreateComment.body().jsonPath().get("postId"), is(postId));
        assertThat(responseForCreateComment.body().jsonPath().get("name"), is(name));
        assertThat(responseForCreateComment.body().jsonPath().get("body"), is(body));
    }
}

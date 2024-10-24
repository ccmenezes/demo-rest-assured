package posts;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.DefaultRequest;
import utils.DefaultResponse;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Posts {

    // Define the base URL
    private static final String uri = "https://jsonplaceholder.typicode.com";

    // A method to get the posts by path
    // Params <status code> the http returned status, <path> the path to a specific resource
    public static ValidatableResponse getPosts(int statusCode, String path) throws IOException {
        ContentType contentType = ContentType.JSON;

        RequestSpecification requestSpecification = DefaultRequest.requestSpecification(uri, path);
        ResponseSpecification responseSpecification = DefaultResponse.responseSpecification(statusCode, contentType);

        return
                given(requestSpecification, responseSpecification)
                        .get()
                        .then();
    }

    // A method to get the posts by post ID
    // Params <status code> the http returned status, <path> the path to a specific resource, <postId> fetch the posts ID from
    // different users
    public static ValidatableResponse getPostByPostId(int statusCode, String path, String postId) {
        ContentType contentType = ContentType.JSON;

        RequestSpecification requestSpecification = DefaultRequest.requestSpecification(uri, path)
                .queryParam("postId", postId);
        ResponseSpecification responseSpecification = DefaultResponse.responseSpecification(statusCode, contentType);

        return
                given(requestSpecification, responseSpecification)
                        .get()
                        .then();
    }

}

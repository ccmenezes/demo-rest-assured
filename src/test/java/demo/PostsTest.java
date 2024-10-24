package demo;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posts.Posts;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostsTest {

    // Allure annotations
    @DisplayName("Test fetch all posts with success.")
    @Owner("Claudia Menezes")
    @Severity(SeverityLevel.CRITICAL)
    //
    @Test
    public void testGetAllPosts() throws IOException {
        String path = "/posts";
        int statusCode = 200;
        String responseGetAllPosts;
        String responseAttributeUserId = "userId";

       ValidatableResponse validatableResponse = Posts.getPosts(statusCode, path);
       responseGetAllPosts = validatableResponse.extract().response().jsonPath().getString(responseAttributeUserId);

       assertEquals(statusCode, validatableResponse.extract().response().getStatusCode());
       assertThat(responseGetAllPosts).isNotEmpty().hasSize(310);

    }

    // Allure annotations
    @DisplayName("Test fetch all posts with success.")
    @Owner("Claudia Menezes")
    @Severity(SeverityLevel.NORMAL)
    //
    @Test
    public void testGetCommentsById() {
        String path = "/comments";
        String postId = "1";
        String arrayPostId = "[1, 1, 1, 1, 1]";
        int statusCode = 200;
        String responseGetAllPosts;
        String responseAttributePostId = "postId";

        ValidatableResponse validatableResponse = Posts.getPostByPostId(statusCode, path, postId);
        responseGetAllPosts = validatableResponse.extract().response().jsonPath().getString(responseAttributePostId);

        assertEquals(statusCode, validatableResponse.extract().response().getStatusCode());
        assertEquals(arrayPostId,responseGetAllPosts);
    }

}
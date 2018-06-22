package com.billie.api.test;

import java.util.List;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.billie.api.model.CommentModel;
import com.billie.api.util.DataReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

/**
 * @author ROMA1 This class will contains all tests related to
 *         https://jsonplaceholder.typicode.com/comments
 * 
 */
public class CommentsTest {
	String baseURI, resPath;
	DataReader jsonTestData;

	/*
	 * Initialize the base URL and read common fields from the data file
	 */

	@BeforeSuite
	public void setUp() {
		jsonTestData = new DataReader();
		baseURI = jsonTestData.getData("URL").get("baseURL");
		resPath = jsonTestData.getData("URL").get("path");
		RestAssured.baseURI = baseURI;
	}

	// Get all comments and verify the status code and size of returned comments
	@Test
	public void getAllComments() {
		Response resp = given().contentType(ContentType.JSON).when().get(resPath);
		List<CommentModel> commentsList = resp.then().extract().jsonPath().getList("$", CommentModel.class);

		// Assert that status 200 is returned and log status
		resp.then().assertThat().statusCode(200).log().status();
		assertTrue(commentsList.size() > 0, "No comments are returned");

	}

	// Verify that number of comments are 5 for specific post Id
	@Test
	public void checkCommentsSize() {
		// Read postId from data file
		String postId = jsonTestData.getData("Data").get("postId");

		// Read expected value from data file
		String expectedCommentsNum = jsonTestData.getData("ExpectedResults").get("commentsSize");
		given().param("postId", postId).when().get(resPath).then().body(".",
				hasSize(Integer.parseInt(expectedCommentsNum)));
	}

	// Get all comments for specific postId and check that the results contain
	// specific comment object
	@Test
	public void getCommentsByPostId() {

		// Prepare expected comment object by reading expected values from data
		// file
		CommentModel expectedComment = new CommentModel();
		expectedComment.setId(Integer.parseInt(jsonTestData.getData("ExpectedResults").get("commentId")));
		expectedComment.setPostId(Integer.parseInt(jsonTestData.getData("ExpectedResults").get("commentPostId")));
		expectedComment.setName(jsonTestData.getData("ExpectedResults").get("commentName"));
		expectedComment.setEmail(jsonTestData.getData("ExpectedResults").get("commentEmail"));
		expectedComment.setBody(jsonTestData.getData("ExpectedResults").get("commentBody"));

		String postIdValue = jsonTestData.getData("Data").get("postId");
		List<CommentModel> commentsList = given().param("postId", postIdValue).when().get(resPath).then().extract()
				.jsonPath().getList("$", CommentModel.class);

		assertTrue(commentsList.contains(expectedComment), "Comment values doesn't match");
	}
}

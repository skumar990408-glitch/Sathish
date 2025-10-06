package com.utils;


import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class ApiUtils {
	
	 public static final String BASE_URL = "https://practice.expandtesting.com/notes/api/api-docs/";
	 
	 public static final String POST_URL="#/Users/post_users_register";
	 public static final String POST_LOGIN_URL="#/Users/post_users_login";
	 public static final String GET_URL="#/Users/get_users_profile";
	 public static final String DELETE_URL="#/Users/delete_users_logout";
	 
	 

	    public static RequestSpecification getRequestSpec() {
	        return RestAssured
	            .given()
	            .baseUri(BASE_URL)
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON);
	    }

	    public static RequestSpecification getAuthSpec(String token) {
	        return getRequestSpec()
	            .header("x-auth-token", token);

}
}

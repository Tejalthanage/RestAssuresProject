package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import api.payloads.User;
import  io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//this is userendpoints.java file which is used to perform CRUD operation

public class UserEndPoints {
	
	public static Response CreateUser(User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.postUrl);
		return response;
		
	}
	
	public static Response Getuser(String username)
	{
	 Response	response=given()
			 .pathParam("username", username)
		.when()
		.get(Routes.getUrl);
	 return response;
	}
	
	public static Response Updateuser(String username,User  payload)
	{
		Response response=given()
				.pathParam("username", username)
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		
		.when()
		.put(Routes.putUrl);
		return response;
		
	}
	
	public static Response deleteUser(String username)
	{
	 Response	response=given()
			 .pathParam("username", username)
		.when()
		.delete(Routes.deleteUrl);
	 return response;
	}
	
}

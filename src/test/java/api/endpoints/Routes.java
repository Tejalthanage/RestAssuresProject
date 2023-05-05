package api.endpoints;

/*
 Swagger Uri-: https://petstore.swagger.io/
 
 create User(Post) -: https://petstore.swagger.io/v2/user
 
 Get User (Get) -: https://petstore.swagger.io/v2/user/{username}
 
 Delete User (delete) -: https://petstore.swagger.io/v2/user/{username}
 
 Update User (put) :-  https://petstore.swagger.io/v2/user/{username}
 
 */


public class Routes {

	public static String baseurl="https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String postUrl=baseurl+"/user";
	public static String getUrl=baseurl+"/user/{username}";
	public static String deleteUrl=baseurl+"/user/{username}";
	public static String putUrl=baseurl+"/user/{username}";
	
	
	
	
	
	
	
}

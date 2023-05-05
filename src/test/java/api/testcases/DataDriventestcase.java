package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviderUtils;
import io.restassured.response.Response;

public class DataDriventestcase {

	@Test(priority = 1 ,enabled = true, dataProvider = "Data",dataProviderClass = DataProviderUtils.class)
	 public void testPostuser(String UserID,String UserName,String FirstName,String LastName,String Email,String Password,String Phone)
	 
	 
	   {
	
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(UserName);
		userpayload.setFirstName(FirstName);
		userpayload.setLastName(LastName);
		userpayload.setEmail(Email);
		userpayload.setPassword(Password);
		userpayload.setPhone(Phone);
		
		 Response	response=UserEndPoints.CreateUser(userpayload);
		 
		 Assert.assertEquals(response.getStatusCode(),200);
		 
		 System.out.println("User created" + userpayload.getUsername());
		 
		
	   }
	
	@Test(priority = 2,dataProvider = "Usernames",dataProviderClass = DataProviderUtils.class,enabled = true)
	public void DeleteUserByname(String username)
	{
	
		try
		{
		Response response=UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(),200);
		//System.out.println("userdelted " + username);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
}


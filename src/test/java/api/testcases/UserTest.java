package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	User userpayload;
	public Logger logger;

	@BeforeClass
	public void Setupdata()
	{
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setUsername(faker.name().username());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=(Logger) LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
   public void	testPostuser()
   {
		logger.info("********** Creating User************* ");
	 Response	response=UserEndPoints.CreateUser(userpayload);
	 response.then().log().all();
	 Assert.assertEquals(response.getStatusCode(),200);
	 
	 logger.info("User Created Successfully");
	 
	
   }
	
	@Test(priority = 2)
	public void testGetUserByname()
	{
		
		logger.info("********** Getting User information************* ");
		Response response = UserEndPoints.Getuser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	
	@Test(priority = 3)
	public void testUpdateUser()
	{
		//Update data using Diffrent data using faker
		logger.info("**********User Updating************* ");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.Updateuser(this.userpayload.getUsername(), userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(),200);
		
		//checking data after update
		

		Response responseafterudtae = UserEndPoints.Updateuser(this.userpayload.getUsername(), userpayload);
		Assert.assertEquals(responseafterudtae.getStatusCode(),200);
		
	}
	
	
	@Test(priority = 4)
	public void testDeetUserByname()
	{

		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	
	
	
	
	
	
	
}

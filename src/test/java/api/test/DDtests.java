package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtests {
  @Test(priority=1,dataProvider="data",dataProviderClass=DataProviders.class)
  public void testPostUser(String userId,String username,String firstName,String lastName,String email,String password,String phone)
  {
	  User userpayload = new User();
	  userpayload.setId(Integer.parseInt(userId));
	  userpayload.setUsername(username);
	  userpayload.setFirstName(firstName);
	  userpayload.setLastName(lastName);
	  userpayload.setEmail(email);
	  userpayload.setPassword(password);
	  userpayload.setPhone(phone);
	  
	 Response response =  UserEndPoints.createUser(userpayload);
	 response.then().log().all();
	 
	 Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
  
  @Test(priority=2,dataProvider="username",dataProviderClass=DataProviders.class)
  public void testDeleteUserByName(String username) 
  {
	  Response response = UserEndPoints.deleteUser(username);
	  Assert.assertEquals(response.getStatusCode(), 200);
  }
}

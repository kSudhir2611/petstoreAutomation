package api.test;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class StoreTest {
 
	Faker faker;
	Store storePayload;
  @BeforeClass
  public void setupData() 
  {
	  faker = new Faker();
	  storePayload = new Store();
	  
	  storePayload.setId(faker.number().randomNumber());
	  storePayload.setPetId(faker.number().numberBetween(1000, 9999));
	  storePayload.setQuantity(faker.number().numberBetween(0, 10));
	  storePayload.setStatus("placed");
	  storePayload.setComplete(true);
  }
  
  @Test(priority=1)
  public void testCreateOrder() 
  {
	  Response res = StoreEndPoints.createOrderForPet(storePayload);
	  
	  res.then().log().all();
	  
	 Assert.assertEquals(res.getStatusCode(), 200);
  }
  
  
  @Test(priority=2)
  public void testgetPOwithId() 
  {
	  Response res = StoreEndPoints.findPOwithId(storePayload.getId());
	  
	  res.then().log().all();
	  
	  Assert.assertEquals(res.getStatusCode(), 200);
  }
  
  
  @Test(priority=3)
  public void testdetetePOwithId() 
  {
	  Response res = StoreEndPoints.deletePOwithId(storePayload.getId());
	  
	  res.then().log().all();
	  
	  Assert.assertEquals(res.getStatusCode(), 200);
  }

}

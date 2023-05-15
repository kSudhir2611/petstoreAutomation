package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import api.utilities.StoreDDTest;
import io.restassured.response.Response;

public class DD2Store 
{
	@Test(priority=1,dataProvider="allData",dataProviderClass=StoreDDTest.class)
	public void testCreateOrder(String id,String petid,String qty, String status,String cmpt) 
	{
		Store userpayload = new Store();
		userpayload.setId(Long.parseLong(id));
		userpayload.setPetId(Integer.parseInt(petid));
		userpayload.setQuantity(Integer.parseInt(qty));
		userpayload.setStatus(status);
		userpayload.setComplete(Boolean.parseBoolean(cmpt));
		
		Response res = StoreEndPoints.createOrderForPet(userpayload);
		
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority=2,dataProvider="orderid",dataProviderClass=StoreDDTest.class)
	public void deletePOwithOrderId(String orderid) 
	{
		Response res = StoreEndPoints.deletePOwithId(Long.parseLong(orderid));
		
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}

}

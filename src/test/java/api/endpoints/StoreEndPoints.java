package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class StoreEndPoints 
{
	public static Response createOrderForPet(Store payload) 
	{
		Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.store_postUrl);
		
		return res;
		
	}
	
	public static Response findPOwithId(long orderid) 
	{
		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("orderid", orderid)
		.when()
			.get(Routes.store_getUrl);
		
		return res;
		
	}
	
	public static Response deletePOwithId(long orderid) 
	{
		Response res = given()
			.accept(ContentType.JSON)
			.pathParam("orderid", orderid)
		.when()
			.delete(Routes.store_deleteUrl);
		
		return res;
	}

}

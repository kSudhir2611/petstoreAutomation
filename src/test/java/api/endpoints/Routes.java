package api.endpoints;

public class Routes {
/*
POST (Create User)-https://petstore.swagger.io/v2/user
GET (Read User)-https://petstore.swagger.io/v2/user/{username}
PUT(Upadate user)-https://petstore.swagger.io/v2/user/{username}
DELETE(Delete user)https://petstore.swagger.io/v2/user
*/
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
	
/*POST Place an order for pet -https://petstore.swagger.io/v2/store/order
GET find po with id-https://petstore.swagger.io/v2/store/order/{orderid}
DELETE delete po with id-https://petstore.swagger.io/v2/store/order/{orderid}*/
	
	public static String store_postUrl = "https://petstore.swagger.io/v2/store/order";
	public static String store_getUrl = "https://petstore.swagger.io/v2/store/order/{orderid}";
	public static String store_deleteUrl = "https://petstore.swagger.io/v2/store/order/{orderid}";
}

package com.qa.api.gorest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.POJO.User;
import com.qa.api.gorest.Util.ExcelUtil;
import com.qa.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "5da41fe4a2f025bed4d01599d07622913b6c170581661d3afbb12141244aab3a";
	//String token = "c63ca2711298d8cfbaf872cdc3e041dedf1aedf0023544f58f242f58bdcb8798";
	
	@DataProvider
	public Object[][] getUserData()
	{
		Object userData[][] = ExcelUtil.getTestData("Sheet1");
		return userData;
	}
	
	@Test(dataProvider="getUserData")
	public void createUserApiTest(String name, String email, String gender, String status)
	{
		//User user = new User("madhuri","madhu@gmail.com","Female","Active"); //it works for one time only
		User user = new User(name, email, gender, status);
		Response response = RestClient.doPost("JSON", baseURI, basePath, token, null, true, user);
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("--------------------------------");
		
	}

}

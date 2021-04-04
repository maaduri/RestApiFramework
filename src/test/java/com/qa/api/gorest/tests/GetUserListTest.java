package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import com.qa.api.gorest.restclient.RestClient;

public class GetUserListTest {
	
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "5da41fe4a2f025bed4d01599d07622913b6c170581661d3afbb12141244aab3a";
	
	@Test(priority=1)
	 public void getAllUserListApiTest() {
	    Response  response = RestClient.doGet("JSON", baseURI, basePath, token, null, true);
	
	   System.out.println(response.getStatusCode());
	   System.out.println(response.prettyPrint());
		
	}
	
	
	@Test(priority=2)
	public void getUserWithQueryParamsApiTest() {
		
		Map<String,String> paramsMap = new HashMap<String,String>();
		paramsMap.put("name", "Parvatihi Meltons");
        paramsMap.put("gender", "Female");
	
        Response  response = RestClient.doGet("JSON", baseURI, basePath, token, paramsMap, true);
	
	    System.out.println(response.getStatusCode());
	    System.out.println(response.prettyPrint());
		
	}
}

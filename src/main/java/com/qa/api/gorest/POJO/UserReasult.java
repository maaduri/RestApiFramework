package com.qa.api.gorest.POJO;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;


import com.qa.api.gorest.Util.TestUtil;
import com.qa.api.gorest.restclient.RestClient;

import io.restassured.response.Response;

public class UserReasult {
	
	@Test
	public void createUserwithFullJson()
	{
		
	String token = "5da41fe4a2f025bed4d01599d07622913b6c170581661d3afbb12141244aab3a";	
	//c63ca2711298d8cfbaf872cdc3e041dedf1aedf0023544f58f242f58bdcb8798
	
	Self sf = new Self("http://www.sf.com");
	Edit ed = new Edit("http://www.ed.com");
	Avatar av = new Avatar("http://www.av.com");
	
	Links ln = new Links(sf, ed, av);
     UserInfo uf = new UserInfo("Reena","Reena@gmail.com","Female","Active",ln);
     
    String UserJsonPayload= TestUtil.getSerializedJSON(uf);
    //System.out.println("Json Body PAyload--------------");
    System.out.println(UserJsonPayload);
    
		
		/*
		 * Map<String,String> authTokenMap = new HashMap<String, String>();
		 * authTokenMap.put("Authorization","Bearer "+ token);
		 */
		 
    //Response response = RestClient.doPost("JSON", "https://gorest.co.in", "/public-api/users", token, null,  true,  UserJsonPayload);
    Response response = RestClient.doPost1("JSON", "https://gorest.co.in", "/public-api/users", token,null, true,  UserJsonPayload); 
    System.out.println(response.getStatusCode());
    System.out.println(response.prettyPrint());
     
}
}
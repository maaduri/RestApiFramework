package com.qa.api.gorest.restclient;
import java.util.Map;

import com.qa.api.gorest.Util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class is having all http methods which will call the apis and having generic methods for 
 * getting the response and fetch the values from response
 * @author Indira
 *
 */
public class RestClient {

	 //HTTP methods GET POST PUT DELETE
	//all these are generic metods . in generic methods we never harcoded.
	
	/**
	 * 
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @return this  methid is returning from the GET call
	 */
	
	public static Response  doGet(String contentType, String baseURI, String basePath, String token,
			                 Map<String, String> paramsMap, boolean log)
	{
       if(setBaseURI(baseURI)) {
       RequestSpecification request = createRequest(contentType, token, paramsMap,log);
       return getResponse("GET", request, basePath);
    		   
	    }
       return null;
	}
	
	/**
	 * This method is called for POST api
	 * @param contentType
	 * @param baseURI
	 * @param basePath
	 * @param token
	 * @param paramsMap
	 * @param log
	 * @param obj
	 * @return THis method is returning response from the post call
	 * 
	 */
	
	public static Response doPost(String contentType, String baseURI, String basePath, String token,
			 Map<String, String> paramsMap,  boolean log, Object obj)                
	{
		 if(setBaseURI(baseURI)) {
		       RequestSpecification request = createRequest(contentType, token, paramsMap,log);
		      // String jsonpayload = TestUtil.getSerializedJSON(obj); //you are sending direct user object
		      // request.body(jsonpayload);
		       request.body(obj);  //if yur are sinding string(by POJO) as object . 
		       return getResponse("POST", request, basePath);
		    		   
			    }
		       return null;
	}
	
	public static Response doPost1(String contentType, String baseURI, String basePath, String token,
			 Map<String, String> paramsMap,  boolean log, String jsonString)                
	{
		 if(setBaseURI(baseURI)) {
		       RequestSpecification request = createRequest(contentType, token, paramsMap,log);
		      
		       request.body(jsonString);  //if yur are sinding string(by POJO) as object . 
		       return getResponse("POST", request, basePath);
		    		   
			    }
		       return null;
	}
	
	
	private static boolean setBaseURI(String baseURI)
	{
		if(baseURI==null || baseURI.isEmpty()) {
			System.out.println("please pass the correct the base URI ..either it is null or balnk/empty");
			return false;
		}
		try {
		RestAssured.baseURI = baseURI;
		return true;
		} catch (Exception e)
		{
			System.out.println("Some exception ot occured while assigning the base URI with Rest ASssured");
			return false;
		}
		
	}
	
	private static RequestSpecification createRequest(String contentType, String token, Map<String, 
			                          String> paramsMap, boolean log)
	{
		RequestSpecification request;
		if(log) {
			 request = RestAssured.given().log().all();
		}
		else {
			 request = RestAssured.given();
		}
		if(token!=null) {
			request.header("Authorization","Bearer "+token);
		}
		
		if(!(paramsMap==null)) {
			request.queryParams(paramsMap);    
			
		}
		
		if(contentType.equalsIgnoreCase("JSON")) {
			request.contentType(ContentType.JSON);
		}
		else if(contentType.equalsIgnoreCase("XML")) {
			request.contentType(ContentType.XML);
		}
		else if(contentType.equalsIgnoreCase("TEXT")){
			request.contentType(ContentType.TEXT);
		}
		return request;
		
	}
	
	private static Response getResponse(String httpMethod, RequestSpecification request, String basePath) {
		return executeAPI( httpMethod,  request,  basePath);
		
	}
	
	private static Response executeAPI(String httpMethod, RequestSpecification request, String basePath)
	{
		Response response = null;
		switch (httpMethod) {
		case "GET":
		            response =	request.get(basePath);
		            break;
		case "POST":
		            response = request.post(basePath);
		            break;
		case "PUT" :
			        response = request.put(basePath);
			        break;
		case "Delete":
			        response = request.delete(basePath);
		default:
			       System.out.println("Please pass the correct http method....");
			        break;
		}
		return response;
		
		
	}

}
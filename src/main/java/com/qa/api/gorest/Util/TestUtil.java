package com.qa.api.gorest.Util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
	
	/**
	 * This method is is used to convert POJO object to JSON String....
	 * @param obj
	 * @return jsonString
	 */
	
	public static String getSerializedJSON(Object obj)
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		 try {
			 jsonString = mapper.writeValueAsString(obj);
			 System.out.println("JSON BODY PAYLOAD --------->"+jsonString);
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return jsonString;
	}

}

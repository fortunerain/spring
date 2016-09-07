package com.accenture.util;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

public class JsonUtil {
	@SuppressWarnings("unchecked")
	public static Object parseJsonString(String jsonString, Class model) {
		Object resultObj = new Object();
		Gson gson = new Gson();
		
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(jsonString);
			resultObj = gson.fromJson(jsonObject.toString(), model);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        	
		return resultObj;
	}
}

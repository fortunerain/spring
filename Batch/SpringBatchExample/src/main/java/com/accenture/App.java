package com.accenture;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.model.OAuthResponseModel;
import com.accenture.util.HttpClientUtil;
import com.accenture.util.JsonUtil;

public class App {
	private static String accessToken;
	private static String result;
	private static String consumerKey = "G3Jf2p4VERrSAfd66eNdyWgIzeAa";
	private static String consumerSecret = "iH0PVTwSQfVLT4HRJfvFUoMr2pEa";
	
	
	public static void main(String[] args) {

		//Using httpClient
		/*OAuthResponseModel oAuthResponseModel = getAccessTokenByHttpClient(); 
		accessToken = oAuthResponseModel.getAccess_token();
		String expireTime = oAuthResponseModel.getExpires_in();
		
		//api calls
		String url = "http://54.169.52.124:8280/artwork/list/1.0.0";
		Map<String, String> params = new HashMap<String, String>();
		params.put("artworkid", "1");
		result = callAPI(url, params);
		
		System.out.println("accessToken : "+accessToken);
		System.out.println("expireTime : "+expireTime);
		System.out.println("result : "+result);
		*/
		String[] springConfig  = 
			{	
				"spring/batch/jobs/apiDataToDb-job.xml" 
			};
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("jsonToDbJob");

		String jsonStr = "{\"result\": \"111\",\"response\": {\"galleryLocation\" : \"1978\"}}";
//		String jsonStr = result;
		try {
			JobParameters jobParam = new JobParametersBuilder().addString("jsonStr", jsonStr).toJobParameters();
//			JobExecution execution = jobLauncher.run(job, new JobParameters());
			JobExecution execution = jobLauncher.run(job, jobParam);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
	
	
	private static String callAPI(String url, Map<String, String> params) {
		
		String headerParams = "Bearer "+accessToken;
		String response = HttpClientUtil.get(url, params, headerParams);
		return response;
	}
	
	/*
	 * Using httpClient 
	 */
	private static OAuthResponseModel getAccessTokenByHttpClient() {
		//Endpoint for authentication
		String url = "https://54.169.52.124:9443/oauth2/token";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", OAuth2Constants.OAUTH2_GRANT_TYPE_CLIENT_CREDENTIALS);
		
		//Base64 is based on key combinations
		byte[] encodedBytes = Base64.encodeBase64((consumerKey+":"+consumerSecret).getBytes());
		String authorization = new String(encodedBytes);
		String headerParams = "Bearer "+authorization;
		
		String response = HttpClientUtil.post(url, params, headerParams);
		return (OAuthResponseModel) JsonUtil.parseJsonString(response, OAuthResponseModel.class);
	}
}

package com.raj.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.raj.models.UserDto;
import com.raj.security.User;
import com.raj.service.DataService;

@Service
public class DataServiceImpl implements DataService{
	
	private HttpHeaders headers = null;
	private HttpEntity<String> entity = null;
	private RestTemplate restTemplate = null;
	private String url = null;
	//private JSONObject input = null;
	private JSONObject requestData = null;
	private Gson gson = null;
	private String serviceResponse = null;
	
	@Override
	public String getAuthenticationToken(String userName, String password) {
		//input = new JSONObject();
		//input.put("login", new UserDto(userName, password));
		JSONArray jArray = new JSONArray();
		jArray.put(new JSONObject(new UserDto(userName, password)));
		try {
			requestData = new JSONObject();
			requestData.put("requestObj", jArray);
			System.out.println(requestData);
			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			entity = new HttpEntity<String>(requestData.toString(), headers);
			url = "http://localhost:8080/SpringRestOauth/getAuthenticationToken";
			restTemplate = new RestTemplate();
			serviceResponse = restTemplate.postForObject(url, entity, String.class);
			System.out.println(serviceResponse);
			gson = new Gson();
			User user = gson.fromJson(serviceResponse.toString(),User.class);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<User> getUserList() {
		
		// preparing user list with few hard coded values
		List<User> userList = new ArrayList<User>();
		
		userList.add(new User("user_a", "user_a@example.com", "9898989898"));
		userList.add(new User("user_b", "user_b@example.com", "9767989898"));
		userList.add(new User("user_c", "user_c@example.com", "9898459898"));
		
		return userList;
	}

}

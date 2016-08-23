package com.raj.token.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.raj.models.SessionTokenDto;
import com.raj.models.UserDto;

@RestController
public class TokenController {

	@RequestMapping(value="/getAuthenticationToken", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createAuthenticationToken(@RequestBody String formData, @RequestHeader HttpHeaders head, HttpServletRequest request) {
		ResponseEntity<String> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.add("Authorization", "");
		HttpEntity<String> entity = null;
		RestTemplate restTemplate = new RestTemplate();
		String responseFromAuth = null;
		String client_type = "";
		String secret = "";
		String status = "0";
		JSONObject resjson;
		Gson gson = new Gson();
		JSONObject json;
		System.out.println("Token Controller: "+formData);
		try {
			resjson = new JSONObject();
			json = new JSONObject(formData);
			JSONArray reqJson = (JSONArray) json.get("requestObj");
			UserDto dto = gson.fromJson(reqJson.getJSONObject(0).toString(),UserDto.class);
			
			String userName = "";
			if(null != dto.getUserName()){
				userName = dto.getUserName();
				client_type = "CS";
				secret = "secret";
			}
			else{
				status = "2";
				resjson.put("s", status);
				resjson.put("msg", "Invalid Credentials");
				responseEntity = new ResponseEntity<String>(resjson.toString(), HttpStatus.OK);
				return responseEntity;
			}
			String pwd = dto.getPassword();
			String processed_url = "http://localhost:8080/SpringRestOauth/oauth/token?grant_type=password&client_id="
					+ client_type + "&client_secret=" + secret + "&username=" + userName + "&password=" + pwd;
			entity = new HttpEntity<String>(formData, headers);
			try {
				System.out.println("URL: "+processed_url);
				responseFromAuth = restTemplate.postForObject(processed_url, entity, String.class);
				System.out.println("Output:\n"+responseFromAuth);
				if (responseFromAuth == null) {
					status = "2";
					resjson.put("s", status);
					resjson.put("msg", "Invalid Credentials");
					responseEntity = new ResponseEntity<String>(resjson.toString(), HttpStatus.OK);
					return responseEntity;
				} 
				else {
					JSONObject resp_json = new JSONObject(responseFromAuth);
					String resp_auth_token = resp_json.getString("value");
					// creating new session
					HttpSession session = request.getSession(true);
					SessionTokenDto sesdto = new SessionTokenDto();
					sesdto.setSessionId(session.getId());
					sesdto.setCreatedTime("" + session.getCreationTime());
					Integer sesstime = 20;
					sesdto.setSessionLifeTime(sesstime * 60);
					sesdto.setAuthenticationToken(resp_auth_token);
					sesdto.setAppId(userName);
					resp_json.put("sessionId", session.getId());
					responseEntity = new ResponseEntity<String>(resp_json.toString(), HttpStatus.OK);
				}
			} 
			catch (HttpClientErrorException e) {
				e.printStackTrace();
		        System.out.println(e.getStatusCode());
		        System.out.println(e.getResponseBodyAsString());
		    }
			catch(Exception e){
				e.printStackTrace();
				resjson.put("s", "2");
				resjson.put("msg", "Invalid Credentials");
				responseEntity = new ResponseEntity<String>(resjson.toString(), HttpStatus.OK);
				return responseEntity;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
}

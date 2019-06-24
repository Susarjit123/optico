package com.controller.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.model.UserResponseModel;

import junit.framework.Assert;
public class UserControllerTest {
	@SuppressWarnings("deprecation")
	@Test
	@Ignore
	public void testGetEmployeeListSuccess() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080" + "/user/users";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<UserResponseModel> result = restTemplate.getForEntity(uri, UserResponseModel.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	}
}

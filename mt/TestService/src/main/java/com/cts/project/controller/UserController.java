package com.cts.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import com.cts.project.config.ServiceConfig;
import com.cts.project.model.Mockquiz;
import com.cts.project.model.User;
import com.netflix.discovery.EurekaClient;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/UserPortal")
public class UserController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	ServiceConfig configuration;

	private User user;
	@RequestMapping("/getAllUsers")
public List<User> getAllUsers(){
		List<User> list = new ArrayList<User>();
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
		HttpEntity<String> requestEntity = new HttpEntity<String>( header);
		list = restTemplate.exchange("http://localhost:9099/UserPortal/getAllUsers",
              HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<User>>() { }).getBody();
		return list;
}

	 @PostMapping("/saveUser")

	 public ResponseEntity<User> saveUser(@RequestBody User user) {
		 HttpHeaders header = new HttpHeaders();
			header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
			HttpEntity<User> requestEntity = new HttpEntity<>(user,header);
			ResponseEntity<User> user1 = restTemplate.exchange("http://localhost:9099/UserPortal/saveUser",
	              HttpMethod.POST, requestEntity, new ParameterizedTypeReference<User>() { });
	 return user1;

	 }
	@PutMapping("/updateUser/{username}")
	public User updateUser(@RequestBody User user,@PathVariable ("username")String username) {
		 HttpHeaders header = new HttpHeaders();
			header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
			HttpEntity<String> requestEntity = new HttpEntity<String>( header);
			user = restTemplate.exchange("http://localhost:9099/UserPortal/updateUser",
	              HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<User>() { }).getBody();
		return user;
	}
	@DeleteMapping("/deleteUser/{username}")
	public boolean deleteUser(@PathVariable ("username")String username) {
		 HttpHeaders header = new HttpHeaders();
			header.setBasicAuth(configuration.getAuthUsername(), configuration.getAuthPassword());
			HttpEntity<String> requestEntity = new HttpEntity<String>( header);
			user = restTemplate.exchange("http://localhost:9099/UserPortal/deleteUser",
	              HttpMethod.DELETE, requestEntity, new ParameterizedTypeReference<User>() { }).getBody();
		return true;
	}		
}

package com.cts.project.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.cts.project.dao.UserRepository;
import com.cts.project.pojos.User;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/UserPortal")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/getAllUsers")
public List<User> getAllUsers(){
	return userRepository.findAll();
}

	 @PostMapping("/saveUser")

	 public User saveUser(@RequestBody User user) {

	 System.out.println(user);

	 userRepository.save(user);
	 return user;

	 }
	@PutMapping("/updateUser/{username}")
	public User updateUser(@RequestBody User user,@PathVariable ("username")String username) {
		user.setUsername(username);
		System.out.println(user);
		userRepository.save(user);
		return user;
	}
	@DeleteMapping("/deleteUser/{username}")
	public boolean deleteUser(@PathVariable ("username")String username) {
		userRepository.deleteById(username);
		return true;
	}
	@GetMapping("/findOneInAll/{username}")

	public User findOneInAll(@PathVariable("username") String username) {

		Optional<User> user = userRepository.findById(username);

		return user.get();

	}
	@GetMapping("/findByUsernameAndPassword/{username}/{password}")

	 public User findByUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password)

	 {
		 User user= userRepository.findByUsernameAndPasswordAndConfirm(username, password,"yes");

		 System.out.println(user);
	 return user;

	 }
		
}

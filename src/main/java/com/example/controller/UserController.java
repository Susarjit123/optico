package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.model.UserResponseModel;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// create
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}

	// read
	@RequestMapping(value = "/{id}")
	public User read(@PathVariable String id) {
		return userRepository.findOne(id);
	}

	/**
	 * @param user
	 */
	@RequestMapping(value = "/update",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody User user) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where(user.getName()).is("Susarjit"));
		user.setAge(20);
		userRepository.save(user);
	}

	/**Delete by {id}
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		userRepository.delete(id);
	}
	
	/**Get All Users
	 * @return
	 */
	@RequestMapping(value="/users", method= RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public UserResponseModel getAllUsers() {
		UserResponseModel userResponseModel=new UserResponseModel();
		 userResponseModel.setUsers(userRepository.findAll());
		 return userResponseModel;
	}
}

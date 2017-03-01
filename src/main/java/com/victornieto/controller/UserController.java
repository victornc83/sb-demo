package com.victornieto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.victornieto.model.User;
import com.victornieto.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserRepository repository ;

	@RequestMapping("/{name}")
	public List<User> getUser(@PathVariable("name") String name){
		return repository.findByNombre(name) ;
	}

	@RequestMapping("/")
	public List<User> getUsers(){
		return repository.findAll() ;
	}

	@RequestMapping("/search/{name}")
	public List<User> getUsersByName(@PathVariable String name){
		List<User> users = repository.findByNombre(name);
		return users;
	}

	@PostMapping("/")
	public ResponseEntity<String> addUser(@RequestBody User user){
		repository.save(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{name}")
	public ResponseEntity<String> delUserByName(@PathVariable String name){
        List<User> users = repository.findByNombre(name);
        try{
        	for (User u:users){
        		repository.delete(u);
        	}
        	return new ResponseEntity<>(HttpStatus.ACCEPTED) ;
        }
        catch(IllegalArgumentException i){
        		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

	@RequestMapping(method=RequestMethod.PUT, value="/{name}")
	public ResponseEntity<String> updateUser(@PathVariable String name, @RequestBody User user) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}

package com.zykaExpress.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zykaExpress.custom_excpetions.ResourceNotFoundException;
import com.zykaExpress.model.User;
import com.zykaExpress.service.UserService;


@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	private UserService useService;
	
	@PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = useService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@RequestBody Long id){
		String user=useService.DeleteUser(id);
		return ResponseEntity.ok(user);
	}
	
	 @GetMapping("/{id}")
	 public ResponseEntity<Optional<User>> findUser(@PathVariable Long id){
		 Optional<User> getUser=useService.GetUSer(id);
		 return ResponseEntity.ok(getUser);
	 }
	 
	 
	
	/*
	 * @GetMapping("/login") public ResponseEntity<User>
	 * getUserByEmailAndPassword(@RequestParam String email, @RequestParam String
	 * password) { Optional<User> user =useService.getUser(email, password); return
	 * user.map(ResponseEntity::ok).orElseGet(() ->
	 * ResponseEntity.status(401).build()); }
	 */
	    
}

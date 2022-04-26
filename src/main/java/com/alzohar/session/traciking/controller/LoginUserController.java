package com.alzohar.session.traciking.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.session.traciking.entity.User;
import com.alzohar.session.traciking.repositroy.UserRepository;
@RestController
public class LoginUserController {
	@Autowired
	UserRepository userRepo;
	private final HttpServletRequest req;

	@Autowired
	public LoginUserController(HttpServletRequest req) {
		this.req = req;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
		
		User fetcheduser = userRepo.findByEmail(user.getEmail());
		if(fetcheduser.getPassword().equals(user.getPassword())) {
			Map<String, String> response = new HashMap<String, String>();
			req.getSession().isNew();
			response.put("messaage", "user is login sccessfully");
			response.put("status", "successfull");
			response.put("Session Key", req.getSession().getId());
			response.put("Session Key Encode", Base64.getEncoder().encodeToString(req.getSession().getId().getBytes()));
			return ResponseEntity.ok(response);
		}
		throw new UsernameNotFoundException("user not found");
		
		
//		result.put("Session Key Encode", Base64.getEncoder().encodeToString(req.getSession().getId().getBytes()));
		

}

}
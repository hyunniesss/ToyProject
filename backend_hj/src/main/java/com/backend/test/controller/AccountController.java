package com.backend.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.test.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/signup")
	public ResponseEntity<HashMap<String, Object>> signup(String userId) {
		
		boolean flag = accountService.checkId(userId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", !flag);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}

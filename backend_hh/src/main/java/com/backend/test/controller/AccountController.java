package com.backend.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.test.dto.Account;
import com.backend.test.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/signup")
	public ResponseEntity<HashMap<String, Object>> signup(String userId) {
		boolean flag = accountService.checkId(userId);
		HashMap<String, Object> map = new HashMap<>();
		map.put("success", !flag);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<HashMap<String, Object>> signup(Account account) {
		System.out.println(account.toString());
		accountService.signup(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

package com.project.toy.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.toy.repo.AccountRepo;
import com.project.toy.service.account.AccountService;

//@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@Autowired
	private AccountRepo accountRepo;
	

}

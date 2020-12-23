package com.project.toy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.toy.dto.Account;
import com.project.toy.dto.Profile;
import com.project.toy.repo.AccountRepo;
import com.project.toy.repo.ProfileRepo;
import com.project.toy.service.account.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private AccountRepo accountRepo;
	
	@GetMapping("/")
	public void test() {
		Account ac = Account.builder().userEmail("email").userId("id").userName("name").userPassword("password").build();
		ac = accountRepo.save(ac);
		System.out.println("AC : "+ac.toString());
		profileRepo.save(Profile.builder().account(ac).build());
		List<Profile> list = profileRepo.findAll();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		
		List<Long> temp = profileRepo.findAccountId();
		for(int i=0;i<temp.size();i++) {
			System.out.println("TEMP : "+temp.get(i));
		}
	}

}

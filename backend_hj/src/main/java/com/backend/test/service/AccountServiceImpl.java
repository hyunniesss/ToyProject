package com.backend.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.test.dto.Account;
import com.backend.test.repo.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Override
	public boolean checkId(String userId) {
		Account account = accountRepo.findByUserId(userId); // 명명 규칙 findByXX
		if (account == null)
			return false;
		return true;
	}

}

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

	@Override
	public boolean insertAccount(Account account) {
		accountRepo.save(account);
		// accountRepo.flush();
		return true;
	}

	@Override
	public boolean checkPassword(String userId, String userPassword) {
		Account account = accountRepo.findByUserIdAndUserPassword(userId, userPassword);
		if (account == null)
			return false;
		return true;
	}

	@Override
	public void updatePwd(Account account) {
		Account a = accountRepo.findByUserId(account.getUserId());
		a.setUserPassword(account.getUserPassword());
		accountRepo.save(a);
		// accountRepo.flush();
	}

	@Override
	public boolean deleteAccount(Integer uid) {
		Account account = accountRepo.getOne(uid);
		if (account == null) {
			return false;
		}
		
		accountRepo.deleteById(uid);
		return true;
	}
}

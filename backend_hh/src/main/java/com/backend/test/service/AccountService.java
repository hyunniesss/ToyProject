package com.backend.test.service;

import com.backend.test.dto.Account;

public interface AccountService {
	
	boolean checkId(String userId);
	void signup(Account account);

}

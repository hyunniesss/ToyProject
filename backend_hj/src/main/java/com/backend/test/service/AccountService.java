package com.backend.test.service;

import com.backend.test.dto.Account;

public interface AccountService {

	boolean checkId(String userId);

	boolean insertAccount(Account account);

	boolean checkPassword(String userId, String userPassword);

	void updatePwd(Account account);

	boolean deleteAccount(Integer uid);
}

package com.backend.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.test.dto.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	
	public Account findByUserId(String userId);

	public Account findByUserIdAndUserPassword(String userId, String userPassword);
}

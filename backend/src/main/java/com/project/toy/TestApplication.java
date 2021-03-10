package com.project.toy;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.project.toy.dto.Account;
import com.project.toy.dto.Club;
import com.project.toy.dto.Role;
import com.project.toy.dto.RoleId;
import com.project.toy.repo.RoleRepo;

@Component
@Transactional
public class TestApplication implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;	// 얘를 레포지토리에 넣어야해

	@Autowired
	RoleRepo roleRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Account account = Account.builder().userEmail("email@email.com").userId("email").userName("이름").userPassword("password").build();
		
		entityManager.persist(account);
		
		System.out.println("실행됨");

	}
}

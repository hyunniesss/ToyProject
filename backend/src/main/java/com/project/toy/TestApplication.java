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
	EntityManager entityManager; // 얘를 레포지토리에 넣어야해

	@Autowired
	RoleRepo roleRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Account account = Account.builder().userEmail("email@email.com").userId("email").userName("이름")
				.userPassword("password").build();

		entityManager.persist(account);

		System.out.println("실행됨");
		Club club = Club.builder().clubName("클럽B").description("동아리 설명은 어쩌구저쩌구").build();
		account = Account.builder().userId("201521362").userName("박이름").userPassword("password")
				.userEmail("email13@email.com").build();

		Role role = Role.builder().build();
		role.setClub(club);
		role.setAccount(account);
		role.setClubRole(null);

		Session session = entityManager.unwrap(Session.class);
		session.save(club);
		session.save(account);
		session.save(role);

		RoleId roleId = new RoleId();
		roleId.setAccount(account);
		roleId.setClub(club);

//		Role role1= entityManager.find(Role.class, roleId);
		Role role1 = session.find(Role.class, roleId);
		System.out.println(role1.getClubRole());
	}

}

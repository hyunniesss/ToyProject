package com.project.toy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.project.toy.dto.Account;
import com.project.toy.dto.Club;
import com.project.toy.dto.Role;

@Component
@Transactional
public class TestApplication implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("여길 들어오긴 할까");
		Club club = Club.builder().clubName("클럽A").description("동아리 설명은 어쩌구저쩌구").build();
		System.out.println("==============="+club.toString()+"===============");
		Account account = Account.builder().userId("201521362").userName("김이름").userPassword("password")
				.userEmail("email135@email.com").build();
		System.out.println("==============="+account.toString()+"===============");
		
		Role role = Role.builder().build();
		role.setClub(club);
		role.setAccount(account);
		System.out.println("==============="+role.toString()+"===============");
		
		Session session = entityManager.unwrap(Session.class);
		session.save(club);
		System.out.println(session.get(Club.class, 1L));
		session.save(account);
		System.out.println(session.get(Account.class, 1L));
		session.save(role);
		System.out.println(session.get(Role.class, 1L));
	}

}

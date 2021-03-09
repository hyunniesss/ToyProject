package com.project.toy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.toy.dto.Account;
import com.project.toy.dto.Club;
import com.project.toy.dto.Role;
import com.project.toy.dto.RoleId;

@Repository
public interface RoleRepo extends JpaRepository<Role, RoleId> {
	List<Role> findAllByAccountAndClub(Account account, Club club);
}

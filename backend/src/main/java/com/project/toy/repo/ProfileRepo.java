package com.project.toy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.toy.dto.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Long>{
	
	@Query(value="select account_id from profile",nativeQuery=true)
	List<Long> findAccountId(); 

}

package com.project.toy.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * 복합키를 가지는 Role의 PK를 묶기 위한 Class
 * JpaRepository<T, ID>에서 ID에 쓰이기도 한다.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoleId implements Serializable{
	private Account account;
	private Club club;

	// lombok을 사용하지 않으면 작성 필수 
//	@Override
//	public boolean equals(Object o) {
//		if(this == o) return true;
//		if(o == null || getClass() != o.getClass()) return false;
//		Role role = (Role) o; 
//		return account.getUid().equals(role.getAccount().getUid()) &&
//				club.getUid().equals(role.getClub().getUid());
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(account, club);
//	}
	
}

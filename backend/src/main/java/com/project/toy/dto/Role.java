package com.project.toy.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@IdClass(RoleId.class)
public class Role { // 얘가 주인

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CLUB_ID")
	private Club club;
	
	@Enumerated(EnumType.STRING)
	private UserRole clubRole;
}

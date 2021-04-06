package com.project.toy.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
	private Club club;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	private Account account;

	@Column(columnDefinition = "varchar(20) default 'CLUB_ADMIN'")
	private String clubRole = "CLUB_ADMIN";
}

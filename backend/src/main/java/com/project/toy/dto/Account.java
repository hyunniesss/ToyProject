package com.project.toy.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;

	private boolean status; // 로그인 상태

	@Column(nullable = false, unique = true)
	private String userId; // 학번

	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false)
	private String userPassword;

	@Column(nullable = false, unique = true)
	private String userEmail;

	private String profile;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Role> clubRoles = new ArrayList<>();

	private String siteRole; // ROLE_ADMIN

}

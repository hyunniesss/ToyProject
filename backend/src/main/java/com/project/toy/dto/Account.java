package com.project.toy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"USER_ID", "USER_NAME", "USER_EMAIL"})})
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACCOUNT_ID")
	private Long uid;

	private boolean status; // 로그인 상태

	@Column(nullable = false, name="USER_ID")
	private String userId; // 학번

	@Column(nullable = false, name="USER_NAME")
	private String userName;

	@Column(nullable = false, name="USER_PASSWORD")
	private String userPassword;

	@Column(nullable = false, name="USER_EMAIL")
	private String userEmail;

	private String profile;

//	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
//	private List<Role> clubRoles = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	private UserRole siteRole; // ROLE_ADMIN

}

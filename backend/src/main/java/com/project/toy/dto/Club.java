package com.project.toy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@ToString
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"CLUB_NAME"})})
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLUB_ID")
	private Long uid;

	@Column(nullable = false, name="CLUB_NAME")
	private String clubName;

	private String description;

	private String profile;

	private boolean isCentral;

//	@OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
//	private List<Role> clubs;

}

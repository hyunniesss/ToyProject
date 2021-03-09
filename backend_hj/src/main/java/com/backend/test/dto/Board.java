package com.backend.test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자 만들기
@AllArgsConstructor // 전체 생성자
@Entity // 테이블과 연결
@Getter
@Setter
@ToString
@Builder // 모든 파라미터를 사용하지 않고도 값을 넣을 수 있고, Constructor 대신이라고 생각하자
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uid;
	@Column(name = "user_id") // 이름을 똑같이 사용한다면 굳이 안적어도 된다. 대문자가 있으면 요런 형식으로 바꿔줌
	private String userId;
	private String userPassword;
	private String userName;

}

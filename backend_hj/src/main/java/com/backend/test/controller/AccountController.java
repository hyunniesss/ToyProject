package com.backend.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.test.dto.Account;
import com.backend.test.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	// 아이디 확인
	@GetMapping("/signup")
	public ResponseEntity<HashMap<String, Object>> signup(String userId) {

		boolean flag = accountService.checkId(userId);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", !flag);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 회원가입
	// @RequestBody로 파라미터로 받아야 JSON으로 보낼 수 있다.
	@PostMapping("/signup")
	public ResponseEntity<HashMap<String, Object>> signup(@RequestBody Account account) {
		boolean flag = accountService.insertAccount(account);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", flag);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 로그인
	@PutMapping("/login")
	public ResponseEntity<HashMap<String, Object>> login(@RequestBody Account account) {
		String userId = account.getUserId();
		String userPassword = account.getUserPassword();

		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean flag = accountService.checkId(userId);
		if (!flag) { // 아이디 없을 때
			map.put("success", flag);
			map.put("message", "아이디 없음");
		} else {
			flag = accountService.checkPassword(userId, userPassword);
			map.put("success", flag);
			if (!flag) { // 아이디는 있으나 비밀번호 틀렸을 때
				map.put("message", "비밀번호 불일치");
			}
		}

		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 비밀번호 변경
	@PutMapping(value = "/updatePwd")
	public ResponseEntity<HashMap<String, Object>> updatePwd(@RequestBody Account account) {
		accountService.updatePwd(account);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	// 회원 탈퇴
	@DeleteMapping("/delete")
	public ResponseEntity<HashMap<String, Object>> delete(Integer uid) {
		boolean flag = accountService.deleteAccount(uid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("success", flag);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}

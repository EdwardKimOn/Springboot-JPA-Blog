package com.metlin.blog.controller.api;

import com.metlin.blog.dto.ResponseDto;
import com.metlin.blog.model.BlogUser;
import com.metlin.blog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogUserApiController {
	@Autowired
	private BlogUserService blogUserService;
	
//	@Autowired
//	private HttpSession session;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody BlogUser user) {
		int result = blogUserService.회원가입(user);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody BlogUser user){
		blogUserService.회원수정(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}

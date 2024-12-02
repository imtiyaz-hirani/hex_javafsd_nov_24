package com.springboot.bank_demo.controller;

 import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 import com.springboot.bank_demo.model.UserInfo;
import com.springboot.bank_demo.service.UserInfoService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/api/userinfo/address/company/add")
	public void savebatchUserInfoWithAddressAndCompany(
								@RequestBody List<UserInfo> userinfo) {
		userInfoService.insertuserInfoBatch(userinfo);
	}
	
	@GetMapping("/api/user-details/all")
	public Page<UserInfo> getuserDetails(
					@RequestParam(required = false, defaultValue = "0") String page, 
					@RequestParam(required = false, defaultValue = "1000000") String size) 
							throws Exception{
		Pageable pageable = null; 
		
		try {
			pageable =   PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
		}
		catch(Exception e) {
			throw e; 
		}
		
		Page<UserInfo> list =  userInfoService.getuserDetails(pageable);
		return list; 
	}
}

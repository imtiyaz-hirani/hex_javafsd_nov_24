package com.springboot.bank_demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.bank_demo.model.AddressInfo;
import com.springboot.bank_demo.model.Company;
import com.springboot.bank_demo.model.Geo;
import com.springboot.bank_demo.model.UserInfo;
import com.springboot.bank_demo.repository.AddressInfoRepo;
import com.springboot.bank_demo.repository.CompanyRepo;
import com.springboot.bank_demo.repository.GeoRepo;
import com.springboot.bank_demo.repository.UserInfoRepo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepo userInfoRepo;
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private AddressInfoRepo addressInfoRepo;
	@Autowired
	private GeoRepo geoRepo;
	
	public void insertuserInfoBatch(List<UserInfo> userinfo) {
		List<UserInfo> list = new ArrayList<>(); 
		
		for(UserInfo user : userinfo) {
			//save geo
			Geo geo = user.getAddress().getGeo();
			geo = geoRepo.save(geo); //with id 
			
			//save address
			AddressInfo addressInfo = user.getAddress();
			addressInfo.setGeo(geo);
			addressInfo = addressInfoRepo.save(addressInfo); //with id
			
			//save company 
			Company company = user.getCompany();
			company = companyRepo.save(company);//with id
			
			//set user
			user.setCompany(company);
			user.setAddress(addressInfo);
			list.add(user);
		}
		
		//save user in batch 
		userInfoRepo.saveAll(list);
	}

	public Page<UserInfo> getuserDetails(Pageable pageable) {
		 
		return userInfoRepo.findAll(pageable);
	}
	
	
}

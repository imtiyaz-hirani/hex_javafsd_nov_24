package com.springboot.SpringBatch.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.SpringBatch.model.Address;
import com.springboot.SpringBatch.model.Employee;
import com.springboot.SpringBatch.repository.AddressRepository;
import com.springboot.SpringBatch.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	public void uploadEmployeethruExcel(MultipartFile file) throws IOException {
		/* Step 1: Convert file into InputStream */
		InputStream inputStream = file.getInputStream();
		
		/*step 2: give this inputStream to BufferedReader */
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		
		/*Step 3: Read the content line by line using loop and save them in object*/
		br.readLine(); // this gives all headers which we ignore 
		String data=""; 
		
		List<Employee> list = new ArrayList<>();
		while((data = br.readLine()) != null) {
			//System.out.println(data);
			Employee employee = new Employee();
			Address address = new Address();
			String[] str = data.split(",");
			employee.setName(str[1]);
			employee.setSalary(Double.parseDouble(str[2]));
			employee.setContact(str[3]);
			
			address.setCity(str[4]);
			address.setPincode(str[5]);
			//generate address ID 
			int id = (int)(Math.random()* 10000000);
			address.setId(id);
			
			//attach address to employee
			employee.setAddress(address); //remember, address and employee are both without id
			list.add(employee);
		}
		
		/* step 4: Iterate over the list, detach address, save address and re-attach again 
		 * Right now, the address is without the id, after detaching and saving and reattaching, 
		 * i will have address with id. */
		/*
		List<Employee> empList = new ArrayList<>();
		for(Employee e :list) {
			Address address = e.getAddress();  //detach 
			address = addressRepository.save(address); //save
			e.setAddress(address);
			empList.add(e);
		}
		*/
		/*Step 4: Save all address using batch*/
		List<Address> listAddress =  list.stream().map(e->e.getAddress()).toList();
		addressRepository.saveAll(listAddress);
		
		/*Step 5: Save Employee in batch */
		employeeRepository.saveAll(list);
	}
}

package com.springboot.SpringBatch.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.SpringBatch.exception.ResourceNotFoundException;
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

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
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

	public void deleteEmployeeByCity(String city) {
		List<Employee> list =  employeeRepository.findAll();
		List<Employee> filteredList = 
				list.parallelStream()
				.filter(e-> e.getAddress().getCity().equalsIgnoreCase(city))
				.toList();
		
		employeeRepository.deleteAll(filteredList);
	}

	public Page<Employee> getAllEmployee(Pageable pageable) {
 		return employeeRepository.findAll(pageable) ;
	}

	public Employee validate(int id) throws ResourceNotFoundException {
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("Invalid ID");
		return optional.get();
	}

	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}

	public List<Employee> getEmployees() {
		 
		return employeeRepository.findAll();
	}

	public List<Employee> searchByName(String name) {
		 
		return employeeRepository.searchByName(name);
	}

	public List<Employee> searchByNameV2(String name) {
		List<Employee> list = employeeRepository.findAll();
		
		return list.parallelStream()
					.filter(e->e.getName().contains(name))
					.toList();
	}
	
	
	
}

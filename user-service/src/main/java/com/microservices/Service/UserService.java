package com.microservices.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.Entity.Department;
import com.microservices.Entity.ResponseTemplate;
import com.microservices.Entity.User;
import com.microservices.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplate getUserWithDepartment(Long userId) {
		ResponseTemplate rt = new ResponseTemplate();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://localhost:8089/department/" + 
		user.getDepartmentId(),Department.class);
		rt.setUser(user);
		rt.setDepartment(department);
		return rt;
	}

}

package com.microservices.department.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.department.Entity.Department;
import com.microservices.department.Repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartmentByid(Long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}
}

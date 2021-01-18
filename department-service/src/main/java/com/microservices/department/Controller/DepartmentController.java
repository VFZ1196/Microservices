package com.microservices.department.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.department.Entity.Department;
import com.microservices.department.Service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.save(department);
	}
	
	@GetMapping("/department/{id}")
	public Department getDepartmentByid(@PathVariable("id") Long departmentId) {
		return departmentService.getDepartmentByid(departmentId);
	}

}

package com.tiagobalduino.springhibernate.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiagobalduino.springhibernate.model.Department;
import com.tiagobalduino.springhibernate.service.DepartmentService;

@Component
@RestController
public class DepartmentRest {
	@Autowired
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@RequestMapping("/listDepartment")
	public @ResponseBody List<Department> listDepartment(){
		List<Department> list = departmentService.list();
		return list;
	}
	
}

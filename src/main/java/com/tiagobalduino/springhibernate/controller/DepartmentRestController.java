package com.tiagobalduino.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagobalduino.springhibernate.model.Department;
import com.tiagobalduino.springhibernate.service.DepartmentService;

@RestController
public class DepartmentRestController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/departments",  method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity listDepartment() {
		List<Department> list = departmentService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/department/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getDepartment(@PathVariable("id") Integer id) {

		List<Department> find = departmentService.find(id);
		if (find == null) {
			return new ResponseEntity("Nenhum Departamento encontrado para o ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(find, HttpStatus.OK);
	}

	@RequestMapping(value = "/departments", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity createDepartment(@RequestBody Department department) {

		departmentService.add(department);

		return new ResponseEntity(department, HttpStatus.OK);
	}

	@RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity deleteDepartment(@PathVariable Integer id) {

		List<Department> find = departmentService.find(id);
		if (find == null) {
			return new ResponseEntity("Nenhum Departamento encontrado para o ID " + id, HttpStatus.NOT_FOUND);
		}

		departmentService.delete(find.get(0));

		return new ResponseEntity(HttpStatus.OK);

	}

	@RequestMapping(value = "/departments/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity updateDepartment(@PathVariable Integer id, @RequestBody Department department) {

		List<Department> find = departmentService.find(id);

		if (null == find) {
			return new ResponseEntity("Nenhum Departamento encontrado para o ID " + id, HttpStatus.NOT_FOUND);
		}

		departmentService.edit(department);

		return new ResponseEntity(HttpStatus.OK);
	}

}

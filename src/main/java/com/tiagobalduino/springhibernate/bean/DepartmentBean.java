package com.tiagobalduino.springhibernate.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiagobalduino.springhibernate.model.Department;
import com.tiagobalduino.springhibernate.service.DepartmentService;

@Component
@ManagedBean
@SessionScoped
public class DepartmentBean {
	
	private Department department;
	
	@Autowired
	DepartmentService departmentService;
	
	public void add() {
		if(department != null){
			departmentService.add(department);
			init();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage( null, new FacesMessage( "Saved successfully!" ));
		}
	}
	
	public void edit(){
		departmentService.edit(department);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( "Edited successfully!" ));
	}
	
	public void delete(Department department){
		departmentService.delete(department);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( "Removed successfully!" ));
	}
	
	@PostConstruct
	public void init() {
		department = new Department();

	}
	
	public void loadDepartment(Department department){
		this.department = department;
	}
	
	public List<Department> list() {
		List<Department> listDepartments = departmentService.list();
		
		return listDepartments;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
}

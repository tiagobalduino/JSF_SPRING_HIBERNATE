package com.tiagobalduino.springhibernate.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagobalduino.springhibernate.dao.DepartmentDAO;
import com.tiagobalduino.springhibernate.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDAO departmentDAO;
	 
    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }
 
    @Override
    @Transactional
    public void add(Department department) {
        this.departmentDAO.addDepartment(department);;
    }
    
    @Override
    @Transactional
    public void edit(Department department) {
        this.departmentDAO.edit(department);
    }
 
    @Override
    @Transactional
    public List<Department> list() {
        return this.departmentDAO.listDepartments();
    }

	@Override
	@Transactional
	public void delete(Department department) {
		this.departmentDAO.delete(department);
		
	}
 
}

package com.tiagobalduino.springhibernate.dao;

import java.util.List;

import com.tiagobalduino.springhibernate.model.Department;
 

public interface DepartmentDAO {
 
    public void addDepartment(Department department);
    public List<Department> listDepartments();
    public void edit(Department department);
    public void delete(Department department);
}
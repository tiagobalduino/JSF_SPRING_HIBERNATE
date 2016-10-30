package com.tiagobalduino.springhibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiagobalduino.springhibernate.model.Department;
 
@Service
public interface DepartmentService {
 
    public void add(Department department);
    public List<Department> list();
    public void edit(Department department);
    public void delete(Department department);
   
}
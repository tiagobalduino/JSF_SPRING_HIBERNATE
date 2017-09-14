package com.tiagobalduino.springhibernate.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tiagobalduino.springhibernate.model.Permission;
 
@Service
public interface PermissionService {
 
    public void add(Permission permission);
    public List<Permission> list();
    public void edit(Permission permission);
    public void delete(Permission permission);
    public List<Permission> find(Integer id);
   
}
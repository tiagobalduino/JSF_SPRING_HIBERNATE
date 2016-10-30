package com.tiagobalduino.springhibernate.dao;

import java.util.List;

import com.tiagobalduino.springhibernate.model.Permission;
 

public interface PermissionDAO {
 
    public void addPermission(Permission department);
    public List<Permission> listPermissions();
    public void edit(Permission department);
    public void delete(Permission department);
}
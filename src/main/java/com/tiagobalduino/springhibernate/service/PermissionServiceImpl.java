package com.tiagobalduino.springhibernate.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagobalduino.springhibernate.dao.PermissionDAO;
import com.tiagobalduino.springhibernate.model.Permission;

@Service
public class PermissionServiceImpl implements PermissionService {

	private PermissionDAO permissionDAO;
	 
    public void setPermissionDAO(PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }
 
    @Override
    @Transactional
    public void add(Permission permission) {
        this.permissionDAO.addPermission(permission);
    }
    
    @Override
    @Transactional
    public void edit(Permission permission) {
        this.permissionDAO.edit(permission);
    }
 
    @Override
    @Transactional
    public List<Permission> list() {
        return this.permissionDAO.listPermissions();
    }

	@Override
	@Transactional
	public void delete(Permission permission) {
		this.permissionDAO.delete(permission);
		
	}

	@Override
	@Transactional
	public List<Permission> find(Integer id) {
		
		return this.permissionDAO.find(id);
	}
 
}

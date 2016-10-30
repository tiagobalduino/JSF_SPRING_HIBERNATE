package com.tiagobalduino.springhibernate.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiagobalduino.springhibernate.model.Permission;
import com.tiagobalduino.springhibernate.service.PermissionService;

@Component
@ManagedBean
@SessionScoped
public class PermissionBean {
	
	private Permission permission;
	
	@Autowired
	PermissionService permissionService;
	
	public void add() {
		if(permission != null){
			permissionService.add(permission);
			init();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage( null, new FacesMessage( "Saved successfully!" ));
		}
	}
	
	public void edit(){
		permissionService.edit(permission);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( "Edited successfully!" ));
	}
	
	public void delete(Permission permission){
		permissionService.delete(permission);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( "Removed successfully!" ));
	}
	
	@PostConstruct
	public void init() {
		permission = new Permission();

	}
	
	public void loadPermission(Permission permission){
		this.permission = permission;
	}
	
	public List<Permission> list() {
		List<Permission> listPermission = permissionService.list();
		
		return listPermission;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
}

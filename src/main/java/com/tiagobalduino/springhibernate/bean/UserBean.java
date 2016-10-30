package com.tiagobalduino.springhibernate.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiagobalduino.springhibernate.model.Department;
import com.tiagobalduino.springhibernate.model.Permission;
import com.tiagobalduino.springhibernate.model.User;
import com.tiagobalduino.springhibernate.service.DepartmentService;
import com.tiagobalduino.springhibernate.service.PermissionService;
import com.tiagobalduino.springhibernate.service.UserService;


@Component
@ManagedBean
@SessionScoped
public class UserBean {

	private User user;

	@Autowired
	UserService userService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	PermissionService permissionService;

	private Permission permission;


	

	public void add() {
		if (user != null) {
			userService.add(user);
			init();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage( null, new FacesMessage( "Saved successfully!" ));
		}
	}

	public List<Department> departmentList() {
		List<Department> list = departmentService.list();
		return list;
	}

	public List<Permission> permissionList() {
		List<Permission> list = permissionService.list();
		return list;
	}

	public void addPermissionUser() {
		if (!user.permissionsList().contains(permission)) {
			user.permissionsList().add(permission);
		}
	}
	
	public void removePermissionUser(Permission permission){
		if(user.permissionsList() != null){
			if(!user.permissionsList().isEmpty()){
				user.permissionsList().remove(permission);
				
			}
		}
	}

	public void edit() {
		userService.edit(user);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( "Edited successfully!" ));
	}

	public void delete(User user) {
		userService.delete(user);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage( null, new FacesMessage( "Removed successfully!" ));
	}

	@PostConstruct
	public void init() {
		user = new User();
		user.setPermissions(new ArrayList<Permission>());
		permission = new Permission();

	}

	public void newPermission() {
		permission = new Permission();
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void loadUser(User user) {
		this.user = user;
	}

	public List<User> list() {
		List<User> listUsers = userService.list();

		return listUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

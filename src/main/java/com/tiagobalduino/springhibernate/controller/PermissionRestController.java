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

import com.tiagobalduino.springhibernate.model.Permission;
import com.tiagobalduino.springhibernate.service.PermissionService;

@RestController
public class PermissionRestController {

	@Autowired
	private PermissionService permissionService;

	@RequestMapping("/permissions")
	public List listPermissions() {
		List<Permission> list = permissionService.list();
		return list;
	}

	@RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getPermission(@PathVariable("id") Integer id) {

		List<Permission> find = permissionService.find(id);
		if (find == null) {
			return new ResponseEntity("Nenhuma Permissão encontrada para o ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(find, HttpStatus.OK);
	}

	@RequestMapping(value = "/permissions", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity createPermission(@RequestBody Permission permission) {

		permissionService.add(permission);

		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity deletePermission(@PathVariable Integer id) {

		List<Permission> find = permissionService.find(id);
		if (find == null) {
			return new ResponseEntity("Nenhuma Permissão encontrada para o ID " + id, HttpStatus.NOT_FOUND);
		}

		permissionService.delete(find.get(0));

		return new ResponseEntity(HttpStatus.OK);

	}

	@RequestMapping(value = "/permissions/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity updatePermission(@PathVariable Integer id, @RequestBody Permission permission) {

		List<Permission> find = permissionService.find(id);

		if (null == find) {
			return new ResponseEntity("Nenhuma Permissão encontrada para o ID " + id, HttpStatus.NOT_FOUND);
		}

		permissionService.edit(permission);

		return new ResponseEntity(HttpStatus.OK);
	}

}

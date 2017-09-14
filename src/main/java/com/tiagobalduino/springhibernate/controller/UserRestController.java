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

import com.tiagobalduino.springhibernate.model.Department;
import com.tiagobalduino.springhibernate.model.User;
import com.tiagobalduino.springhibernate.service.DepartmentService;
import com.tiagobalduino.springhibernate.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List listUsers() {
		List<User> list = userService.list();
		return list;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity getUser(@PathVariable("id") Integer id) {

		List<User> find = userService.find(id);
		if (find == null) {
			return new ResponseEntity("Nenhum Usuário encontrado para o ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(find, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity createUser(@RequestBody User user) {

		userService.add(user);

		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity deleteUser(@PathVariable Integer id) {

		List<User> find = userService.find(id);
		if (find == null) {
			return new ResponseEntity("Nenhum Usuário encontrado para o ID " + id, HttpStatus.NOT_FOUND);
		}

		userService.delete(find.get(0));

		return new ResponseEntity(HttpStatus.OK);

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user) {

		List<User> find = userService.find(id);

		if (null == find) {
			return new ResponseEntity("Nenhum Usuário encontrado para o ID " + id, HttpStatus.NOT_FOUND);
		}

		userService.edit(user);

		return new ResponseEntity(HttpStatus.OK);
	}

}

package com.tiagobalduino.springhibernate.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagobalduino.springhibernate.dao.UserDAO;
import com.tiagobalduino.springhibernate.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	 
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
 
    @Override
    @Transactional
    public void add(User user) {
        this.userDAO.addUser(user);;
    }
    
    @Override
    @Transactional
    public void edit(User user) {
        this.userDAO.edit(user);
    }
 
    @Override
    @Transactional
    public List<User> list() {
        return this.userDAO.listUsers();
    }

	@Override
	@Transactional
	public void delete(User user) {
		this.userDAO.delete(user);
		
	}
 
}

package com.tiagobalduino.springhibernate.dao;

import java.util.List;

import com.tiagobalduino.springhibernate.model.User;
 

public interface UserDAO {
 
    public void addUser(User user);
    public List<User> listUsers();
    public void edit(User user);
    public void delete(User user);
    public List<User>find(Integer id);
}
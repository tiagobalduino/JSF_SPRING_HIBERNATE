package com.tiagobalduino.springhibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiagobalduino.springhibernate.model.User;
 
@Service
public interface UserService {
 
    public void add(User user);
    public List<User> list();
    public void edit(User user);
    public void delete(User user);
    public List<User> find(Integer id);
   
}
package com.tiagobalduino.springhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tiagobalduino.springhibernate.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addUser(User p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("User saved successfully, User Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> UserList = session.createQuery("from User").list();
        return UserList;
    }

	@Override
	public void edit(User user) {
		Session session = this.sessionFactory.getCurrentSession();
        session.merge(user);
		
	}

	@Override
	public void delete(User user) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(user);
		
	}
 
}

package com.tiagobalduino.springhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tiagobalduino.springhibernate.model.Permission;

@Repository
public class PermissionDAOImpl implements PermissionDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(PermissionDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addPermission(Permission p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Permission saved successfully, Permission Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Permission> listPermissions() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Permission> permissionList = session.createQuery("from Permission").list();
        return permissionList;
    }

	@Override
	public void edit(Permission permission) {
		Session session = this.sessionFactory.getCurrentSession();
        session.merge(permission);
		
	}

	@Override
	public void delete(Permission permission) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(permission);
		
	}
 
}

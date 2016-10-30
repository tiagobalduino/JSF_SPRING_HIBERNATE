package com.tiagobalduino.springhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tiagobalduino.springhibernate.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addDepartment(Department p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Department saved successfully, Department Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Department> listDepartments() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("from Department").list();
        return departmentList;
    }

	@Override
	public void edit(Department department) {
		Session session = this.sessionFactory.getCurrentSession();
        session.merge(department);
		
	}

	@Override
	public void delete(Department department) {
		Session session = this.sessionFactory.getCurrentSession();
        session.delete(department);
		
	}
 
}

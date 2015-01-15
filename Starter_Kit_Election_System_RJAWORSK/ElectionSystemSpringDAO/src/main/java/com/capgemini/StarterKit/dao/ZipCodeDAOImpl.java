package com.capgemini.StarterKit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.capgemini.StarterKit.model.ZipCode;

public class ZipCodeDAOImpl implements ZipCodeDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(ZipCode p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ZipCode> list() {
		Session session = this.sessionFactory.openSession();
		List<ZipCode> zipCodeList = session.createQuery("from ZipCode").list();
		session.close();
		return zipCodeList;
	}

}

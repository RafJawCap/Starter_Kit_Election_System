package com.capgemini.StarterKit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.capgemini.StarterKit.model.Candidate;

public class CandidateDAOImpl implements CandidateDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Candidate p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidate> list() {
		Session session = this.sessionFactory.openSession();
		List<Candidate> candidateList = session.createQuery("from Candidate").list();
		session.close();
		return candidateList;
	}

}

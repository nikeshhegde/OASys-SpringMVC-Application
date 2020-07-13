package com.project.erp.daoImpl.gstian.examcell;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.erp.dao.gstian.examcell.SubjectAllotmentDao;
import com.project.erp.model.SubjectAllotment;

@Repository
public class SubjectAllotmentDaoImpl implements SubjectAllotmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void add(SubjectAllotment subject) {
		getSession().save(subject);

	}

	public void edit(SubjectAllotment subject) {
		getSession().update(subject);
	}

	public void delete(int subjectId) {
		Session session=getSession();
		session.beginTransaction();
		session.delete(getSubjectAlloted(subjectId));
		session.getTransaction().commit();
		
	}

	public SubjectAllotment getSubjectAlloted(int subjectId) {
		return (SubjectAllotment) getSession().get(SubjectAllotment.class,
				subjectId);
	}

	@SuppressWarnings("unchecked")
	public List<SubjectAllotment> getAllSubjectAlloted() {

		return getSession().createCriteria(SubjectAllotment.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<SubjectAllotment> subjectFetch(String branch, String semester) {
		String hql = "FROM SubjectAllotment s WHERE s.branch = :branch and s.semester = :semester";
		Query query = getSession().createQuery(hql);
		query.setParameter("branch", branch);
		query.setParameter("semester", semester);

		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<SubjectAllotment> subjectFetch(String branch, String semester,
			String year) {
		int yearval = Integer.parseInt(year);
		String hql = "FROM SubjectAllotment s WHERE s.branch = :branch and s.semester = :semester and s.year= :year";
		Query query = getSession().createQuery(hql);
		query.setParameter("branch", branch);
		query.setParameter("semester", semester);
		query.setParameter("year", yearval);
		return query.list();
	}

	private Session getSession() {
		Session sess = sessionFactory.openSession();

		return sess;
	}

}

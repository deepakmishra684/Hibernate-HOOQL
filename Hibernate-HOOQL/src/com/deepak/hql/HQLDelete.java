package com.deepak.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deepak.util.HibernateUtil;
/**
 * @author deepak
 *
 */
public class HQLDelete {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("HQL Query for Delete Record");
		// HQL Query for Delete Record
		String hql = "DELETE FROM Employee " + "WHERE id = :employee_id";
		Query query = session.createQuery(hql);
		query.setParameter("employee_id", 1l);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}
}
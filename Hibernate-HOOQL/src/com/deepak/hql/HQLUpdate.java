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
public class HQLUpdate {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("HQL query for update record");
		// HQL query for update record
		String hql = "UPDATE Employee set salary = :salary WHERE id = :employee_id";
		Query query = session.createQuery(hql);
		query.setParameter("salary", 1000.00);
		query.setParameter("employee_id", 1l);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
	}
}
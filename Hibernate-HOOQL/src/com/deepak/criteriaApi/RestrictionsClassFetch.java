package com.deepak.criteriaApi;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.deepak.model.Employee;
import com.deepak.util.HibernateUtil;

/**
 * @author deepak
 *
 */
public class RestrictionsClassFetch {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/*
		 * We can use same type SimpleExpression are gt,ge,lt,le,eq,ne,
		 * between,like
		 */

		// Restrictions with SimpleExpression Like
		System.out.println("** Like ***");
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("firstName", "Deep%"));
		List list = criteria.list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		/*// Restrictions with SimpleExpression In
		System.out.println("**  in() operator ****");
		Criteria criteria1 = session.createCriteria(Employee.class);
		criteria1.add(Restrictions.in("firstName", new String[]{"Ankit","Sumit"}));
		list = criteria1.list();
		Iterator itr1 = list.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr.next());
		}
*/
		// Restriction with SimpleExpression gt
		System.out.println("**  SimpleExpression gt ****");
		Criteria criteria2 = session.createCriteria(Employee.class);
		criteria2.add(Restrictions.gt("salary", 1000.00));
		list = criteria2.list();
		Iterator itr3 = list.iterator();
		while (itr3.hasNext()) {
			System.out.println(itr3.next());
		}

		// Restrictions with Restrictions Example
		System.out.println("Restrictions with Restrictions Example");
		Criteria criteria3 = session.createCriteria(Employee.class);
		criteria3.setFirstResult(2);
		criteria3.setMaxResults(5);
		list = criteria3.list();
		Iterator itr2 = list.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		session.close();
		System.out.println("Done");
	}
}

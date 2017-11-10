package com.deepak.criteriaApi;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deepak.model.Employee;
import com.deepak.util.HibernateUtil;

/**
 * @author deepak
 *
 */
public class OrderClassFetch {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Restrictions with Order By with asc

		System.out.println("** Order By with asc");
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("salary"));
		List list = criteria.list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Restrictions with Order By with desc

		System.out.println("** Order By with desc");
		Criteria criteria1 = session.createCriteria(Employee.class);
		criteria1.addOrder(Order.desc("salary"));
		List list1 = criteria1.list();
		Iterator itr1 = list1.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}

		session.close();
		System.out.println("Done");
	}
}

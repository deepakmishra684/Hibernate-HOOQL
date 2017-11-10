package com.deepak.criteriaApi;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.deepak.model.Employee;
import com.deepak.util.HibernateUtil;

/**
 * @author deepak
 *
 */
public class ProjectionsClassFetch {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		/**
		 * What is Projection ? You can also use Projections to specify distinct
		 * clauses and aggregate functions like max, sum and so on. It's like
		 * referring to which data you're fetching. Like modifying the select
		 * clause in an SQL query.
		 * 
		 * We can fetch data of a particular column by projection such as name
		 * etc.
		 * 
		 * If you are adding more than one property using set Projection then
		 * only last added projection will consider
		 */

		System.out.println("** Single filed with Criteria ***");
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.property("firstName"));
		criteria.setProjection(Projections.property("lastName"));
		List list = criteria.list();

		for (Iterator itr = list.iterator(); itr.hasNext();) {
			String empName = (String) itr.next();
			System.out.println(empName);

		}

		/**
		 * ===========How to use ProjectionList===========
		 * 
		 * If you are adding more than one property then you have to use
		 * ProjectionList
		 * 
		 */
		System.out.println("** Multiple fields with ProjectionList **");
		Criteria criteria1 = session.createCriteria(Employee.class);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.property("firstName")).add(Projections.property("lastName"));
		criteria1.setProjection(proList);
		List list1 = criteria.list();
		Iterator itr1 = list1.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}
	}
}

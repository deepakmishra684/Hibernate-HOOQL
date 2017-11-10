package com.deepak.criteriaApi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Subqueries;

import com.deepak.model.Address;
import com.deepak.model.Employee;
import com.deepak.util.HibernateUtil;

/**
 * @author deepak
 *
 */
public class DetachedCriteriaClassFetch {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		/**
		 * Detached queries and subqueries
		 * 
		 * The DetachedCriteria class allows you to create a query outside the
		 * scope of a session and then execute it using an arbitrary Session.
		 */

		/**
		 * The Below DetachedCriteria and Criteria condition will generate the
		 * query like that
		 * 
		 * Hibernate: select EMP_ID, FIRST_NAME, LAST_NAME, SALARY from EMPLOYEE
		 * where EMP_ID in (select EMP_ID from ADDRESS)
		 */
		DetachedCriteria detCriteria = DetachedCriteria.forClass(Address.class)
				.setProjection(Property.forName("empId"));

		Criteria criteria = session.createCriteria(Employee.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Subqueries.propertyIn("id", detCriteria));
		List list = criteria.list();
		for (Object object : list) {
			System.out.println(object);
		}

	}
}

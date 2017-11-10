package com.deepak.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deepak.model.Employee;
import com.deepak.util.HibernateUtil;

/**
 * @author deepak
 *
 */
public class HQLFetch {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("***HQL Query to fetch data from database***");
		// HQL Query to fetch data from database
		String hql1 = "from Employee";
		Query query = session.createQuery(hql1);
		List<Employee> allEmp = (List<Employee>) query.list();
		for (Employee emp : allEmp) {
			System.out.println(emp);
		}

		System.out.println("=== HQL Query on condition ===");
		// HQL Query on condition
		String hql2 = "from Employee where id > 5";
		Query query2 = session.createQuery(hql2);
		allEmp = (List<Employee>) query2.list();
		for (Employee emp : allEmp) {
			System.out.println(emp);
		}

		System.out.println("===HQL Query on condition 2===");
		// HQL Query on condition 2
		String hql3 = "from Employee";
		Query query3 = session.createQuery(hql3);
		query3.setFirstResult(2);
		query3.setMaxResults(5);
		allEmp = (List<Employee>) query3.list();
		for (Employee emp : allEmp) {
			System.out.println(emp);
		}
		
		System.out.println("===Select One Particular property===");
		// HQL Query Select One Particular field
		String hql4 = "Select firstName from Employee";
		Query query4 = session.createQuery(hql4);
		List<String> empNameList = (List<String>) query4.list();
		for (String empName : empNameList) {
			System.out.println(empName);
		}

		System.out.println("===Select More than One Particular filed===");
		// HQL Query Select More than One Particular filed
		String hql5 = "Select firstName,lastName from Employee";
		Query query5 = session.createQuery(hql5);
		List<Object[]> objList = (List<Object[]>) query5.list();
		for (Object[] objects : objList) {
			String firstName = (String) objects[0];
			String lastName = (String) objects[1];
		}
		for (Object[] objects : objList) {
			System.out.println(Arrays.toString(objects));
		}

		System.out.println("===HQL Query using named Parameter===");
		// HQL Query using named Parameter
		String hql6 = "FROM Employee E WHERE E.id = :employee_id";
		Query query6 = session.createQuery(hql6);
		query6.setParameter("employee_id", 1);
		List<Employee> results = (List<Employee>)query.list();
		System.out.println(results);

		sessionFactory.close();
		System.out.println(" Done ");
	}

}

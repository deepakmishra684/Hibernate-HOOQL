package com.deepak.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.deepak.model.Address;
import com.deepak.model.Employee;
import com.deepak.util.HibernateUtil;

/**
 * @author deepak
 *
 */
public class HQLInsert {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// Save Employee 1
		Employee emp = new Employee("Deepak", "Mishra", 70000);
		session.save(emp);
		Address address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 2
		emp = new Employee("Ankit", "Singh", 500000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 3
		emp = new Employee("Sumit", "Katiyar", 150000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 4
		emp = new Employee("Rahul", "Mishra", 40000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 5
		emp = new Employee("Deepak", "Singh", 55000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 6
		emp = new Employee("CKK", "Singh", 45000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 7
		emp = new Employee("Manish", "Srivastava", 40000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee 8
		emp = new Employee("Deepak", "Katiyar", 45000);
		session.save(emp);
		address = new Address(emp.getId(), "Lucknow", "UP");
		session.save(address);

		// Save Employee
		/*
		 * HQL supports INSERT INTO clause only where records can be inserted
		 * from one object to another object
		 */
		/*String hql = "INSERT INTO Employee(firstName, lastName, salary)"
				+ "SELECT firstName, lastName, salary FROM old_employee";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
*/
		tx.commit();
		session.close();
		System.out.println("Done");
	}
}

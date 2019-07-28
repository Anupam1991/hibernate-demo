package com.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Student;


public class Test {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	
	
	
	public static void main(String[] args) {
		try {
			final Session session = HibernateUtil.getHibernateSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Student student = new Student();
			student.setFirstName("Anupam");
			student.setLastName("upadhyay");
			session.save(student);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

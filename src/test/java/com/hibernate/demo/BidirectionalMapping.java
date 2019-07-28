package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Address;
import com.hibernate.entity.Student;

// the navigational access from both of the tables are known as bi directional mapping
public class BidirectionalMapping {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	
	public static void main(String[] args) {
		try {
			final Session session = HibernateUtil.getHibernateSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Student student = new Student();
			student.setFirstName("Anuup");
			student.setLastName("Sharma");
			
			Address address = new Address();
			address.setCity("Jaipur");
			address.setState("Rajasthan");
			address.setPincode(302002);
			address.setStudent(student);
			
			student.setAddress(address);
			session.save(student);
			
			// due to cascade property hibernate able to delete parent object
			// session.delete(address);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

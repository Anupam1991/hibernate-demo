package com.hibernate.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Certification;
import com.hibernate.entity.Developer;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Technology;

public class ManyToMany {

	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	
	public static void main(String[] args) {
	try {
		final Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Certification certi1 = new Certification();
		certi1.setCertificationName("JAVA Certification");
		
		Certification certi2 = new Certification();
		certi2.setCertificationName("Hibernate Certification");
		
		Employee e1 = new Employee();
		e1.setFirstName("Anuup");
		e1.setLastName("Sharma");
		Set<Certification> listOfCertification = new HashSet<>();
		listOfCertification.add(certi1);
		listOfCertification.add(certi2);
		e1.setListOfCertification(listOfCertification);
		
		Employee e2 = new Employee();
		e2.setFirstName("Naveen");
		e2.setLastName("Sharma");
		Set<Certification> listOfCertification2 = new HashSet<>();
		listOfCertification2.add(certi1);
		e2.setListOfCertification(listOfCertification2);
		
		Employee e3 = new Employee();
		e3.setFirstName("Suresh");
		e3.setLastName("Sharma");
		Set<Certification> listOfCertification3 = new HashSet<>();
		listOfCertification3.add(certi2);
		e3.setListOfCertification(listOfCertification3);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		
		tx.commit();
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}


}

package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.entity.Developer;
import com.hibernate.entity.Technology;

public class OneToManyUniDirectional {
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	
	public static void main(String[] args) {
		try {
			final Session session = HibernateUtil.getHibernateSession();
			Transaction tx = session.getTransaction();
			tx.begin();
			Technology tech1 = new Technology();
			tech1.setName("JAVA");
			
			Technology tech2 = new Technology();
			tech1.setName("Angualar");
			
			Developer dev1 = new Developer();
			dev1.setFirstName("Anuup");
			dev1.setLastName("Sharma");
			dev1.setTechnology(tech1);
			
			Developer dev2 = new Developer();
			dev2.setFirstName("Rahul");
			dev2.setLastName("Sharma");
			dev2.setTechnology(tech1);
			
			Developer dev3 = new Developer();
			dev3.setFirstName("Rahul");
			dev3.setLastName("Sharma");
			dev3.setTechnology(tech2);
			
			session.save(dev1);
			session.save(dev2);
			session.save(dev3);
			
			// due to cascade property hibernate able to delete parent object
			// session.delete(address);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

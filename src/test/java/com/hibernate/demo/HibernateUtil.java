package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static Session getHibernateSession() {

	    final SessionFactory sf = new Configuration()
	        .configure("hibernate.cfg.xml").buildSessionFactory();

	    final Session session = sf.openSession();
	    return session;
	}
	
//	private static final SessionFactory sessionFactory = buildSessionFactory();
//
//	private static SessionFactory buildSessionFactory() {
//		try {
//			// load from different directory
//			SessionFactory sessionFactory = new Configuration().configure(
//					"hibernate.cfg.xml")
//					.buildSessionFactory();
//
//			return sessionFactory;
//
//		} catch (Throwable ex) {
//			// Make sure you log the exception, as it might be swallowed
//			System.err.println("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public static void shutdown() {
//		// Close caches and connection pools
//		getSessionFactory().close();
//	}

}

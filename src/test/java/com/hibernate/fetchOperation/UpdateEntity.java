package com.hibernate.fetchOperation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.demo.HibernateUtil;
import com.hibernate.entity.Brand;
import com.hibernate.entity.Product;

public class UpdateEntity {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	public static void main(String[] args) {
	try {
		final Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Brand b1 = session.get(Brand.class, 9);
		
		System.out.println(b1.getBrandName());
		System.out.println(b1.getProductList());
		
		Product p1 = session.get(Product.class, 13);
		
		System.out.println(p1.getCategory().getCategoryName());
		System.out.println(p1.getBrand().getBrandName());
		
		p1.setBrand(b1);
		session.update(p1);
		
		
		// due to cascade property hibernate able to delete parent object
		// session.delete(address);
		tx.commit();
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

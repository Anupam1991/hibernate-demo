package com.hibernate.fetchOperation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.demo.HibernateUtil;
import com.hibernate.entity.Product;

public class NativeSqlMappedInEntity {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	public static void main(String[] args) {
	try {
		final Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		//Mapping Native query to Entity
        List<Product> productList = session.createNativeQuery("SELECT * FROM product",Product.class)
              .list();
        for (Product p : productList) {
           Integer id=p.getId();
           String name=p.getProductName();
           System.out.println("Product["+id+","+name+"]");
        }
		
		
		// due to cascade property hibernate able to delete parent object
		// session.delete(address);
		tx.commit();
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}



}

package com.hibernate.fetchOperation;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.demo.HibernateUtil;
import com.hibernate.entity.Brand;
import com.hibernate.entity.Category;
import com.hibernate.entity.Product;

public class PersistProduct {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	public static void main(String[] args) {
	try {
		final Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Category category1 = new Category();
		category1.setCategoryName("Shampoo");
		
		Category category2 = new Category();
		category2.setCategoryName("Soap");
		
		Brand brand1 = new Brand();
		brand1.setBrandName("Dove");
		
		Brand brand2 = new Brand();
		brand2.setBrandName("Himalaya");
		
		// products for dove
		Product p1 = new Product();
		p1.setBrand(brand1);
		p1.setCategory(category1);
		p1.setProductName("Dryness Care Shampoo");
		
		Product p2 = new Product();
		p2.setBrand(brand1);
		p2.setCategory(category1);
		p2.setProductName("Dandruff Care Shampoo");
		
		Product p3 = new Product();
		p3.setBrand(brand1);
		p3.setCategory(category2);
		p3.setProductName("Beauty Soap");
		
		Product p4 = new Product();
		p4.setBrand(brand1);
		p4.setCategory(category2);
		p4.setProductName("Simple Soap");
		
		// end products for dove
		
		Product p5 = new Product();
		p5.setBrand(brand2);
		p5.setCategory(category2);
		p5.setProductName("Neem and Turmeric Soap");
		
		Product p6 = new Product();
		p6.setBrand(brand2);
		p6.setCategory(category2);
		p6.setProductName("Moisturizing Almond Soap");
		
		Product p7 = new Product();
		p7.setBrand(brand2);
		p7.setCategory(category2);
		p7.setProductName("Herbals Cream and Honey Soap");
		
		Product p8 = new Product();
		p8.setBrand(brand2);
		p8.setCategory(category1);
		p8.setProductName("Anti- Hair Fall");
		
		Product p9 = new Product();
		p9.setBrand(brand1);
		p9.setCategory(category1);
		p9.setProductName("Protein Shampoo");
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		session.save(p6);
		session.save(p7);
		session.save(p8);
		session.save(p9);
		
		
		// due to cascade property hibernate able to delete parent object
		// session.delete(address);
		tx.commit();
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

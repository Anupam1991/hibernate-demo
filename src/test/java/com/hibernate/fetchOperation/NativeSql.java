package com.hibernate.fetchOperation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import com.hibernate.demo.HibernateUtil;

@SuppressWarnings("all")
public class NativeSql {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	public static void main(String[] args) {
	try {
		final Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		// Native query selecting all columns
        List<Object[]> products = session.createNativeQuery("SELECT * FROM Product").list();
        for (Object[] objects : products) {
           Integer id=(Integer)objects[0];
           String name=(String)objects[1];
           System.out.println("Product["+id+","+name+"]");
        }
        
      //Native query with JOIN
        System.out.println("--------------------------------------------------------------");
        List<Object[]> productList=session.createNativeQuery(""
              + "select p.product_name as productName, b.brand_name as brandName "
              + "from product p inner join brand b "
              + "on p.brand_id=b.id").list();
        for (Object[] objects : productList) {
           String productName=(String)objects[0];
           String brandName=(String)objects[1];
           System.out.println("Product["+productName+","+brandName+"]");
        }
        
        
      //Native query with JOIN
        System.out.println("--------------------------------------------------------------");
        List<Object[]> productList2=session.createNativeQuery(""
              + "select p.product_name as productName, b.brand_name as brandName,c.category_name as categoryName "
              + "from product p "
              + "inner join brand b on p.brand_id=b.id "
        	  + "inner join category c on p.category_id=c.id ").list();
        for (Object[] objects : productList2) {
           String productName=(String)objects[0];
           String brandName=(String)objects[1];
           String categoryName=(String)objects[2];
           System.out.println("Product["+productName+","+brandName+","+categoryName+"]");
        }
        
        Object product=session.createNativeQuery(""
                + "select p.product_name as productName from product as p where id = 1 ").uniqueResult();
        System.out.println(product);
		
		
		// due to cascade property hibernate able to delete parent object
		// session.delete(address);
		tx.commit();
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

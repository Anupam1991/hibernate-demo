package com.hibernate.fetchOperation;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.hibernate.demo.HibernateUtil;
import com.hibernate.entity.Brand;
import com.hibernate.entity.Product;

@SuppressWarnings("all")
public class CriteriaExample {
	
	static { //runs when the main class is loaded.
	    System.setProperty("org.jboss.logging.provider", "slf4j");
	}
	public static void main(String[] args) {
	try {
		final Session session = HibernateUtil.getHibernateSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		
		// onwards from hibernate 5
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<Product> cr = cb.createQuery(Product.class);
//		Root<Product> root = cr.from(Product.class);
//		cr.select(root);
//		Query<Product> query = session.createQuery(cr);
//		
//		List<Product> results = query.getResultList();
//		System.out.println(results);
		
		// before hibernate 5
//		Criteria criteria = session.createCriteria(Product.class);
//		List<Product> result2 = criteria.list();
//		System.out.println(result2);
		
		
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Product> query = builder.createQuery(Product.class);
//        Root<Product> root = query.from(Product.class);
//        query.select(root).where(builder.equal(root.get("id"), 1));
//        Query<Product> q=session.createQuery(query);
//        Product product=q.getSingleResult();
//        System.out.println(product.getProductName());
		
		
		/*-------------------------------------------------------*/
        
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Product> query = builder.createQuery(Product.class);
//        Root<Product> root = query.from(Product.class);
//        query.select(root).where(builder.equal(root.get("productName"), "Dryness Care Shampoo"));
//        Query<Product> q=session.createQuery(query);
//        Product product=q.getSingleResult();
//        System.out.println(product.getProductName());
		
//		Criteria criteria = session.createCriteria(Product.class);
//		criteria.add(Restrictions.eq("productName", "Dryness Care Shampoo"));
//		Product product = (Product) criteria.uniqueResult();
//		System.out.println(product.getProductName());
		
		/*-------------------------------------------------------*/
		
//		Brand b1 = session.get(Brand.class, 9);
//		
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Product> query = builder.createQuery(Product.class);
//		Root<Product> root = query.from(Product.class);
//		query.select(root).where(builder.equal(root.get("brand"), b1));
//		Query<Product> q=session.createQuery(query);
//		List<Product> product = q.getResultList();
//       	for(Product p : product) {
//       		System.out.println(p.getProductName());
//       	}
//       	
//       	
//       	Criteria criteria = session.createCriteria(Product.class);
//		criteria.add(Restrictions.eq("brand", b1));
//		List<Product> productlist =  criteria.list();
//		for(Product p : productlist) {
//       		System.out.println(p.getProductName());
//       	}
		
		
		
		// due to cascade property hibernate able to delete parent object
		// session.delete(address);
		tx.commit();
		session.close();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}

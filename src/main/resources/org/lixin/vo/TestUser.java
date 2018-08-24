package org.lixin.vo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

public class TestUser {
	/*SessionFactory是单例*/
	private static SessionFactory factory = null;
	static{
		factory = new Configuration().configure().buildSessionFactory();
	}
	public static Session openSession(){
		return factory.openSession();
	}
	@Test
	public void testAdd(){
		Session session = openSession();
		session.beginTransaction();
		User user = new User();
		user.setName("lixin");
		user.setPassword("111111");
		user.setPhone("15080176683");
		session.save(user);
		Assert.assertTrue(user.getId()>0);
		session.getTransaction().commit();
	}
}

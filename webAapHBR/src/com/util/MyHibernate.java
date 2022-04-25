package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernate {

	public static SessionFactory MySessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}
}

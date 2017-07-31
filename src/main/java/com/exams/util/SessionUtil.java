package com.exams.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Logger;

/**
 * Created by sanya on 21.06.2017.
 */
public class SessionUtil {
	private static final SessionUtil instance = new SessionUtil();
	private final SessionFactory factory;
	private static final String PROD_CONFIG_NAME = "hibernate.cfg.xml";
	private static final String TEST_CONFIG_NAME = "test-hibernate.cfg.xml";
	Logger logger = Logger.getLogger(this.getClass().toString());

	private SessionUtil(){
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(PROD_CONFIG_NAME).build();
		//StandardServiceRegistry registry1 = new StandardServiceRegistryBuilder().configure()
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	public static Session getSession(){
		return getInstance().factory.openSession();
	}

	private static SessionUtil getInstance(){
		return instance;
	}
}

package com.exams.util;

import com.exams.dao.factory.DatabaseType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Logger;

/**
 * Created by sanya on 21.06.2017.
 */
public class HibernateUtil {
	private SessionFactory sessionFactory;
	private static final String PROD_CONFIG_NAME = "hibernate.cfg.xml";
	private static final String TEST_CONFIG_NAME = "test-hibernate.cfg.xml";

	public HibernateUtil(DatabaseType databaseType){
		StandardServiceRegistry registry;
		switch (databaseType){
			case PRODUCTION:
				registry = new StandardServiceRegistryBuilder().configure(PROD_CONFIG_NAME).build();
				break;
			case TEST:
				registry = new StandardServiceRegistryBuilder().configure(TEST_CONFIG_NAME).build();
				break;
			default:
				registry = new StandardServiceRegistryBuilder().configure(TEST_CONFIG_NAME).build();
		}
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

package com.loymark.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static SessionFactory sessionFactory;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace(); // This is not the best way to handle exceptions
            }
        }
        return sessionFactory;

    }
}

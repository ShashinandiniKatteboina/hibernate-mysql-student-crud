package com.example.OrderDemo;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	public class Utility {
	    private static SessionFactory sessionFactory;
	    static {
       try {
     sessionFactory = new Configuration()
	                    .configure("hibernate.cfg.xml")
	                    .addAnnotatedClass(Order.class)
	                    .buildSessionFactory();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	}
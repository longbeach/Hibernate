package com.hibernate.persistance;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePersistence {

private static final SessionFactory sessionFactory = buildSessionFactory();

 private static SessionFactory buildSessionFactory() {
        try {
            // Creation de la SessionFactory depuis hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public static void shutdown() {
            // Fermer les caches et pools de connexion
            getSessionFactory().close();
        }
        }
package org.foobarspam.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//
//public final class HibernateUtils {
//
//    private HibernateUtils () {}
//
//    private static StandardServiceRegistry registry;
//    private static MetadataSources sources;
//    private static Metadata metadata;
//    private static SessionFactory sessionFactory;
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            if (metadata == null) {
//                if (sources == null) {
//                    if (registry == null) {
//                        try { // Create registry
//                            registry = new StandardServiceRegistryBuilder()
//                                    .configure()
//                                    .build();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    try { // Create MetadataSources
//                        sources = new MetadataSources(registry);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                try { // Create Metadata: sources puede ser null si salta excepcion en el try anterior
//                    metadata = sources
//                            .getMetadataBuilder()
//                            .build();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//            try { // Create SessionFactory: metadata puede ser null si salta excepcion en el try anterior
//                // Create SessionFactory
//                sessionFactory = metadata
//                        .getSessionFactoryBuilder()
//                        .build();
//
//            } catch (Exception e) {
//                e.printStackTrace();
////            if (registry != null) {
////              StandardServiceRegistryBuilder.destroy(registry);
////            }
//            }
//        }
//        return sessionFactory;
//    }
//}

// Antiguo, para borrar

public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
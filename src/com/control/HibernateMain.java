package com.control;

import com.to.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        try {
            Configuration con = new Configuration().configure();
            con.addAnnotatedClass(com.to.Customer.class);
            StandardServiceRegistryBuilder builder = new
                    StandardServiceRegistryBuilder().applySettings(con.getProperties());
            SessionFactory factory = con.buildSessionFactory(builder.build());
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            Customer c1 = session.get(Customer.class, 1);
            System.out.println("The customer details: " + c1);
            c1.setCustomerName("Mani_A");
            c1.setPoints(6000);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

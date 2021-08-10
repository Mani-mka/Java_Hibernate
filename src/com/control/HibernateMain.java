package com.control;

import com.to.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(com.to.Customer.class);
        StandardServiceRegistryBuilder builder = new
                StandardServiceRegistryBuilder().applySettings(con.getProperties());
        SessionFactory factory = con.buildSessionFactory(builder.build());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer c1 = new Customer(1, "Manish", "Oven", 3000);
        session.save(c1);
        transaction.commit();
        session.close();

    }
}

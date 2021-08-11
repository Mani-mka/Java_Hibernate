package com.control;

import com.to.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

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
//            Customer c1 = new Customer(1, "Manish", "Oven", 3000);
//            Customer c2 = new Customer(2, "Mani", "book", 4000);
//            session.save(c1);
//            session.save(c2);
//            Customer c = session.get(Customer.class, 2);
//            c.setCustomerName("Mani_mka");
//            c.setOrder("Snooker cue");
//            c.setPoints(3500);
//            System.out.println("The customer details: " + c);
//            c1.setCustomerName("Mani_A");
//            c1.setPoints(6000);
            Query query = session.createQuery("from Customer where points>=:threshold order by customerName");
            query.setInteger("threshold", 1000);
            List<Customer> customerList = query.list();
            for(Customer customer:customerList){
                System.out.println(customer);
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

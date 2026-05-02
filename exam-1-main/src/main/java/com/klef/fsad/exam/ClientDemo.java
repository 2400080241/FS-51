package com.klef.fsad.exam;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo
{
    public static void main(String[] args)
    {
        SessionFactory sf =
        new Configuration().configure().buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Insert Record
        Transport t1 = new Transport();
        t1.setId(101);
        t1.setName("Bus");
        t1.setDate("02-05-2026");
        t1.setStatus("Available");
        t1.setType("Public");
        t1.setFare(50.0);

        session.save(t1);

        Transport t2 = new Transport();
        t2.setId(102);
        t2.setName("Train");
        t2.setDate("02-05-2026");
        t2.setStatus("Running");
        t2.setType("Railway");
        t2.setFare(120.0);

        session.save(t2);

        tx.commit();

        // View All Records using HQL
        session = sf.openSession();

        Query<Transport> q =
        session.createQuery("from Transport", Transport.class);

        List<Transport> list = q.list();

        for(Transport t : list)
        {
            System.out.println(
            t.getId()+" "
            +t.getName()+" "
            +t.getDate()+" "
            +t.getStatus()+" "
            +t.getType()+" "
            +t.getFare());
        }

        session.close();
        sf.close();
    }
}
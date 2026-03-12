package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo
{
 public static void main(String[] args)
 {
  Configuration cfg = new Configuration();
  cfg.configure();

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();
  Transaction tx = session.beginTransaction();

  Restaurant r = new Restaurant();

  r.setId(101);
  r.setName("Spicy Hub");
  r.setDate("12-03-2026");
  r.setStatus("Open");
  r.setLocation("Hyderabad");
  r.setRating(4.5);

  session.save(r);

  String hql = "update Restaurant set name=:n,status=:s where id=:i";

  Query query = session.createQuery(hql);

  query.setParameter("n", "Food Palace");
  query.setParameter("s", "Closed");
  query.setParameter("i", 101);

  int result = query.executeUpdate();

  System.out.println("Rows Updated : " + result);

  tx.commit();

  session.close();
  sf.close();
 }
}

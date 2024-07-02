package com.shova.controller;

import com.shova.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateUserTable {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        User uone = new User();
        t.commit();
        System.out.println("successfully created user table");
        sessionFactory.close();
        session.close();
    }
}

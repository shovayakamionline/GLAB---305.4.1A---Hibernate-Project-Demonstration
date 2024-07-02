package com.shova.controller;

import com.shova.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class FindUser_Hql {
    public void findUser(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM User";  //example of HQL to ger all records for user class
        TypedQuery query = session.createQuery(hql);
        List<User> results = query.getResultList();
        for (User user : results) {
            System.out.println("User Id: " + user.getId() + " | " + "Full name: " +
                    user.getFullname()+ " | " + "Email: " + user.getEmail() + " | " + "password: " + user.getPassword());
        }
    }
    public void findUserSelect() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session session = f.openSession();
        String hql = "SELECT u FROM User u";
        Query query = session.createQuery(hql);
        List<User> list = query.getResultList();
        for (User user : list){
            System.out.println("User Id: " + user.getId() + " | " + "Full name: " +
                    user.getFullname()+ " | " + "Email: " + user.getEmail() + " | " + "password: " + user.getPassword());
        }
    }
    public void getRecordById() {
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session session = f.openSession();
        String hql = "FROM User E WHERE E.id > 2 ORDER BY E.salary DESC";
        TypedQuery query = session.createQuery(hql);
        List<User> results = query.getResultList();
        for (User user : results){
            System.out.println("User Id: " + user.getId() + " | " + "Full name: " +
                    user.getFullname()+ " | " + "Email: " + user.getEmail() + " | " + "password: " + user.getPassword());
        }
    }
    public void getRecords() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery<Object[]> query = session.createQuery(
                "SELECT U.salary, U.fullname FROM User AS U", Object[].class);
        List<Object[]> values = query.getResultList();
        for (Object[] a : values) {
            System.out.println("Salary: " + a[0] + ", City: " + a[1]);
        }
    }
    public void  getMaxSalary() {
        SessionFactory factory = new   Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "SELECT COUNT(*) FROM User U";
        List results = session.createQuery(hql).getResultList();
        System.out.println(results);
       /* String hql = "SELECT max(U.salary) FROM User AS U";
        TypedQuery query = session.createQuery(hql);
        double value =(double) query.getSingleResult();*/
//        System.out.println(value);
        System.out.println(results);
    }

    public void   getMaxSalaryGroupBy() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "SELECT SUM(U.salary), U.city FROM User AS U GROUP BY U.city";
        TypedQuery query = session.createQuery(hql);
        List<Object[]> result =query.getResultList();
        for (Object[] obj : result) {
            System.out.println("Total salary " +obj[0] +" | city: "+ obj[1] );
        }
    }
    public void NamedQueryExample() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM User AS u WHERE u.id = :id";
        TypedQuery query = session.createQuery(hql);
        query.setParameter("id", 2);
        List<User> result = query.getResultList();
        for (User user : result) {
            System.out.println("User Id: " + user.getId() + " | " + " Full name: " + user.getFullname() + " | " + "Email: " + user.getEmail() + " | " + "password" + user.getPassword());
        }
    }
}

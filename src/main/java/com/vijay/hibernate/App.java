package com.vijay.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vijay.hibernate.entity.Student;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.config.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			/*System.out.println("Creating new student object");
			Student s1 = new Student("vijay", "moganti", "vijaymoganti@gmail.com");
			session.beginTransaction();
			session.save(s1);
			session.getTransaction().commit();
			System.out.println(s1.getEmail());
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student s2 = new Student();
			s2 = (Student) session.get(Student.class, s1.getId());
			System.out.println(s2);
			session.getTransaction().commit();*/
			/*session.beginTransaction();
			List<Student> list = session.createQuery("from Student").list();
			displayMethod(list);
			List<Student> list1 = session.createQuery("from Student s where s.email"+ " LIKE'%hotmail.com'").list();
			displayMethod(list1);
			session.getTransaction().commit();*/
			session.beginTransaction();
			//session.createQuery("update Student set lastName='kiran'").executeUpdate();
			session.createQuery("delete Student where id=3").executeUpdate();
			session.getTransaction().commit();
			

		} finally {
			factory.close();
		}

	}

	private static void displayMethod(List<Student> list) {
		for(Student studentList : list){
			System.out.println(studentList);
		}
	}
}

package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student tempStudent = new Student("Deepak", "Yadav", "deepak@spring.com");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			// New Code to Read
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nReading student with Id: "+ tempStudent.getId());
			
			System.out.println("\nStudent: "+ session.get(Student.class, tempStudent.getId()));
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			session.close();
		}
	}

}

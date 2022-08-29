package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int studentId = 1;
			
			System.out.println("Student Id: "+studentId);
			
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("Student: "+ theStudent);
			
			System.out.println("Updating Student...");
			
			theStudent.setFirstName("Scooby");			
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Student after updating: "+ session.get(Student.class, studentId));
			
			// New Code
			
			System.out.println("\nUpdating email of all Students: ");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			session.close();
		}
	}

}

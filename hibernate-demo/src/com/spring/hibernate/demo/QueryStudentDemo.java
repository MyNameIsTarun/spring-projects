package com.spring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			// Query all Students
			System.out.println("Quering All Students: ");
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();			
			theStudents.forEach(System.out :: println);
			
			/* --------------------------------------------------------------------- */
			
			System.out.println("\nStudent having last name of Yadav: ");
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Yadav'")
					.getResultList();
			theStudents.forEach(student -> System.out.println(student));
			
			/* --------------------------------------------------------------------- */
			
			System.out.println("\nStudent having last name of Doe OR first name Larry: ");
			
			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'"
					+ " OR s.firstName = 'Larry'").getResultList();
			theStudents.forEach(student -> System.out.println(student));
			
			/* --------------------------------------------------------------------- */
			
			System.out.println("\nStudent having email LIKE '@spring.com': ");
			
			theStudents = session.createQuery("from Student where email "
					+ "LIKE '%@spring.com'").getResultList();
			theStudents.forEach(System.out :: println);
			
			/* --------------------------------------------------------------------- */
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			session.close();
		}
	}

}

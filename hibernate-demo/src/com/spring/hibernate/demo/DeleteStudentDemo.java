package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int studentId = 1;
			
//			System.out.println("Student Id: "+studentId);
			
//			Student theStudent = session.get(Student.class, studentId);
//			
//			System.out.println("Deleting student...");
//			
//			session.delete(theStudent);
			
			// Another approach to delete student
			
			System.out.println("Deleting student with id 4: ");
			
			session.createQuery("delete from Student where id = 4").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}finally {
			session.close();
		}
	}

}

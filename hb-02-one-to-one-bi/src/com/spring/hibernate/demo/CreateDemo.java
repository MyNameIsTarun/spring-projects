package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
//			Instructor tempInstructor = new Instructor("Tarun", "Kanade", "tarun@gamil.com");
//			
//			InstructorDetail tempInstructorDetail = new InstructorDetail(
//					"https://example.com/", "Coding");
			
			Instructor tempInstructor = new Instructor("Mandar", "Mandlik", "mandar@gamil.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"https://example.com/", "Treating Patient");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			session.close();
		}
	}

}

package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			InstructorDetail theInstructorDetail = session.get(InstructorDetail.class, 3);
			
			System.out.println(theInstructorDetail);
			
			System.out.println("\nAssociated Instructor: "+ theInstructorDetail.getInstructor());
			
			System.out.println("\nDeleting Instructor detail: ");
			
			// break bi-directional link first
			theInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(theInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}

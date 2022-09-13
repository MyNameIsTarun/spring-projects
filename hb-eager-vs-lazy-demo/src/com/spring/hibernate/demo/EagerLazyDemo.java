package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Instructor tempInstructor = session.get(Instructor.class, 1);
			
			System.out.println("Instructor: "+tempInstructor);
			
			System.out.println("Courses: \n");
			
			for(Course course: tempInstructor.getCourses()) {
				System.out.println(course.getTitle());
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}

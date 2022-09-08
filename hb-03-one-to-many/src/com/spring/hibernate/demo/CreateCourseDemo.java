package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class CreateCourseDemo {

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
			
			Course course1 = new Course("Mathematics");
			Course course2 = new Course("Data Structures & Algorithms");
			Course course3 = new Course("Physics");
			
			tempInstructor.addCourse(course1);
			tempInstructor.addCourse(course2);
			tempInstructor.addCourse(course3);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}

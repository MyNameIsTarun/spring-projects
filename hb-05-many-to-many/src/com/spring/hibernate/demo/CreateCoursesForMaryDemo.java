package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;
import com.spring.hibernate.demo.entity.Student;

public class CreateCoursesForMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student mary = (Student) session.createQuery("from Student where firstName = 'Mary'")
								.getSingleResult();
			
			
			Course c1 = new Course("Data Structures & Algorithms");
			Course c2 = new Course("Spring boot");
			
			c1.addStudent(mary);
			c2.addStudent(mary);
			
			System.out.println("\nSaving Courses...");
			session.save(c1);
			session.save(c2);
			System.out.println("Courses saved.\n");
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}

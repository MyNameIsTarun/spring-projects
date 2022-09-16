package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;
import com.spring.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			Course tempCourse = new Course("Java: How to create Hello World");
			
			System.out.println("\nSaving Course...");
			session.save(tempCourse);
			System.out.println("Course saved.");
			
			Student tempStudent1 = new Student("Deepak", "Doe", "Deepak@spring.com");
			Student tempStudent2 = new Student("Dev", "Public", "Dev@spring.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			System.out.println("\nSaving Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Students saved.");
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			session.close();
			
			factory.close();
		}
	}

}

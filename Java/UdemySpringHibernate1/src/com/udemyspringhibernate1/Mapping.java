package com.udemyspringhibernate1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemyspringhibernate1.entity.Course;
import com.udemyspringhibernate1.entity.Instructor;
import com.udemyspringhibernate1.entity.InstructorDetail;

public class Mapping {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		//oneToOneAdd(sessionFactory);
		//oneToOneFetch(sessionFactory);
		//oneToOneDelete(sessionFactory);
		//oneToOneFetch2(sessionFactory);
		oneToManyAdd(sessionFactory);
	}
	
	public static void oneToOneAdd(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Instructor instructor = new Instructor("firstname2","lastname2","email2");
			InstructorDetail instructorDetail = new InstructorDetail("youtubechannel2","hobby2");
			
			instructor.setInstructorDetail(instructorDetail);
			
			System.out.println(instructor);
			System.out.println(instructorDetail);
			
			session.beginTransaction();
			session.save(instructorDetail);
			session.save(instructor);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void oneToOneFetch(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Instructor> instructors = 
					session.createQuery("from instructor").getResultList();
			
			Instructor instructor = instructors.get(0);
			
			System.out.println(instructor);
			System.out.println(instructor.getInstructorDetail());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void oneToOneFetch2(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class,3);
			
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void oneToOneDelete(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 2);
			
			session.delete(instructor);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void oneToManyAdd(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Instructor instructor = 
					new Instructor("Muhammed Emin","Tetik","metetik@gmail.com");
			InstructorDetail instructorDetail = 
					new InstructorDetail("youtube.com/metetik","bicycle");		
			instructor.setInstructorDetail(instructorDetail);
			
			Course course1 = new Course("Spring - Hibernate");
			Course course2 = new Course("Basic Python");
			Course course3 = new Course("Django");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			instructor.addCourse(course3);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
}

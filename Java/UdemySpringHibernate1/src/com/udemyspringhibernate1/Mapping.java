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
			//session.save(instructor);
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

			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Course course1 = new Course("Java-Basic");
			Course course2 = new Course("Java-Spring");
			Course course3 = new Course("Python-Basic");
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			instructor.addCourse(course3);
			
			System.out.println(course1.getInstructor().getId());
			session.save(course1);
			session.save(course2);
			session.save(course3);
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

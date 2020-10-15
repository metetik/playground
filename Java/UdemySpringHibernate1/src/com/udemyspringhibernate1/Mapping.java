package com.udemyspringhibernate1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemyspringhibernate1.entity.Course;
import com.udemyspringhibernate1.entity.Instructor;
import com.udemyspringhibernate1.entity.InstructorDetail;
import com.udemyspringhibernate1.entity.Review;
import com.udemyspringhibernate1.entity.Student;

public class Mapping {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//oneToOneAdd(sessionFactory);
		//oneToOneFetch(sessionFactory);
		//oneToOneDelete(sessionFactory);
		//oneToOneFetch2(sessionFactory);
		//oneToManyAdd(sessionFactory);
		//oneToManyFetch(sessionFactory);
		//oneToManyDelete(sessionFactory);
		//oneToManyUniAdd(sessionFactory);
		//oneToManyUniFetch(sessionFactory);
		//oneToManyUniDelete(sessionFactory);
		//manyToManyAdd(sessionFactory);
		//manyToManyFetch(sessionFactory);
		//manyToManyManyDelete(sessionFactory);
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
			Course course1 = new Course("Java-Basic");
			Course course2 = new Course("Java-Spring");
			Course course3 = new Course("Python-Basic");
			
			instructor.setInstructorDetail(instructorDetail);
			
			instructor.addCourse(course1);
			instructor.addCourse(course2);
			instructor.addCourse(course3);
			
			session.beginTransaction();
			session.save(instructor);
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
	public static void oneToManyFetch(SessionFactory sessionFactory){
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			
			System.out.println("Instructor : "
							+ instructor.toString());
			System.out.println("Instructor Detail : "
							+ instructor.getInstructorDetail().toString());
			System.out.println("Courses : ");
			
			for(Course course : instructor.getCourses()) {
				System.out.println("\t"+course.toString());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public static void oneToManyDelete(SessionFactory sessionFactory){
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 2);
			session.delete(course);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public static void oneToManyUniAdd(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = new Course("Pacman - How to Score Million Points");
			
			course.addReview(new Review("Great Course"));
			course.addReview(new Review("Good Course"));
			course.addReview(new Review("I like it.."));
			
			session.save(course);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void oneToManyUniFetch(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 4);
			
			System.out.println("Course : " + course.toString());
			
			System.out.println("Reviews : ");
			
			for(Review review : course.getReviews()) {
				System.out.println("\t"+review.toString());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void oneToManyUniDelete(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 4);
			
			session.delete(course);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void manyToManyAdd(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			Course course1 = new Course("Course 3");
			Course course2 = new Course("Course 4");
			
			course1.addStudent(student);
			course2.addStudent(student);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public static void manyToManyFetch(SessionFactory sessionFactory){
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			
			System.out.println("Student : "
							+ student.toString());

			System.out.println("Courses : ");
			
			for(Course course : student.getCourses()) {
				System.out.println("\t"+course.toString());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	public static void manyToManyManyDelete(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			/*
			session.beginTransaction();
			
			Course course = session.get(Course.class, 6);
			
			session.delete(course);
			
			session.getTransaction().commit();
			*/
			session.beginTransaction();
			
			Student student = session.get(Student.class, 1);
			
			session.delete(student);
			
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

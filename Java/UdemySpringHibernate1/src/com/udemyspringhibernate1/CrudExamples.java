package com.udemyspringhibernate1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemyspringhibernate1.entity.Student;

public class CrudExamples {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();

		//addStudent(sessionFactory);
		
		//readStudent(sessionFactory, 4);
		
		//queryStudent(sessionFactory, "from Student s where last_name='E3'");
		
		//updateStudent(sessionFactory);
	}

	public static void addStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("muhammed","tetik","m.e.tetik03@gmail.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void readStudent(SessionFactory sessionFactory,int studentId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, studentId);
			
			session.getTransaction().commit();
			
			System.out.println(student.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void queryStudent(SessionFactory sessionFactory,String query) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			List<Student> students = session.createQuery(query).getResultList();
					
			session.getTransaction().commit();

			for (Student student : students) {
				System.out.println(student.toString());	
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateStudent(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			
			student.setFirstName("Çavuş");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		readStudent(sessionFactory, 2);
	}
}
package javaee.dao;

import java.util.List;

import org.hibernate.Session;

import javaee.model.Student;
import javaee.util.HibernateUtil;

/**
 * Student Data Access Object
 * @author Ali Bassam
 *
 */
public class StudentDAO {

	/**
	 * Retrieves all students
	 * @return
	 */
	public static List<Student> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		session.getTransaction().commit();
		session.close();
		return students;
	}
}

package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Course;

@Repository 
public class ClientRepository {
	
	public Course addCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(course);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.err.println("Error  addCourse. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }

        return course;
    }
	 public Course getCourse(String code) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Course course = null;

	        try {
	            course = session.get(Course.class, code);
	            Hibernate.initialize(course.getCourseSessions());

	        } catch (HibernateException hibernateException) {
	            System.err.println("Error getCourse. " + hibernateException);
	        } finally {
	            if (session != null) {
	                try {
	                    session.close();
	                } catch (HibernateException hibernateException) {
	                    System.err.println("Error closing hibernate session. " + hibernateException);
	                }
	            }
	        }

	        return course;
	    }
	
	public Course updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(course);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.err.println("Error updateCourse. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }

        return course;
    }

    public void deleteCourse(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Course course = session.get(Course.class, code);
            assert course != null;
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.err.println("Error deleteCourse. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
	public List<Course> getAllCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> courses = new ArrayList<>();

        try {
            Query<Course> query = session.createQuery("from Course");
            courses = query.list();
        } catch (HibernateException hibernateException) {
            System.err.println("Error getAllCourses. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }

        return courses;
    }
	
	

}

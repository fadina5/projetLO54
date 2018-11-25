package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.CourseSession;

@Repository
public class CourseSessionRepository {

	public CourseSession addCourseSession(CourseSession courseSession) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(courseSession);
			session.getTransaction().commit();
		} catch (HibernateException hibernateException) {
			System.err.println("Error addCourseSession. " + hibernateException);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					System.err.println("Error closing hibernate session. " + he);
				}
			}
		}

		return courseSession;
	}

	/*public CourseSession getCourseSession(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CourseSession courseSession = null;

		try {
			courseSession = session.get(CourseSession.class, id);
			Hibernate.initialize(courseSession.getClients());
		} catch (HibernateException hibernateException) {
			System.err.println("Error readCourseSession. " + hibernateException);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException hibernateException) {
					System.err.println("Error closing hibernate session. " + hibernateException);
				}
			}
		}

		return courseSession;
	}*/

	public CourseSession updateCourseSession(CourseSession courseSession) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.merge(courseSession);
			session.getTransaction().commit();
		} catch (HibernateException hibernateException) {
			System.err.println("Error updateCourseSession. " + hibernateException);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException hibernateException) {
					System.err.println("Error closing hibernate session. " + hibernateException);
				}
			}
		}

		return courseSession;
	}

	public void deleteCourseSession(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			CourseSession courseSession = session.get(CourseSession.class, id);
			assert courseSession != null;
			session.beginTransaction();
			session.delete(courseSession);
			session.getTransaction().commit();
		} catch (HibernateException hibernateException) {
			System.err.println("Error deleteCourseSession. " + hibernateException);
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
	public List<CourseSession> getAllCourseSessions() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CourseSession> courseSessions = new ArrayList<>();

		try {
			Query<CourseSession> query = session.createQuery("FROM COURSE_SESSION");
			courseSessions = query.list();

		} catch (HibernateException hibernateException) {
			System.err.println("Error getAllCourseSessions. " + hibernateException);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException hibernateException) {
					System.err.println("Error closing hibernate session. " + hibernateException);
				}
			}
		}

		return courseSessions;
	}
}

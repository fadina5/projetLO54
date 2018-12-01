package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.config.Util;
import fr.utbm.gestion.ecole.entity.CourseSession;

@Repository
public class CourseSessionRepository {

	public CourseSession addCourseSession(CourseSession courseSession) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(courseSession);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}

			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
		}

		return courseSession;
	}

	public CourseSession findCourseSession(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		CourseSession courseSession = new CourseSession();

		try {
			courseSession = session.get(CourseSession.class, id);

		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}

			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
		}

		return courseSession;
	}

	public CourseSession updateCourseSession(CourseSession courseSession) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.merge(courseSession);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}

			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
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
		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}

			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<CourseSession> findAllCourseSessions() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CourseSession> courseSessions = new ArrayList<>();

		try {
			Query<CourseSession> query = session.createQuery("from CourseSession");
			courseSessions = query.list();
			// define percentage
			courseSessions.forEach(courseSession -> courseSession.setClientPercentage(
					Util.getIntegerPercent(courseSession.getClients().size(), courseSession.getMax())));

		} catch (HibernateException he) {
			he.printStackTrace();
			if (session.getTransaction() != null) {
				try {
					session.getTransaction().rollback();
				} catch (HibernateException he2) {
					he2.printStackTrace();
				}

			}
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (HibernateException he) {
					he.printStackTrace();
				}
			}
		}

		return courseSessions;
	}
}

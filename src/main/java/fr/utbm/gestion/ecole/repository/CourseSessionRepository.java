package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.tools.HibernateUtil;
import fr.utbm.gestion.ecole.tools.Util;

@Repository
public class CourseSessionRepository {

	public CourseSession saveCourseSession(CourseSession courseSession) {

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
			Hibernate.initialize(courseSession.getClients());
			courseSession.setClientPercentage(Util.getIntegerToPercent(courseSession.getClients().size(), courseSession.getMax()));

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
			courseSessions.forEach(courseSession -> courseSession.setClientPercentage(
					Util.getIntegerToPercent(courseSession.getClients().size(), courseSession.getMax())));

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

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<CourseSession> findCourseSessions(String titre, Date date, Integer idlocation) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<CourseSession> courseSessions = new ArrayList<>();

		try {

			Criteria criteria = session.createCriteria(CourseSession.class);

			if (date != null) {
				criteria.add(Restrictions.between("startDate", date, date));
			}
			if (idlocation != null) {
				criteria.add(Restrictions.eq("location.id", idlocation));
			}
			if (titre != null) {
				criteria.createCriteria("course").add(Restrictions.ilike("titre", "%" + titre + "%"));
			}
			courseSessions = criteria.list();
			courseSessions.forEach(courseSession -> courseSession.setClientPercentage(
					Util.getIntegerToPercent(courseSession.getClients().size(), courseSession.getMax())));
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

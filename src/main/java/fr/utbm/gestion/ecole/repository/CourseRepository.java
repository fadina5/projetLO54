package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;
import fr.utbm.gestion.ecole.config.Util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Course;

@Repository
public class CourseRepository {

	public Course addCourse(Course course) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(course);
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

		return course;
	}

	public Course findCourse(String code) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Course course = new Course();
		try {
			course = session.get(Course.class, code);
			
			// define percentage
			course.getCourseSessions().forEach(courseSession -> courseSession.setClientPercentage(
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
		return course;
	}

	public Course updateCourse(Course course) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.merge(course);
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
	public List<Course> findAllCourses() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Course> courses = new ArrayList<>();

		try {
			Query<Course> query = session.createQuery("from Course");
			courses = query.list();
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

		return courses;
	}

}

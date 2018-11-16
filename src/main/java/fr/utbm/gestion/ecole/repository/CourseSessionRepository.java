package fr.utbm.gestion.ecole.repository;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Course;
import fr.utbm.gestion.ecole.entity.CourseSession;

@Repository
public class CourseSessionRepository {
	public void addCourseSession(){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	
	    session.beginTransaction();
	    //Rechercher un enregistrement
	   CourseSession courseSession = new CourseSession(1234,new Date(),new Date(),1000);
	   //Course course = new Course("LO54","Programmation");
	   //courseSession.setCourse(course);
	    session.save(courseSession);
	    session.getTransaction().commit();       
	}
}

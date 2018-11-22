package fr.utbm.gestion.ecole.repository;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Course;
import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.entity.Location;

@Repository
public class CourseSessionRepository {
	public void addCourseSession(){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	
	    session.beginTransaction();
	    //Rechercher un enregistrement
	    Location location =new Location("Belfort");
	    Course course = new Course("LO54","Programmation");
	    CourseSession courseSession = new CourseSession(course,location,new Date(),new Date(),1000);
	    session.save(courseSession);
	    session.getTransaction().commit();       
	}
}

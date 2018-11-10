package fr.utbm.gestion.ecole.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Course;

@Repository
public class CourseRepository {
	
	
	public void addCourse(){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	
	    session.beginTransaction();
	    //Rechercher un enregistrement
	   Course course = new Course("LO54","Programmation");
	   
	    session.save(course);
	    session.getTransaction().commit();       
	}
}

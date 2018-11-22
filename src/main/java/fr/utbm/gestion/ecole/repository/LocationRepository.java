package fr.utbm.gestion.ecole.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Location;

@Repository
public class LocationRepository {
	public void addLocation(){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	
	    session.beginTransaction();
	    //Rechercher un enregistrement
	   Location location =new Location("Belfort");
	   
	    session.save(location);
	    session.getTransaction().commit();       
	}
}

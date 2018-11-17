package fr.utbm.gestion.ecole.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Client;

@Repository 
public class ClientRepository {
	public void addClient(){

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	
	    session.beginTransaction();
	    //Rechercher un enregistrement
	   Client client=new Client(1,"PrenomTest","NomTest","AdresseTest","+34567878","maitTest");
	   
	    session.save(client);
	    session.getTransaction().commit();       
	}

}

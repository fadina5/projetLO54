package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Client;

@Repository 
public class ClientRepository {
	
	 public Client addClient(Client client) {
	        
		 Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            session.beginTransaction();
	            session.persist(client);
	            session.getTransaction().commit();
	        } catch (HibernateException hibernateException) {
	            System.err.println("Error addClient " + hibernateException);
	        } finally {
	            if (session != null) {
	                try {
	                    session.close();
	                } catch (HibernateException hibernateException) {
	                    System.err.println("Error closing hibernate session. " + hibernateException);
	                }
	            }
	        }

	        return client;
	    }

	    public Client getClient(Integer id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Client client=new Client();

	        try {
	            client = session.get(Client.class, id);
	        } catch (HibernateException hibernateException) {
	            System.err.println("Error getClient. " + hibernateException);
	        } finally {
	            if (session != null) {
	                try {
	                    session.close();
	                } catch (HibernateException hibernateException) {
	                    System.err.println("Error closing hibernate session. " + hibernateException);
	                }
	            }
	        }

	        return client;
	    }

	    public Client updateCustomer(Client client) {
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            session.beginTransaction();
	            session.merge(client);
	            session.getTransaction().commit();
	        } catch (HibernateException hibernateException) {
	            System.err.println("Error updateClient " + hibernateException);
	        } finally {
	            if (session != null) {
	                try {
	                    session.close();
	                } catch (HibernateException hibernateException) {
	                    System.err.println("Error closing hibernate session. " + hibernateException);
	                }
	            }
	        }

	        return client;
	    }

	    public void deleteClient(Integer id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();

	        try {
	            Client client = session.get(Client.class, id);
	            assert client != null;
	            session.beginTransaction();
	            session.delete(client);
	            session.getTransaction().commit();
	        } catch (HibernateException hibernateException) {
	            System.err.println("Error deleteClient " + hibernateException);
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
	    public List<Client> getAllClients() {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        List<Client> clients = new ArrayList<>();

	        try {
	            Query<Client> query = session.createQuery("FROM CLIENT");
	            clients = query.list();
	        } catch (HibernateException hibernateException) {
	            System.err.println("Error getAllClient. " + hibernateException);
	        } finally {
	            if (session != null) {
	                try {
	                    session.close();
	                } catch (HibernateException hibernateException) {
	                    System.err.println("Error closing hibernate session. " + hibernateException);
	                }
	            }
	        }

	        return clients;
	    }
	
}

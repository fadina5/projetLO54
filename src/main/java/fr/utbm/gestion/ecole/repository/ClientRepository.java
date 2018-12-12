package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.tools.HibernateUtil;

@Repository
public class ClientRepository {

	public Client saveClient(Client client) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(client);
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

		return client;
	}

	public Client findClient(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Client client = new Client();

		try {
			client = session.get(Client.class, id);
			
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

		return client;
	}

	public Client updateClient(Client client) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.merge(client);
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
	public List<Client> findAllClients() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Client> clients = new ArrayList<>();

		try {
			Query<Client> query = session.createQuery("from Client");
			clients = query.list();
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

		return clients;
	}

}

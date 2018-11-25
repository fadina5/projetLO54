package fr.utbm.gestion.ecole.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.utbm.gestion.ecole.config.HibernateUtil;
import fr.utbm.gestion.ecole.entity.Location;

@Repository
public class LocationRepository {
	
	public Location addLocation(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(location);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.err.println("Error createLocation. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }

        return location;
    }

    public Location getLocation(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location location = new Location();

        try {
            location = session.get(Location.class, id);
        } catch (HibernateException hibernateException) {
            System.err.println("Error readLocation. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }

        return location;
    }

    public Location updateLocation(Location location) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(location);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.err.println("Error updateLocation. " + hibernateException);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException hibernateException) {
                    System.err.println("Error closing hibernate session. " + hibernateException);
                }
            }
        }

        return location;
    }

    public void deleteLocation(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Location location = session.get(Location.class, id);
            assert location != null;
            session.beginTransaction();
            session.delete(location);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            System.err.println("Error deleteLocation. " + hibernateException);
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
    public List<Location> getAllLocations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Location> locations = new ArrayList<>();

        try {
            Query<Location> query = session.createQuery("FROM LOCATION");
            locations = query.list();
        } catch (HibernateException he) {
            System.err.println("Error getAllLocations. " + he);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    System.err.println("Error closing hibernate session. " + he);
                }
            }
        }

        return locations;
    }
}

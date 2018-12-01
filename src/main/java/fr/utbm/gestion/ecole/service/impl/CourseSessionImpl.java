package fr.utbm.gestion.ecole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.gestion.ecole.config.Util;
import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.repository.ClientRepository;
import fr.utbm.gestion.ecole.repository.CourseSessionRepository;
import fr.utbm.gestion.ecole.service.CourseSessionService;

@Service
public class CourseSessionImpl implements CourseSessionService {

	@Autowired
	private CourseSessionRepository courseSessionRepository;
	@Autowired
	private ClientRepository clientRepository;

	public void addCourseSession(CourseSession courseSession) {
		courseSession = courseSessionRepository.addCourseSession(courseSession);
		System.out.println("la session de cours créé est: " + courseSession.toString());
	}

	public CourseSession getCourseSession(Integer id) {
		CourseSession courseSession = courseSessionRepository.findCourseSession(id);
		System.out.println("la session de cours correspondant à " + id + "est:" + courseSession.toString());
		return courseSession;
	}

	public void updateCourseSession(CourseSession courseSession) {
		courseSession = courseSessionRepository.updateCourseSession(courseSession);
		System.out.println("la mise à jour de la session de cours: " + courseSession.toString());
	}

	public void deleteCourseSession(Integer id) {
		courseSessionRepository.deleteCourseSession(id);
		System.out.println("la session de cours avec pour" + id + "a été supprimé");
	}

	public List<CourseSession> getAllCoursesSessions() {
		List<CourseSession> coursesSession = courseSessionRepository.findAllCourseSessions();
		System.out.println("la liste des session des cours: " + coursesSession.toString());
		return coursesSession;
	}

	public void registerClent(String courseSessionId, Client client) throws Exception {
		// Parse parameter(s)
		Integer id = Util.convertStringToInteger(courseSessionId);

		// Read course session from id
		CourseSession courseSession = courseSessionRepository.findCourseSession(id);

		// Check if course session not full
		if (courseSession.getClients().size() == courseSession.getMax()) {
			throw new Exception("La session de cours est pleine");
		}

		// Set course session and create a customer
		client.setCourseSession(courseSession);
		clientRepository.addClient(client);

		// Add customer to list of customers
		courseSession.getClients().add(client);
		courseSessionRepository.updateCourseSession(courseSession);
		System.out.println("Le client enregistré est: " + client.toString());
	}

}

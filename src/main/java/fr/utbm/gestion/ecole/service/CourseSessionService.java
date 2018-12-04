package fr.utbm.gestion.ecole.service;

import java.util.Date;
import java.util.List;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.entity.CourseSession;

public interface CourseSessionService {

	public void addCourseSession(CourseSession courseSession);

	public CourseSession getCourseSession(Integer id);

	public void updateCourseSession(CourseSession courseSession);

	public void deleteCourseSession(Integer id);

	public List<CourseSession> getAllCoursesSessions();
	
	public void registerClient(String idcourseSession, Client client) throws Exception;
	
	public List<CourseSession> filteredCourseSessions(String titre, Date date, Integer idlocation);
}

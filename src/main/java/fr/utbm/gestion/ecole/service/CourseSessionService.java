package fr.utbm.gestion.ecole.service;

import java.text.ParseException;
import java.util.List;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.entity.CourseSession;

public interface CourseSessionService {

	public void addCourseSession(CourseSession courseSession);

	public CourseSession getCourseSession(Integer id);

	public void updateCourseSession(CourseSession courseSession);

	public void deleteCourseSession(Integer id);

	public List<CourseSession> getAllCoursesSessions();
	
	public void registerClient(Integer idcourseSession, Client client) throws Exception;
	
	public List<CourseSession> filteredCourseSessions(String titre, String date, String location) throws ParseException;
}

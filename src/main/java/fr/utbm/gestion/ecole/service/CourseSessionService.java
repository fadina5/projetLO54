package fr.utbm.gestion.ecole.service;

import java.util.List;

import fr.utbm.gestion.ecole.entity.CourseSession;

public interface CourseSessionService {

	public void addCourseSession(CourseSession courseSession);

	//public CourseSession getCourseSession(Integer id);

	public void updateCourseSession(CourseSession courseSession);

	public void deleteCourseSession(Integer id);

	public List<CourseSession> getAllCourseSessions();
}

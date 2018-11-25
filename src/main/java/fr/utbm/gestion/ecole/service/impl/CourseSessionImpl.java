package fr.utbm.gestion.ecole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.repository.CourseSessionRepository;
import fr.utbm.gestion.ecole.service.CourseSessionService;

@Service
public class CourseSessionImpl implements CourseSessionService {
	
	@Autowired 
	private CourseSessionRepository courseSessionRepository;
	
	public void addCourseSession(CourseSession courseSession) {
        courseSession = courseSessionRepository.addCourseSession(courseSession);
        System.out.println("la session de cours créé est: " + courseSession);
    }

  // public CourseSession getCourseSession(Integer id) {
        
       // return courseSessionRepository.getCourseSession(id);
    //}

    public void updateCourseSession(CourseSession courseSession) {
        courseSession = courseSessionRepository.updateCourseSession(courseSession);
        System.out.println("la mise à jour de la session de cours: " + courseSession);
    }

    public void deleteCourseSession(Integer id) {
    	courseSessionRepository.deleteCourseSession(id);
        System.out.println("la session de cours a été supprimé");
    }

    public List<CourseSession> getAllCourseSessions() {
        return courseSessionRepository.getAllCourseSessions();
    }

}

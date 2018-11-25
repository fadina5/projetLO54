package fr.utbm.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.service.impl.CourseSessionImpl;

@RestController
public class TestController {
	
	@Autowired
	private CourseSessionImpl courseSessionImpl;
	
	@GetMapping("/course")
	public ResponseEntity<List<CourseSession> > getCourseSession(){
		List <CourseSession> coursesSession=courseSessionImpl.getAllCourseSessions();
		return new ResponseEntity<List<CourseSession> >(coursesSession, HttpStatus.OK);
	}
	
	
	
	
}

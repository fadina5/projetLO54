package fr.utbm.gestion.ecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.utbm.gestion.ecole.entity.Course;
import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.service.impl.CourseServiceImpl;
import fr.utbm.gestion.ecole.service.impl.CourseSessionImpl;

@RestController
@PropertySource("classpath:application.properties")
public class TestController {
	
	@Autowired
	private CourseSessionImpl courseSessionImpl;
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	@GetMapping("/testCourseSession")
	public ResponseEntity<List<CourseSession> >getCourseSession(){
		List <CourseSession> coursesSession=courseSessionImpl.getAllCoursesSessions();
		return new ResponseEntity<List<CourseSession> >(coursesSession, HttpStatus.OK);
	}
	@GetMapping("/course")
	public ResponseEntity<List<Course>>getAllCourses(){
		List <Course> courses=courseServiceImpl.getAllCourses();
		return new ResponseEntity<List<Course> >(courses, HttpStatus.OK);
	}
	@GetMapping("/coursecode")
	public ResponseEntity<Course> getCourse(String code){
		code="BD51";
		Course course=courseServiceImpl.getCourse(code);
		return new ResponseEntity<Course >(course, HttpStatus.OK);
	}
	@RequestMapping(value = "/testupdate", method = RequestMethod.PUT)
    public ResponseEntity<Course> updateCourse() {
		String code="LO54";
		Course course=courseServiceImpl.getCourse(code);
        
        course.setCode("LO55");
        
        courseServiceImpl.updateCourse(course);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/testdelete", method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse() {
        String code="LO55";
		courseServiceImpl.deleteCourse(code);
        return new ResponseEntity<Course>(HttpStatus.OK);
    }
	
	@RequestMapping("/about")
	public ModelAndView aboutPage(ModelAndView model){
		model.addObject("MESSAGE","About Us Page");
		model.setViewName("about");
		return model;
	}
	
	
	
	
}

package fr.utbm.gestion.ecole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.gestion.ecole.entity.Course;
import fr.utbm.gestion.ecole.repository.CourseRepository;
import fr.utbm.gestion.ecole.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService  {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public void addCourse(Course course) {
        course =courseRepository.addCourse(course); 
        System.out.println("le nouveau cours inséré est: " + course.toString());
    }

   public Course getCourse(String code) {
	  Course course = courseRepository.findCourse(code);
      System.out.println("le cours correspondant au "+code+"est : " + course.toString());
      return course;
      
    }

    public void updateCourse(Course course) {
       course=courseRepository.updateCourse(course);
        System.out.println("la mise à jour du cours est: " + course.toString());
    }

    public void deleteCourse(String code) {
    	courseRepository.deleteCourse(code);
        System.out.println("le cours avec pour " + code +" a été supprimé");
    }

    public List<Course> getAllCourses() {
    	List<Course> courses = courseRepository.findAllCourses();
    	System.out.println("la liste des cours: " + courses.toString());
    	return courses;
    }
    public List<Course> getCoursesByTitle(String titre) {
        return this.courseRepository.findCoursesByTitre(titre);
    }


}

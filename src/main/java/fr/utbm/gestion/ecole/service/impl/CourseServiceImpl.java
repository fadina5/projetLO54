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
        System.out.println("le nouveau cours inséré est: " + course);
    }

   // public Course getCourse(String code) {
     //   return courseRepository.getCourse(code);
   // }

    public void updateCourse(Course course) {
       course=courseRepository.updateCourse(course);
        System.out.println("la mise à jour du cours est: " + course);
    }

    public void deleteCourse(String code) {
    	courseRepository.deleteCourse(code);
        System.out.println("Deleted Course " + code);
    }

    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }


}

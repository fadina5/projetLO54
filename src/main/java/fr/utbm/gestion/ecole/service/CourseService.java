package fr.utbm.gestion.ecole.service;

import java.util.List;

import fr.utbm.gestion.ecole.entity.Course;

public interface CourseService {
	
	public void addCourse(Course course);

	public Course getCourse(String code);

	public void updateCourse(Course course);

	public void deleteCourse(String code);

	public List<Course> getAllCourses();
	
}

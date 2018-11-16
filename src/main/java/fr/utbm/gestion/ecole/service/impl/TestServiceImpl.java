package fr.utbm.gestion.ecole.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.utbm.gestion.ecole.repository.CourseRepository;
import fr.utbm.gestion.ecole.repository.CourseSessionRepository;
import fr.utbm.gestion.ecole.repository.LocationRepository;
import fr.utbm.gestion.ecole.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseSessionRepository courseSessionRepository;
	
	@Autowired
	private LocationRepository locationRepository;
		
	@Transactional
	public void  getCourse() {

		 courseRepository.addCourse();
		 courseSessionRepository.addCourseSession();
		 locationRepository.addLocation();
	}

}

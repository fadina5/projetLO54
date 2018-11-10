package fr.utbm.gestion.ecole.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.utbm.gestion.ecole.repository.CourseRepository;
import fr.utbm.gestion.ecole.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private CourseRepository courseRepository;
		
	@Transactional
	public @ResponseBody void  getCourse() {

		 courseRepository.addCourse();
	}

}

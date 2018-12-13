package fr.utbm.gestion.ecole.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.utbm.gestion.ecole.entity.Course;
import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.service.impl.CourseServiceImpl;
import fr.utbm.gestion.ecole.service.impl.CourseSessionImpl;
import fr.utbm.gestion.ecole.service.impl.LocationServiceImpl;

@RestController
public class IndexController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private CourseSessionImpl courseSessionImpl;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHome() {
		
		ModelAndView modelAndView = new ModelAndView("Acceuil");
		List<Course> courses = new ArrayList<>(this.courseServiceImpl.getAllCourses());
		modelAndView.addObject("courses", courses);
		modelAndView.addObject("locations", this.locationServiceImpl.getAllLocations());
		return modelAndView;
		
	
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView getSearchTitre(@RequestParam(value = "titre", defaultValue = "") String titre) {
		ModelAndView modelAndView = new ModelAndView("Acceuil");

		List<Course> courses = new ArrayList<>(this.courseServiceImpl.getCoursesByTitre(titre));
		modelAndView.addObject("courses", courses);
		modelAndView.addObject("advanced", false);
		modelAndView.addObject("titre", titre);
		modelAndView.addObject("locations", this.locationServiceImpl.getAllLocations());
		return modelAndView;
	}

	@RequestMapping(value = "/advanced-search", method = RequestMethod.POST)
	public ModelAndView getAdvancedSearchResults(@RequestParam("titre") String titre, @RequestParam("date") String date, @RequestParam("location") String location) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("Acceuil");
		 
		List<CourseSession> courseSessions = new ArrayList<>(this.courseSessionImpl.filteredCourseSessions(titre, date, location));
		
		modelAndView.addObject("courseSession", courseSessions);
		modelAndView.addObject("advanced", true);
		modelAndView.addObject("titre", titre);
		modelAndView.addObject("date", date);
		modelAndView.addObject("location", location);
		modelAndView.addObject("locations", this.locationServiceImpl.getAllLocations());
		return modelAndView;
	}
}
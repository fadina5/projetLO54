package fr.utbm.gestion.ecole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.entity.Course;
import fr.utbm.gestion.ecole.entity.CourseSession;
import fr.utbm.gestion.ecole.service.impl.CourseServiceImpl;
import fr.utbm.gestion.ecole.service.impl.CourseSessionImpl;
import fr.utbm.gestion.ecole.service.impl.LocationServiceImpl;
import fr.utbm.gestion.ecole.tools.Util;

@RestController
public class IndexController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private CourseSessionImpl courseSessionImpl;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHome(@RequestParam(required = false) Integer p) {
		
	       
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("client", new Client());
		PagedListHolder<Course> coursePagedListHolder = new PagedListHolder<>(this.courseServiceImpl.getAllCourses());
		coursePagedListHolder.setPageSize(Util.COURSE_PER_PAGE);

		if (p == null || p < 1 || p > coursePagedListHolder.getPageCount()) {
			p = 1;
		}
		coursePagedListHolder.setPage(p - 1);
		modelAndView.addObject("page", p);
		modelAndView.addObject("coursePagedListHolder", coursePagedListHolder);

		modelAndView.addObject("locations", this.locationServiceImpl.getAllLocations());
		return modelAndView;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView showSearchResults(@RequestParam(value = "titre", defaultValue = "") String titre,
			@RequestParam(value = "page-number", required = false) Integer p) {
		ModelAndView modelAndView = new ModelAndView("home");

		PagedListHolder<Course> coursePagedListHolder = new PagedListHolder<>(this.courseServiceImpl.getCoursesByTitre(titre));
		coursePagedListHolder.setPageSize(Util.COURSE_PER_PAGE);

		if (p == null || p < 1 || p > coursePagedListHolder.getPageCount()) {
			p = 1;
		}
		coursePagedListHolder.setPage(p - 1);
		modelAndView.addObject("page", p);
		modelAndView.addObject("coursePagedListHolder", coursePagedListHolder);
		modelAndView.addObject("advanced", false);
		modelAndView.addObject("titre", titre);
		modelAndView.addObject("locations", this.locationServiceImpl.getAllLocations());
		return modelAndView;
	}

	@RequestMapping(value = "/advanced-search", method = RequestMethod.POST)
	public ModelAndView showAdancedSearchResults(@RequestParam("titre") String titre, @RequestParam("date") String date,
			@RequestParam("location") Integer idLocation,
			@RequestParam(value = "page-number", required = false) Integer p) {
		ModelAndView modelAndView = new ModelAndView("home");

		PagedListHolder<CourseSession> courseSessionPagedListHolder = new PagedListHolder<>(
		this.courseSessionImpl.filteredCourseSessions(titre, date, idLocation));
		courseSessionPagedListHolder.setPageSize(Util.COURSESESSION_PER_PAGE);

		if (p == null || p < 1 || p > courseSessionPagedListHolder.getPageCount()) {
			p = 1;
		}
		courseSessionPagedListHolder.setPage(p - 1);
		modelAndView.addObject("page", p);
		modelAndView.addObject("courseSessionPagedListHolder", courseSessionPagedListHolder);
		modelAndView.addObject("advanced", true);
		modelAndView.addObject("titre", titre);
		modelAndView.addObject("date", date);
		modelAndView.addObject("location", idLocation);
		modelAndView.addObject("locations", this.locationServiceImpl.getAllLocations());
		return modelAndView;
	}

}
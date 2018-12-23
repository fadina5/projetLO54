package fr.utbm.gestion.ecole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.utbm.gestion.ecole.service.impl.CourseServiceImpl;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;

    @GetMapping("/{code}")
    public ModelAndView showCourse(@PathVariable("code") String code) {
        ModelAndView modelAndView = new ModelAndView("course");
        modelAndView.addObject("course", this.courseServiceImpl.getCourse(code));
        return modelAndView;
    }
}
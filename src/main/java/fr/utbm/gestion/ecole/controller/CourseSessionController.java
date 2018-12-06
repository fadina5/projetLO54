package fr.utbm.gestion.ecole.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.service.impl.CourseSessionImpl;

@RestController
@RequestMapping("/course-session")
public class CourseSessionController {
	
	
	@Autowired
	private CourseSessionImpl courseSessionImpl;

		@GetMapping("/{id}")
	    public ModelAndView showRegisterForm(HttpServletRequest request, @PathVariable("id") Integer id, @RequestParam(required = false) String success,@RequestParam(required = false) String full)
		{

	        ModelAndView modelAndView = new ModelAndView("course-session");
	        Client client = new Client();
	       //if (success != null) {
	          modelAndView.addObject("success", success);

	            // Check if courseSession is full
	          //  if (full != null) {
	                modelAndView.addObject("full", full);
	           // }

	            Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
	            if (!CollectionUtils.isEmpty(flashMap)) {
	                client = (Client) flashMap.get("client");
	            }
	        //}

	        modelAndView.addObject("courseSession", this.courseSessionImpl.getCourseSession(id));

	      
	        if (client == null) client = new Client();
	        modelAndView.addObject("client", client);

	        return modelAndView;
	    }

	   

}

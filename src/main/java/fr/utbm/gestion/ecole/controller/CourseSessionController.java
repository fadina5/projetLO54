package fr.utbm.gestion.ecole.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import fr.utbm.gestion.ecole.entity.Client;
import fr.utbm.gestion.ecole.service.impl.ClientServiceImpl;
import fr.utbm.gestion.ecole.service.impl.CourseSessionImpl;

@Controller
@RequestMapping("/course-session")
public class CourseSessionController {
	
	
	@Autowired
	private CourseSessionImpl courseSessionImpl;
	
	@Autowired
	private ClientServiceImpl clientServiceImpl;

		@GetMapping("/{id}")
	    public ModelAndView showRegisterForm(HttpServletRequest request, @PathVariable("id") Integer id, @RequestParam(required = false) String success,@RequestParam(required = false) String full)
		{ ModelAndView modelAndView = new ModelAndView("inscription");
	        Client client = new Client();
	      if (success != null) {
	          modelAndView.addObject("success", success);

	           //Check if courseSession is full
	       if (full != null) {
	                modelAndView.addObject("full", full);
	           }

	            Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
	            if (!CollectionUtils.isEmpty(flashMap)) {
	                client = (Client) flashMap.get("client");
	            }
	        }
	      modelAndView.addObject("clients", this.clientServiceImpl.getAllClients());
	        modelAndView.addObject("courseSession", this.courseSessionImpl.getCourseSession(id));

	      
	        if (client == null) client = new Client();
	        modelAndView.addObject("client", client);

	        return modelAndView;
	    }
		@PostMapping("/{id}/register")
	    public ModelAndView registerClient(@PathVariable("id") Integer id,
	                                       @Valid @ModelAttribute("client") Client client,
	                                       BindingResult bindingResult, RedirectAttributes redirectAttributes) {

	        String nextUrl = "redirect:/course-session/" + id + "?success=";

	        // Redirect back into form page if there are validation errors
	        if (bindingResult.hasErrors()) {
	            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.client", bindingResult);
	            redirectAttributes.addFlashAttribute("client", client);
	            return new ModelAndView(nextUrl);
	        }

	        // Try proceeding registration
	        try {
				this.courseSessionImpl.registerClient(id, client);
				nextUrl += "true";
	        } catch (Exception e) {
	            System.err.println(e.toString());
	            nextUrl += "false";
	            // Check if exception is due to max of courseSession
	            if (e.getMessage().equals("La session de cours est pleine")) {
	                nextUrl += "&full=true";
	            }
	        }

	        return new ModelAndView(nextUrl);
	    }
		

	   

}

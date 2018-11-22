package fr.utbm.gestion.ecole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.utbm.gestion.ecole.service.impl.TestServiceImpl;

@RestController
public class TestController {
	@Autowired
	private TestServiceImpl testServiceImpl;
	
	@RequestMapping("/test")
	public ResponseEntity<String> courseDetails(){
		testServiceImpl.getCourse();
		return new ResponseEntity<String>("oK", HttpStatus.OK);
	}
   

}

package com.arun.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	private static final Logger log = LoggerFactory.getLogger(DummyController.class);

	@GetMapping("/home/{user}")
	public ResponseEntity<String> getMessage(@PathVariable String user) {
		try {
			log.trace("start of getMessage method");
			if(user ==null || "".equalsIgnoreCase(user.trim()) || "null".equalsIgnoreCase(user.trim()))
			{
				log.warn("user name is null");
				throw new Exception("user name is not provided in input");
			}
            log.info("Username is:{}", user);
			String message = "Hello " + user + " welcome to application";
			log.info("message given to user is:" + message);
			log.trace("End of getMessage method");

			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in getMessage method:{}",e.getMessage());
			log.debug("getMessage method ended due to exception");
			return new ResponseEntity<String>("Server error occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

package com.ge.testservice.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ge.testservice.model.User;
import com.ge.testservice.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

/**
 * @author shreedhar sahoo
 *
 */
@RestController
@RequestMapping("/user")
public class TestserviceUserRESTController {

	@Autowired
	User user;
	
	@Autowired
	UserRepository userRepository;
	
    @ApiOperation(value = "Provides User Data retrieval")
    @GetMapping(value = "/info/",name = "getUserData",produces = "application/vnd.ge.testservice.userinfo.v1.0+json")
    public ResponseEntity<User> getUserData(
    		@RequestParam (
    				name="username",
    				required=false
    				) 
    	    @NotEmpty(message="{testservice.username.notEmpty}")
    		String username, 
    		HttpServletResponse response) throws Exception{

        System.out.println("Request for User Name : " + username);
        user = userRepository.findUserByusernameEquals(username);
        if (user==null) {
        	return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		} 
    	return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintViolationExceptions(
	      ConstraintViolationException ex, WebRequest request) {
	    String exceptionResponse = String.format("Invalid input parameters: %s\n", ex.getMessage());
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	 }

}
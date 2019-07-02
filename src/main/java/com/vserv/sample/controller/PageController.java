package com.vserv.sample.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.vserv.sample.model.Employee;
import com.vserv.sample.model.Note;
import com.vserv.sample.model.StatusUpdate;

@Controller
public class PageController {
	@RequestMapping("/")
	String home() {
		return "app.homepage";
	}
	static final String URL_NOTES = "http://localhost:8081/api/notes/1";
	static final String URL_EMPLOYEES = "http://localhost:8081/api/notes/1";
    static final String URL_EMPLOYEES_XML = "http://localhost:8080/employees.xml";
    static final String URL_EMPLOYEES_JSON = "http://localhost:8080/employees.json";
 
	
	@RequestMapping("/about")
	String about() {
		//Note n;
		if(false) {
		
		RestTemplate restTemplate = new RestTemplate();
		 
        // Send request with GET method and default Headers.
        String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);
 
        System.out.println(result);
		}
		if(false) {
			
			 // HttpHeaders
	        HttpHeaders headers = new HttpHeaders();
	 
	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Request to return JSON format
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("my_other_key", "my_other_value");
	 
	        // HttpEntity<String>: To get result as String.
	        HttpEntity<Note> entity = new HttpEntity<Note>(headers);
	 
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // Send request with GET method, and Headers.
	        ResponseEntity<Note> response = restTemplate.exchange(URL_NOTES, //
	                HttpMethod.GET, entity, Note.class);
	 
	        Note result = response.getBody();
	 
	        System.out.println(result);
	       
		}
        
		if(false) {
			RestTemplate restTemplate = new RestTemplate();
			 
	        // Send request with GET method and default Headers.
	        Employee[] list = restTemplate.getForObject(URL_EMPLOYEES, Employee[].class);
	 
	        if (list != null) {
	            for (Employee e : list) {
	                System.out.println("Employee: " );
	            }
	        }
	 
			
		}
		
		if(false) {
			// HttpHeaders
	        HttpHeaders headers = new HttpHeaders();
	 
	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_XML }));
	        // Request to return XML format
	        headers.setContentType(MediaType.APPLICATION_XML);
	        headers.set("my_other_key", "my_other_value");
	 
	        // HttpEntity<Employee[]>: To get result as Employee[].
	        HttpEntity<Employee[]> entity = new HttpEntity<Employee[]>(headers);
	 
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // Send request with GET method, and Headers.
	        ResponseEntity<Employee[]> response = restTemplate.exchange(URL_EMPLOYEES, //
	                HttpMethod.GET, entity, Employee[].class);
	 
	        HttpStatus statusCode = response.getStatusCode();
	        System.out.println("Response Satus Code: " + statusCode);
	 
	        // Status Code: 200
	        if (statusCode == HttpStatus.OK) {
	            // Response Body Data
	            Employee[] list = response.getBody();
	 
	            if (list != null) {
	                for (Employee e : list) {
	                    System.out.println("Employee: ");
	                }
	            }
	        }
			
		}
		
		if(false) {
			
			 HttpHeaders headers = new HttpHeaders();
			 
		        // 
		        // Authentication
		        // 
		        String auth = "USER_NAME  PASSWORD";
		      //  byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		        String authHeader = "Basic " + new String("encodedAuth");
		        headers.set("Authorization", authHeader);
		        // 
		        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		        // Request to return JSON format
		        headers.setContentType(MediaType.APPLICATION_JSON);
		        headers.set("my_other_key", "my_other_value");
		 
		        // HttpEntity<String>: To get result as String.
		        HttpEntity<String> entity = new HttpEntity<String>(headers);
		 
		        // RestTemplate
		        RestTemplate restTemplate = new RestTemplate();
		 
		        // Send request with GET method, and Headers.
		        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
		                HttpMethod.GET, entity, String.class);
		 
		        String result = response.getBody();
		 
		        System.out.println(result);
		}
		
		
		if(false) {
			String empNo = "E11";
			 
		     // Employee newEmployee = new Employee(empNo, "Tom", "Cleck");
		      Employee newEmployee = new Employee();
		      HttpHeaders headers = new HttpHeaders();
		      headers.add("Accept", MediaType.APPLICATION_XML_VALUE);
		      headers.setContentType(MediaType.APPLICATION_XML);
		 
		      RestTemplate restTemplate = new RestTemplate();
		 
		      // Data attached to the request.
		      HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee, headers);
		 
		      // Send request with POST method.
		      Employee e = restTemplate.postForObject("", requestBody, Employee.class);
		 
		      if (e != null) {
		 
		         System.out.println("Employee created: ");
		      } else {
		         System.out.println("Something error!");
		      }
			
		}
		
		if(false) {
			
			/*
			 *  Employee newEmployee = new Employee();         RestTemplate restTemplate =
			 * new RestTemplate();         // Data attached to the request.
			 *         HttpEntity<Employee> requestBody = new HttpEntity<>(newEmployee);
			 *         // Send request with POST method.         ResponseEntity<Employee>
			 * result              = restTemplate.postForEntity(URL_CREATE_EMPLOYEE,
			 * requestBody, Employee.class);         System.out.println("Status code:" +
			 * result.getStatusCode());         // Code = 200.         if
			 * (result.getStatusCode() == HttpStatus.OK) {             Employee e =
			 * result.getBody();
			 *             System.out.println("(Client Side) Employee Created: "+
			 * e.getEmpNo());         }
			 */
		}
        //########################
        
        
        
        
        
        
        
        
        
		
		return "app.about";
	}
	
	@RequestMapping("/addstatus")
	ModelAndView addStatus(ModelAndView modelAndView, Model model) {
		
		modelAndView.setViewName("app.addStatus");
		
		StatusUpdate statusUpdate = new StatusUpdate();
		
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		// **********************************
		 HttpHeaders headers = new HttpHeaders();
		 
	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Request to return JSON format
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("my_other_key", "my_other_value");
	 
	        // HttpEntity<String>: To get result as String.
	        HttpEntity<Note> entity = new HttpEntity<Note>(headers);
	 
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // Send request with GET method, and Headers.
	        ResponseEntity<Note> response = restTemplate.exchange(URL_NOTES, //
	                HttpMethod.GET, entity, Note.class);
	 
	        Note result = response.getBody();
	 
	        //System.out.println(result);
	        
	        modelAndView.getModel().put("noteObject", result);
	        
	        model.addAttribute("specialMessage"," testing is done");
		
		return modelAndView;
	}
	@RequestMapping("/callNewJsp")
	ModelAndView callNewJsp(ModelAndView modelAndView, Model model) {
		
		modelAndView.setViewName("app.callNewJsp");
		
		StatusUpdate statusUpdate = new StatusUpdate();
		
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		// **********************************
		 HttpHeaders headers = new HttpHeaders();
		 
	        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
	        // Request to return JSON format
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("my_other_key", "my_other_value");
	 
	        // HttpEntity<String>: To get result as String.
	        HttpEntity<Note> entity = new HttpEntity<Note>(headers);
	 
	        // RestTemplate
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // Send request with GET method, and Headers.
	        ResponseEntity<Note> response = restTemplate.exchange(URL_NOTES, //
	                HttpMethod.GET, entity, Note.class);
	 
	        Note result = response.getBody();
	 
	        //System.out.println(result);
	        
	        modelAndView.getModel().put("noteObject", result);
	        
	        model.addAttribute("specialMessage"," testing is done");
		
		return modelAndView;
	}
	
	
}

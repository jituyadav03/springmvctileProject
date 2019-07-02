<%@page import="org.springframework.http.HttpMethod"%>
<%@page import="org.springframework.http.ResponseEntity"%>
<%@page import="org.springframework.web.client.RestTemplate"%>
<%@page import="com.vserv.sample.model.Note"%>
<%@page import="org.springframework.http.HttpEntity"%>
<%@page import="org.springframework.http.MediaType"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.springframework.http.HttpHeaders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 This is the about page.
 
 
 <%
/*  HttpHeaders headers = new HttpHeaders();
 String URL_NOTES = "http://localhost:8081/api/notes/1";
 headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
 // Request to return JSON format
 headers.setContentType(MediaType.APPLICATION_JSON);
 headers.set("my_other_key", "my_other_value");

 // HttpEntity<String>: To get result as String.
 HttpEntity<Note> entity = new HttpEntity<Note>(headers);

 // RestTemplate
 RestTemplate restTemplate = new RestTemplate();

 // Send request with GET method, and Headers.
 ResponseEntity<Note> response1 = restTemplate.exchange(URL_NOTES, //
         HttpMethod.GET, entity, Note.class);

 Note result = response1.getBody();
 
  */
 %>
 

 <a> get Notes</a>
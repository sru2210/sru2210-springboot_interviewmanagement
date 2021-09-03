package com.revature.interviewmanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.interviewmanagement.entity.Candidate;
import com.revature.interviewmanagement.exception.DuplicateIdException;
import com.revature.interviewmanagement.exception.IdNotFoundException;
import com.revature.interviewmanagement.service.CandidateService;

@RestController
@RequestMapping("/api")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateSerive;
	
	@GetMapping("/candidate")
	public ResponseEntity<List<Candidate>> getAllCandidate(){
		
		return	new ResponseEntity<List<Candidate>>(candidateSerive.getAllCandidate(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/candidate/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id){
			
		return	new ResponseEntity<Candidate>(candidateSerive.getCandidateById(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	 @GetMapping("/candidate/email/{email}") 
	 public ResponseEntity<Candidate> getCandidateByEmailId(@PathVariable String email){
		 
		 return new ResponseEntity<Candidate>(candidateSerive.getCandidateByEmailId(email), new HttpHeaders(), HttpStatus.OK);  
	} 
	 
	 @GetMapping("/candidate/phone/{phone-number}")  
	 public ResponseEntity<Candidate> getCandidateByPhoneNumber(@PathVariable("phone-number") String phoneNumber){
	
		 return new ResponseEntity<Candidate>(candidateSerive.getCandidateByPhoneNumber(phoneNumber), new HttpHeaders(), HttpStatus.OK);  
	} 
	  
	 @GetMapping("/candidate/name/{name}") 
	 public ResponseEntity<List<Candidate>> getCandidateByName(@PathVariable String name){  
		 
		 return new ResponseEntity<List<Candidate>>(candidateSerive.getCandidateByName(name), new HttpHeaders(), HttpStatus.OK);  
	}  
	 
	 @GetMapping("/candidate/experience/{exp}")
	public ResponseEntity<List<Candidate>> getCandidateByExperience(@PathVariable Integer exp){ 
		 
		 return new ResponseEntity<List<Candidate>>(candidateSerive.getCandidateByExperience(exp), new HttpHeaders(), HttpStatus.OK); 
	} 
	
	 
	 @GetMapping("/candidate/role/{role}")  
	 public ResponseEntity<List<Candidate>> getCandidateByRole(@PathVariable String role){  
		 
		 return new ResponseEntity<List<Candidate>>(candidateSerive.getCandidateByRole(role), new HttpHeaders(), HttpStatus.OK); 
	}
	
	@PostMapping("/candidate")
	public ResponseEntity<String> addCandidate(@RequestBody Candidate candidate){
		
		return	new ResponseEntity<String>(candidateSerive.addCandidate(candidate), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PutMapping("/candidate/{id}")
	public ResponseEntity<String> updateCandidate(@PathVariable Long id,@RequestBody Candidate candidate){
		
		return	new ResponseEntity<String>(candidateSerive.updateCandidate(id,candidate), new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/candidate/{id}")
	public ResponseEntity<String> deleteCandidate(@PathVariable Long id){
		
		return	new ResponseEntity<String>(candidateSerive.deleteCandidate(id), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	
 @ExceptionHandler(DuplicateIdException.class)
	public ResponseEntity<String> DuplicateIdFound(DuplicateIdException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}	
 
 @ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
}
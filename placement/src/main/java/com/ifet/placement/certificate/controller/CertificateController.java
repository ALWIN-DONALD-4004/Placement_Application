package com.ifet.placement.certificate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifet.placement.certificate.entity.CertificateEntity;
import com.ifet.placement.certificate.service.CertificateService;

import jakarta.persistence.NoResultException;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
	@Autowired
	private CertificateService certify;

	//to get all the data in the database
	@GetMapping("/certificateservice")
	public List<CertificateEntity> list(){
		return certify.listAll();
	}
	
	//to give new data to the database
	@PostMapping("/certificateservice")
	public void add(@RequestBody CertificateEntity certify1) {
		certify.save(certify1);
	}
	
	// to get a separate data from a database with respect to ID
	@GetMapping("/certificateservice/{id}")
	public ResponseEntity<CertificateEntity> get(@PathVariable Long id){
		try {
			CertificateEntity c = certify.get(id);
			return new ResponseEntity<CertificateEntity>(c,HttpStatus.OK);
		}
		catch(NoResultException e) {
			return new ResponseEntity<CertificateEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	// delete the data from the database by ID
	@DeleteMapping("/certificateservice/{id}")
	public void delete(@PathVariable Long id) {
		certify.delete(id);
	}
	
	// to update the data in Database by ID
	@PutMapping("/certificateservice/{id}")
	public ResponseEntity<CertificateEntity> update(@PathVariable Long id, @RequestBody CertificateEntity update_c){
		try {
			CertificateEntity exist_c = certify.get(id);
			exist_c.setName(update_c.getName());
			exist_c.setCoursename(update_c.getCoursename());
			exist_c.setVerificationid(update_c.getVerificationid());
			exist_c.setIssueDate(update_c.getIssueDate());
			exist_c.setCourse_duration(update_c.getCourse_duration());
			certify.update(exist_c);
			return new ResponseEntity<CertificateEntity>(exist_c,HttpStatus.OK);
		}
		catch(NoResultException e) {
			return new ResponseEntity<CertificateEntity>(HttpStatus.NOT_FOUND);
		}
	}

}  
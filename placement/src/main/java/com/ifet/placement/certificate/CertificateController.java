package com.ifet.placement.certificate;

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
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class CertificateController {
	@Autowired
	private CertificateService certify;
	
	
	@GetMapping("/certificateservice")
	public List<CertificateEntity> list(){
		return certify.listAll();
	}
	
	

	@PostMapping("/certificateservice")
	public void add(@RequestBody CertificateEntity certify1) {
		certify.save(certify1);
	}
	
	
	
	@GetMapping("/certificateservice/{id}")
	public ResponseEntity<CertificateEntity> get(@PathVariable Integer id){
		try {
			CertificateEntity c = certify.get(id);
			return new ResponseEntity<CertificateEntity>(c,HttpStatus.OK);
		}
		catch(NoResultException e) {
			return new ResponseEntity<CertificateEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping("/certificateservice/{id}")
	public void delete(@PathVariable Integer id) {
		certify.delete(id);
	}
	
	
	
	@PutMapping("/certificateservice/{id}")
	public ResponseEntity<CertificateEntity> update(@PathVariable Integer id, @RequestBody CertificateEntity update_c){
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
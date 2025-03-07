package com.ifet.placement.certificate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifet.placement.certificate.entity.CertificateEntity;
import com.ifet.placement.certificate.repository.CertificateRepository;

@Service
public class CertificateService {
	
	@Autowired
	private CertificateRepository repo;
	
	//get at the data
	public List<CertificateEntity> listAll() {
		return repo.findAll();
	}
	
	//save the record
	public String save(CertificateEntity cust) {
		repo.save(cust);
		return "message entered Successfully";
	}
		
	//retriving the particular record with id
	public CertificateEntity get(Long id) {
		return repo.findById(id).get();
	}
		
	//delete the particular Data
	public void delete(Long id) {
		repo.deleteById(id);
	}
		
	//update the record
	public void update(CertificateEntity cust) {
		repo.save(cust);
	}

}
package com.ifet.placement.certificate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {
	
	@Autowired
	private CertificateRepository repo;
	
	
	public List<CertificateEntity> listAll() {
		return repo.findAll();
	}
	
	//save the record
	public void save(CertificateEntity cust) {
		repo.save(cust);
	}
		
	//retriving the particular record with id
	public CertificateEntity get(Integer id) {
		return repo.findById(id).get();
	}
		
	//delete the particular Data
	public void delete(Integer id) {
		repo.deleteById(id);
	}
		
	//update the record
		
	public void update(CertificateEntity cust) {
		repo.save(cust);
	}

}
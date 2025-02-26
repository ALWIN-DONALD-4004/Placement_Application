package com.ifet.placement.certificate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifet.placement.certificate.entity.CertificateEntity;

public interface CertificateRepository extends JpaRepository<CertificateEntity, Long>{


}
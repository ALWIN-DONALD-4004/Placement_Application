package com.ifet.placement.certificate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CertificateEntity {
	
	@Id
	@Column(name = "Student Roll Number")
	private Long roll_number;
	
	@Column(name = "Student Name")
	
	private String name;
	
	@Column(name = "Course Name")
	private String coursename;
	
	@Column(name = "Verification ID")
	private String Verificationid;
	
	@Column(name = "Issued Date")
	private String issueDate;
	
	@Column(name = "Course Duration")
	private String course_duration;
	
	
	public CertificateEntity(Long register_number, String name, String coursename, String verificationid,
			String issueDate, String course_duration) {
		super();
		this.roll_number = register_number;
		this.name = name;
		this.coursename = coursename;
		this.Verificationid = verificationid;
		this.issueDate = issueDate;
		this.course_duration = course_duration;
	}
	

	public CertificateEntity() {
		super();
		
	}
	
	
	public Long getRegister_number() {
		return roll_number;
	}
	public void setRegister_number(Long register_number) {
		this.roll_number = register_number;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
	public String getVerificationid() {
		return Verificationid;
	}
	public void setVerificationid(String verificationid) {
		this.Verificationid = verificationid;
	}
	
	
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	
	public String getCourse_duration() {
		return course_duration;
	}
	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}

	
	@Override
	public String toString() {
		return "CertificateEntity [register_number=" + roll_number + ", name=" + name + ", coursename=" + coursename
				+ ", Verificationid=" + Verificationid + ", issueDate=" + issueDate + ", course_duration="
				+ course_duration + "]";
	}
	
	
	
}  
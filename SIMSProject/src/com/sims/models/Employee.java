package com.sims.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Employee_Master")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employeemastersequence")
	@SequenceGenerator(name="employeemastersequence", sequenceName="employee_master_sequence", allocationSize=1)	
	private Integer  empId ;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;

	@Column(name = "EMP_ALIAS_NAME")
	private String empAliasName;

	@Column(name = "EMPLOYEE_CODE")
	private String empCode;
	
    //@Type(type = "date")
	@Temporal(TemporalType.DATE)
	@Column(name = "EMP_DOJ")	
	private Date empDOJ;
	
	@Column(name = "EMP_IMAGE")
	private byte[] empImage;

	@Column(name = "EMP_ID_PROOF")
	private byte[] empIdProof;

	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmpAliasName() {
		return empAliasName;
	}

	public void setEmpAliasName(String empAliasName) {
		this.empAliasName = empAliasName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	public byte[] getEmpImage() {
		return empImage;
	}

	public void setEmpImage(byte[] empImage) {
		this.empImage = empImage;
	}

	public byte[] getEmpIdProof() {
		return empIdProof;
	}

	public void setEmpIdProof(byte[] empIdProof) {
		this.empIdProof = empIdProof;
	}


	
	}

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
@Table(name="Section_Master")
public class Section implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sectionmastersequence")
	@SequenceGenerator(name="sectionmastersequence", sequenceName="section_master_sequence", allocationSize=1)	
	private Integer  sectionId ;
	
	@Column(name = "SECTION_NAME")
	private String sectionName;

	@Column(name = "SECTION_ALIAS_NAME")
	private String sectionAliasName;

	@Column(name = "SECTION_CODE")
	private String sectionCode;

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionAliasName() {
		return sectionAliasName;
	}

	public void setSectionAliasName(String sectionAliasName) {
		this.sectionAliasName = sectionAliasName;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}
	
   	}

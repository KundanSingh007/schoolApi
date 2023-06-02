package com.school.mg.bean;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SCIENCE")
public class ScienceBean {
	
	@Id
	@Column(name="STUDENTID")
	private String sId;
	
	@Column(name="STUDENTNAME")
	private String studentsName;
	
	@Column(name="ROLLNO")
	private String rollNo;

	@Column(name="CLASSTEACHER")
	private String clsTeacher;
	
	@Column(name="ROOM")
	private String room;
	
	@Column(name="PEN")
	private String pen;
	
	@Column(name="PENCIL")
	private String pencil;
	
	@Column(name="DUSTER")
	private String duster;
	
	@Column(name = "CREATED_BY")
	private String creatdBy;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate ;
	
	@Column(name = "CREATED_ON")
	private String createdOn;
	
	@Column(name = "RECORD_STATUS")
	private int recordStatus;
	

	
	

}

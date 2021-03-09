package com.project.toy.dto;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@DiscriminatorValue("일정")
public class Plan extends Board{
	
//	@Id @GeneratedValue
	private Long id;
	
//	@Embedded
//	private Board board;
	
	private boolean isOpen;
	
//	@Temporal(TemporalType.TIME)
	private Date startTime;

//	@Temporal(TemporalType.TIME)
	private Date endTime;

}

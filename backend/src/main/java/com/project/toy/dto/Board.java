package com.project.toy.dto;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn
//@Embeddable
public abstract class Board {

//	@Id @GeneratedValue
//	private Long id;
//	
//	@OneToOne
//	private Club club;
//	
//	private String title;
//	
//	@OneToOne
//	private Account writer;
//	
//	private String content;
//	
//	private String file;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date regtime = new Date();
}

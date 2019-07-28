package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {
	
	
	// form this @GenericGenerator we are saying hibernate to use parent key id as the primary key for this table 
	// do not generate a new id for address_id table would always use the corressponding id which is present in student class
	@Id
	@Column(name="address_id")
	@GeneratedValue(generator = "newGenerater")
	@GenericGenerator(name = "newGenerater", strategy = "foreign",parameters= {@Parameter(value = "student",name="property")})
	private int addressId;
	
	private int pincode;
	
	private String city;
	
	private String state;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;
}

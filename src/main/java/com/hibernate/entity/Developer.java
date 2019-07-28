package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="developer")
@Data
public class Developer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="developer_id")
	private int developerId;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="technology_id")
	private Technology technology; 
}

package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="technology")
public class Technology {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="technology_id")
	private int technologyId;
	
	@Column(name="technology_name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "technology")
	private Set<Developer> developerList = new HashSet<Developer>(0);

	public int getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(int technologyId) {
		this.technologyId = technologyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Developer> getDeveloperList() {
		return developerList;
	}

	public void setDeveloperList(Set<Developer> developerList) {
		this.developerList = developerList;
	}
}

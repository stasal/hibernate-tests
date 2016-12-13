package org.hibernate.bugs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Stanislav Alekminskiy
 */
@Entity
@Table(name = "Workplaces")
public class Workplace {
	@Id
	@GeneratedValue
	@Column(name = "Workplace_ID")
	private Long id;

	@Column(name = "Location")
	private String location;

	public Workplace() {
	}

	public Workplace(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

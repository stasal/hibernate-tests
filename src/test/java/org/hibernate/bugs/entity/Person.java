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
@Table(name = "Persons")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "Person_ID")
	private Long id;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

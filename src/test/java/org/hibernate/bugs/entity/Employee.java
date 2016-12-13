package org.hibernate.bugs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Stanislav Alekminskiy
 */
@Entity
@Table(name = "Employees")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "Employee_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "Person_ID", referencedColumnName = "Person_ID")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "Workplace_ID", referencedColumnName = "Workplace_ID")
	private Workplace workplace;

	public Employee() {
	}

	public Employee(Person person, Workplace workplace) {
		this.person = person;
		this.workplace = workplace;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Workplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}
}

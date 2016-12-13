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
@Table(name = "Computers")
public class Computer {
	@Id
	@GeneratedValue
	@Column(name = "Computer_ID")
	private Long id;

	@Column(name = "Inventory_Number")
	private String inventoryNumber;

	@ManyToOne
	@JoinColumn(name = "Workplace_ID", referencedColumnName = "Workplace_ID")
	private Workplace workplace;

	public Computer() {
	}

	public Computer(String inventoryNumber, Workplace workplace) {
		this.inventoryNumber = inventoryNumber;
		this.workplace = workplace;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public Workplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}
}

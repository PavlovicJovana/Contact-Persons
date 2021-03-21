package it.engineering.spring.mvc.task.contacts.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class CityEntity implements Serializable, it.engineering.spring.mvc.task.contacts.entity.Entity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pttnumber")
	private Long number;
	private String name;
	
	public CityEntity() {
		
	}

	public CityEntity(Long pttnumber, String name) {
		super();
		this.number = pttnumber;
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long pttnumber) {
		this.number = pttnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CityEntity [pttnumber=" + number + ", name=" + name + "]";
	}
	
}

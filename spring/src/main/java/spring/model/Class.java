package spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Class {

	@Id
	private Integer id;
	private String name;
	
	public Class() {
	}

	public Class(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

package spring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class StudentClass {

	@EmbeddedId
	private StudentClassPK primaryKey;
	
	public StudentClass() {
	}
	
	public StudentClass(StudentClassPK primaryKey) {
		super();
		this.primaryKey = primaryKey;
	}

	public StudentClassPK getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(StudentClassPK primaryKey) {
		this.primaryKey = primaryKey;
	}
}

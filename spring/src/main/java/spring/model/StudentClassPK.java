package spring.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentClassPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer studentId;
	private Integer classId;
	
	public StudentClassPK() {
	}
	
	public StudentClassPK(Integer studentId, Integer classId) {
		super();
		this.studentId = studentId;
		this.classId = classId;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
}

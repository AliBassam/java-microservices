package spring.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * A bean to be returned as a response in a REST call
 * It contains the main information of the Student as well as a list of his classes
 * @author Ali Bassam
 *
 */
public class StudentClassesBean {

	private Integer id;
	private String firstname;
	private String lastname;
	private List<String> classesNames;
	
	public StudentClassesBean() {
	}
	
	public StudentClassesBean(Integer id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setClassesNames(List<String> classesNames) {
		this.classesNames = classesNames;
	}
	public List<String> getClassesNames() {
		if(classesNames == null)
			classesNames = new ArrayList<String>();
		return classesNames;
	}
	
}

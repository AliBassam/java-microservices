package javaee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Student Model
 * @author Ali Bassam
 *
 */
@Entity
@Table(name="T_STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="F_ID")
	private Integer id;
	@Column(name="F_FIRSTNAME", length=32, nullable=false)
	private String firstname;
	@Column(name="F_LASTNAME", length=32, nullable=false)
	private String lastname;
	@Temporal(TemporalType.DATE)
	@Column(name="F_BIRTHDATE", nullable=true)
	private Date birthDate;
	
	public Student() {
	}
	
	public Student(Integer id, String firstname, String lastname, Date birthDate) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthDate = birthDate;
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
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}

package spring.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.bean.StudentClassesBean;
import spring.client.RestClient;
import spring.dao.ClassRepository;
import spring.dao.StudentClassRepository;
import spring.model.Class;
import spring.model.StudentClass;

/**
 * Rest Controller for Classes
 * @author Ali Bassam
 *
 */
@RestController
public class ClassController {

	@Autowired
	ClassRepository classRepository;

	@Autowired
	StudentClassRepository studentClassRepository;

	@Autowired
	RestClient restClient;

	/**
	 * Retrieve all classes
	 * @return
	 */
	@GetMapping(path = "/rest/class/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<spring.model.Class> getClasses() {
		return StreamSupport.stream(classRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	/**
	 * Retrieve all students and their classes
	 * @return
	 */
	@GetMapping(path = "/rest/class/student/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentClassesBean> getUsersClasses() {
		// Retrieve All Students Data from Students Microservice
		List<StudentClassesBean> studentsClasses = restClient.getAllStudents();

		// Retrieve All Classes
		List<Class> classesList = StreamSupport.stream(classRepository.findAll().spliterator(), false).collect(Collectors.toList());

		// Retrieve All Students Classes
		List<StudentClass> studentClassList = StreamSupport.stream(studentClassRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		//Populate Response
		studentClassList.stream().forEach(x->{
			//Search For Student Info
			StudentClassesBean scb = studentsClasses.stream().filter(s->s.getId().equals(x.getPrimaryKey().getStudentId())).findFirst().orElse(null);
			if(scb == null) {
				scb = new StudentClassesBean(x.getPrimaryKey().getStudentId(), null, null);
				studentsClasses.add(scb);
			}
			
			Class theClass = classesList.stream().filter(c->c.getId().equals(x.getPrimaryKey().getClassId())).findFirst().orElse(null);
			if(theClass != null)
				scb.getClassesNames().add(theClass.getName());
			
		});

		return studentsClasses;
	}

}

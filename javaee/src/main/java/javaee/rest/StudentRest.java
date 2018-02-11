package javaee.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javaee.dao.StudentDAO;
import javaee.model.Student;

/**
 * Student Rest Service
 * @author Ali Bassam
 *
 */
@Path("student")
public class StudentRest {

	/**
	 * Retrieve students
	 * @return
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudents() {
		List<Student> students = StudentDAO.findAll();
		
		return Response.ok(students).build();
	}
}


package spring.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import spring.bean.StudentClassesBean;

/**
 * Rest Client to communicte with other Microservices
 * @author Ali Bassam
 *
 */
@Service
public class RestClient {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${microservice.student.all}")
	String microserviceStudentAll;
	
	/**
	 * Retrieves all students from Student microservice
	 * @return
	 */
	public List<StudentClassesBean> getAllStudents() {
		ResponseEntity<StudentClassesBean[]> response;
		try {
			response = restTemplate.getForEntity(new URI(microserviceStudentAll), StudentClassesBean[].class);
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
			return new ArrayList<StudentClassesBean>();
		}
		return Arrays.asList(response.getBody());
	}
}

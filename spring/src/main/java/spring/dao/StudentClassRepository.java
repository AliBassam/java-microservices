package spring.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import spring.model.StudentClass;

/**
 * Student Class DAO
 * @author Ali Bassam
 *
 */
public interface StudentClassRepository extends CrudRepository<StudentClass, Serializable>{

}

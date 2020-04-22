package hh.swd20.Hospital_project.domain;

import java.util.List; 
import org.springframework.data.repository.CrudRepository;


	
	public interface WardRepository extends CrudRepository<Ward, Long> {
	    List<Ward> findByName(String wardName);
}

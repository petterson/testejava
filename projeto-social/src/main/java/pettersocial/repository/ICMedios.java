package pettersocial.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pettersocial.model.ICMedio;


public interface ICMedios extends CrudRepository<ICMedio, Long>{
	
	@Query("select p from CandidatoPorEstado p")
	ArrayList<String> findAllEstado();

}

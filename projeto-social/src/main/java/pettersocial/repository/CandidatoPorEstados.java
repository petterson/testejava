package pettersocial.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pettersocial.model.CandidatoPorEstado;

public interface CandidatoPorEstados extends CrudRepository<CandidatoPorEstado, Long>{
	
	@Query("select p from CandidatoPorEstado p")
	ArrayList<String> findAllEstado();
	
	@Query("select DISTINCT p.estado from Pessoa p")
	ArrayList<String> findAllDistinctEstado();

}

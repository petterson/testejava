package pettersocial.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pettersocial.model.Pessoa;

public interface Pessoas extends CrudRepository<Pessoa, Long>{
	
	
	@Query("select p.estado from Pessoa p")
	ArrayList<String> findAllEstado();
	
	@Query("select DISTINCT p.estado from Pessoa p")
	ArrayList<String> findAllDistinctEstado();
	
	@Query("select p from Pessoa p")
	ArrayList<Pessoa> findAllPessoa();
}

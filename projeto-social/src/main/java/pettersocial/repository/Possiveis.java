package pettersocial.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pettersocial.model.Possivel;

public interface Possiveis extends CrudRepository<Possivel, Long>{
	
	@Query("select DISTINCT p.tipo_sanguineo from Pessoa p")
	ArrayList<String> findAllDistinctTipoSanguineo();

}

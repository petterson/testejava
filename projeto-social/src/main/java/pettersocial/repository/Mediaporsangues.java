package pettersocial.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pettersocial.model.Mediaportiposanguineo;


public interface Mediaporsangues extends CrudRepository<Mediaportiposanguineo, Long>{
	
	@Query("select DISTINCT p.tipo_sanguineo from Pessoa p")
	ArrayList<String> findAllDistinctTipoSanguineo();

}

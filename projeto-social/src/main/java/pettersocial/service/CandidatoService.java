package pettersocial.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pettersocial.model.CandidatoPorEstado;
import pettersocial.repository.CandidatoPorEstados;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoPorEstados candidatoPorEstados;
     
     
     public ArrayList<CandidatoPorEstado> findAll() {
    	 var users = new ArrayList<CandidatoPorEstado>();
         return users;
     }
     
     public Long contador() {
         return candidatoPorEstados.count();
     }
}

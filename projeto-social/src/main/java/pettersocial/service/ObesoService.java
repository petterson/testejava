package pettersocial.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pettersocial.model.Obeso;
import pettersocial.model.Pessoa;
import pettersocial.repository.Obesos;
import pettersocial.repository.Pessoas;

@Service
public class ObesoService {
	
	@Autowired
	private Obesos obesos;
	@Autowired
	private Pessoas pessoas;
	
	public ArrayList<Obeso> findAll() {
        var users = new ArrayList<Obeso>();
        return users;
    }
	
	public Long contador() {
        return obesos.count();
    }
	
	public ArrayList<Pessoa> getListPessoas(){	
		return pessoas.findAllPessoa();
	}
}

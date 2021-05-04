package pettersocial.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pettersocial.model.ICMedio;
import pettersocial.model.Pessoa;
import pettersocial.repository.ICMedios;
import pettersocial.repository.Pessoas;

@Service
public class ICMedioService {
	
	@Autowired
	private ICMedios icmedios;
	@Autowired
	private Pessoas pessoas;
	
	public ArrayList<ICMedio> findAll() {
        var users = new ArrayList<ICMedio>();
        return users;
    }
	
	public Long contador() {
        return icmedios.count();
    }
	
	public ArrayList<Pessoa> getListPessoa(){
		return pessoas.findAllPessoa();
	}

}

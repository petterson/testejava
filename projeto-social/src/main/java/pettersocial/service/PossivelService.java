package pettersocial.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pettersocial.model.Pessoa;
import pettersocial.model.Possivel;
import pettersocial.repository.Pessoas;
import pettersocial.repository.Possiveis;

@Service
public class PossivelService {
	
	@Autowired
	private Possiveis possiveis;
	@Autowired
	private Pessoas pessoas;
	
	public ArrayList<Possivel> findAll() {
        var users = new ArrayList<Possivel>();
        return users;
    }
	
	public Long contador() {
        return possiveis.count();
    }
	
	public ArrayList<Pessoa> getListPessoas(){	
		return pessoas.findAllPessoa();
	}
	
	public ArrayList<String> getListDistinctTipoSnguineo(){	
		return possiveis.findAllDistinctTipoSanguineo();
	}

}

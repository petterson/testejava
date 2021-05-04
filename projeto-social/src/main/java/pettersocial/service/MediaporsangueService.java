package pettersocial.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pettersocial.model.Mediaportiposanguineo;
import pettersocial.model.Pessoa;
import pettersocial.repository.Mediaporsangues;
import pettersocial.repository.Pessoas;

@Service
public class MediaporsangueService {
	
	@Autowired
	private Mediaporsangues mediaporsangues;
	@Autowired
	private Pessoas pessoas;
	
	public ArrayList<Mediaportiposanguineo> findAll() {
        var users = new ArrayList<Mediaportiposanguineo>();
        return users;
    }
	
	public Long contador() {
        return mediaporsangues.count();
    }
	
	public ArrayList<Pessoa> getListPessoas(){
		return pessoas.findAllPessoa();
	}
	
	public ArrayList<String> getListDistinctTipoSnguineo(){	
		return mediaporsangues.findAllDistinctTipoSanguineo();
	}

}

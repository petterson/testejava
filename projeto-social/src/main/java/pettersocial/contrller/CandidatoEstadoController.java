package pettersocial.contrller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pettersocial.model.CandidatoPorEstado;
import pettersocial.repository.CandidatoPorEstados;
import pettersocial.service.FileService;

@Controller
public class CandidatoEstadoController {
	
	@Autowired
	private CandidatoPorEstados candidatoPorEstados;
	@Autowired
	private FileService fs;
	ModelAndView modelAndView;
	ArrayList<String> total;
	ArrayList<String> distinct;
	
	@PostMapping("/buscaCandidato")
	public String salvarCandidato(RedirectAttributes redirectAttributes) {
		this.distinct = new ArrayList<>(fs.getListEstadoDistinct());
		java.util.Collections.sort(this.distinct);
		this.total = new ArrayList<>(fs.getListEstado());
		this.criaCandidatoPorEstado();
		return "redirect:/mostraCandidato";
	}
	
	@GetMapping("/mostraCandidato")
	public ModelAndView mostra(RedirectAttributes re) {
		 this.modelAndView = new ModelAndView("BuscaCandidato");
		 modelAndView.addObject("candidatoPorEstados", candidatoPorEstados.findAll());
		return modelAndView;
	}
	
//////////////CADASTRA  QUANTIDADE DE CANDIDATO A POR ESTADO////////////////
	
	public void criaCandidatoPorEstado() {
		for(int i=0; i<this.distinct.size(); i++) {
				int quantidade = this.defineQuantidadeCandidatoPorEstado(this.distinct.get(i));
				CandidatoPorEstado c = new CandidatoPorEstado();
				c.setNome(this.distinct.get(i));
				c.setQuantCandidato(quantidade);				
				try {
					this.candidatoPorEstados.save(c);
	    			}catch (IllegalArgumentException e) {
	    				
	    				e.getMessage().formatted("merda");
	    			}
		    }
    }
	
	//////////////SOMA QUANTIDADE DE CANDIDATO A POR ESTADO////////////////
	
	private int defineQuantidadeCandidatoPorEstado(String esta) {
		int soma =0;
		for(int i=0; i<this.total.size(); i++) {
		       if(this.total.get(i).equals(esta)) {
		          soma += 1;
		         }
	        }	
	return soma;
   }
	

}

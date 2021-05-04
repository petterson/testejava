package pettersocial.contrller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pettersocial.model.Obeso;
import pettersocial.model.Pessoa;
import pettersocial.repository.Obesos;
import pettersocial.service.ObesoService;

@Controller
public class ObesoController {
	
	@Autowired
	private ObesoService obs;
	@Autowired
	private Obesos obesos;
	ModelAndView modelAndView;
	ArrayList<Obeso> listobeso;
	ArrayList<Pessoa> pes;
	
	
	@PostMapping("/buscaObeso")
	public String salvarICMedio(RedirectAttributes redirectAttributes) {
		//this.modelAndView.clear();
		this.listobeso = new ArrayList<>();
		this.pes = obs.getListPessoas();
		this.getListObeso(this.pes);
		for(int i=0; i<this.listobeso.size(); i++) {
			this.obesos.save(this.listobeso.get(i));
		}
		return "redirect:/mostraObeso";
	}
	
	@GetMapping("/mostraObeso")
	public ModelAndView mostra(RedirectAttributes re) {   
		 this.modelAndView = new ModelAndView("BuscaObeso");
		 modelAndView.addObject("obesos", obesos.findAll());
		return modelAndView;
	}
	
	private ArrayList<Obeso> getListObeso(ArrayList<Pessoa> p){
		int somaM=0;
		int somaF=0;
		for(int i=0; i<this.pes.size(); i++) {
			if(this.calculaObesidade(this.pes.get(i).getPeso(), this.pes.get(i).getAltura())) {
			if(p.get(i).getSexo().equals("Masculino")) {
				somaM +=1;
			}else {
				somaF +=1;
			}
			}
		}
			Obeso obm = new Obeso();
			obm.setHomoumul("Homem");
			obm.setPercentual(this.calculaPercentual(somaM, this.pes.size()));
			obm.setQuantidade(somaM);
			this.listobeso.add(obm);
			Obeso obf = new Obeso();
			obf.setHomoumul("Feminino");
			obf.setPercentual(this.calculaPercentual(somaF, this.pes.size()));
			obf.setQuantidade(somaF);
			this.listobeso.add(obf);
		
		return this.listobeso;
	}
	
	private boolean calculaObesidade(int peso, Double altura) {
		boolean res=true;
		Double icm = peso / (altura * altura);
		if(icm < 30.0) {
		   res = false;
		}
		return res;
	}
	
	private String calculaPercentual(int soma, int total) {
		String perc=" ";
		String s = " %";
		int i = (soma * 100) / total;
		perc = Integer.toString(i);
		perc = perc + s;	
		return perc;
	}

}

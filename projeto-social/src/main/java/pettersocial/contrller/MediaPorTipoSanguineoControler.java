package pettersocial.contrller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pettersocial.model.Mediaportiposanguineo;
import pettersocial.model.Pessoa;
import pettersocial.repository.Mediaporsangues;
import pettersocial.service.MediaporsangueService;

@Controller
public class MediaPorTipoSanguineoControler {
	
	@Autowired
	private MediaporsangueService ms;
	@Autowired
	private Mediaporsangues mediasporsangues;
	ModelAndView modelAndView;
	ArrayList<Pessoa> pes;
	ArrayList<String> tipo_sanguineo;
	ArrayList<Mediaportiposanguineo> media_por_tipo;
	private int count;
	
	@PostMapping("/buscaMedia")
	public String salvarMedia(RedirectAttributes redirectAttributes) {
		this.pes = new ArrayList<>(ms.getListPessoas());
		this.tipo_sanguineo = new ArrayList<>(ms.getListDistinctTipoSnguineo());
		this.media_por_tipo = new ArrayList<>();
		this.getListMediaPorTipoSanguineo();
		for(int i=0; i<this.media_por_tipo.size(); i++) {
			this.mediasporsangues.save(this.media_por_tipo.get(i));
		}
		return "redirect:/mostraMedia";
	}
	
	@GetMapping("/mostraMedia")
	public ModelAndView mostra(RedirectAttributes re) {
		 this.modelAndView = new ModelAndView("BuscaMedia");
		 modelAndView.addObject("mediasporsangues", mediasporsangues.findAll());
		return modelAndView;
	}
	
///////////////CRIA OBJETOS MEDIAPORTIPOSNAUINEO /////////////////////
	
	private void getListMediaPorTipoSanguineo(){
		int media=0;
		for(int i=0; i<this.tipo_sanguineo.size(); i++) {
			try {
				media = this.calculaMedia(this.tipo_sanguineo.get(i));
				Mediaportiposanguineo mt = new Mediaportiposanguineo();
				mt.setTiposangue(this.tipo_sanguineo.get(i));
				mt.setMediaidade(media);
				mt.setQuantidadeporsangue(this.count);
				this.media_por_tipo.add(mt);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	 ///////////////CALCULA MÉDIA /////////////////////
	
	private int calculaMedia(String tipo_sanguineo) throws ParseException {
		this.count =0;
		int idade =0;
		for(int i=0; i<this.pes.size(); i++) {
			if(this.pes.get(i).getTipo_sanguineo().equals(tipo_sanguineo)) {
				idade += this.calculaIdade(this.pes.get(i).getData_nasc());
				
				this.count +=1;
			}
		}
		return idade / this.count;
	}
	
       ///////////////CALCULA IDADE /////////////////////

	private int calculaIdade(String data) throws ParseException{
		int idade =0;
		Calendar cal = GregorianCalendar.getInstance();
		int datatual = cal.get(Calendar.YEAR);
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");	
		Date a = (Date)f.parse(data);
		GregorianCalendar nasci = new GregorianCalendar();
		nasci.setTime(a);
		int datanasc = nasci.get(Calendar.YEAR);
			idade = datatual - datanasc;
		return idade;
		}

}

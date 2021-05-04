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

import pettersocial.model.Pessoa;
import pettersocial.model.Possivel;
import pettersocial.repository.Possiveis;
import pettersocial.service.PossivelService;

@Controller
public class PossivelController {
	
	@Autowired
	private PossivelService ms;
	@Autowired
	private Possiveis possiveis;
	ModelAndView modelAndView;
	ArrayList<Pessoa> pes;
	ArrayList<String> tipo_sanguineo;
	
	
	@PostMapping("/buscaPossivel")
	public String salvarPossivel(RedirectAttributes redirectAttributes) {
		this.pes = new ArrayList<>(ms.getListPessoas());
		this.eliminaOsSemPeso();
		this.eliminaOsSemIdades();
		System.out.println(this.pes.size());
		this.tipo_sanguineo = new ArrayList<>(ms.getListDistinctTipoSnguineo());
		java.util.Collections.sort(this.tipo_sanguineo);
		this.tipo_sanguineo.forEach(System.out::println);
		this.criaObjetoPossiveisDoadores();
		return "redirect:/mostraPossivel";
	}
	
	@GetMapping("/mostraPossivel")
	public ModelAndView mostraPossivel(RedirectAttributes re) {
		 this.modelAndView = new ModelAndView("BuscaPossivel");
		 modelAndView.addObject("possiveis", possiveis.findAll());
		return modelAndView;
	}
	
	 ///////////////CRIA OBJETO POSSIVEIS/////////////////////
	
	private void criaObjetoPossiveisDoadores() {
		
		for(int i=0; i<this.tipo_sanguineo.size(); i++) {
			int total = this.calculaPossiveisDoadores2(this.tipo_sanguineo.get(i), this.pes);
			Possivel p = new Possivel();
			p.setTipo_sangue(this.tipo_sanguineo.get(i));
			p.setPosdoador(total);
			possiveis.save(this.preencheStringPossivel(p, this.tipo_sanguineo.get(i)));
		}
	}
	
     ///////////////PREENCHE STRING NO OBJETO /////////////////////
	
	private Possivel preencheStringPossivel(Possivel p, String tipo_sangue){
		String s0 = " A+ A- O+ O-";
		String s1 = "A- O-";
		String s2 = "B+ B- O+ O-";
		String s3 = "B- O-";
		String s4 = " A+ A- B+ B- O+ O- AB+ AB-";
		String s5 = "A- B- O- AB-";
		String s6 = "O+ O-";
		String s7 = "O-";
			if(p.getTipo_sangue().equals("A+")) {
			   p.setDoador(s0);
			}else if(p.getTipo_sangue().equals("A-")) {
				p.setDoador(s1);
			}else if(p.getTipo_sangue().equals("AB+")) {
				p.setDoador(s2);
			}else if(p.getTipo_sangue().equals("AB-")) {
				p.setDoador(s3);
			}else if(p.getTipo_sangue().equals("B+")) {
				p.setDoador(s4);
			}else if(p.getTipo_sangue().equals("B-")) {
				p.setDoador(s5);
			}else if(p.getTipo_sangue().equals("O+")) {
				p.setDoador(s6);
			}else {
				p.setDoador(s7);
			}
		return p;
	}
	
	 ///////////////CALCULA QUANTIDADE DOADORS /////////////////////
	
		private int calculaPossiveisDoadores2(String tipo_sanguineo, ArrayList<Pessoa> p) {
			int cont=0;
			for(int i=0; i<p.size(); i++) {
				if(tipo_sanguineo.equals("A+")) {
				if(p.get(i).getTipo_sanguineo().equals("A+") || p.get(i).getTipo_sanguineo().equals("A-")
						|| p.get(i).getTipo_sanguineo().equals("O+") || p.get(i).getTipo_sanguineo().equals("O-")) {
					cont += 1;
				}
				}else if(tipo_sanguineo.equals("A-")) {
						if(p.get(i).getTipo_sanguineo().equals("A-") || p.get(i).getTipo_sanguineo().equals("O-")) {
							cont +=1;
						}				
				}else if(tipo_sanguineo.equals("AB+")){
					if(p.get(i).getTipo_sanguineo().equals("B+") || p.get(i).getTipo_sanguineo().equals("B-")
							|| p.get(i).getTipo_sanguineo().equals("O+") || p.get(i).getTipo_sanguineo().equals("O-")) {
						cont +=1;
					}	
				}else if(tipo_sanguineo.equals("AB-")){
					if(p.get(i).getTipo_sanguineo().equals("B-") || p.get(i).getTipo_sanguineo().equals("O-")) {
						cont +=1;
					}
				}else if(tipo_sanguineo.equals("B+")){
					if(p.get(i).getTipo_sanguineo().equals("A+") || p.get(i).getTipo_sanguineo().equals("A-")
					   || p.get(i).getTipo_sanguineo().equals("AB+")|| p.get(i).getTipo_sanguineo().equals("AB-")
				       || p.get(i).getTipo_sanguineo().equals("B+") || p.get(i).getTipo_sanguineo().equals("B-")
					   || p.get(i).getTipo_sanguineo().equals("O+") || p.get(i).getTipo_sanguineo().equals("O-")){
					   cont +=1;
				}				
				}else if(tipo_sanguineo.equals("B-")){
					if(p.get(i).getTipo_sanguineo().equals("A-") || p.get(i).getTipo_sanguineo().equals("B-")
							|| p.get(i).getTipo_sanguineo().equals("O-") || p.get(i).getTipo_sanguineo().equals("AB-")) {
					cont +=1;
				}	
				}else if(tipo_sanguineo.equals("O+")){
					if(p.get(i).getTipo_sanguineo().equals("O+") || p.get(i).getTipo_sanguineo().equals("O-")) {
						cont +=1;
					}
				}else if(tipo_sanguineo.equals("O-")){
						if(p.get(i).getTipo_sanguineo().equals("O-")) { 
						cont +=1;
						}
				      }
					}
		return cont;
	}
		
   private ArrayList<Pessoa> eliminaOsSemPeso(){
	   for(int i=0; i<this.pes.size(); i++) {
				if(this.pes.get(i).getPeso() < 50) {
					System.out.println(this.pes.get(i).getPeso());
					 this.pes.remove(i);	 
				}
		 }
	   
	   return this.pes;
   }
		
  ///////////////ELIMINA DA LISTA QUEM NÃO TEM IDADE PARA DOAR/////////////////////
		
    private ArrayList<Pessoa> eliminaOsSemIdades(){
			 for(int i=0; i<this.pes.size(); i++) {
				 int idade;
				try {
					idade = this.calculaIdade(this.pes.get(i).getData_nasc());
					if(idade < 16 || idade > 69) {
						System.out.println(this.pes.get(i).getData_nasc());
						 this.pes.remove(i);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}	 
			 }
			
			return this.pes;
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

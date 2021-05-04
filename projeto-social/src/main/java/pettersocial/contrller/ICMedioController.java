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

import pettersocial.model.ICMedio;
import pettersocial.model.Pessoa;
import pettersocial.repository.ICMedios;
import pettersocial.service.ICMedioService;

@Controller
public class ICMedioController {
	
	@Autowired
	private ICMedios icmedios;
	@Autowired
	private ICMedioService icms;
	ModelAndView modelAndView;
	ArrayList<Pessoa> p;
	ArrayList<ICMedio> icmlist;
	
	@PostMapping("/buscaIcmedio")
	public String salvarICMedio(RedirectAttributes redirectAttributes) {
		this.p = icms.getListPessoa();
		try {
			this.getList(this.p);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		     for(int i=0; i<this.icmlist.size(); i++) {
		    	 ICMedio c = this.icmlist.get(i);
		try {
			   icmedios.save(c);
		}catch (IllegalArgumentException e) {
			e.getMessage().formatted("merda");
		}
		}
		return "redirect:/mostraIcmedio";
	}
	
	@GetMapping("/mostraIcmedio")
	public ModelAndView mostra(RedirectAttributes re) {
		 this.modelAndView = new ModelAndView("BuscaIcmedio");
		 modelAndView.addObject("icmedios", icmedios.findAll());
		return modelAndView;
	}
	
	///////////////RETORNA OBJETOS IMCMEDIO/////////////
	
	private void getList(ArrayList<Pessoa> p) throws ParseException {
		
		this.icmlist = new ArrayList<>();
		ICMedio d0 = new ICMedio();
		d0.setDecada("ATÉ DEZ ANOS");
		d0.setIcm(0.0);
		ICMedio d10 = new ICMedio();	
		d10.setDecada("ENTRE 11 e 20");
		d10.setIcm(0.0);
		ICMedio d20 = new ICMedio();
		d20.setDecada("ENTRE 21 e 30");
		d20.setIcm(0.0);
		ICMedio d30 = new ICMedio();
		d30.setDecada("ENTRE 31 e 40");
		d30.setIcm(0.0);
		ICMedio d40 = new ICMedio();
		d40.setDecada("ENTRE 41 e 50");
		d40.setIcm(0.0);
		ICMedio d50 = new ICMedio();
		d50.setDecada("ENTRE 51 e 60");
		d50.setIcm(0.0);
		ICMedio d60 = new ICMedio();
		d60.setDecada("ENTRE 61 e 70");
		d60.setIcm(0.0);
		ICMedio d70 = new ICMedio();
		d70.setDecada("ENTRE 71 e 80");
		d70.setIcm(0.0);
		ICMedio d80 = new ICMedio();
		d80.setDecada("ENTRE 81 e 90");
		d80.setIcm(0.0);
		ICMedio d90 = new ICMedio();
		d90.setDecada("ENTRE 91 e 100");
		d90.setIcm(0.0);
        
	    int soma0=0;
	    int soma10=0;
	    int soma20=0;
	    int soma30=0;
	    int soma40=0;
	    int soma50=0;
	    int soma60=0;
	    int soma70=0;
	    int soma80=0;
	    int soma90=0;
	    Double icm0 = 0.0;
	    Double icm10 = 0.0;
	    Double icm20 = 0.0;
	    Double icm30 = 0.0;
	    Double icm40 = 0.0;
	    Double icm50 = 0.0;
	    Double icm60 = 0.0;
	    Double icm70 = 0.0;
	    Double icm80 = 0.0;
	    Double icm90 = 0.0;
	    
		for(int i=0; i< p.size(); i++) {
			int idade = this.calculaIdade(p.get(i).getData_nasc());
			if(idade < 11) {
			   soma0 +=1;
			   d0.setIcm(d0.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
			   icm0 = d0.getIcm();
			}else if(idade < 21) {
				soma10 +=1;
				d10.setIcm(d10.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm10 = d10.getIcm();
			}else if(idade < 31) {
				soma20 +=1;
				d20.setIcm(d20.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm20 = d20.getIcm();
			}else if(idade < 41) {
				soma30 +=1;
				d30.setIcm(d30.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm30 = d30.getIcm();
			}else if(idade < 51) {
				soma40 +=1;
				d40.setIcm(d40.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm40 = d40.getIcm();
			}else if(idade < 61) {
				soma50 +=1;
				d50.setIcm(d50.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm50 = d50.getIcm();
			}else if(idade < 71 ) {
				soma60 +=1;
				d60.setIcm(d60.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm60 = d60.getIcm();
			}else if(idade < 81) {
				soma70 +=1;
				d70.setIcm(d70.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm70 = d70.getIcm();
			}else if(idade < 91 ) {
				soma80 +=1;
				d80.setIcm(d80.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm80 = d80.getIcm();
			}else if(idade < 100 ) {
				soma90 +=1;
				d90.setIcm(d90.getIcm() + (p.get(i).getPeso() / (p.get(i).getAltura() * p.get(i).getAltura())));
				icm90 = d90.getIcm();
			}
		}
		
		d0.setIcm(icm0 /soma0);
		System.out.println(soma0);
		d10.setIcm(icm10 /soma10);
		System.out.println(soma10);
		d20.setIcm(icm20 /soma20);
		System.out.println(soma20);
		d30.setIcm(icm30 /soma30);
		System.out.println(soma30);
		d40.setIcm(icm40 /soma40);
		System.out.println(soma40);
		d50.setIcm(icm50 /soma50);
		System.out.println(soma50);
		d60.setIcm(icm60 /soma60);
		System.out.println(soma60);
		d70.setIcm(icm70 /soma70);
		System.out.println(soma70);
		d80.setIcm(icm80 /soma80);
		System.out.println(soma80);
		d90.setIcm(icm90 /soma90);
		System.out.println(soma90);
	
		this.icmlist.add(d0);
		this.icmlist.add(d10);
		this.icmlist.add(d20);
		this.icmlist.add(d30);
		this.icmlist.add(d40);
		this.icmlist.add(d50);
		this.icmlist.add(d60);
		this.icmlist.add(d70);
		this.icmlist.add(d80);
		this.icmlist.add(d90);
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

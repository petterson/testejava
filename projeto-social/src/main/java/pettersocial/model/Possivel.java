package pettersocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Possivel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo_sangue;
	private int posdoador;
	private String doador; 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo_sangue() {
		return tipo_sangue;
	}
	public void setTipo_sangue(String tipo_sangue) {
		this.tipo_sangue = tipo_sangue;
	}
	public int getPosdoador() {
		return posdoador;
	}
	public void setPosdoador(int posdoador) {
		this.posdoador = posdoador;
	}
	
	public String getDoador() {
		return doador;
	}
	public void setDoador(String doador) {
		this.doador = doador;
	}
	@Override
	public String toString() {
		return "Possivel [id=" + id + ", tipo_sangue=" + tipo_sangue + ", posdoador=" + posdoador + ", doador=" + doador
				+ ", getId()=" + getId() + ", getTipo_sangue()=" + getTipo_sangue() + ", getPosdoador()="
				+ getPosdoador() + ", getDoador()=" + getDoador() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}

package pettersocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ICMedio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String decada;
	private Double icm;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDecada() {
		return decada;
	}
	public void setDecada(String decada) {
		this.decada = decada;
	}
	
	public Double getIcm() {
		return icm;
	}
	public void setIcm(Double icm) {
		this.icm = icm;
	}
	@Override
	public String toString() {
		return "ICMedio [id=" + id + ", decada=" + decada + ", icm=" + icm + ", getId()=" + getId() + ", getDecada()="
				+ getDecada() + ", getIcm()=" + getIcm() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}

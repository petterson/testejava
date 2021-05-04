package pettersocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Obeso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String homoumul;
	private String percentual;
	private int quantidade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHomoumul() {
		return homoumul;
	}
	public void setHomoumul(String homoumul) {
		this.homoumul = homoumul;
	}
	public String getPercentual() {
		return percentual;
	}
	public void setPercentual(String percentual) {
		this.percentual = percentual;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "PercentualObeso [id=" + id + ", homoumul=" + homoumul + ", percentual=" + percentual + ", quantidade="
				+ quantidade + ", getId()=" + getId() + ", getHomoumul()=" + getHomoumul() + ", getPercentual()="
				+ getPercentual() + ", getQuantidade()=" + getQuantidade() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

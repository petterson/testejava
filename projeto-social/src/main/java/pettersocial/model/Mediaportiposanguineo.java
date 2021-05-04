package pettersocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mediaportiposanguineo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tiposangue;
	private int  mediaidade;
	private int quantidadeporsangue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTiposangue() {
		return tiposangue;
	}
	public void setTiposangue(String tiposangue) {
		this.tiposangue = tiposangue;
	}
	public int getMediaidade() {
		return mediaidade;
	}
	public void setMediaidade(int mediaidade) {
		this.mediaidade = mediaidade;
	}
	public int getQuantidadeporsangue() {
		return quantidadeporsangue;
	}
	public void setQuantidadeporsangue(int quantidadeporsangue) {
		this.quantidadeporsangue = quantidadeporsangue;
	}
	@Override
	public String toString() {
		return "Mediaportiposanguineo [id=" + id + ", tiposangue=" + tiposangue + ", mediaidade=" + mediaidade
				+ ", quantidadeporsangue=" + quantidadeporsangue + ", getId()=" + getId() + ", getTiposangue()="
				+ getTiposangue() + ", getMediaidade()=" + getMediaidade() + ", getQuantidadeporsangue()="
				+ getQuantidadeporsangue() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}

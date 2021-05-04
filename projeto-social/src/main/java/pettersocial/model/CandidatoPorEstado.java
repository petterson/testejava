package pettersocial.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CandidatoPorEstado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private int quantCandidato;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantCandidato() {
		return quantCandidato;
	}
	public void setQuantCandidato(int quantCandidato) {
		this.quantCandidato = quantCandidato;
	}
	@Override
	public String toString() {
		return "CandidatoPorEstado [id=" + id + ", nome=" + nome + ", quantCandidato=" + quantCandidato + ", getId()="
				+ getId() + ", getNome()=" + getNome() + ", getQuantCandidato()=" + getQuantCandidato()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}

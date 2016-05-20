package br.dagostini.persistencia.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SETOR")
public class Setor {

	@Id
	@GeneratedValue
	@Column(name = "setor_id")
	private Long id;

	@Column(name = "setor_nome")
	private String nome;

	@OneToMany(mappedBy = "setor", targetEntity = Empregado.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Empregado> empregados;

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

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

}

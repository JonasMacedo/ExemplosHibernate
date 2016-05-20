package br.dagostini.persistencia.onetomany;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="EMPREGADO")
public class Empregado {

	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private Long id;

	@Column(name="EMP_NOME")
	private String nome;

	@Column(name="EMP_SOBRENOME")
	private String sobrenome;

	@Column(name="EMP_NASCIMENTO")
	private Date dataNascimento;

	@Column(name="EMP_CELULAR")
	private String celular;

	@ManyToOne
	@JoinColumn(name="SETOR_ID")
	private Setor setor;

	public Empregado(String _nome, String _sobrenome, String _celular) {
		this.nome = _nome;
		this.sobrenome = _sobrenome;
		this.celular = _celular;
	}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}

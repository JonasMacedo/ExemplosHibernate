package br.dagostini.comum;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "colab_nome")
	private String nome;

	@Column(name = "colab_sobrenome")
	private String sobrenome;

	@Column(name = "colab_aniversario")
	private Date aniversario;

	@Column(name = "colab_celular")
	private String celular;

	public Colaborador() {

	}

	public Colaborador(String nome, String sobrenome, Date aniversario, String celular) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.aniversario = aniversario;
		this.celular = celular;
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

	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", aniversario=" + aniversario
				+ ", celular=" + celular + "]";
	}

}

package br.com.projetoWEB.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.projetoWEB.model.enumerated.FaixaDeGraduacao;
import br.com.projetoWEB.model.enumerated.Sexo;
import br.com.projetoWEB.model.enumerated.Status;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 411211519375977329L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "CPF")
	private String CPF;

	@Column(name = "IDADE")
	private int idade;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco = new Endereco();

	@Enumerated(EnumType.STRING)
	@Column(name = "FAIXA_DE_GRADUACAO")
	private FaixaDeGraduacao faixaDeGraduacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "SEXO")
	private Sexo sexo;

	@Column(name = "NOME_RESPONSAVEL")
	private String nomeResponsavel;

	@Column(name = "TELEFONE_RESPONSAVEL")
	private String telefoneDoResponsavel;

	@Column(name = "NOME_ALUNO")
	private String nomeAluno;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		this.CPF = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public FaixaDeGraduacao getFaixaDeGraduacao() {
		return faixaDeGraduacao;
	}

	public void setFaixaDeGraduacao(FaixaDeGraduacao faixaDeGraduacao) {
		this.faixaDeGraduacao = faixaDeGraduacao;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getTelefoneDoResponsavel() {
		return telefoneDoResponsavel;
	}

	public void setTelefoneDoResponsavel(String telefoneDoResponsavel) {
		this.telefoneDoResponsavel = telefoneDoResponsavel;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

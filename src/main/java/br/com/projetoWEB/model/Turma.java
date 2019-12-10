package br.com.projetoWEB.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.projetoWEB.model.enumerated.FaixaDeGraduacao;

@Entity
@Table(name = "TURMA")
public class Turma implements Serializable {

	private static final long serialVersionUID = -2300528889780644315L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME_TURMA")
	private String nomeDaTurma;

	@Column(name = "FAIXA_DE_GRADUACAO")
	@Enumerated(EnumType.STRING)
	private FaixaDeGraduacao faixaDeGraduacaoDaTurma;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "DIAS_DA_SEMANA_TURMA", joinColumns = @JoinColumn(name = "TURMA_ID"), inverseJoinColumns = @JoinColumn(name = "DIAS_DA_SEMANA_ID"))
	private List<DiasDaSemana> diasDaSemana = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TURMA_ALUNO", joinColumns = @JoinColumn(name = "TURMA_ID"), inverseJoinColumns = @JoinColumn(name = "ALUNO_ID"))
	private List<Aluno> alunos = new ArrayList<>();

	@Column(name = "MINIMO_ALUNOS")
	private int minimoDeAlunos;

	@Column(name = "MAXIMO_ALUNOS")
	private int maximoDeAlunos;

	@Column(name = "IDADE_MINIMA_ALUNO")
	private int idadeMinimaDosAlunos;

	@Column(name = "IDADE_MAXIMA_ALUNO")
	private int idadeMaximaDosAlunos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDaTurma() {
		return nomeDaTurma;
	}

	public void setNomeDaTurma(String nomeDaTurma) {
		this.nomeDaTurma = nomeDaTurma;
	}

	public FaixaDeGraduacao getFaixaDeGraduacaoDaTurma() {
		return faixaDeGraduacaoDaTurma;
	}

	public void setFaixaDeGraduacaoDaTurma(FaixaDeGraduacao faixaDeGraduacaoDaTurma) {
		this.faixaDeGraduacaoDaTurma = faixaDeGraduacaoDaTurma;
	}

	public List<DiasDaSemana> getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(List<DiasDaSemana> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public int getMinimoDeAlunos() {
		return minimoDeAlunos;
	}

	public void setMinimoDeAlunos(int minimoDeAlunos) {
		this.minimoDeAlunos = minimoDeAlunos;
	}

	public int getMaximoDeAlunos() {
		return maximoDeAlunos;
	}

	public void setMaximoDeAlunos(int maximoDeAlunos) {
		this.maximoDeAlunos = maximoDeAlunos;
	}

	public int getIdadeMinimaDosAlunos() {
		return idadeMinimaDosAlunos;
	}

	public void setIdadeMinimaDosAlunos(int idadeMinimaDosAlunos) {
		this.idadeMinimaDosAlunos = idadeMinimaDosAlunos;
	}

	public int getIdadeMaximaDosAlunos() {
		return idadeMaximaDosAlunos;
	}

	public void setIdadeMaximaDosAlunos(int idadeMaximaDosAlunos) {
		this.idadeMaximaDosAlunos = idadeMaximaDosAlunos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Turma [id=" + getId() + ", nomeDaTurma=" + nomeDaTurma + ", faixaDeGraduacaoDaTurma="
				+ faixaDeGraduacaoDaTurma + ", diasDaSemana=" + diasDaSemana + ", minimoDeAlunos=" + minimoDeAlunos
				+ ", maximoDeAlunos=" + maximoDeAlunos + ", idadeMinimaDosAlunos=" + idadeMinimaDosAlunos
				+ ", idadeMaximaDosAlunos=" + idadeMaximaDosAlunos + "]";
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
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

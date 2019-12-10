package br.com.projetoWEB.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FREQUENCIA")
public class FrequenciaAula implements Serializable {

	private static final long serialVersionUID = 5344281560915634162L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "TRUMA")
	private Turma turma;

	@Column(name = "DATA_DA_FREQUENCIA")
	private Date dataDaFrequencia = new Date();

	@Column(name = "ANOTACOES")
	@Lob
	private String anotacoes;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name = "FREQUENCIA_ID"), inverseJoinColumns = @JoinColumn(name = "ALUNO_ID"))
	private List<Aluno> alunosFrequentes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Date getDataDaFrequencia() {
		return dataDaFrequencia;
	}

	public void setDataDaFrequencia(Date dataDaFrequencia) {
		this.dataDaFrequencia = dataDaFrequencia;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public List<Aluno> getAlunosFrequentes() {
		return alunosFrequentes;
	}

	public void setAlunosFrequentes(List<Aluno> alunosFrequentes) {
		this.alunosFrequentes = alunosFrequentes;
	}

	@Override
	public String toString() {
		return "FrequenciaAula [id=" + getId() + ", turma=" + turma + ", dataDaFrequencia=" + dataDaFrequencia
				+ ", anotacoes=" + anotacoes + ", alunosFrequentes=" + alunosFrequentes + "]";
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
		FrequenciaAula other = (FrequenciaAula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

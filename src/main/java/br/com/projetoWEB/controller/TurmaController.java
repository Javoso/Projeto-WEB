package br.com.projetoWEB.controller;

import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.projetoWEB.dao.GenericDAO;
import br.com.projetoWEB.model.Aluno;
import br.com.projetoWEB.model.DiasDaSemana;
import br.com.projetoWEB.model.Turma;
import br.com.projetoWEB.model.enumerated.FaixaDeGraduacao;
import br.com.projetoWEB.util.jsf.FacesUtil;

@Named
@ViewScoped
public class TurmaController implements Serializable {

	private static final long serialVersionUID = -2437633336322408321L;

	private Long idTurma;
	private Turma turma;
	private Aluno aluno;

	private List<Aluno> alunos = new ArrayList<>();

	private List<DiasDaSemana> diasDaSemana = new ArrayList<>();


	@Inject
	private GenericDAO<Turma> daoTurma;
	
	@Inject
	private GenericDAO<DiasDaSemana> daoDiasDaSemana;

	@Inject
	private GenericDAO<Aluno> daoAluno;

	public TurmaController() {
	}

	@PostConstruct
	public void iniciar() {
		this.turma = new Turma();
		this.aluno = new Aluno();
		this.alunos = daoAluno.findAll(Aluno.class);
		this.diasDaSemana = daoDiasDaSemana.findAll(DiasDaSemana.class);
	}

	public void prepararParaEditar() {
		if (idTurma != null) {
			turma = daoTurma.findById(Turma.class, idTurma);
		}
	}

	public void cadastrar() {
		if (StringUtils.isNotBlank(this.turma.getNomeDaTurma())) {
			daoTurma.salvar(this.turma);
			FacesUtil.addMensagem().info("Cadastrado com sucesso!").para("msg");
		} else {
			FacesUtil.addMensagem().error("", "", "Erro ao concluir cadastrado").para("msg");
		}
		this.turma = new Turma();
	}

	public void adicionarAlunoNaTurma(Aluno aluno) {
		if (nonNull(aluno)) {
			if (!turma.getAlunos().contains(aluno)) {
				turma.getAlunos().add(aluno);
			}
		}
	}

	public List<Turma> getTurmas() {
		return daoTurma.findAll(Turma.class);
	}

	public FaixaDeGraduacao[] getFaixasGraduacao() {
		return FaixaDeGraduacao.values();
	}

	public void excluir() {
		daoTurma.remover(Turma.class, turma.getId());
		FacesUtil.addMensagem().warn("Excluído com sucesso!").para("msg");
		this.turma = new Turma();

	}

	public String editar() {
		if (StringUtils.isNotBlank(this.turma.getNomeDaTurma())) {
			daoTurma.editar(turma);
			FacesUtil.addMensagem().info("Editado com sucesso!").para("msg").mantendoMensagemAposRedirect();
			turma = new Turma();
		}
		return "/pages/exibir/turmas?faces-redirect=true";
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idAtor) {
		this.idTurma = idAtor;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<DiasDaSemana> getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(List<DiasDaSemana> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
}

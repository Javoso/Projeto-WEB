package br.com.projetoWEB.controller;

import static java.util.Objects.nonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.projetoWEB.dao.GenericDAO;
import br.com.projetoWEB.model.Ator;
import br.com.projetoWEB.model.Filme;
import br.com.projetoWEB.model.Genero;

@Named
@RequestScoped
public class GraficoController implements Serializable {
	private static final long serialVersionUID = 4114036487780506154L;

	private BarChartModel modelBar = new BarChartModel();

	private PieChartModel pieModel = new PieChartModel();

	private PieChartModel pieModel2 = new PieChartModel();

	private Ator ator = new Ator();

	private Genero genero;

	private Filme filme = new Filme();

	private List<Filme> filmes = new ArrayList<>();

	@Inject
	private GenericDAO<Filme> filmeDao = new GenericDAO<>();

	@Inject
	private GenericDAO<Ator> atorDao = new GenericDAO<>();

	@Inject
	private GenericDAO<Genero> generoDao = new GenericDAO<>();

	public void preRender() {
		initPieModel("Informações");
		initModel("Informações");
		genero = new Genero();
	}

	public void selectGenero() {
		adcionarValue("Atores por Filme");
	}

	private void adcionarValue(String titulo) {
		ChartSeries serie = new ChartSeries(titulo);
		if (nonNull(ator.getId())) {
		}
		if (nonNull(genero.getId())) {
			filmes = filmeDao.findByAtributeList(Filme.class, "genero", genero);
		}
		if (nonNull(filmes)) {
			for (Filme filme : filmes) {
				serie.setLabel(filme.getNome());
				serie.set(filme.getNome(), filme.getAtores().size());
			}
			this.modelBar.setTitle(titulo);
			this.modelBar.setLegendLabel("Filmes");
			this.modelBar.setAnimate(true);
			this.modelBar.addSeries(serie);
			this.modelBar.setShowPointLabels(true);
			this.modelBar.setShowDatatip(true);
		} else {
			serie.set("1", Math.random() * 1000);
			serie.set("2", Math.random() * 1000);
			serie.set("3", Math.random() * 1000);
			serie.set("4", Math.random() * 1000);
			serie.set("5", Math.random() * 1000);
			serie.set("6", Math.random() * 1000);
			serie.set("7", Math.random() * 1000);
			serie.set("8", Math.random() * 1000);
			serie.set("9", Math.random() * 1000);
			serie.set("10", Math.random() * 1000);
			this.modelBar.setAnimate(true);
			this.modelBar.setShowPointLabels(true);
			this.modelBar.setShowDatatip(true);
			this.modelBar.addSeries(serie);
		}
	}

	private void initPieModel(String rotulo) {
		for (Genero genero : generoDao.findAll(Genero.class)) {
			pieModel.set(genero.getNome(), filmeDao.findByAtributeList(Filme.class, "genero", genero).size());
		}
		pieModel.setLegendPosition("e");
		pieModel.setFill(false);
		pieModel.setShowDataLabels(true);
		pieModel.setDiameter(150);
		pieModel.setShadow(false);
		pieModel.setTitle(rotulo);
	}

	private void initModel(String rotulo) {
		for (Genero genero : generoDao.findAll(Genero.class)) {
			pieModel2.set(genero.getNome(), filmeDao.findByAtributeList(Filme.class, "genero", genero).size());
		}
		pieModel2.setLegendPosition("w");
		pieModel2.setFill(false);
		pieModel2.setShowDataLabels(true);
		pieModel2.setDiameter(150);
		pieModel2.setShadow(false);
		pieModel2.setTitle(rotulo);
	}

	public BarChartModel getModelBar() {
		return modelBar;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}

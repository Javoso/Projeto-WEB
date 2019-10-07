package br.com.projetoWEB.model;

public enum Sexo {
	
	MASCULINO("masculino"), FEMININO("feminino");

	private String sexo;

	Sexo(String sexo ) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}
}

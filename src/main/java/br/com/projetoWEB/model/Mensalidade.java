package br.com.projetoWEB.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MENSALIDADE")
public class Mensalidade implements Serializable {

	private static final long serialVersionUID = -6822720094841323764L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "VALOR_MENSALIDADE")
	private BigDecimal valor;
	@Column(name = "CICLO_PAGAMENTO")
	private String cicloPagamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCicloPagamento() {
		return cicloPagamento;
	}

	public void setCicloPagamento(String cicloPagamento) {
		this.cicloPagamento = cicloPagamento;
	}

	@Override
	public String toString() {
		return "Mensalidade [id=" + getId() + ", valor=" + valor
				+ ", cicloPagamento=" + cicloPagamento + "]";
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
		Mensalidade other = (Mensalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

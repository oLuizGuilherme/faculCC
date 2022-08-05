package avaliacaoDiagnostica;

import java.math.BigDecimal;

public class Vendedor {

	private String nome;
	private BigDecimal salarioBase;
	private Integer tempoServico;
	private Categoria categoria;
	private BigDecimal totalVendas;

	public Vendedor() {
	}
	
	public Vendedor(String nome, Integer tempoServico,
			BigDecimal totalVendas) {
		this.nome = nome;
		this.salarioBase = new BigDecimal(1500);
		this.setCategoria();
		this.tempoServico = tempoServico;
		this.totalVendas = totalVendas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(BigDecimal salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Integer getTempoServico() {
		return tempoServico;
	}

	public void setTempoServico(Integer tempoServico) {
		this.tempoServico = tempoServico;
		this.setCategoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	private void setCategoria() {
		if (tempoServico > 60) {
			this.categoria = Categoria.A;
		} else if (tempoServico > 30) {
			this.categoria = Categoria.B;
		} else {
			this.categoria = Categoria.C;
		}
	}

	public BigDecimal getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(BigDecimal totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public BigDecimal comissao() {
		if (totalVendas.compareTo(new BigDecimal(20000)) > 0) {
			return totalVendas.multiply(new BigDecimal(0.2));
		} else if (totalVendas.compareTo(new BigDecimal(10000)) > 0){
			return totalVendas.multiply(new BigDecimal(0.15));
		} else {
			return totalVendas.multiply(new BigDecimal(0.05));
		}
	}
	
	public BigDecimal gratificacao() {
		if (categoria.equals(Categoria.A)) {
			return salarioBase.multiply(new BigDecimal(0.15));
		} else if (categoria.equals(Categoria.B)) {
			return salarioBase.multiply(new BigDecimal(0.075));
		} else {
			return new BigDecimal(0);
		}
	}
	
	public BigDecimal salario() {
		return salarioBase.add(comissao()).add(gratificacao());
	}

}

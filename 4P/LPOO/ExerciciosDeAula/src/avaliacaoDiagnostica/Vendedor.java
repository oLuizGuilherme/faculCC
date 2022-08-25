package avaliacaoDiagnostica;

import java.math.BigDecimal;

public class Vendedor {

	private String nome;
	private static BigDecimal salarioBase = new BigDecimal(1500);
	private Integer tempoServico;
	private Categoria categoria;
	private BigDecimal totalVendas;

	public Vendedor() {
	}

	public Vendedor(String nome, Integer tempoServico, BigDecimal totalVendas) {
		this.nome = nome;
		this.tempoServico = tempoServico;
		this.setCategoria();
		this.totalVendas = totalVendas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static BigDecimal getSalarioBase() {
		return salarioBase;
	}

	public static void setSalarioBase(BigDecimal salarioBase){
		Vendedor.salarioBase = salarioBase;
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
		return "Nome: " + nome + " | Salário: " + salario();
	}

	public BigDecimal comissao() {
		if (totalVendas.compareTo(BigDecimal.valueOf(20000)) > 0) {
			return totalVendas.multiply(BigDecimal.valueOf(0.2));
		} else if (totalVendas.compareTo(BigDecimal.valueOf(10000)) > 0) {
			return totalVendas.multiply(BigDecimal.valueOf(0.15));
		} else {
			return totalVendas.multiply(BigDecimal.valueOf(0.05));
		}
	}

	public BigDecimal gratificacao() {
		if (categoria.equals(Categoria.A)) {
			return salarioBase.multiply(BigDecimal.valueOf(0.15));
		} else if (categoria.equals(Categoria.B)) {
			return salarioBase.multiply(BigDecimal.valueOf(0.075));
		} else {
			return new BigDecimal(0);
		}
	}

	public BigDecimal salario() {
		return salarioBase.add(comissao()).add(gratificacao());
	}

}

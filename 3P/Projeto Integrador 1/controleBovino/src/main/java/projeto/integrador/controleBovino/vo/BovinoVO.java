package projeto.integrador.controleBovino.vo;

import java.math.BigDecimal;
import java.time.LocalDate;

import projeto.integrador.controleBovino.modelo.Bovino;

public class BovinoVO {

	private String codigo;
	private Double litrosLeite;
	private Double quilosRacao;
	private BigDecimal peso;
	private LocalDate nascimento;
	private Boolean abatido;

	public BovinoVO() {
	}

	public BovinoVO(String codigo, Double litrosLeite, Double quilosRacao, BigDecimal peso,
			LocalDate nascimento, Boolean abatido) {
		this.codigo = codigo;
		this.litrosLeite = litrosLeite;
		this.quilosRacao = quilosRacao;
		this.peso = peso;
		this.nascimento = nascimento;
		this.abatido = abatido;
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getLitrosLeite() {
		return litrosLeite;
	}

	public Double getQuilosRacao() {
		return quilosRacao;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setLitrosLeite(Double litrosLeite) {
		this.litrosLeite = litrosLeite;
	}

	public void setQuilosRacao(Double quilosRacao) {
		this.quilosRacao = quilosRacao;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public Boolean isAbatido() {
		return abatido;
	}
	
	public void setAbatido(Boolean abatido) {
		this.abatido = abatido;
	}

	public static BovinoVO entityToVO(Bovino bovino) {
		return new BovinoVO(bovino.getCodigo(), bovino.getLitrosLeite(), bovino.getQuilosRacao(), bovino.getPeso(), bovino.getNascimento(), bovino.isAbatido());
	}

}

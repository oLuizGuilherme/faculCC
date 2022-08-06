package avaliacaoDiagnostica;

import java.math.BigDecimal;

public class VetVendedor {

	private Vendedor[] vet;
	private int nElem;

	public VetVendedor() {
		vet = new Vendedor[10];
		nElem = 0;
	}

	public int getnElem() {
		return nElem;
	}

	public Vendedor getVendedor(int i) {
		if (i => nElem || i < 0)
			return null;
		return vet[i];
	}

	public int pesquisa(String nome) {
		for (int i = 0; i < nElem; i++) {
			if (vet[i].getNome().equalsIgnoreCase(nome)) {
				return i;
			}
		}
		return -1;
	}

	private boolean eCheia() {
		return nElem == vet.length;
	}

	public int insere(Vendedor vendedor) {
		if (pesquisa(vendedor.getNome()) != -1)
			return -2;

		if (eCheia())
			return -1;

		vet[nElem] = vendedor;
		nElem++;
		return 0;
	}

	public boolean remove(String nome) {
		int pesquisa = pesquisa(nome);
		if (pesquisa == -1)
			return false;

		vet[pesquisa] = vet[nElem-1];
		nElem--;

		return true;
	}

	public BigDecimal totalVendas(Categoria categoria) {
		BigDecimal totalVendasCategoria = new BigDecimal(0);
		for (int i = 0; i < nElem; i++) {
			if (vet[i].getCategoria().equals(categoria)) {
				totalVendasCategoria.add(vet[i].getTotalVendas());
			}
		}
		return totalVendasCategoria;
	}
	
	public int quantVendedor(Categoria categoria) {
		int quantVendedorCategoria = 0;
		for (int i = 0; i < nElem; i++) {
			if (vet[i].getCategoria().equals(categoria)) {
				quantVendedorCategoria++;
			}
		}
		return quantVendedorCategoria;
	}
	
	public BigDecimal mediaVendas(Categoria categoria) {
		return totalVendas(categoria) / quantVendedor(categoria);
	}

}

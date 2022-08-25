package avaliacaoDiagnostica;

import java.math.BigDecimal;

import io.InOut;

public class AppEmpresa {

	private static VetVendedor vetor;
	private static String menuTxt = "Selecine uma opção.\n1 - Cadastrar vendedor.\n2 - Imprimir folha de pagamento.\n3 - Imprimir Média de Vendas por Categoria.\n4 - Sair.";

	public static void main(String[] args) {

		vetor = new VetVendedor();

		menu();

	}

	private static void menu() {
		int opt;
		do {
			opt = InOut.leInt(menuTxt);
			switch (opt) {
			case 1:
				cadastrar();
				break;
			case 2:
				imprimirFolhaPagamento();
				break;
			case 3:
				imprimirMediaVendasPorCategoria();
				break;
			case 4:
				InOut.msgDeInformacao("FECHANDO", "Fechando o role");
				break;
			default:
				System.out.println("Segura la niña");
			}
		} while (opt != 4);
	}

	private static void cadastrar() {
		String nome = InOut.leString("Informe o nome do vendedor.");
		int tempoServico = InOut.leInt("Informe o tempo de serviço do vendedor.");
		BigDecimal totalVendas = new BigDecimal(InOut.leDouble("Informe o total de vendas do vendedor."));
		Vendedor vendedor = new Vendedor(nome, tempoServico, totalVendas);
		String erros = inserir(vendedor);
		if (erros.length() > 0)
			InOut.msgDeErro("ERRO", erros);
	}

	private static String inserir(Vendedor vendedor) {
		String erros = "";
		int resposta = vetor.insere(vendedor);
		if (resposta == -1) {
			erros = "Não foi possível inserir o vendedor, pois a lista está cheia.";
		} else if (resposta == -2) {
			erros = "Não foi possível inserir o vendedor, pois já existe um vendedor com o mesmo nome na lista.";
		}
		return erros;
	}

	private static void imprimirFolhaPagamento() {
		BigDecimal totalSalarios = new BigDecimal(0);
		String folhaPagamentoTxt = "";
		for (int i = 0; i < vetor.getnElem(); i++) {
			folhaPagamentoTxt += vetor.getVendedor(i) + "\n";
			totalSalarios.add(vetor.getVendedor(i).salario());
		}
		folhaPagamentoTxt += "Total dos salários: " + totalSalarios;

		InOut.msgDeInformacao("FOLHA DE PAGAMENTOS", folhaPagamentoTxt);
	}

	private static void imprimirMediaVendasPorCategoria() {

		char categoria = InOut.leChar("Digite a letra correspondente à categoria que deseja saber a média de vendas.");
		Character.toUpperCase(categoria);
		switch (categoria) {
		case 'A':
			InOut.msgDeInformacao("Média de vendas da categoria A", vetor.mediaVendas(Categoria.A).toString());
			break;
		case 'B':
			InOut.msgDeInformacao("Média de vendas da categoria B", vetor.mediaVendas(Categoria.B).toString());
			break;
		case 'C':
			InOut.msgDeInformacao("Média de vendas da categoria C", vetor.mediaVendas(Categoria.C).toString());
			break;
		default: 
			
		}

	}

}
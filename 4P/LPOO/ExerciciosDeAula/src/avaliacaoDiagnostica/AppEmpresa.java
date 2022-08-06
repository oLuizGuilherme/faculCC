package avaliacaoDiagnostica;

public class AppEmpresa {

    private static VetVendedor vetor;
    private static String menuTxt = "Selecine uma opção.\n1 - Cadastrar vendedor.\n2 - Imprimir folha de pagamento\n3 - Sair";

    public static void main(String[] args) {

        vetor = new VetVededor();

        menu();

    }

    private static void menu() {

        do {
            int opt = InOut.leInt(menuTxt);
            switch (opt) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    imprimirFolhaPagamento();
                    break;
                case 3:
                    InOut.msgDeInformacao("Fechando o role");
                    break;
                default:
                    System.out.println("Segura la niña");
            }
        } while (opt != 3)
    }

    private static void cadastrar() {
        String nome = InOut.leString("Informe o nome do vendedor.");
        int tempoServico = InOut.leInt("Informe o tempo de serviço do vendedor.");
        BigDecimal totalVendas = new BigDecimal(InOut.leDouble("Informe o total de vendas do vendedor."));
        Vendedor vendedor = new Vendedor(nome, tempoServico, totalVendas);
        String erros = inserir(vendedor);
        if (erros.lenght() > 0)
            InOut.msgDeErro(erros);
    }

    private static String inserir(Vendedor vendedor) {
        String erros = "";
        int resposta = vetor.insere(vendedor);
        if (resposta == -1) {
            erros = "Não foi possível inserir o vendedor, pois a lista está cheia.";
        } else if (respota == -2) {
            erros = "Não foi possível inserir o vendedor, pois já existe um vendedor com o mesmo nome na lista.";
        }
    }

    private static void imprimirFolhaPagamento() {
        BigDecimal totalSalarios = new BigDecimal(0);
        for (int i = 0; i < vetor.getNElem(); i++) {
            System.out.println(vetor[i]);
            totalSalarios.add(vetor[i].salario());
        }

        System.out.println("Total dos salários: " + totalSalarios);

        System.out.println(vetor.media(Categoria.A));
        System.out.println(vetor.media(Categoria.B));
        System.out.println(vetor.media(Categoria.C));

    }

}
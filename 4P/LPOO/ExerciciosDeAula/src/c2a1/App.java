package c2a1;

import java.util.ArrayList;

import io.InOut;

public class App {

	public static void main(String[] args) {

		ArrayList<Conta> banco = new ArrayList<>();

		menu(banco);

	}

	private static void menu(ArrayList<Conta> banco) {

		String menu = "1 - Cadastrar conta.\n2 - Saldo.\n3 - Saque.\n4 - Depósito.\n5 - Transferência.\n6 - Sair.";
		int opcao = 0;

		do {
			opcao = InOut.leInt(menu);
			switch (opcao) {

			case 1:
				cadastrarConta(banco);
				break;

			case 2:
				saldo(banco);
				break;

			case 3:
				saque(banco);
				break;

			case 4:
				deposito(banco);
				break;

			case 5:
				transferencia(banco);
				break;

			case 6:
				break;

			default:
				break;

			}

		} while (opcao != 6);
	}

	private static void cadastrarConta(ArrayList<Conta> banco) {
		Conta conta = null;

		int tipoConta = InOut
				.leInt("Informe o tipo de conta que deseja inserir.\n1 - Conta simples.\n2 - Conta Especial.");
		if (tipoConta == 1) {
			conta = inserirContaComum();
		} else if (tipoConta == 2) {
			conta = inserirContaEspecial();
		} else {
			return;
		}

		if (conta == null)
			return;

		boolean existe = false;

		for (Conta c : banco) {
			if (c.getNumero() == conta.getNumero()) {
				existe = true;
				break;
			}
		}

		if (existe) {
			InOut.msgDeAviso("CADASTRO NÃO EFETUADO",
					"Cadastro inválido. Némero de conta " + conta.getNumero() + " existente.");
		} else {
			banco.add(conta);
			InOut.msgDeInformacao("CADASTRO EFETUADO", "A conta " + conta.getNumero() + " foi cadastrada com sucesso.");
		}
	}

	private static Conta inserirContaComum() {
		String nome = InOut.leString("Nome:\n");
		String cpf = InOut.leString("CPF:\n");
		int numeroConta = InOut.leInt("Número da conta:\n");
		double valorConta = InOut.leDouble("Valor da conta:\n");
		return new Conta(nome, cpf, numeroConta, valorConta);
	}

	private static Conta inserirContaEspecial() {
		String nome = InOut.leString("Nome:\n");
		String cpf = InOut.leString("CPF:\n");
		int numeroConta = InOut.leInt("Número da conta:\n");
		double valorConta = InOut.leDouble("Valor da conta:\n");
		double limite = InOut.leDouble("Limite da conta:\n");
		return new ContaEspecial(nome, cpf, numeroConta, valorConta, limite);
	}

	// tratando todas as contas como contas especiais ent�o
	// esta pegando o saldo e somando com o limite
	private static void saldo(ArrayList<Conta> banco) {
		int numeroConta = InOut.leInt("Informe o número da conta:\n");
		Conta conta = null;

		for (Conta c : banco) {
			if (c.getNumero() == numeroConta) {
				conta = c;
				break;
			}
		}

		if (conta != null) {
			InOut.msgDeInformacao("SALDO", "O saldo da conta " + numeroConta + " é " + conta.saldo() + ".");
		} else {
			InOut.msgDeAviso("SALDO INDISPONÍVEL", "Conta inexistente. Não foi possível visualizar o saldo.");
		}
	}

	private static void saque(ArrayList<Conta> banco) {
		int numeroConta = InOut.leInt("Informe o número da conta:\n");
		double valorSaque = InOut.leDouble("Informe o valor do saque:\n");
		Conta conta = null;

		for (Conta c : banco) {
			if (c.getNumero() == numeroConta) {
				conta = c;
				break;
			}
		}
		if (conta != null) {
			boolean sacou = conta.saque(valorSaque);
			if (sacou) {
				InOut.msgDeInformacao("SAQUE REALIZADO",
						"O saque de " + valorSaque + " da conta " + numeroConta + " foi realizado.");
			} else {
				InOut.msgDeAviso("SAQUE NÃO REALIZADO", "Não foi possível realizar o saque de " + valorSaque
						+ " da conta " + numeroConta + ", por falta de saldo na conta.");
			}
		} else {
			InOut.msgDeAviso("SAQUE NÃO REALIZADO",
					"Não foi possível encontrar uma conta com o número" + numeroConta + ".");
		}

	}

	private static void deposito(ArrayList<Conta> banco) {
		int numeroConta = InOut.leInt("Insira o numero da conta:\n");
		double valorDeposito = InOut.leDouble("Insira o valor a ser depositado:\n");
		Conta conta = null;

		for (Conta c : banco) {
			if (c.getNumero() == numeroConta) {
				conta = c;
				break;
			}
		}

		if (conta != null) {
			conta.deposito(valorDeposito);
			InOut.msgDeInformacao("DEPÓSITO REALIZADO",
					"O depÓsito de " + valorDeposito + " na conta " + numeroConta + " foi realizado.");
		} else {
			InOut.msgDeAviso("DEP�SITO NÃO REALIZADO", "Não foi possível realizar o depósito de " + valorDeposito
					+ " conta " + numeroConta + " inexistente.");
		}

	}

	private static void transferencia(ArrayList<Conta> banco) {
		int numeroContaTransferir = InOut.leInt("Insira o número da conta a transferir:\n");
		int numeroContaAquirir = InOut.leInt("Insira o número da conta a receber:\n");
		double valorTransferencia = InOut.leDouble("Insira o valor a ser transferido:\n");
		Conta conta = null;
		Conta outraConta = null;

		for (Conta c : banco) {
			if (c.getNumero() == numeroContaTransferir) {
				conta = c;
			}
			if (c.getNumero() == numeroContaAquirir) {
				outraConta = c;
			}
		}
		if (conta != null && outraConta != null) {
			boolean transferiu = conta.transferencia(valorTransferencia, outraConta);
			if (transferiu) {
				InOut.msgDeInformacao("TRANSFERêNCIA REALIZADA",
						"A tranferência no valor de R$ " + valorTransferencia + " da conta " + numeroContaTransferir
								+ " para a conta " + numeroContaAquirir + " foi realizada.");

			} else if (conta.saldo() < valorTransferencia) {
				InOut.msgDeAviso("TRANSFERÊNCIA NÃO REALIZADA",
						"Não foi possível realizar a tranferência no valor de R$ " + valorTransferencia + " da conta "
								+ numeroContaTransferir + " para a conta " + numeroContaAquirir
								+ " por falta de saldo.");
			} else {
				InOut.msgDeAviso("TRANSFERÊNCIA NÃO REALIZADA",
						"Não era pra ter caido aqui");
			}

		} else {
			InOut.msgDeAviso("TRANSFERÊNCIA NÃO REALIZADA",
					"Não foi possível realizar a transferência. Uma das contas informadas é inexistente inexistente.");
		}

	}

}

/**
 * BancoETE: Simula operações bancárias em uma conta corrente e poupança.
 * 
 * @author João Paulo Falcão
 * @since 2024-01-03
 * @version 1.0
 */

import java.util.Random;
import java.util.Scanner;

public class BancoETE {
	static String nomeTitular = "";
	static int agencia = 0;
	static int numeroContaCorrente = 0;
	static int numeroContaPoupanca = 0;
	static int digitoVerificador = 0;
	static double saldoContaCorrente = 0.0;
	static double saldoContaPoupanca = 0.0;
	static double valorDepositoInicial = 0.0;
	static int qtdLetrasTitular = 0;

	public static void saldo() {
		System.out.println("\n" + nomeTitular);
		System.out.printf("Agência: %04d\n", agencia);
		System.out.printf("Conta Corrente: %05d-%d\n", numeroContaCorrente, digitoVerificador);
		System.out.printf("Saldo Conta Corrente: R$ %.2f\n", saldoContaCorrente);
		System.out.printf("Conta Poupança: %05d-%d\n", numeroContaPoupanca, digitoVerificador);
		System.out.printf("Saldo Conta Poupança: R$ %.2f\n", saldoContaPoupanca);
		System.out.println();
	}

	public static void deposito() {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Valor do depósito: R$ ");
		double valorDeposito = entrada.nextDouble();
		if (valorDeposito <= 0) {
			System.out.println("\nDepósito não permitido!\n");
		} else {
			saldoContaCorrente += valorDeposito;
			System.out.println("\nDepósito realizado com sucesso!\n");
		}
	}

	public static void saque() {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Valor do saque: R$ ");
		double valorSaque = entrada.nextDouble();
		if (valorSaque <= 0) {
			System.out.println("\nSaque não permitido!\n");
		} else if (saldoContaCorrente < valorSaque) {
			System.out.println("\nSaldo insuficiente!\n");
		} else {
			saldoContaCorrente -= valorSaque;
			System.out.println("\nSaque realizado com sucesso!\n");
		}
	}

	public static void transferencia() {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Qual valor deseja transferir: R$ ");
		double valorTransferencia = entrada.nextDouble();
		if (valorTransferencia <= 0) {
			System.out.println("\nTransferência não permitida!\n");
		} else if (saldoContaCorrente < valorTransferencia) {
			System.out.println("\nSaldo insuficiente!\n");
		} else {
			saldoContaCorrente -= valorTransferencia;
			saldoContaPoupanca += valorTransferencia;
			System.out.println("\nTransferência realizada com sucesso!\n");
		}
	}

	public static void resgate() {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Qual valor deseja resgatar: R$ ");
		double valorResgate = entrada.nextDouble();
		if (valorResgate <= 0) {
			System.out.println("\nResgate não permitido!\n");
		} else if (saldoContaPoupanca < valorResgate) {
			System.out.println("\nSaldo insuficiente!\n");
		} else {
			saldoContaPoupanca -= valorResgate;
			saldoContaCorrente += valorResgate;
			System.out.println("\nResgate realizado com sucesso!\n");
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Random random = new Random();

		int opcaoMenu = 0;

		while (opcaoMenu != 6) {
			System.out.println("$$$$$ BANCO ETE $$$$$");
			System.out.println("0-Criar Conta");
			System.out.println("1-Exibir Saldo");
			System.out.println("2-Depósito Conta Corrente");
			System.out.println("3-Saque Conta Corrente");
			System.out.println("4-Transferência Conta Poupança");
			System.out.println("5-Resgate Conta Poupança");
			System.out.println("6-Sair");
			System.out.print("Opção: ");
			opcaoMenu = entrada.nextInt();

			switch (opcaoMenu) {
			case 0:
				if (qtdLetrasTitular == 0) {
					while (true) {
						System.out.print("Titular: ");
						nomeTitular = entrada.nextLine().toUpperCase();
						if (nomeTitular.matches("^[a-zA-Z]+$")) {
							break;
						} else {
							System.out.println("Digite apenas caracteres alfabéticos!");
						}
					}

					qtdLetrasTitular = nomeTitular.length();
					agencia = random.nextInt(9000) + 1000;
					numeroContaCorrente = random.nextInt(90000) + 10000;
					numeroContaPoupanca = random.nextInt(90000) + 10000;
					digitoVerificador = random.nextInt(10);

					System.out.println(nomeTitular);
					System.out.printf("Agência: %04d\n", agencia);
					System.out.printf("Conta Corrente: %05d-%d\n", numeroContaCorrente, digitoVerificador);
					System.out.printf("Conta Poupança: %05d-%d\n", numeroContaPoupanca, digitoVerificador);
				} else {
					System.out.println("\nNão é permitido cadastrar novos clientes!\n");
					continue;
				}

				int opcaoDepositoInicial = 0;
				System.out.print("Deseja realizar um depósito na Conta Corrente? [0-SIM][1-NÃO]: ");
				opcaoDepositoInicial = entrada.nextInt();
				if (opcaoDepositoInicial == 0) {
					System.out.print("Valor do depósito: R$ ");
					valorDepositoInicial = entrada.nextDouble();
					if (valorDepositoInicial <= 0.0) {
						System.out.println("\nDepósito não permitido!\n");
					} else {
						saldoContaCorrente += valorDepositoInicial;
						System.out.println("\nDepósito realizado com sucesso!\n");
					}
				}
				break;

			case 1:
				if (qtdLetrasTitular == 0) {
					System.out.println("\nAinda não há conta cadastrada!\n");
				} else {
					saldo();
				}
				break;

			case 2:
				if (qtdLetrasTitular == 0) {
					System.out.println("\nAinda não há conta cadastrada!\n");
				} else {
					deposito();
				}
				break;

			case 3:
				if (qtdLetrasTitular == 0) {
					System.out.println("\nAinda não há conta cadastrada!\n");
				} else {
					saque();
				}
				break;

			case 4:
				if (qtdLetrasTitular == 0) {
					System.out.println("\nAinda não há conta cadastrada!\n");
				} else {
					transferencia();
				}
				break;

			case 5:
				if (qtdLetrasTitular == 0) {
					System.out.println("\nAinda não há conta cadastrada!\n");
				} else {
					resgate();
				}
				break;

			case 6:
				System.out.println("\nSaindo...\n");
				break;

			default:
				System.out.println("\nOpção inválida!\n");
				break;
			}
		}

		entrada.close();
	}
}

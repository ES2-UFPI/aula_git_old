import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.sun.security.ntlm.Client;

import java.util.ArrayList;

public class Main {
	ArrayList<Cliente> clientes = new ArrayList<>();
	Scanner tc = new Scanner(System.in); // Create a Scanner object

	public void adicionarCliente() {
		String cpf;
		String nome;
		ArrayList<Conta> contas = new ArrayList<>();

		System.out.println("Insira o CPF: ");
		cpf = tc.nextLine();
		System.out.println("Insira o Nome: ");
		nome = tc.nextLine();

		Cliente cliente = new Cliente(cpf, nome, contas);

		clientes.add(cliente);
	}

	public void removerCliente(Cliente cliente) {
		System.out.println("Insira o CPF do cliente a ser removido: ");
		String nome = tc.nextLine();
		for (Cliente c : clientes) {
			if (c.getNome() == nome) {
				clientes.remove(c);
				break;
			}
		}
	}

	public Conta verifyConta(int num) {
		for (Cliente c : clientes) {
			for (Conta conta : c.getContas()) {
				if (conta.getAgencia() == num)
					return conta;
			}
		}
		return null;
	}

	public void doOperation(int tipo, Cliente c) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o número da conta: ");
		String numConta = entrada.nextLine();
		Conta conta = this.verifyConta(Integer.parseInt(numConta));
		Conta c2 = null;
		if (conta != null) {
			if (tipo == 3) {
				System.out.println("Saldo atual: " + conta.getSaldo());]
				return;
			}
			else if (tipo == 4) {
				System.out.println("Digite o número da conta a ser transferido o dinheiro: ");
				String num2 = entrada.nextLine();
				c2 = this.verifyConta(Integer.parseInt(num2));
				if (c2 != null) {
					System.out.println("Digite o valor: ");
					double valor = entrada.nextFloat();
					c.doOperation(tipo, valor, conta, c2);
				} else {
					System.out.println("Conta não existe");
				}
				return;
			} else {
				System.out.println("Digite o valor: ");
				double valor = entrada.nextFloat();
				c.doOperation(tipo, valor, conta, c2);
			}
		} else {
			System.out.println("Conta não existe");
		}
		entrada.close();
		return;
	}

	private void MenuOperacoes(Cliente c) {
		Menu menu = new Menu("Operações", Arrays.asList("Sacar", "Depositar", "Ver Saldo", "Transferir", "Voltar"));
		float valor = 0;
		String numConta = "";
		List<String> opt;
		int op = 0;
		Scanner entrada = new Scanner(System.in);

		do {
			valor = 0;
			op = menu.getSelection(5);
			switch (op) {
			case 0:
				this.doOperation(1, c);
				break;
			case 1:
				this.doOperation(2, c);
				break;
			case 2:
				this.doOperation(3, c);
				break;
			case 3:
				this.doOperation(4, c);
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
		} while (op != 4);
		this.menuClient();
		entrada.close();
	}

	public void menuCliente() {
		Menu menu = new Menu("Operações", Arrays.asList("Criar cliente", "Remover conta", "Operações", "Sair"));
		Scanner s = new Scanner(System.in);
		int op = 0;
		do {
			op = menu.getSelection(4);
			switch (op) {
			case 0:
				// Criar cliente
				break;
			case 1:
				// Remover cliente
				break;
			case 2:
				// ask for cpf before.
				this.MenuOperacoes(c);
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
		} while (op != 3);
		s.close();
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.menuCliente();
		System.out.println("Fim");
	}

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static Scanner s;
	private static int numContas = 0;

	public static void main(String[] args) {
		int op;

		do {
			Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
			op = mainMenu.getSelection();

			if (op == 1) {
				MenuConta();
			} else if (op == 2) {
				cadastrarCliente();
			} else if (op == 3) {
				int resul;
				Menu menuOperacoes = new Menu("Menu Operações", Arrays.asList("Saque", "Depósito", "Transferência"));
				resul = menuOperacoes.getSelection();
				if (resul == 1) {

				}
				if (resul == 2) {

				}
				if (resul == 3) {

					System.out.println("Informe o nome do cliente que deseja transferir:");
					s = new Scanner(System.in);
					String cliente1 = s.nextLine();
					Cliente c1 = clientes.buscaCliente(cliente1);
					if (c1 == null) {
						System.out.println("Cliente não encontrado");
					}
					System.out.println("Informe o número da conta que deseja transferir:");
					s = new Scanner(System.in);
					int conta1 = s.nextInt();
					Conta continha = c1.getConta(conta1);
					if (continha == null) {
						System.out.println("Conta não encontrada");
					}
					System.out.println("Informe o nome do cliente que receberá a transferência:");
					s = new Scanner(System.in);
					String cliente2 = s.nextLine();
					Cliente c2 = clientes.buscaCliente(cliente2);
					if (c1 == null) {
						System.out.println("Cliente não encontrado");
					}
					System.out.println("Informe o número da conta que receberá a quantia:");
					s = new Scanner(System.in);
					int conta2 = s.nextInt();
					Conta continha2 = c1.getConta(conta2);
					if (continha == null) {
						System.out.println("Conta não encontrada");
					}
					System.out.println("Informe a quantia que deseja transferir:");
					s = new Scanner(System.in);
					float valor = s.nextFloat();
					if (valor < 1) {
						System.out.println("Não é possível transferir essa quantia");
					}
					Operacao operarei = new Operacao();
					operarei.transferencia(continha, continha2, valor);

				}
			}
		} while (op != 4);

		System.out.println("Fim!\n\n");
	}

	public static void cadastrarCliente() {

		System.out.println("\n\nCadastro de cliente ");
		System.out.println("Informe o nome do cliente: ");
		s = new Scanner(System.in);
		String nome = s.nextLine();

		System.out.println("Agencia: ");
		int agencia = s.nextInt();

		Cliente cliente = new Cliente(nome, agencia);
		clientes.add(cliente);
		System.out.println(cliente.getNome() + " foi cadastrado como cliente.\n\n");
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public static Cliente BuscarCliente(String nomeDoCliente) {
		for (Cliente c : clientes) {
			if (c.getNome().equals(nomeDoCliente)) {
				return c;
			}
		}

		return null;
	}

	public static Conta BuscarConta(Cliente cliente, int numeroDaConta) {
		return cliente.getConta(numeroDaConta);
	}

	public static void MenuConta() {
		System.out.println("\n\n Menu de Conta");
		System.out.println("Nome do Cliente: ");

		s = new Scanner(System.in);
		String nomeDoCliente = s.nextLine();
		Cliente cliente = BuscarCliente(nomeDoCliente);

		if (cliente != null) {
			System.out.println("1. Criar nova conta.");
			System.out.println("2. Buscar Conta.");
			s = new Scanner(System.in);

			switch (s.nextInt()) {
			case 1:
				int num = CriarConta(cliente);
				System.out.println("Conta criada com sucesso!\nNumero da conta: " + num);
				break;
			case 2:
				System.out.println("\nDigite o número da conta: ");
				s = new Scanner(System.in);

				Conta conta = BuscarConta(cliente, s.nextInt());

				if (conta != null) {
					System.out.println("\nSaldo: " + conta.getSaldo());
					System.out.println("\nOperações: " + conta.getOperacoes().toString());
				} else
					System.out.println("Conta não encontrada!");
				break;
			default:
				System.out.println("Opção não consta no menu.");
				break;
			}
		} else {
			System.out.println("Cliente não encontrado!");
		}
	}

	public static int CriarConta(Cliente cliente) {
		Conta conta = new Conta();

		numContas++;

		conta.setNum(numContas);
		cliente.setConta(conta);
		return numContas;
	}
}

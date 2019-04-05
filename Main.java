import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

	private void MenuOperações() {
		Menu menu = new Menu("Operações", Arrays.asList("Sacar", "Depositar", "Ver Saldo", "Transferir", "Voltar"));
		float valor = 0;
		List<String> opt;
		int op = 0;
		Scanner entrada = new Scanner(System.in);

		do {
			valor = 0;
			op = menu.getSelection(5);
			switch (op) {
			case 0:
				System.out.println("Digite o valor a ser sacado!");
				valor = entrada.nextFloat();
				// System.out.println( Float.toString(valor) + " foi sacado");
				break;

			case 1:
				System.out.println("Digite o valor a ser depositado!");
				valor = entrada.nextFloat();
				// System.out.println( Float.toString(valor) + " foi depositado");
				break;

			case 2:
				// Acredito que aqui basta chamar o método de versaldos da classe operação
				break;

			case 3:
				System.out.println("Digite o valor a ser transferido!");
				// System.out.println( Float.toString(valor) + " foi transferido");
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
		} while (op != 4);
		this.menuClient();
		entrada.close();
	}

	public void menuClient() {
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
				this.MenuOperações();
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
		m.menuClient();
		System.out.println("Fim");
	}

}

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Cliente> clientes = new ArrayList<>();

	private void MenuOperacoes(Cliente c) {
		Menu menu = new Menu("Operacoes", Arrays.asList("Sacar", "Depositar", "Ver Saldo", "Transferir", "Voltar"));
		Scanner entrada = new Scanner(System.in);
		
		float valor;
		List<String> opt;
		int op = 0;

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

		this.menuCliente();
		entrada.close();
	}

	public void menuCliente() {
		Menu menu = new Menu("Operacoes", Arrays.asList("Criar cliente", "Remover conta", "Operacoes", "Sair"));
		Scanner s = new Scanner(System.in);
		
		String cpf, nome;
		int op = 0;
		
		do {
			op = menu.getSelection(4);
			switch (op) {
				case 0:
					System.out.println("Digite o CPF do cliente: ");
					cpf = s.nextLine();
					System.out.println("Digite o nome do cliente: ");
					nome = s.nextLine();

					clientes.add(new Cliente().adicionarCliente(cpf, nome));
					break;
				
				case 1:
					System.out.println("Digite o CPF do cliente: ");
					cpf = s.nextLine();

					clientes.remove(new Cliente().removerCliente(clientes, cpf));
					break;
				
				case 2:
					System.out.println("Digite o CPF do cliente: ");
					cpf = s.nextLine();
					
					Cliente c = new Cliente().buscarClientePorCpf(clientes, cpf); 
					
					if (c != null) { this.MenuOperacoes(c); } 
					else { System.out.println("Não foi encontrado cliente."); }
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

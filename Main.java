import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	ArrayList<Cliente> clientes = new ArrayList<>();
	Scanner tc = new Scanner(System.in);  // Create a Scanner object

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
	public static void main(String[] args) {
		Menu mainMenu = new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));
		int op=0;
		do {
			op = mainMenu.getSelection();
			System.out.println( op + "foi selecionada");
		} while(op!=4);
		System.out.println("Fim");
	}

}

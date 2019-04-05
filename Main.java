import java.util.Arrays;
import java.util.List;
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
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Sacar", "Depositar", "Ver Saldo", "Transferir", "Sair"));
		Scanner entrada = new Scanner(System.in);
		float valor = 0;
		List<String> opt;
		int op=0;
		do {
			valor = 0;
			opt = mainMenu.getOptions();
			op = mainMenu.getSelection();
			System.out.println( opt.get(op) + " foi selecionada");
			switch (op){
				case 0:
					System.out.println("Digite o valor a ser sacado!");
					valor = entrada.nextFloat();
					System.out.println( Float.toString(valor) + " foi sacado");
				break;

				
				case 1:					
					System.out.println("Digite o valor a ser depositado!");
					valor =  entrada.nextFloat();	
					System.out.println( Float.toString(valor) + " foi depositado");
				break;
				
				case 2:						
				
				break;

				case 3:
					System.out.println("Digite o valor a ser transferido!");
					valor =  entrada.nextFloat();
					System.out.println( Float.toString(valor) + " foi transferido");
				break;
			}
		} while(op!=4);
		System.out.println("Fim");
		entrada.close();
	}

}

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ClienteManager cm = new ClienteManager();
	Scanner sc = new Scanner(System.in);

	public void doOperation(int tipo, Cliente c) {
		System.out.println("Digite o número da conta: ");
		String numConta = sc.nextLine();
		
		Conta conta = cm.verifyConta(Integer.parseInt(numConta));
		Conta c2 = null;
		
		if (conta != null) {
			if (tipo == 3) {
				System.out.println("Saldo atual: " + conta.getSaldo());
				return;

			} else if (tipo == 4) {
				System.out.println("Digite o número da conta a ser transferido o dinheiro: ");
				String num2 = sc.nextLine();
				c2 = cm.verifyConta(Integer.parseInt(num2));

				if (c2 != null) {
					System.out.println("Digite o valor: ");
					double valor = sc.nextFloat();
					c.doOperation(tipo, valor, conta, c2);

				} else { System.out.println("Conta não existe"); }
				return;

			} else {
				System.out.println("Digite o valor: ");
				double valor = sc.nextFloat();
				c.doOperation(tipo, valor, conta, c2);
			}

		} else {
			System.out.println("Conta não existe");
			return;
		}
		sc.close();
		return;
	}

	private void MenuOperacoes(Cliente c) {
		Menu menu = new Menu("Operações", Arrays.asList("Sacar", "Depositar", "Ver Saldo", "Transferir",
				"Adicionar conta", "Remover conta", "Ver Operacoes", "Voltar"));
		String numConta;
		int op = 0;

		do {
			op = menu.getSelection(8);
			switch (op) {
			case 0:
				this.doOperation(1, c); break;
			case 1:
				this.doOperation(2, c); break;
			case 2:
				this.doOperation(3, c); break;
			case 3:
				this.doOperation(4, c); break;
			case 4:
				System.out.println("Digite o numero da conta: ");
				numConta = sc.nextLine();
				int num = Integer.parseInt(numConta);
				
				if (cm.verifyConta(num) == null) { c.criarConta(new Conta(0.0, num)); } 
				else { System.out.println("Conta já existe!"); }
				break;

			case 5:
				System.out.println("Digite o numero da conta: ");
				numConta = sc.nextLine();
				
				Conta conta = cm.verifyConta(Integer.parseInt(numConta));
				
				if (conta != null) { c.removerConta(conta); } 
				else { System.out.println("Conta não existe!"); }
				break;
			case 6:
				System.out.println("Digite o numero da conta: ");
				numConta = sc.nextLine();

				Conta conta2 = cm.verifyConta(Integer.parseInt(numConta));

				if (conta2 != null) { System.out.println(conta2.getHistorico()); }
				else { System.out.println("Conta não existe!"); }
				break;
			}
		} while (op != 7);

		sc.close();
		this.menuCliente();
	}

	public void menuCliente() {
		Menu menu = new Menu("Operações", Arrays.asList("Criar cliente", "Remover cliente", "Operações", "Sair"));
		Cliente c;

		String cpf, nome;
		int op = 0;
		boolean autorizado;
		
		do {
			op = menu.getSelection(4);
			switch (op) {
			case 0:
				System.out.println("Digite o cpf do cliente: ");
				cpf = sc.nextLine();
				autorizado = cm.verificaCPF(cpf);
				
				if (autorizado) {
					System.out.println("Digite o nome do cliente: ");
					nome = sc.nextLine();
					cm.getClientes().add(new Cliente(cpf, nome, new ArrayList<Conta>()));
				}
				else { System.out.println("Já existe um cliente com esse cpf!"); }
				break;

			case 1:
				c = cm.getCliente();
				
				if (c != null) { cm.RemoverCliente(c); }
				else { System.out.println("Não existe um cliente com este CPF"); }
				break;

			case 2:
				c = cm.getCliente();

				if (c != null) { this.MenuOperacoes(c); } 
				else { System.out.println("Não foi encontrado cliente."); }
				break;
			}
		} while (op != 3);
		sc.close();
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.menuCliente();
		System.out.println("Fim");
	}
}

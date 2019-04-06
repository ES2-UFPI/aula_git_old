import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Cliente> clientes = new ArrayList<>();

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
				System.out.println("Saldo atual: " + conta.getSaldo());
				return;
			} else if (tipo == 4) {
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
			return;
		}
		entrada.close();
		return;
	}

	private void MenuOperacoes(Cliente c) {
		Menu menu = new Menu("Operações", Arrays.asList("Sacar", "Depositar", "Ver Saldo", "Transferir", "Adicionar conta", "Remover conta", "Voltar"));
		Scanner s = new Scanner(System.in);
		String numConta;
		int op = 0;

		do {
			op = menu.getSelection(7);
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
			case 4:
				System.out.println("Digite o numero da conta: ");
				numConta = s.nextLine();

				c.criarConta(new Conta().adicionarConta(Integer.parseInt(numConta)));
				break;
			case 5:
				System.out.println("Digite o numero da conta: ");
				numConta = s.nextLine();
				
				c.removerConta(verifyConta(Integer.parseInt(numConta)));
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
		} while (op != 6);
		s.close();
		this.menuCliente();
	}
	public Boolean verificaCPF(String cpf){
		for (Cliente cliente : clientes){
			if (cpf == cliente.getCpf()){
				return false;
			}
		}
		return true;
	}
	public void menuCliente() {
		Menu menu = new Menu("Operações", Arrays.asList("Criar cliente", "Remover conta", "Operações", "Sair"));
		Scanner s = new Scanner(System.in);

		String cpf, nome;
		int op = 0;
		boolean autorizado;

		do {
			op = menu.getSelection(4);
			switch (op) {
			case 0:
				System.out.println("Digite o CPF do cliente: ");
				cpf = s.nextLine();
				autorizado = verificaCPF(cpf);
				if (autorizado){
					System.out.println("Digite o nome do cliente: ");
					nome = s.nextLine();
					clientes.add(new Cliente().adicionarCliente(cpf, nome));
				}
				else{
					System.out.println("Já existe um cliente com esse cpf!");
					break;
				}
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

				if (c != null) {
					this.MenuOperacoes(c);
				} else {
					System.out.println("Não foi encontrado cliente.");
				}
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

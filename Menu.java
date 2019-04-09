
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
	private String title;
	private List<String> options;
	public ArrayList<Cliente> clientes = new ArrayList<>();
	public ArrayList<Conta> contas = new ArrayList<>();

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public int getSelection() {
		int op = 0;
		while (op==0){
			System.out.println(title+"\n");
			int i=1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
				switch (op) {
				case 1:
					System.out.println("Digite o nome do cliente: ");
					Scanner nome = new Scanner(System.in);
					String nome_cliente = nome.nextLine();
					System.out.println("Digite o CPF: ");
					Scanner cpf = new Scanner(System.in);
					int cpf_cliente = cpf.nextInt();
					System.out.println("Digite a agência: ");
					Scanner agencia = new Scanner(System.in);
					String agencia_cliente = agencia.nextLine();
					Cliente cliente = new Cliente(nome_cliente, cpf_cliente, agencia_cliente);
					clientes.add(cliente);
					System.out.println("Cadastro realizado com sucesso!");
					System.out.println("Nome do cliente: " + nome_cliente);
					System.out.println("CPF: " + cpf_cliente);
					System.out.println("Agência: " + agencia_cliente);
					break;
				case 2:
					System.out.println("Digite seu CPF: ");
					Scanner cpf_id = new Scanner(System.in);
					int cpf_conta = cpf_id.nextInt();
					for (Cliente cliente2 : clientes) {
						if(cliente2.getCpf() == cpf_conta) {
							Conta conta = new Conta(cliente2);
							contas.add(conta);
							System.out.println("Cadastro realizado com sucesso!");
						}
					}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					break;
				}
			}
			catch (NumberFormatException e) {
				op = 0;
			}
			if (op >= i){
				System.out.println("Opcao errada!");
				op = 0;
			}

		}
		return op;
	}
}

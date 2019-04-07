import java.util.Arrays;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Criar Conta", "Cadastrar Cliente", "Saque","Deposito","Transferencia","Sair"));
		
		Cliente c;
		Conta acc;
		String nome;
		Scanner s;
		
		while(true) {
			int opcao = mainMenu.getSelection();
			System.out.println(opcao + "foi selecionada");
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a nome do cliente para criar a conta:");
				s = new Scanner(System.in);
				nome = s.nextLine();
				try {
					c = mainMenu.getCliente(nome);
				}catch (Exception e) {
					//cliente nao encontrado
					System.out.println("Interrompendo operacao");
					break;
				}
				acc = new Conta(c);
				c.setConta(acc);
				System.out.println("Conta criada com sucesso!");
				break;
			case 2:
				System.out.println("Digite o nome do novo cliente:");
				s = new Scanner(System.in);
				nome = s.nextLine();
				c = new Cliente();
				c.setNome(nome);
				System.out.println("Digite a agencia do novo cliente:");
				s = new Scanner(System.in);
				nome = s.nextLine();
				c.setAgencia(nome);
				mainMenu.setCliente(c);
				System.out.println("Cliente cadastrado com sucesso!");
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("Saindo");
				return;
			default:
				break;
			}
		}
	}

}

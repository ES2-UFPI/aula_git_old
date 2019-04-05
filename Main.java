import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Cadastrar Cliente", "Abertura de Conta", "Depósito", "Saque", "Transferência"));
		System.out.println(mainMenu.getSelection() + "foi selecionada");
	}

}

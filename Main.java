import java.util.Arrays;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Conta", "Cliente", "Operacoes", "Sair"));

		int ops = 0;

		do {
			ops = mainMenu.getSelection();
			System.out.println("\n" + ops + " foi selecionada.\n");

			if (ops == 1) {
				System.out.println("\nA conta foi adicionada.\n");
			}

			if (ops == 2) {
				System.out.println("\nO cliente foi adicionado.\n");
			}
		}
		while (ops != 4);

		System.out.println("Fim");
	}

} // fim Main

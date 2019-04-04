import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Menu mMenu =  new Menu();
		int op=0;
		do {
			System.out.println("Digite o valor: ");
			Scanner s1 = new Scanner(System.in);
			int valor = Integer.parseInt(s1.nextLine());
			if(valor == 1){
					Scanner s2 = new Scanner(System.in);
					String nome = s2.nextLine();
					System.out.println(nome);
					mMenu.getClientes().add(nome);
				}
			System.out.println( op + "foi selecionada");
		} while(op!=4);
		System.out.println("Fim");
	}
}

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	private String title;
	private List<String> options;

	public Menu(List<String> options) {
		this.title = "Menu";
		this.options = options;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public int getSelection() {		
		int opcao, i = 0;
		while(i<5){
			System.out.println(Integer.toString(i) + "-" + options.get(i));
			i++;
		}
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção!"));
		return opcao;

	}
}
/* I dont know how this function
int op = 0;
		while (op == 0) {
			System.out.println(title + "\n");
			int i = 1;
			for (String option : options) {
				System.out.println(i++ + " - " + option);
			}

			System.out.println("Informe a opcao desejada. ");
			Scanner s = new Scanner(System.in);
			String str = s.nextLine();
			try {
				op = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				op = 0;
			}
			if (op >= i) {
				System.out.println("Opcao errada!");
				op = 0;
			}

		}
		return op;

*/
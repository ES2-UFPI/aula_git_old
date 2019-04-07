
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	private ArrayList<Cliente> clientes;

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
		this.clientes = new ArrayList<Cliente>();
	}
	
	public Cliente getCliente(String nome)  throws ElementoInexistente {
		for(Cliente c : clientes) {
			if(c.getNome().compareTo(nome) == 0) {
				return c;
			}
		}
		throw new ElementoInexistente();
	}
	
	public void setCliente(Cliente c) {
		clientes.add(c);
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
			}
			catch (NumberFormatException e) {
				op =0;
				System.out.println("Formato incorreto!");
			}
			if (op>=i){
				System.out.println("Opcao errada!");
				op=0;
			}
		}
		return op;
	}
}

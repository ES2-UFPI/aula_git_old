
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	private ArrayList<String> cliente = new ArrayList();

	public Menu() {
	}

	public ArrayList getClientes(){
		return cliente;
	}

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

}

import java.util.List;

//import javax.swing.JComboBox; Ia fazer interface gráfica, mas evitei
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Menu {
	private String title;
	private List<String> options;

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public List<String> getOptions() {
		return options;
	}

	public int getSelection() {		
		int opcao, i = 0;		
		while(i<5){
			
			System.out.println(Integer.toString(i) + "-" + options.get(i));
			i++;
		}		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		opcao = Integer.parseInt(str);
		return opcao;

	}
}

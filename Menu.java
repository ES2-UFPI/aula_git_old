import java.util.List;

//import javax.swing.JComboBox; Ia fazer interface gráfica, mas evitei
import javax.swing.JOptionPane;

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
		opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção!"));
		return opcao;

	}
}

import java.util.List;
import java.util.Scanner;

public class Menu {
	private String title;
	private List<String> options;
	Scanner s = new Scanner(System.in);

	public Menu(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public List<String> getOptions() {
		return options;
	}

	public int getSelection(int tam) {
		int opcao, i = 0;
		while (i < tam) {

			System.out.println(Integer.toString(i) + "-" + options.get(i));
			i++;
		}
		String str = null;
		str = s.nextLine();
		opcao = Integer.parseInt(str);
		return opcao;

	}
}

import java.util.ArrayList;


public class Cliente {
	
	private String nome;
	private int cpf;
	private String agencia;
	private ArrayList<Conta> contas = new ArrayList<>();

	public String getNome() {
		return nome;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public String getAgencia() {
		return agencia;
	}
	
	public ArrayList<Conta> getContas() {
		return contas;
	}
	
	public Cliente(String nome, int cpf, String agencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.agencia = agencia;
	}

}

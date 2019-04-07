import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String agencia;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public Cliente() {
		this.nome = null;
		this.agencia = null;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}
	
	public ArrayList<Conta> getContas(){
		return contas;
	}
	
	public void setConta(Conta conta) {
		this.contas.add(conta);
	}
}

import java.util.ArrayList;

public class Conta {
	private Double saldo;
	private Cliente cliente;
	private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();
	
	public Conta(Cliente cliente) {
		saldo = (double) 0;
		this.cliente = cliente;
	}
	
	public ArrayList<Operacao> getOperacoes(){
		return operacoes;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

}

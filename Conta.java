import java.util.ArrayList;
public class Conta {
	
	private Cliente cliente;
	private double saldo;
	private ArrayList<operacoes> operacoes = new ArrayList<>();

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public ArrayList<operacoes> getOperacoes() {
		return operacoes;
	}
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
	}

}

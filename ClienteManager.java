import java.util.ArrayList;
import java.util.Scanner;

public class ClienteManager {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente buscarClientePorCpf(String cpf) {
		for (Cliente c : clientes) {
			if (c.getCpf().equalsIgnoreCase(cpf)) {
				return c;
			}
		}
		return null;
	}

	public Boolean verificaCPF(String cpf) {
		for (Cliente cliente : clientes) {
			if (cpf == cliente.getCpf()) {
				return false;
			}
		}
		return true;
	}

	public void RemoverCliente(Cliente c) {
		for (Conta conta : c.getContas()) {
			c.getContas().remove(conta);
		}
		clientes.remove(c);
    }
    
    public Conta verifyConta(int num) {
		for (Cliente c : clientes) {
			for (Conta conta : c.getContas()) {
				if (conta.getAgencia() == num)
					return conta;
			}
		}
		return null;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente getCliente() {
        Scanner sc = new Scanner(System.in);
        String cpf;

        System.out.println("Digite o CPF do cliente: ");
        cpf = sc.nextLine();

        Cliente c = buscarClientePorCpf(cpf);
        return c;
    }
}
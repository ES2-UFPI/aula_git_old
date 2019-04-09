package aula_git;

public class Operacao {
	
	public static void deposito(Conta c, Double valor) {
		c.setSaldo(c.getSaldo() + valor);
	}
	
	public static boolean saque(Conta c, Double valor) {
		if(c.getSaldo() < valor) {
			System.out.println("Saldo insuficiente!");
			return false;
		}
		
		c.setSaldo(c.getSaldo() - valor);
		return true;
	}
	
	public static boolean transferencia(Conta origem, Conta destino, Double valor) {
		if(saque(origem, valor)) {
			deposito(destino, valor);
			return true;
		}
		return false;
	}

}

public class Conta {
    
    private int agencia;
    private Double saldo;
    private String historico;

    public Conta(Double saldo, int agencia) {
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public String getHistorico() {
        return this.historico;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addOperation(Operacao op) {
        String str = "Tipo: " + op.getTipo() + "\nValor:" + op.getValor() + "\nDest:" + op.getDestinatario() + "\n";
		this.historico += str;
    }
}

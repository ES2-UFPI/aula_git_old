public class Conta {
    private Double saldo;
    private String historico;

    public Conta(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public String getHistorico() {
        return this.historico;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addOperation(Operacao op) {
        String str = "Tipo: " + op.getTipo() + "\nValor:" + op.getValor() + "\nDest:" + op.getDestinatario() + "\n";
		this.historico += str;
    }
}

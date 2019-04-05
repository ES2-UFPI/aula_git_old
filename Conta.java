public class Conta {
    
    private int id;
    private Double saldo;
    private String historico;

    public Conta(Double saldo, int id) {
        this.saldo = saldo;
        this.id = id;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public String getHistorico() {
        return this.historico;
    }

    public int getID() {
        return this.id;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addOperation(Operacao op) {
        String str = "Tipo: " + op.getTipo() + "\nValor:" + op.getValor() + "\nDest:" + op.getDestinatario() + "\n";
		this.historico += str;
    }
}

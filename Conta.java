public class Conta {

    private int agencia;
    private Double saldo;
    private String historico;

    public Conta(Double saldo, int agencia) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.historico = "";
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
        String str = "";
        if (op.getTipo() == 3) {
            str = "Tipo: " + op.getTipo() + "\nValor:" + op.getValor() + "\nDe: " + Integer.toString(op.getRemetente().getAgencia()) + " Para: "
                    +Integer.toString(op.getDestinatario().getAgencia())  + "\n";
        } else {
            str = "Tipo: " + op.getTipo() + "\nValor:" + op.getValor() + "\nDest:" + Integer.toString(op.getDestinatario().getAgencia()) + "\n";
        }
        this.historico += str;
    }
}

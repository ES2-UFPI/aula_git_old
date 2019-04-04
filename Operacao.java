public class Operacao {
    // 1 - Saque
    // 2 - Deposito
    // 3 - Transferencia

    private int tipo;
    private Double valor;
    private Conta dest;

    public Operacao(int tipo, Double valor, Conta dest) {
        this.tipo = tipo;
        this.valor = valor;
        this.dest = dest;
    }

    public int getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public int getDestinatario() {
        return dest;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setDestinatario(Conta dest) {
        this.dest = dest;
    }
}
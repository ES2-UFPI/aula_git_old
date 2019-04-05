public class Operacao {
    // 1 - Saque
    // 2 - Deposito
    // 3 - Transferencia

    private int tipo;
    private Double valor;
    private Conta remt;
    private Conta dest;

    public Operacao(int tipo, Double valor, Conta dest, Conta remt) {
        this.tipo = tipo;
        this.valor = valor;
        this.dest = dest;
        this.remt = remt;
    }

    public int getTipo() {
        return tipo;
    }

    public Double getValor() {
        return valor;
    }

    public Conta getDestinatario() {
        return dest;
    }

    public Conta getRemetente() {
        return remt;
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

    public void setRemetente(Conta remt) {
        this.remt = remt;
    }

    public void doOperation() {

        switch (getTipo()) {
        case 1:
            // Saque
            Conta c1 = getDestinatario();
            if (getValor() < c1.getSaldo() && getValor() > 0) {
                c1.setSaldo(c1.getSaldo() - getValor());
                c1.addOperation(this);
            } else {
                if (getValor() < c1.getSaldo()) {
                    System.out.println("Saldo insuficiente.");
                }
                if (getValor() < 0) {
                    System.out.println("Valor negativo.");
                }
            }
            break;

        case 2:
            // Deposito
            Conta c2 = getDestinatario();
            if (getValor() > 0) {
                c2.setSaldo(c2.getSaldo() + getValor());
                c2.addOperation(this);
            } else {
                if (getValor() < 0) {
                    System.out.println("Valor negativo.");
                }
            }

            break;

        case 3:
            // Tranferencia
            Conta c3 = getRemetente();
            Conta c4 = getDestinatario();
            if ((c3.getSaldo() - getValor() >= 0) && getValor() > 0) {
                c3.setSaldo(c3.getSaldo() - getValor());
                c4.setSaldo(c4.getSaldo() + getValor());

                c3.addOperation(this);
                c4.addOperation(this);
            } else {
                if (c3.getSaldo() - getValor() < 0) {
                    System.out.println("Saldo insuficiente.");
                }
                if (getValor() < 0) {
                    System.out.println("Valor negativo.");
                }
            }
        default:
            break;
        }
    }
}

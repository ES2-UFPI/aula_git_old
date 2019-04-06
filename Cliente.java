import java.util.ArrayList;

public class Cliente {

    private String cpf;
    private String nome;
    private ArrayList<Conta> contas;

    public Cliente(String cpf, String nome, ArrayList<Conta> contas) {
        this.cpf = cpf;
        this.nome = nome;
        this.contas = contas;
    }

    public Cliente() {
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void criarConta(Conta c) {
        this.getContas().add(c);
    }

    public void removerConta(Conta c) {
        for (Conta c1 : this.getContas()) {
            if (c1.getAgencia() == c.getAgencia()) {
                this.getContas().remove(c);
            }
        }
    }

    public void doOperation(int tipo, double valor, Conta rem, Conta dest) {
        Operacao op = new Operacao(tipo, valor, dest, rem);
        op.doOperation();
    }
}

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {

    private String cpf;
    private String nome;
    private ArrayList<Conta> contas;

    public Cliente(String cpf, String nome, ArrayList<Conta> contas) {
        this.cpf = cpf;
        this.nome = nome;
        this.contas = contas;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void criarConta(Conta c) {
        this.getContas().add(c);
    }

    public void removerConta(Conta c) {
        for (Iterator<Conta> iterator = this.getContas().iterator(); iterator.hasNext();) {
            Conta c1 = iterator.next();
            if (c.getID() == c1.getID()) {
                this.getContas().remove(c);
            }
        }
    }
}

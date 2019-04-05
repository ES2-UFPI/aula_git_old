import java.util.ArrayList;

public class Cliente {

    private String nome;
    private ArrayList<Conta> contas;

    public Cliente(String nome, ArrayList<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
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
}

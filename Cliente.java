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

    public String getCpf(){
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

}

import java.util.ArrayList;

public class Cliente {
    private long nCliente;
    private String nome;
    private int nif;
    private Carro carro ;

    public long getnCliente() {
        return nCliente;
    }

    public void setnCliente(long nCliente) {
        this.nCliente = nCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Numero cliente- "+ nCliente + "| Cliente- " +nome + "| NIF- " + nif + "| Carro : " + carro;
    }
}

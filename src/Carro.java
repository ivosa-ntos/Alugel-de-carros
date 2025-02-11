public class Carro {
    private String modelo;
    private String marca;
    private String matricula;
    private Boolean alugado ;


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Boolean getAlugado() {
        return alugado;
    }

    public void setAlugado(Boolean alugado) {
        this.alugado = alugado;

    }

    @Override
    public String toString() {
        return "Matricula- "+ matricula + "| Marca- " + marca + "|Modelo- "+ modelo + "| Alugado- " + alugado;
    }
}

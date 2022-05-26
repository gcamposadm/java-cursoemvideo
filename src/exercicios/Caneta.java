package exercicios;

public class Caneta {
    private String modelo, cor;
    private float ponta;
    private boolean tampada;

    public Caneta(String modelo, String cor, float ponta, boolean tampada) {
        this.setModelo(modelo);
        this.setCor(cor);
        this.setPonta(ponta);
        this.setTampada(tampada);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public float getPonta() {
        return ponta;
    }

    public void setPonta(float ponta) {
        this.ponta = ponta;
    }

    public boolean isTampada() {
        return tampada;
    }

    public void setTampada(boolean tampada) {
        this.tampada = tampada;
    }

    public void status() {
        System.out.printf("Modelo: %s\n", this.getModelo());
        System.out.printf("Ponta: %.1f\n", this.getPonta());
        System.out.printf("Cor: %s\n", this.getCor());
        System.out.printf("Tampada: %b", this.isTampada());
    }
}

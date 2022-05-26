package banco;

public class Conta implements InterfaceConta {

    private int numero;
    private String tipo, dono;
    private float saldo;
    private boolean status;

    public Conta(String dono, String tipo) {
        this.setDono(dono);
        this.setTipo(tipo);
        this.setSaldo(0f);
        this.setStatus(true);

        if (!(this.getTipo().equalsIgnoreCase("Conta Poupança") ||
                this.getTipo().equalsIgnoreCase("Conta Corrente"))) {
            System.out.println("\nTipo de conta inválida");
        }
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getDono() {
        return dono;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public void sacar(float valorSaque) {
        float novoSaldo = this.getSaldo() - valorSaque;
        if (!this.isStatus()) {
            System.out.print("\nPara sacar é preciso informar uma conta aberta");
        } else if (this.getSaldo() < 0f) {
            System.out.printf("\nSeu saldo é de R$%.2f", this.getSaldo());
            System.out.print("\nPara sacar o saldo deve ser positivo");
        } else if (novoSaldo < 0) {
            System.out.print("\nSaldo insuficiente!");
        } else {
            this.setSaldo(novoSaldo);
            System.out.printf("\nSaque de R$%.2f efetuado com sucesso!", valorSaque);
            System.out.printf("\nSeu novo saldo é de R$%.2f", this.getSaldo());
        }
    }

    @Override
    public void depositar(float valorDeposito) {
        if (!this.isStatus()) {
            System.out.print("\nPara depositar é preciso informar uma conta aberta");
        } else {
            float novoSaldo = this.getSaldo() + valorDeposito;
            this.setSaldo(novoSaldo);
            System.out.printf("\nDepósito de R$%.2f efetuado com sucesso!", valorDeposito);
            System.out.printf("\nSeu novo saldo é de R$%.2f", this.getSaldo());
        }
    }

    @Override
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.printf("\nSaldo atual: R$%.2f", this.getSaldo());
            System.out.printf("\nPara encerrar a conta o saldo deve estar zerado");
        } else if (this.getSaldo() < 0) {
            System.out.printf("\nSaldo atual: R$%.2f", this.getSaldo());
            System.out.printf("\nPara encerrar a conta todos os débitos devem ser quitados");
        } else {
            setStatus(false);
            System.out.printf("\nSua conta foi encerrada com sucesso!");
        }
    }

    public void pagarTarifaMensal() {
        float novoSaldo;
        float valorTarifa;
        if (!this.isStatus()) {
            System.out.print("\nPara pagar a tarifa é preciso informar uma conta aberta");
        } else if (this.getSaldo() < 0f) {
            System.out.printf("\nSeu saldo é de R$%.2f", this.getSaldo());
            System.out.print("\nPara pagar a tarifa o saldo deve ser positivo");
        } else {
            if (this.getTipo().equalsIgnoreCase("Conta Poupança")) {
                valorTarifa = 12f;
            } else {
                valorTarifa = 20f;
            }
            novoSaldo = this.getSaldo() - valorTarifa;
            if (novoSaldo < 0) {
                System.out.print("\nSaldo insuficiente!");
            } else {
                this.setSaldo(novoSaldo);
                System.out.printf("\nPagamento da tarifa mensal de R$%.2f efetuado com sucesso", valorTarifa);
                System.out.printf("\nSeu novo saldo é de R$%.2f", this.getSaldo());
            }
        }
    }

    public void estadoAtual() {
        System.out.printf("\nDono: %s", this.getDono());
        System.out.printf("\nTipo: %s", this.getTipo());
        System.out.printf("\nNúmero: %s", this.getNumero());
        System.out.printf("\nSaldo: R$%.2f", this.getSaldo());
    }
}

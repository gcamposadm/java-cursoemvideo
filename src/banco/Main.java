package banco;

public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta("Fulano da Silva", "Conta Corrente");
        conta1.depositar(1000000);
        conta1.sacar(100000);
        conta1.pagarTarifaMensal();

    }
}

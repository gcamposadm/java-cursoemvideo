package banco;

public interface InterfaceConta {
    public abstract void sacar(float valorSaque);

    public abstract void depositar(float valorDeposito);

    public abstract void fecharConta();
}

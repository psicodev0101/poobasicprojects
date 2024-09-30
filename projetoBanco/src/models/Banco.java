package models;

import java.util.ArrayList;

public class Banco {

    private final ArrayList<Conta> contas = new ArrayList<>();

    public void abrirContaCorrente (int numeroConta, String titular, int limiteChequeEsp) {

        contas.add(new ContaCorrente(numeroConta, titular, limiteChequeEsp));
    }

    public void abrirContaPoupanca (int numeroConta, String titular) {
        contas.add(new ContaPoupanca(numeroConta, titular));
    }

    public Conta acessarConta (int numeroConta) {
        Conta contaAcessada = null;
        for(Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contaAcessada = conta;
            }
        }
        return contaAcessada;
    }
}

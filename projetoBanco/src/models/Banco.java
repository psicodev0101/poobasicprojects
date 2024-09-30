package models;

import java.util.ArrayList;

public class Banco {

    //ArrayList para armazenar as contas (cc ou poupanca)
    private final ArrayList<Conta> contas = new ArrayList<>();

    public void abrirContaCorrente (int numeroConta, String titular, int limiteChequeEsp) {
    //abre conta CC e armazena no arraylist
        contas.add(new ContaCorrente(numeroConta, titular, limiteChequeEsp));
    }

    public void abrirContaPoupanca (int numeroConta, String titular) {
    //abre conta poupanca e armazena no arraylist
        contas.add(new ContaPoupanca(numeroConta, titular));
    }

    public Conta acessarConta (int numeroConta) {
    //faz a busca por uma conta pelo numero e retorna essa conta pra poder ser acessada
        Conta contaAcessada = null;
        for(Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contaAcessada = conta;
            }
        }
        return contaAcessada;
    }
}

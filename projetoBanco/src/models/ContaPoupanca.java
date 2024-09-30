package models;

import services.SaqueService;

public class ContaPoupanca extends Conta {

    private static final double TAXA_JUROS = 6.5D;

    public ContaPoupanca(int numeroConta, String titularConta) {
        super(numeroConta, titularConta);
    }

    @Override
    public boolean sacar(double valor, SaqueService saqueService) {

    //implementa sacar de Conta, recebe o valor e o tipo de saque requisitado

        if (saqueService.confirmarSaquePoupanca(valor, this)) {
        /* usa a instancia do tipo de saque para verificar se o saldo da conta e
         o limite do cheque especial atendem aos requisitos do tipo de saque instanciado */

            return saqueService.sacar(valor, this);
        } else {
            System.out.println("ERRO: Saldo insuficiente!");
            return false;
        }
    }

}

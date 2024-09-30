package models;

import services.SaqueService;

public class ContaCorrente extends Conta {

    private int limiteChequeEsp;

    public ContaCorrente(int numeroConta, String titularConta, int limiteChequeEsp) {
        super(numeroConta, titularConta);
        this.limiteChequeEsp = limiteChequeEsp;
    }

    public int getLimiteChequeEsp() {
        return limiteChequeEsp;
    }

    public void setLimiteChequeEsp(int limiteChequeEsp) {
        this.limiteChequeEsp = limiteChequeEsp;
    }

    @Override
    public boolean sacar(double valor, SaqueService saqueService) {

    //implementa sacar de Conta, recebe o valor e o tipo de saque requisitado

        if (saqueService.confirmarSaqueCC(valor, this)) {
        /* usa a instancia do tipo de saque para verificar se o saldo da conta e
        o limite do cheque especial atendem aos requisitos do tipo de saque instanciado */

            return saqueService.sacar(valor, this);
        } else {
            System.out.println("ERRO: Saldo insuficiente!");
            return false;
        }
    }

}

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
        if (saqueService.confirmarSaqueCC(valor, this)) {
            return saqueService.sacar(valor, this);
        } else {
            System.out.println("ERRO: Saldo insuficiente!");
            return false;
        }
    }

}

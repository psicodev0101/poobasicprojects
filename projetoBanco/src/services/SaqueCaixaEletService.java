package services;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class SaqueCaixaEletService implements SaqueService {

    private static final double TAXA_SAQUE = 7.50;

    @Override
    public boolean sacar(double valor, Conta conta) {
        conta.setSaldoConta(conta.getSaldoConta() - (valor + TAXA_SAQUE));
        return true;
    }

    public boolean confirmarSaqueCC(double valor, ContaCorrente contaCorrente) {
        return valor + TAXA_SAQUE <= contaCorrente.getSaldoConta() + contaCorrente.getLimiteChequeEsp();
    }

    public boolean confirmarSaquePoupanca (double valor, ContaPoupanca contaPoupanca) {
        return valor + TAXA_SAQUE <= contaPoupanca.getSaldoConta();
    }
}

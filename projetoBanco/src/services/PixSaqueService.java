package services;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class PixSaqueService implements SaqueService{
    @Override
    public boolean sacar(double valor, Conta conta) {
        conta.setSaldoConta(conta.getSaldoConta() - valor);
        conta.setLimiteSaquePix(conta.getLimiteSaquePix()-1);
        return true;
    }

    @Override
    public boolean confirmarSaqueCC(double valor, ContaCorrente contaCorrente) {
        return valor <= contaCorrente.getSaldoConta() + contaCorrente.getLimiteChequeEsp()
                && contaCorrente.getLimiteSaquePix() > 0;
    }

    @Override
    public boolean confirmarSaquePoupanca(double valor, ContaPoupanca contaPoupanca) {
        return valor <= contaPoupanca.getSaldoConta() && contaPoupanca.getLimiteSaquePix() > 0;
    }
}

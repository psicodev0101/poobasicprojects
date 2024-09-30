package services;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class SaqueCaixaEletService implements SaqueService {

    private static final double TAXA_SAQUE = 7.50;

    @Override
    public boolean sacar(double valor, Conta conta) {

    /*Entrega para o metodo "sacar" das contas o resultado da chamada:
     * recebe a conta e retira do seu saldo o valor sacado adicionado
     * do valor de TAXA_SAQUE */

        conta.setSaldoConta(conta.getSaldoConta() - (valor + TAXA_SAQUE));
        return true;
    }

    public boolean confirmarSaqueCC(double valor, ContaCorrente contaCorrente) {

    /* recebe o valor a ser sacado e a conta corrente de origem, com isso, confere se
     * há saldo suficiente (considerando saldo + limite de cheque especial) para retirada
     * do saldo e da TAXA_SAQUE */

        return valor + TAXA_SAQUE <= contaCorrente.getSaldoConta() + contaCorrente.getLimiteChequeEsp();
    }

    public boolean confirmarSaquePoupanca (double valor, ContaPoupanca contaPoupanca) {

    /* recebe o valor a ser sacado e a conta poupança de origem, com isso, confere se
     * há saldo suficiente na conta (garantindo que nao fique negativada), considerando
     * que será retirado o valor + TAXA_SAQUE */

        return valor + TAXA_SAQUE <= contaPoupanca.getSaldoConta();
    }
}

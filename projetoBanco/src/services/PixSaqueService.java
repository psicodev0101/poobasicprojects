package services;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class PixSaqueService implements SaqueService{
    @Override
    public boolean sacar(double valor, Conta conta) {

    /*Entrega para o metodo "sacar" das contas o resultado da chamada:
    * recebe a conta e retira do seu saldo o valor sacado, além de alterar
    * o limite atual de saques via pix*/

        conta.setSaldoConta(conta.getSaldoConta() - valor);
        conta.setLimiteSaquePix(conta.getLimiteSaquePix()-1);
        return true;
    }

    @Override
    public boolean confirmarSaqueCC(double valor, ContaCorrente contaCorrente) {

    /* recebe o valor a ser sacado e a conta corrente de origem, com isso, confere se
    * há saldo suficiente para a operação (considerando saldo + limite de cheque especial)
    * e se a conta possui limite de saques pix */

        return valor <= contaCorrente.getSaldoConta() + contaCorrente.getLimiteChequeEsp()
                && contaCorrente.getLimiteSaquePix() > 0;
    }

    @Override
    public boolean confirmarSaquePoupanca(double valor, ContaPoupanca contaPoupanca) {

    /* recebe o valor a ser sacado e a conta poupança de origem, com isso, confere se
    * há saldo suficiente na conta (garantindo que nao fique negativada) e se a conta
    * possui limite de saques pix */

        return valor <= contaPoupanca.getSaldoConta() && contaPoupanca.getLimiteSaquePix() > 0;
    }
}

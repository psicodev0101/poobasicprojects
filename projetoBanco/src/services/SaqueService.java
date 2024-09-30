package services;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public interface SaqueService {

    boolean sacar (double valor, Conta conta);
    boolean confirmarSaqueCC (double Valor, ContaCorrente contaCorrente);
    boolean confirmarSaquePoupanca (double valor, ContaPoupanca contaPoupanca);

}

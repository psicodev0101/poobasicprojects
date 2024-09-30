package services;

import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public interface SaqueService {

    public boolean sacar (double valor, Conta conta);
    public boolean confirmarSaqueCC (double Valor, ContaCorrente contaCorrente);
    public boolean confirmarSaquePoupanca (double valor, ContaPoupanca contaPoupanca);

}

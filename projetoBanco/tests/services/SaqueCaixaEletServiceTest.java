package services;

import models.ContaCorrente;
import models.ContaPoupanca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaqueCaixaEletServiceTest {
    ContaCorrente contaCorrente = new ContaCorrente(123, "contacc", 200);
    ContaPoupanca contaPoupanca = new ContaPoupanca(456, "contapp");
    SaqueCaixaEletService saqueCaixaEletService = new SaqueCaixaEletService();

    @Test
    void sacarTest() {
        contaCorrente.depositar(100);

        //testando saque simples funcional
        saqueCaixaEletService.sacar(50, contaCorrente);
        assertEquals(42.5, contaCorrente.getSaldoConta());

        //testando saque além do limite cheque especial
        saqueCaixaEletService.sacar(100, contaCorrente);
        assertEquals(-65D, contaCorrente.getSaldoConta());
    }

    @Test
    void confirmarSaqueCCTest() {
        contaCorrente.depositar(100);

        //testando detecção de limite do cheque especial (100,00 saldo + 200,00 limite)
        assertFalse(saqueCaixaEletService.confirmarSaqueCC(300, contaCorrente));

        //testando saque funcional
        assertTrue(saqueCaixaEletService.confirmarSaqueCC(292.5D, contaCorrente));
    }

    @Test
    void confirmarSaquePoupancaTest() {
        contaPoupanca.depositar(100);

        //testando limite de negatividade de conta poupanca
        assertFalse(saqueCaixaEletService.confirmarSaquePoupanca(100, contaPoupanca));

        //testando saque funcional
        assertTrue(saqueCaixaEletService.confirmarSaquePoupanca(92.5D, contaPoupanca));
    }
}
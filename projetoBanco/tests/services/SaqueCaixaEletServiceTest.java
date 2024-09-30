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

        saqueCaixaEletService.sacar(50, contaCorrente);
        assertEquals(42.5, contaCorrente.getSaldoConta());

        saqueCaixaEletService.sacar(100, contaCorrente);
        assertEquals(-65D, contaCorrente.getSaldoConta());
    }

    @Test
    void confirmarSaqueCCTest() {
        contaCorrente.depositar(100);

        assertFalse(saqueCaixaEletService.confirmarSaqueCC(300, contaCorrente));

        assertTrue(saqueCaixaEletService.confirmarSaqueCC(292.5D, contaCorrente));
    }

    @Test
    void confirmarSaquePoupancaTest() {
        contaPoupanca.depositar(100);

        assertFalse(saqueCaixaEletService.confirmarSaquePoupanca(100, contaPoupanca));

        assertTrue(saqueCaixaEletService.confirmarSaquePoupanca(92.5D, contaPoupanca));
    }
}
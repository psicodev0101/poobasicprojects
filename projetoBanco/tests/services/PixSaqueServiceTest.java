package services;

import models.ContaCorrente;
import models.ContaPoupanca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixSaqueServiceTest {

    ContaCorrente contaCorrente = new ContaCorrente(123, "contacc", 200);
    ContaPoupanca contaPoupanca = new ContaPoupanca(456, "contapp");
    PixSaqueService pixSaqueService = new PixSaqueService();

    @Test
    void sacarTest() {
        contaCorrente.depositar(500);
        pixSaqueService.sacar(250, contaCorrente);
        assertEquals(250, contaCorrente.getSaldoConta());
        assertEquals(9, contaCorrente.getLimiteSaquePix());

        contaPoupanca.depositar(500);
        pixSaqueService.sacar(250, contaPoupanca);
        assertEquals(250, contaPoupanca.getSaldoConta());
        assertEquals(9, contaPoupanca.getLimiteSaquePix());
    }

    @Test
    void confirmarSaqueCCTest() {
        contaCorrente.depositar(100);

        //testando detecção de limite do cheque especial (100,00 saldo + 200,00 limite)
        assertFalse(pixSaqueService.confirmarSaqueCC(400, contaCorrente));

        //testando saque funcional
        assertTrue(pixSaqueService.confirmarSaqueCC(300, contaCorrente));
    }

    @Test
    void confirmarSaquePoupancaTest() {
        contaPoupanca.depositar(100);

        //testando limite de negatividade de conta poupanca
        assertFalse(pixSaqueService.confirmarSaquePoupanca(400, contaPoupanca));

        //testando saque funcional
        assertTrue(pixSaqueService.confirmarSaquePoupanca(100, contaPoupanca));
    }
}
package models;

import org.junit.jupiter.api.Test;
import services.PixSaqueService;
import services.SaqueCaixaEletService;

import static org.junit.jupiter.api.Assertions.*;

class ContaPoupancaTest {

    ContaPoupanca conta = new ContaPoupanca(123, "teste");

    @Test
    void depositarTest() {
        conta.depositar(500);
        assertEquals(500, conta.getSaldoConta());
    }

    @Test
    void sacarTest() {
        conta.depositar(500);

        //sacando via pix
        conta.sacar(250, new PixSaqueService());
        assertEquals(250, conta.getSaldoConta());
        assertEquals(9, conta.getLimiteSaquePix());

        //sacando via caixa eletronico (erro por negativacao)
        conta.sacar(250, new SaqueCaixaEletService());
        assertEquals(250, conta.getSaldoConta());

        //sacando via caixa eletronico (funcionando)
        conta.sacar(242.5D, new SaqueCaixaEletService());
        assertEquals(0, conta.getSaldoConta());
    }
}
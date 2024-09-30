package models;

import org.junit.jupiter.api.Test;
import services.PixSaqueService;
import services.SaqueCaixaEletService;

import static org.junit.jupiter.api.Assertions.*;

class ContaCorrenteTest {

    ContaCorrente conta = new ContaCorrente(123, "teste", 120);

    @Test
    public void sacarTest() {
        conta.depositar(200);

        //sacando metade do valor via pix
        assertTrue(conta.sacar(100D, new PixSaqueService()));
        assertEquals(100D, conta.getSaldoConta());

        //sacando a outra metade via caixa (deve ficar negativada a taxa de saque)
        assertTrue(conta.sacar(100D, new SaqueCaixaEletService()));
        assertEquals(-7.5D, conta.getSaldoConta());

        //usando toda a capacidade do cheque especial
        conta.sacar(112.5D, new PixSaqueService());
        assertEquals(-120D, conta.getSaldoConta());

        //testando erro ao ultrapassar limite do cheque especial
        assertFalse(conta.sacar(10D, new PixSaqueService()));
        assertEquals(-120D, conta.getSaldoConta()); //vendo se o saldo continua inalterado apos erro
    }
}
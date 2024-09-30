package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BancoTest {
    Banco bancoTest = new Banco();

    @Test
    public void abrirContaCorrenteTest (){
        bancoTest.abrirContaCorrente(123, "teste", 100);
        assertInstanceOf(ContaCorrente.class, bancoTest.acessarConta(123));
        assertEquals(bancoTest.acessarConta(123).getTitularConta(), "teste" );
    }

    @Test
    public void abrirContaPoupancaTest (){
        bancoTest.abrirContaPoupanca(456, "teste");
        assertInstanceOf(ContaPoupanca.class, bancoTest.acessarConta(456));
        assertEquals(bancoTest.acessarConta(456).getTitularConta(), "teste" );
    }

    @Test
    public void acessarContaTest (){
        bancoTest.abrirContaCorrente(123, "testeA", 100);
        bancoTest.abrirContaPoupanca(456, "testeB");
        assertInstanceOf(ContaCorrente.class, bancoTest.acessarConta(123));
        assertInstanceOf(ContaPoupanca.class, bancoTest.acessarConta(456));
    }


  
}
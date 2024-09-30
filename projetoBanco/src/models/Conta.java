package models;

import services.SaqueService;

public abstract class Conta {

    private final int numeroConta;
    private final String titularConta;
    private double saldoConta;
    private int limiteSaquePix = 10;

    public Conta (int numeroConta, String titularConta){
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
    }

    public void depositar (double valor){
            setSaldoConta(getSaldoConta() + valor);
    };

    public abstract boolean sacar(double valor, SaqueService saqueService);

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitularConta() {
        return titularConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta (double valor) {
        saldoConta = valor;
    }

    public int getLimiteSaquePix() {
        return limiteSaquePix;
    }

    public void setLimiteSaquePix(int limiteSaquePix) {
        this.limiteSaquePix = limiteSaquePix;
    }
}

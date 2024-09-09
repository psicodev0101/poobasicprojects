package models;

public abstract class Contribuinte {
    public String nome;
    public Double rendaAnual;
    public Double taxa;

//construtores --------------------------------------------------------------------


    public Contribuinte(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }
}

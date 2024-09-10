package models;

public class ContribuinteCnpj extends Contribuinte {

    private final int quantFuncionarios;

    public ContribuinteCnpj(String nome,
                           Double rendaAnual,
                           int quantFuncionarios){
        super(nome, rendaAnual);
        this.quantFuncionarios = quantFuncionarios;
    }

    public int getQuantFuncionarios (){
        return quantFuncionarios;
    }

}

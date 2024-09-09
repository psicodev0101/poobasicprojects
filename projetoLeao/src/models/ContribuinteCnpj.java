package models;

public class ContribuinteCnpj extends Contribuinte {

    private final int quantFuncionarios;

    //Construtores ------------------------------------------------------------
    public ContribuinteCnpj(String nome,
                           Double rendaAnual,
                           int quantFuncionarios){
        super(nome, rendaAnual);
        this.quantFuncionarios = quantFuncionarios;
    }
//getters e setters---------------------------------------------------------
    public int getQuantFuncionarios (){
        return quantFuncionarios;
    }

//metodos -----------------------------------------------------------------


}

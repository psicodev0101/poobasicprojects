package models;

public class ContribuinteCpf extends Contribuinte {
    private final Double gastosComSaude;

    //Construtores ------------------------------------------------------------
    public ContribuinteCpf(String nome,
                           Double rendaAnual,
                           Double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

//getters e setters---------------------------------------------------------
    public Double getGastosComSaude (){
        return gastosComSaude;
    }
}

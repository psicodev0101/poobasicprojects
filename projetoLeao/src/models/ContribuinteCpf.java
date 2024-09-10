package models;

public class ContribuinteCpf extends Contribuinte {

    private final Double gastosComSaude;

    public ContribuinteCpf(String nome,
                           Double rendaAnual,
                           Double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude (){
        return gastosComSaude;
    }

}

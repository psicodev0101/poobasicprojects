package services;

import models.Contribuinte;
import models.ContribuinteCpf;

public class CobrancaImpCpfService implements CobrancaImpService{

    @Override
    public double calcularImposto(Contribuinte contribuinte) {
        ContribuinteCpf contribuinteCpf = (ContribuinteCpf) contribuinte;
        double imposto = 0.0;
        if (contribuinteCpf.rendaAnual < 2000) {
            imposto = 15D / 100 * contribuinte.rendaAnual;
        } else {
            imposto = 25D / 100 * contribuinte.rendaAnual;
        }
        if (contribuinteCpf.getGastosComSaude() > 0){
            imposto -= contribuinteCpf.getGastosComSaude()/2;
        }
        return imposto;
    }
}

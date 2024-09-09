package services;

import models.Contribuinte;
import models.ContribuinteCnpj;

public class CobrancaImpCnpjService implements CobrancaImpService{

    @Override
    public double calcularImposto(Contribuinte contribuinte) {
        ContribuinteCnpj contribuinteCnpj = (ContribuinteCnpj) contribuinte;

        double imposto = Math.round(16D / 100 * contribuinteCnpj.rendaAnual);
        if (contribuinteCnpj.getQuantFuncionarios() > 10) {
            imposto = Math.round(14D / 100 * contribuinteCnpj.rendaAnual);
        }

        return imposto;
    }

}

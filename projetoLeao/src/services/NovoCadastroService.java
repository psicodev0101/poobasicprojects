package services;

import models.Contribuinte;
import models.ContribuinteCnpj;
import models.ContribuinteCpf;
import models.DatabaseLeao;

import java.util.ArrayList;

public class NovoCadastroService {

    private final DatabaseLeao databaseLeao;

//construtores ---------------------------------------------------------------
    public NovoCadastroService(DatabaseLeao databaseLeao) {
        this.databaseLeao = databaseLeao;
    }

//métodos -----------------------------------------------------------------------------------------
    public void cadastrar(Contribuinte contribuinte) {
        contribuinte.taxa = gerarTaxa(contribuinte);
        databaseLeao.guardarContribuinte(contribuinte);
    }

    public double gerarTaxa (Contribuinte contribuinte) {
        CobrancaImpService cobrancaImpService;
        double resultado = 0D;
        if (contribuinte instanceof ContribuinteCpf){
            cobrancaImpService = new CobrancaImpCpfService();
            resultado = cobrancaImpService.calcularImposto(contribuinte);
        } else if (contribuinte instanceof ContribuinteCnpj){
            cobrancaImpService = new CobrancaImpCnpjService();
            resultado = cobrancaImpService.calcularImposto(contribuinte);
        }
        return resultado;
    }



}

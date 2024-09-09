package services;

import models.Contribuinte;
import models.ContribuinteCnpj;
import models.ContribuinteCpf;
import models.DatabaseLeao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class NovoCadastroServiceTest {

    DatabaseLeao databaseLeao = new DatabaseLeao();
    NovoCadastroService novoCadastroService = new NovoCadastroService(databaseLeao);

    Contribuinte contribTesteA = new ContribuinteCpf("Adailson", 1500D, 250D);
    Contribuinte contribTesteB = new ContribuinteCpf("Adalberto", 2500D, 500D);
    Contribuinte contribTesteC = new ContribuinteCpf("Adalvano", 4500D, 340D);

    Contribuinte contribTesteD = new ContribuinteCnpj("OdontoVida", 52000D, 50);
    Contribuinte contribTesteE = new ContribuinteCnpj("OdontoBem", 14000D, 10);
    Contribuinte contribTesteF = new ContribuinteCnpj("OdontoLife", 10250D, 8);

    @Test
    void cadastrarTest () {
        //cadastrando contribuintes cpf
        novoCadastroService.cadastrar(contribTesteA);
        novoCadastroService.cadastrar(contribTesteB);
        novoCadastroService.cadastrar(contribTesteC);

        //cadastrando contribuintes cnpj
        novoCadastroService.cadastrar(contribTesteD);
        novoCadastroService.cadastrar(contribTesteE);
        novoCadastroService.cadastrar(contribTesteF);

        //testando contribuintes cpf
        assertEquals(databaseLeao.getContribuintesCpf().getFirst(), contribTesteA);
        assertEquals(databaseLeao.getContribuintesCpf().get(1), contribTesteB);
        assertEquals(databaseLeao.getContribuintesCpf().get(2), contribTesteC);

        //testando contribuintes cnpj
        assertEquals(databaseLeao.getContribuintesCnpj().getFirst(), contribTesteD);
        assertEquals(databaseLeao.getContribuintesCnpj().get(1), contribTesteE);
        assertEquals(databaseLeao.getContribuintesCnpj().get(2), contribTesteF);
    }

    @Test
    void gerarTaxaTeste() {
        assertEquals(100D, novoCadastroService.gerarTaxa(contribTesteA));
        assertEquals(375D, novoCadastroService.gerarTaxa(contribTesteB));
        assertEquals(955D, novoCadastroService.gerarTaxa(contribTesteC));

        assertEquals(7280D, novoCadastroService.gerarTaxa(contribTesteD));
        assertEquals(2240D, novoCadastroService.gerarTaxa(contribTesteE));
        assertEquals(1640D, novoCadastroService.gerarTaxa(contribTesteF));
        //finalizar teste aqui
    }
}